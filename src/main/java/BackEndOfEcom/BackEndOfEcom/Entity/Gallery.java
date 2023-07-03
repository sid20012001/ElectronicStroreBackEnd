package BackEndOfEcom.BackEndOfEcom.Entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Gallery {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    int gId ;

    List<String>list=new ArrayList<String>();

    @ManyToOne(fetch = FetchType.LAZY,cascade = CascadeType.ALL)
    Product product;
}
