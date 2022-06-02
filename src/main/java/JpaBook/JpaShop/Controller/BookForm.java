package JpaBook.JpaShop.Controller;

import ch.qos.logback.core.rolling.SizeAndTimeBasedRollingPolicy;
import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class BookForm {

    private Long id; //상품 수정으로 인한 id확인

    private String name;
    private int price;
    private int stockQuantity;

    private String author;
    private String isbn;



}
