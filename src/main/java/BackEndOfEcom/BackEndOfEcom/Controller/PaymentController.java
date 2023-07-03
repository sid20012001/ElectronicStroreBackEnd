package BackEndOfEcom.BackEndOfEcom.Controller;

import BackEndOfEcom.BackEndOfEcom.Entity.OrderSummary;
import org.json.JSONObject;
import org.springframework.web.bind.annotation.*;
 import com.razorpay.*;

@RestController
@CrossOrigin("*")
public class PaymentController {

    @PostMapping("/create_order")

    public String  createOrder(@RequestBody OrderSummary orderSummary) throws RazorpayException {

        int totalPrice = orderSummary.getTotalPrice();
        int userId = orderSummary.getUserId();
        int[] productIds = orderSummary.getProductIds();
        int addressId = orderSummary.getAddressId();

        RazorpayClient client =new RazorpayClient("rzp_test_wQ5qYNqZEJAHIG","IUPSBcNLpdjNcMxCEYOAS0G1");

        JSONObject option=new JSONObject();
        option.put("amount",totalPrice*100);
        option.put("currency","INR");
        option.put("receipt","txn_12345");

        Order order=client.Orders.create(option);

        System.out.println(order);

        return order.toString();

    }
}
