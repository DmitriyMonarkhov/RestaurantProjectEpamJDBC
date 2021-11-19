package entity;

import lombok.*;

@Data
@With
@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter

public class Menu {

    private int id;
    private String dishes;
    private String info;
    private int price;

    public Menu (String dishes, String info, int price) {
        this.dishes = dishes;
        this.info = info;
        this.price = price;
    }

}
