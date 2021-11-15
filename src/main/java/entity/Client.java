package entity;

import lombok.*;
import javax.persistence.*;
import java.io.Serializable;

@Data
@NoArgsConstructor
@Setter
@Getter
@Entity
@Table (name = "client")

public class Client implements Serializable {

    @Id
    @Column (name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column (name = "name", nullable = false)
    private String name;

    @Column (name = "phone", nullable = false)
    private String phone;

    public Client(String name, String phone) {
        this.name = name;
        this.phone = phone;
    }
}
