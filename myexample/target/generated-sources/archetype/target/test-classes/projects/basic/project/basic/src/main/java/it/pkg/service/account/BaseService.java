package it.pkg.service.account;

import java.io.Serializable;
import java.util.List;
import java.util.Map;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.data.jpa.domain.Specification;
import org.springside.modules.persistence.DynamicSpecifications;
import org.springside.modules.persistence.SearchFilter;
import org.springside.modules.utils.Reflections;

import it.pkg.repository.BaseDao;

public abstract class BaseService<T,PK extends Serializable> {
	
	protected  Class<T> entityClass ;
	
	public  BaseService(){
		entityClass = Reflections.getClassGenricType(getClass());
	}
	
	public List<T> getEntities(Map<String, Object> searchParams){
		Map<String, SearchFilter> filters = SearchFilter.parse(searchParams);
		Specification<T> specification =  DynamicSpecifications.bySearchFilter(filters.values(), entityClass);
		return getDao().findAll(specification);
	}
	
	public void delEntity(T entity){
		getDao().delete(entity);
	}
	public void delEntityById(PK id){
		getDao().delete(id);
	}
	public void saveEntity(T entity){
		getDao().save(entity);
	}
	
	public T getEntity(Long id){
		return getDao().findOne((PK) id);
	}
	/** 
	* @Title: getEntitysWithPage 
	* @Description: 用于分页和一些动态查询方法
	* @param @param userId
	* @param @param searchParams
	* @param @param pageNumber
	* @param @param pageSize
	* @param @param sortType
	* @param @return    
	* @return Page<T>    
	* @throws 
	*/
	public Page<T> getEntitysWithPage(Long userId, Map<String, Object> searchParams, int pageNumber, int pageSize,
			String sortType) {
		PageRequest pageRequest = buildPageRequest(pageNumber, pageSize, sortType);
		Specification<T> spec = buildSpecification(userId, searchParams);

		return getDao().findAll(spec, pageRequest);
	}
	
	public List<T>  getAllEntity(){
		return (List<T>) getDao().findAll();
	}
	
	/**
	 * 创建动态查询条件组合.
	 */
	private Specification<T> buildSpecification(Long userId, Map<String, Object> searchParams) {
		Map<String, SearchFilter> filters = SearchFilter.parse(searchParams);
		Specification<T> spec = DynamicSpecifications.bySearchFilter(filters.values(), entityClass);
		return spec;
	}
	
	
	
	/**
	 * 创建分页请求.
	 */
	private PageRequest buildPageRequest(int pageNumber, int pagzSize, String sortType) {
		Sort sort = null;
		if ("auto".equals(sortType)) {
			sort = new Sort(Direction.DESC, "id");
		} else if ("title".equals(sortType)) {
			sort = new Sort(Direction.ASC, "title");
		}

		return new PageRequest(pageNumber - 1, pagzSize, sort);
	}
	
	
	public abstract BaseDao<T,PK>  getDao();
}
