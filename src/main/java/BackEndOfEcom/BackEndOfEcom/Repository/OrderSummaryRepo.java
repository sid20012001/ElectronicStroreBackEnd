package BackEndOfEcom.BackEndOfEcom.Repository;

import BackEndOfEcom.BackEndOfEcom.Entity.OrderSummary;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OrderSummaryRepo extends JpaRepository<OrderSummary,Integer> {
}
