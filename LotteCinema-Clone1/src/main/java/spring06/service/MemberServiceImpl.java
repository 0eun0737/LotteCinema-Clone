package spring06.service;

import java.util.Optional;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

import spring06.domain.dto.MemberLoginDto;
import spring06.domain.dto.MemberRequestDto;
import spring06.domain.entity.Member;
import spring06.domain.entity.MemberRepository;

@Service
public class MemberServiceImpl implements MemberService{

	@Autowired
	private HttpServletRequest requset;
	
	@Autowired
	private MemberRepository repository;
	
	@Autowired
	private PasswordEncoder passwordEncoder; 

	
	@Override
	public void join(MemberRequestDto dto, Model model) {
		//ip 정보 저장
		String ip=requset.getRemoteAddr();
		dto.setIp(ip);
		String encodedPass = passwordEncoder.encode(dto.getPass());
		dto.setPass(encodedPass);
		//System.out.println("pass :" + encodedPass);
		
		//repository객체.. entity객체만 허용
		//toEntity() : dto -> Member
		//repository.save(dto.toEntity());
		model.addAttribute("welcome", dto.getName()+ "님 회원가입을 축하합니다.");
	}


	@Override
	public String login(MemberLoginDto dto, Model model) {
		//1. userId 존재유무 확인
		//repository.findById(null) : Id pk컬럼
		
		Optional<Member> opt = repository.findByUserId(dto.getUserId());
		if(opt.isPresent()) {
			//2. 존재하면 비밀번호 확인
			Member entity=opt.get();
			System.out.println(entity);
			//matches() 메서드를 통해서 비밀번호 체크
			boolean result =passwordEncoder.matches(dto.getPass(), entity.getPass());
			if(result) {
				System.out.println("비밀번호 일치");
				//로그인 처리하세요
				return "redirect:/";
			}
		}
		model.addAttribute("loginerr","아이디가 존재하지 않거나 비밀번호가 불일치!");
		return "/log/login";
		
	}

	
}
