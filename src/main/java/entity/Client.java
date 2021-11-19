package entity;

import lombok.*;

@Data
@With
@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter


public class Client  {

    private int id;
    private String name;
    private String phone;

    public Client(String name, String phone) {
        this.name = name;
        this.phone = phone;
    }
}
