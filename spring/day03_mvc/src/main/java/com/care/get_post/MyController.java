package com.care.get_post;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.care.get_post.dto.Human;

@Controller
@RequestMapping("my")
public class MyController {
	public MyController() {
		System.out.println("gdgd");
	}
	
	@RequestMapping("index")
	public String index() {
		return "get_post/index";
	}
	
	@RequestMapping(value="result", method = RequestMethod.GET)
	public String getResult(HttpServletRequest req, Model model) {
		String name = req.getParameter("name");
		int age = Integer.parseInt(req.getParameter("age"));
		model.addAttribute("name", name);
		model.addAttribute("age", age);
		model.addAttribute("method", "get");
		return "get_post/result";
	}
	
	@RequestMapping(value="result", method = RequestMethod.POST)
	public String postResult(HttpServletRequest req, Model model) {
		String name = req.getParameter("name");
		int age = Integer.parseInt(req.getParameter("age"));
		model.addAttribute("name", name);
		model.addAttribute("age", age);
		model.addAttribute("method", "post");
		return "get_post/result";
	}
	
//	@GetMapping("result")
//	public String result(@RequestParam("name") String name, @RequestParam("age") int age) {
//		System.out.println("get방식");
//		System.out.println(name);
//		System.out.println(age);
//		return "get_post/index";
//	}
//	
//	@PostMapping("result")
//	public String result(HttpServletRequest req, Model model) {
//		String name = req.getParameter("name");
//		int age = Integer.parseInt(req.getParameter("age"));
//		System.out.println(name);
//		System.out.println(age);
//		return "get_post/index";
//	}
}
