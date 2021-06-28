package spring06.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;

import spring06.domain.dto.MemberLoginDto;
import spring06.domain.dto.MemberRequestDto;
import spring06.service.MemberService;

@Controller
public class MemberController {
	//멤버로 service
	@Autowired
	private MemberService service;

	@PostMapping("/member/join")
	public  String join(MemberRequestDto dto, Model model) {
		service.join(dto, model);
		return "/log/login";
		
	}
	@PostMapping("/member/login")
	public String login(MemberLoginDto dto, Model model) {
		
		return service.login(dto, model); 	 
	}
}

