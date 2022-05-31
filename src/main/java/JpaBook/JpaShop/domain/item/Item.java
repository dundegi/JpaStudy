package JpaBook.JpaShop.domain.item;



import JpaBook.JpaShop.domain.Category;
import JpaBook.JpaShop.exception.NotEnoughStockException;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Getter @Setter
@Inheritance(strategy = InheritanceType.SINGLE_TABLE) //상속 전략 공부
@DiscriminatorColumn(name = "dtype")  // DiscriminatoValue로 각각 구분
public abstract class Item {

    @Id
    @GeneratedValue
    @Column(name = "item_id")
    private Long id;

    private String name;
    private int price;
    private int stockQuantity;

    @ManyToMany(mappedBy = "items")
    private List<Category> categories = new ArrayList<>();

    //비즈니스 로직
    public void addStock(int quantity){
        this.stockQuantity += quantity; //재고수량 증가
    }

    public void removeStock(int quantity){
        int restStock = this.stockQuantity - quantity;
        if(restStock < 0 ){
            throw new NotEnoughStockException("need more stock");

        }
        this.stockQuantity = restStock;
    }
}
