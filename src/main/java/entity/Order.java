package entity;

import javax.persistence.*;
import java.io.Serializable;
import lombok.*;

@Data
@NoArgsConstructor
@Setter
@Getter
@Entity
@Table (name = "orders")

public class Order implements Serializable {
    @Id
    @Column (name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column (name = "client_id", nullable = false)
    private int client_id;

    @Column (name = "menu_id", nullable = false)
    private int menu_id;

    public Order(int client_id, int menu_id) {
        this.client_id = client_id;
        this.menu_id = menu_id;
    }
}
