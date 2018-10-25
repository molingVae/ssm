package com.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpSession;

@Controller
public class LoginController {
   
	@RequestMapping("/login")
	public String login(HttpSession session,String username,String password) throws Exception{

		// 调用service进行用户身份验证
		// ...

		// 在session中保存用户身份信息
		session.setAttribute("username", username);
		// 重定向到商品列表页面
		return "redirect:/findUsers.action";

	
	
	}
	@RequestMapping("/logout")
	public String logout(HttpSession session) throws Exception{
		
		// 清除session
		session.invalidate();
		return "redirect:/findUsers.action";
	}
	
	
}