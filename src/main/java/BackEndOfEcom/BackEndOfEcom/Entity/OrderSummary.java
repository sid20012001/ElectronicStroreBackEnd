package BackEndOfEcom.BackEndOfEcom.Entity;

import jakarta.persistence.*;
import lombok.*;

import java.util.ArrayList;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Entity
public class OrderSummary {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    int oId ;

    int addressId;

    int []productIds;


    int totalPrice;

    int userId;
}
