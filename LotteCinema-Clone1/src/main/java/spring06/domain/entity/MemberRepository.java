package spring06.domain.entity;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

public interface MemberRepository extends JpaRepository<Member, Long>{
	//사용자 정의 메서드 구현 (jpa메서드 쿼리 문법에 맞게 메서드작성 사용 가능)
	Optional<Member> findByUserId(String userId);
	
	
	
	
	
}
