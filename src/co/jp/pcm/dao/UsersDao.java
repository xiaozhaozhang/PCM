package co.jp.pcm.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import co.jp.pcm.entity.Users;

public interface UsersDao {

	/**
	 * 通过ID查询用户
	 * 
	 * @param id
	 * @return
	 */
	Users queryById(@Param("access") String access, @Param("psd") String psd);

	/**
	 * 查询所有用户
	 * 
	 * @param offset 查询起始位置
	 * @param limit 查询条数
	 * @return
	 */
	List<Users> queryAll(@Param("offset") int offset, @Param("limit") int limit);

	/**
	 * 减少馆藏数量
	 * 
	 * @param id
	 * @return 如果影响行数等于>1，表示更新的记录行数
	 */
	int reduceNumber(long id);
}