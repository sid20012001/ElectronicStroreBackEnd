package BackEndOfEcom.BackEndOfEcom.Entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
public class Address {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    int addressId;

    int pinCode;
    String houseName;
    String street;
    String landMark;
    String city;
    String district;
    int userId;

}
