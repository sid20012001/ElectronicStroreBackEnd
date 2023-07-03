package BackEndOfEcom.BackEndOfEcom.service;

import BackEndOfEcom.BackEndOfEcom.Entity.Address;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface AddressService {

    Address saveAddress(Address address);
    void deleteAddress(int addressId);
    Address getAddressById(int userId, int addressId);
    List<Address> getAllAddresses(int userID);
}
