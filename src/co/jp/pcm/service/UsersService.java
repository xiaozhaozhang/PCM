package co.jp.pcm.service;
import java.util.List;

import co.jp.pcm.dto.AppointExecution;
import co.jp.pcm.entity.Book;
import co.jp.pcm.entity.Users;

/**
 * 业务接口：站在"使用者"角度设计接口 三个方面：方法定义粒度，参数，返回类型（return 类型/异常）
 */
public interface UsersService {

	/**
	 * 查询用户
	 * 
	 * @param bookId
	 * @return
	 */
	 public Users login(String accsee,String psd);

	/**
	 * 查询所有图书
	 * 
	 * @return
	 */
	List<Users> getList();

	/**
	 * 预约图书
	 * 
	 * @param bookId
	 * @param studentId
	 * @return
	 */
//	AppointExecution appoint(long id, long studentId);

}