package BackEndOfEcom.BackEndOfEcom.Entity;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.*;
import lombok.*;

import java.util.Arrays;
import java.util.stream.Collectors;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
public class PaymentDone {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private Long addressId;
    private String paymentId;
    private Long userId;

    @Column(columnDefinition = "TEXT")
    private String productIds;

    public void setProductIds(Long[] productIdArray) {
        this.productIds = String.join(",", Arrays.stream(productIdArray)
                .map(String::valueOf)
                .collect(Collectors.toList()));
    }

    public Long[] getProductIds() {
        String[] productIdStrings = this.productIds.split(",");
        return Arrays.stream(productIdStrings)
                .map(Long::valueOf)
                .toArray(Long[]::new);
    }
}
