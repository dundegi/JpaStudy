package JpaBook.JpaShop.Service;

import JpaBook.JpaShop.domain.Member;
import JpaBook.JpaShop.repository.MemberRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional(readOnly = true)
@RequiredArgsConstructor //final이 있는 필드를 가지고 생성자 만들어줌
public class MemberService {


    private final MemberRepository memberRepository;

    //회원가입
    @Transactional //읽기 작업이 아닌 쓰기 작업이면 리드온니를 넣으면 데이터 변경이 안 된다.
    public Long join(Member member){
        vailidateDuplicateMember(member);
        memberRepository.save(member);
        return member.getId();
    }

    private void vailidateDuplicateMember(Member member) {
        List<Member> findMembers = memberRepository.findByName(member.getName());
        if(!findMembers.isEmpty()){
            throw new IllegalStateException("이미 존재하는 회원입니다.");
        }


    }
    //회원 전체 조회

    public List<Member> findMembers(){
        return memberRepository.findAll();
    }

    //회원 단건 조회

    public Member findOne(Long memberId){
        return memberRepository.findOne(memberId);
    }


    @Transactional
    public void update(Long id, String name) {
        Member member = memberRepository.findOne(id);
        member.setName(name);
    }
}
