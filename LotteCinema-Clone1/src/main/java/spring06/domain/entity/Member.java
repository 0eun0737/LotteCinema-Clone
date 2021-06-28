package spring06.domain.entity;

import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EntityListeners;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.ToString;

@ToString
@Builder
@AllArgsConstructor
@RequiredArgsConstructor
@EntityListeners(AuditingEntityListener.class)
@Getter
@Entity
public class Member {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long no;
	//@Column(columnDefinition = "unique no null")
	@Column(unique=true, nullable = false)
	private String userId; //아이디
	
	@Column(nullable = false)
	private String pass; //비밀번호
	@Column(nullable = false)
	private String name; //이름
	@Column
	private String phone; //전화번호
	@Column
	private String email; //이메일
	@Column
	private String ip; //ip
	
	@CreatedDate
	@Column
	private LocalDateTime createdDate; //가입일
	
	@LastModifiedDate
	@Column
	private LocalDateTime updatedDate; //최종수정일
}
