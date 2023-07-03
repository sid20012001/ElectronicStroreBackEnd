package BackEndOfEcom.BackEndOfEcom.Controller;

import BackEndOfEcom.BackEndOfEcom.Entity.Address;
import BackEndOfEcom.BackEndOfEcom.service.AddressService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/addresses")
@CrossOrigin("*")
public class AddressController {
    @Autowired
    private  AddressService addressService;



    @PostMapping
    public ResponseEntity<Address> createAddress(@RequestBody Address address) {
        Address savedAddress = addressService.saveAddress(address);
        return ResponseEntity.status(HttpStatus.CREATED).body(savedAddress);
    }

    @GetMapping("/{userId}/{addressId}")
    public ResponseEntity<Address> getAddressById(@PathVariable int userId,@PathVariable int addressId) {
        Address address = addressService.getAddressById(userId,addressId);
        return ResponseEntity.ok(address);
    }

    @GetMapping("/{userId}")
    public List<Address>getAllAddress(@PathVariable int userId){
      return   this.addressService.getAllAddresses(userId);
    }



    @DeleteMapping("/{addressId}")
    public ResponseEntity<Void> deleteAddress(@PathVariable int addressId) {
        addressService.deleteAddress(addressId);
        return ResponseEntity.noContent().build();
    }
}
