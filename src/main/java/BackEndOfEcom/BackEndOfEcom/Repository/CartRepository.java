package BackEndOfEcom.BackEndOfEcom.Repository;

import BackEndOfEcom.BackEndOfEcom.Entity.Cart;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CartRepository extends JpaRepository<Cart, Integer> {

    List<Cart> findByUserid(int userId);
   public Cart findByProductIdAndUserid(int pId, int userid);
}