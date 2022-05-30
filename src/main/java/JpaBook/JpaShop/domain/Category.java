package JpaBook.JpaShop.domain;

import JpaBook.JpaShop.domain.item.Item;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Getter @Setter
public class Category {

    @Id @GeneratedValue
    @Column(name = "category_id")
    private Long id;

    private String name;

    @ManyToMany
    @JoinTable(name = "category_item",
            joinColumns = @JoinColumn(name = "category_id"), //중간단계 테이블 연결
            inverseJoinColumns = @JoinColumn(name = "item_id")) //반대쪽 테이블 연결
    private List<Item> items = new ArrayList<>();

    @ManyToOne  //셀프 양방향 연관관계 맺을 때
    @JoinColumn(name = "parent_id")
    private Category parent;

    @OneToMany(mappedBy = "parent")
    private List<Category> child = new ArrayList<>(); //자식은 여러개 가질 수 있음.

    //연관 관계 (편의) 메서드
    public void addChildCategory(Category child){
        this.child.add(child);
        child.setParent(this);
    }


}
