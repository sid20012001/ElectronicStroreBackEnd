package BackEndOfEcom.BackEndOfEcom.service;

import BackEndOfEcom.BackEndOfEcom.Entity.Address;
import BackEndOfEcom.BackEndOfEcom.Repository.AddressRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class AddressServiceImpl implements AddressService {

    @Autowired
    private AddressRepo addressRepo;



    @Override
    public Address saveAddress(Address address) {
        return addressRepo.save(address);
    }

    @Override
    public void deleteAddress(int addressId) {
        addressRepo.deleteById(addressId);
    }

    @Override
    public Address getAddressById(int userId, int addressId) {
       return this.addressRepo.findByUserIdAndAddressId(userId,addressId);
    }

    @Override
    public List<Address> getAllAddresses(int userId) {
        return addressRepo.findByUserId(userId);
    }
}
