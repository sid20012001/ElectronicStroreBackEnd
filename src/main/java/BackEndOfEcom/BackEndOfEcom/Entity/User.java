package BackEndOfEcom.BackEndOfEcom.Entity;


import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;

import java.util.ArrayList;
import java.util.List;


@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    Long uid;
    String username;
    String password;
    String firstname;
    String lastname;
    String email;
    String mobile;
    String role;


}
