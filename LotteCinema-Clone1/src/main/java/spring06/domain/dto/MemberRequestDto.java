package spring06.domain.dto;

import lombok.Data;
import spring06.domain.entity.Member;

@Data
public class MemberRequestDto {
	
	private String userId; //아이디
	private String pass; //비밀번호
	private String name; //이름
	private String phone; //전화번호
	private String email; //이메일
	private String ip; //ip :request 에서 얻어오기
	
	public Member toEntity() {
		return Member.builder()
				.userId(userId)
				.pass(pass)
				.name(name)
				.phone(phone)
				.email(email)
				.ip(ip)
				.build();
	}
}
