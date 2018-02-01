package cn.itcast.usermanage.controller;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import cn.itcast.usermanage.pojo.EasyUIResult;
import cn.itcast.usermanage.pojo.User;
import cn.itcast.usermanage.service.UserService;

@RequestMapping("user")
@Controller
public class UserController {
	
	@Autowired
	private UserService userService;
	
	@RequestMapping("page/{pageName}")
	public String toUsers(@PathVariable("pageName")String pageName){
		return pageName;
	}
	
	/*@RequestMapping("page/add")
	public String toUserAdd(){
		return "user-add";
	}*/
	
	@RequestMapping("list")
	@ResponseBody
	public EasyUIResult queryUserByPage(@RequestParam("page")Integer pageNum, @RequestParam("rows")Integer pageSize){
		return this.userService.queryUserByPage(pageNum, pageSize);
	}
	
	@RequestMapping("save")
	@ResponseBody
	public Map<String, Object> saveUser(User user){
		Map<String, Object> map = new HashMap<>();
		try {
			Boolean b = this.userService.saveUser(user);
			if(b){
				map.put("status", 200);
			} else {
				map.put("status", 500);
			}
		} catch (Exception e) {
			map.put("status", 500);
			e.printStackTrace();
		}
		return map;
	}
}
