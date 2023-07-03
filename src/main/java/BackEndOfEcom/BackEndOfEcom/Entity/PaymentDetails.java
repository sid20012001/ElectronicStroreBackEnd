package BackEndOfEcom.BackEndOfEcom.Entity;
//
//import jakarta.persistence.Entity;
//import jakarta.persistence.GeneratedValue;
//import jakarta.persistence.GenerationType;
//import jakarta.persistence.Id;
//import lombok.*;
//
//@Entity
//@Data
//@NoArgsConstructor
//@AllArgsConstructor
//@Setter
//@Getter
//public class ProductToDelever {
//
//    @Id
//    @GeneratedValue(strategy = GenerationType.AUTO)
//    int parsalId;
//
//   int  addressId;
//   String paymentId ;
//
//   int [] productIds ;
//   int userId ;
//
//
//
//
//
//}

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@Entity
public class PaymentDetails {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Long addressId;
    private String userId;
    private String paymentId;
    private String productIds; // Storing product IDs as comma-separated string

    // Constructors, getters, and setters

    // ...

    public void setProductIds(List<Long> productIds) {
        this.productIds = String.join(",", productIds.stream().map(String::valueOf).collect(Collectors.toList()));
    }

    public List<Long> getProductIdsList() {
        return Arrays.stream(productIds.split(","))
                .map(Long::valueOf)
                .collect(Collectors.toList());
    }
}
