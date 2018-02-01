package cn.itcast.usermanage.service;

import static org.junit.Assert.fail;

import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import cn.itcast.usermanage.pojo.User;

public class UserServiceTest {

	private UserService userService;

	@Before
	public void setUp() throws Exception {
		ApplicationContext context = new ClassPathXmlApplicationContext("spring/applicationContext.xml",
				"spring/applicationContext-mybatis.xml","spring/applicationContext-transaction.xml");
		this.userService = context.getBean(UserService.class);
	}

	@Test
	public void testAddUsers() {
		User user1 = new User();
		user1.setName("凤姐");
		user1.setUserName("luoyufeng");
		user1.setAge(18);
		user1.setPassword("111111");
		User user2 = new User();
		user2.setName("凤姐他姐");
		user2.setUserName("luodafeng");
		user2.setAge(18);
		user2.setPassword("111111");
		this.userService.addUsers(user1 , user2);
	}

}
