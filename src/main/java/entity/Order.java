package entity;

import lombok.*;

@Data
@NoArgsConstructor
@Setter
@Getter


public class Order{

    private int id;
    private int client_id;
    private int menu_id;

    public Order(int client_id, int menu_id) {
        this.client_id = client_id;
        this.menu_id = menu_id;
    }
}
