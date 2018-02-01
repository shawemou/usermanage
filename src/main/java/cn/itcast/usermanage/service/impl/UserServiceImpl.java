package cn.itcast.usermanage.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.itcast.usermanage.mapper.UserMapper;
import cn.itcast.usermanage.pojo.EasyUIResult;
import cn.itcast.usermanage.pojo.User;
import cn.itcast.usermanage.service.UserService;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;

@Service
public class UserServiceImpl implements UserService {
	
	@Autowired
	private UserMapper userMapper;

	@Override
	public EasyUIResult queryUserByPage(Integer pageNum, Integer pageSize) {
		EasyUIResult easyUIResult = new EasyUIResult();
		/**在查询方法调用之前，调用分页插件的静态方法，中间最好不要隔任何代码 ,参数1:第几页 ;参数2:每页多少条*/
		PageHelper.startPage(pageNum, pageSize);
		/**查询所有的User即可 */
		List<User> userList = this.userMapper.queryUserAll();
		/**初始化pageInfo对象，所有的分页参数都可以在该对象中获取 */
		PageInfo<User> pageInfo = new PageInfo<>(userList);
		easyUIResult.setRows(userList);
		easyUIResult.setTotal(pageInfo.getTotal());
		return easyUIResult;
	}

	@Override
	public void addUsers(User user1, User user2) {
//		this.userMapper.insertUser(user1);
//		int i=1/0;
//		this.userMapper.insertUser(user2);
	}

	@Override
	public Boolean saveUser(User user) throws Exception {
		int count = this.userMapper.insertUser(user);
		if(count == 1){
			return true;
		}
		return false;
	}

}
