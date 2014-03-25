#set( $symbol_pound = '#' )
#set( $symbol_dollar = '$' )
#set( $symbol_escape = '\' )
package ${package}.service.account;

/** 
* @ClassName: ServiceException 
* @Description: service层共用exception，由spring管理事务的函数中抛出并触发事务回滚 
* @author XuTao
* @date 2013-12-13 上午10:49:57 
*  
*/
public class ServiceException extends RuntimeException{

	private static final long serialVersionUID = 1L;
	
	public ServiceException(){
		super();
	}

	
	public ServiceException(String message) {
		super(message);
	}
	
	public ServiceException(String message, Throwable cause) {
	        super(message, cause);
    }
	 
	 
	public ServiceException(Throwable cause) {
	        super(cause);
	 }
}
