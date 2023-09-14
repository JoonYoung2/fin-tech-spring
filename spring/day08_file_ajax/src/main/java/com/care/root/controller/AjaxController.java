package com.care.root.controller;

import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;

import com.care.root.dto.InfoDTO;

@Controller
public class AjaxController {
	@GetMapping("non_ajax")
	public String nonAjax() {
		System.out.println("non ajax");
		return "ajax/non_ajax";
	}

	@GetMapping("ajax01")
	public String ajax01() {
		System.out.println("ajax01");
		return "ajax/ajax01";
	}

	@GetMapping("ajax_test")
	public void ajaxTest() {
		System.out.println("ajax_test");
	}

	@GetMapping("ajax02")
	public String ajax02() {
		return "ajax/ajax02";
	}

	int cnt = 0;

	@GetMapping("result02")
	@ResponseBody
	public String result02() {
		return "" + cnt++;
	}

	@GetMapping("ajax03")
	public String ajax03() {
		return "ajax/ajax03";
	}

	@PostMapping(value = "result03", produces = "application/json;charset=utf-8")
	@ResponseBody
	public InfoDTO result03(@RequestBody InfoDTO dto) {
		dto.setName("zz");
		dto.setAge(11);
		return dto;
	}

	@GetMapping("ajax04")
	public String ajax04() {
		return "ajax/ajax04";
	}

	@PostMapping(value = "result04", produces = "application/json; charset=utf-8") // 받는 쪽(서버)에서 이런 형식으로 받겠다는 뜻.
	@ResponseBody
	public Map<String, String> result04(@RequestBody Map<String, String> map) {
		System.out.println(map);
		System.out.println(map.get("name"));
		map.put("nick", "gd");
		return map;
	}
	
	@GetMapping("rest01")
	public String rest01() {
		return "ajax/rest01";
	}
	
	@GetMapping("member")
	public String member() {
		return "ajax/member";
	}
}
