package spring06.domain.dto;

import lombok.Data;
import spring06.domain.entity.Member;

@Data
public class MemberLoginDto {
	
	private String userId; //아이디
	private String pass; //비밀번호
	
	public Member toEntity() {
		return Member.builder()
				.userId(userId)
				.pass(pass)
				.build();
	}
}
