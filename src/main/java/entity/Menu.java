package entity;

import javax.persistence.*;
import java.io.Serializable;
import lombok.*;

@Data
@NoArgsConstructor
@Setter
@Getter
@Entity
@Table (name = "menu")

public class Menu implements Serializable {

    @Id
    @Column (name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column (name = "dishes", nullable = false)
    private String dishes;

    @Column (name = "info", nullable = false)
    private String info;

    @Column (name = "price", nullable = false)
    private int price;

    public Menu (String dishes, String info, int price) {
        this.dishes = dishes;
        this.info = info;
        this.price = price;
    }

}
