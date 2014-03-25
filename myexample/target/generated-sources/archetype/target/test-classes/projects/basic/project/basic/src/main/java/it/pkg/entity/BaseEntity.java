package it.pkg.entity;


/** 
* @ClassName: BaseEntity 
* @Description: 实体实现基类 
* @author XuTao
* @date 2013-12-13 上午10:21:30 
*  
*/
//  此处不能写超类
public abstract class BaseEntity {
	protected Long id;
	
	
	public abstract Long getId();

	public void setId(Long id) {
		this.id = id;
	}
	

}
