package spring06.service;

import org.springframework.ui.Model;

import spring06.domain.dto.MemberLoginDto;
import spring06.domain.dto.MemberRequestDto;


public interface MemberService {

	void join(MemberRequestDto dto, Model model);

	String login(MemberLoginDto dto, Model model);

}
