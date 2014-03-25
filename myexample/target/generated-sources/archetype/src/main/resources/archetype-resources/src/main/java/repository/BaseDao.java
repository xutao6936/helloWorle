#set( $symbol_pound = '#' )
#set( $symbol_dollar = '$' )
#set( $symbol_escape = '\' )
package ${package}.repository;

import java.io.Serializable;

import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.repository.PagingAndSortingRepository;

/** 
* @ClassName: BaseDao 
* @Description: dao抽象类 
* @author XuTao
* @date 2013-12-18 下午04:01:19 
* 
* @param <T>
* @param <PK> 
*/
public interface BaseDao<T,PK extends Serializable> extends PagingAndSortingRepository<T,PK>,JpaSpecificationExecutor<T>{
	
	

}
