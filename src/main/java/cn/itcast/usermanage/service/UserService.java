package cn.itcast.usermanage.service;

import cn.itcast.usermanage.pojo.EasyUIResult;
import cn.itcast.usermanage.pojo.User;

public interface UserService {

	/**
	 * 分页查询用户信息
	 * @param pageNum
	 * @param pageSize
	 * @return
	 */
	public EasyUIResult queryUserByPage(Integer pageNum, Integer pageSize);
	
	/**
	 * 测试事务
	 * @param user1
	 * @param user2
	 */
	public void addUsers(User user1, User user2);

	/**
	 * 新增用户信息
	 * @param user
	 * @return
	 */
	public Boolean saveUser(User user) throws Exception;

}
