package cn.itcast.usermanage.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import cn.itcast.usermanage.pojo.User;

public interface UserMapper {

	/**
	 * 根据id查询用户信息
	 * @param id
	 * @return
	 */
	public User queryUserById(Long id);

	/**
	 * 分页查询用户信息
	 * @param pageNum
	 * @param pageSize
	 * @return
	 */
	public List<User> queryUserByPage(@Param("start")Integer start, @Param("size")Integer size);

	/**
	 * 查询所有用户信息
	 * @return
	 */
	public List<User> queryUserAll();

	/**
	 * 新增用户信息
	 * @param user
	 */
	public int insertUser(User user) throws Exception;
}
