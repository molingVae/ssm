package com.controller;

import com.exception.CustomException;
import com.pojo.User;
import com.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;



@Controller
public class UserController {

	@Autowired
	private UserService userService;
	@Autowired
	private User user;
	// 根据姓名模糊查询json
	@RequestMapping(value = "/reqUsers", method = { RequestMethod.GET,
			RequestMethod.POST })
	public @ResponseBody List<User> reqUsers(@RequestBody String username) throws Exception {
		user.setUsername(username);
		List<User> userList = userService.findUserByName(user);
		return  userList;

	}

	// 根据姓名模糊查询
	@RequestMapping(value = "/findUsers", method = { RequestMethod.GET,
			RequestMethod.POST })
	public  ModelAndView findUsers( String username) throws Exception {
		user.setUsername(username);
		// 调试全局异常控制器
		if (username == "") {
			throw new CustomException("输入不能为空");
		}
		System.out.println(username);
		// 商品列表
		List<User> userList = userService.findUserByName(user);
		// 创建modelAndView准备填充数据、设置视图
		ModelAndView modelAndView = new ModelAndView();

		// 填充数据
		modelAndView.addObject("userList", userList);
		// 视图
		modelAndView.setViewName("userList");

		return modelAndView;

	}
	@RequestMapping("/queryUser")
	public String queryUser(Model model,int id) throws Exception{
		
		User users =userService.queryUserById(id);
		
		model.addAttribute("user", users);
		
		
		return  "userUpdate";
		
	}
	@RequestMapping("/updateUser")
	public String updateUser(Model model,User user) throws Exception{
		
		int s=userService.updateUserById(user);
		if(s>=1)
		model.addAttribute("message", "更改成功");
		return "success";
		
		
	}
}
