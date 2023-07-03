package BackEndOfEcom.BackEndOfEcom.Repository;

import BackEndOfEcom.BackEndOfEcom.Entity.Address;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AddressRepo extends JpaRepository<Address,Integer> {
    public Address findByUserIdAndAddressId(int userId,int addressId);

    public List<Address> findByUserId(int userId);
}
