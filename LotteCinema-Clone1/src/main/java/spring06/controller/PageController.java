package spring06.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class PageController {
	
	@GetMapping("/log/join")
	public String join() {
		return "/log/join";
	}
	@GetMapping("/log/login")
	public String login() {
		return "/log/login";
	}
}
