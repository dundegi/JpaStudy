package JpaBook.JpaShop.domain;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

import static javax.persistence.FetchType.LAZY;

@Entity
@Getter @Setter
public class Delivery {

    @Id @GeneratedValue
    @Column(name = "delivery_id")
    private Long id;

    @OneToOne(mappedBy = "delivery", fetch = LAZY)
    private Order order;

    @Embedded
    private Address address;

                                    //enum 클래스 사용시 꼭 붙이기.
    @Enumerated(EnumType.STRING) //ORDINAL , STRING 두 타입 중 스트링만 쓰기. ORDINAL은 숫자로 나타내기 때문에 다른 상태가 추가되면 문제가 된다.
    private DeliveryStatus status; //READY, COMP 배송준비, 배송
}
