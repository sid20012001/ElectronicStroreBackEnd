package BackEndOfEcom.BackEndOfEcom.Repository;

import BackEndOfEcom.BackEndOfEcom.Entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductRepository  extends JpaRepository<Product,Integer> {
}
