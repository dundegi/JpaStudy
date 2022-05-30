package JpaBook.JpaShop.repository;

import JpaBook.JpaShop.domain.Member;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Repository
@RequiredArgsConstructor
public class MemberRepository {


    private final EntityManager em;

    public void save(Member member){ //회원 등록
        em.persist(member);
    }

    public Member findOne(Long id){
        return em.find(Member.class, id); //단건 조회
    }

    public List<Member> findAll(){

        return em.createQuery("select m from Member m", Member.class) //jpql - 엔티티 객체에 대한 쿼리
                .getResultList();
    }

    public List<Member> findByName(String name){
        return em.createQuery("select m from Member m where m.name = :name", Member.class)
                .setParameter("name", name)
                .getResultList();
    }
}
