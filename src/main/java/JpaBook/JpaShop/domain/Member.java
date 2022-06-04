package JpaBook.JpaShop.domain;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Entity
@Getter @Setter
public class Member {

    @Id @GeneratedValue
    @Column(name = "member_id")
    private Long id;

    @NotEmpty
    private String name;

    @Embedded //@Embedded나 Embeddable 하나만 있어도 되지만 보통 둘 다 해준다.
    private Address address;

    @OneToMany(mappedBy = "member") //연관관계 주인이 member, order 테이블에 있는 멤버필드에 의해 매핑
    private List<Order> orders = new ArrayList<>();








}
