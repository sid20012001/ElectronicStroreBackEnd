package BackEndOfEcom.BackEndOfEcom.Controller;

import BackEndOfEcom.BackEndOfEcom.Entity.PaymentDone;
import BackEndOfEcom.BackEndOfEcom.Repository.PaymentDoneRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin("*")
public class PaymentSuccessController {

    private final PaymentDoneRepository paymentDoneRepository;

    @Autowired
    public PaymentSuccessController(PaymentDoneRepository paymentDoneRepository) {
        this.paymentDoneRepository = paymentDoneRepository;
    }

    @PostMapping("/payment_success")
    public void handlePaymentSuccess(@RequestBody PaymentDone paymentDone) {
        // Save the payment details to the database
        paymentDoneRepository.save(paymentDone);
    }
}
