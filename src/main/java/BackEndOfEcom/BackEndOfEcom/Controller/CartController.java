package BackEndOfEcom.BackEndOfEcom.Controller;

import BackEndOfEcom.BackEndOfEcom.Entity.Cart;
import BackEndOfEcom.BackEndOfEcom.service.CartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin("*")
public class CartController {

    @Autowired
    private CartService cartService;

    @PostMapping("/add-cart-item")
    public ResponseEntity<Cart> addToCart(@RequestBody Cart cart) {
        Cart addedCart = cartService.addToCart(cart);
        return ResponseEntity.ok(addedCart);
    }



    @GetMapping("get-entire-cart")
    public ResponseEntity<List<Cart>> getCartItems() {
        List<Cart> cartItems = cartService.getCartItems();
        return ResponseEntity.ok(cartItems);
    }

    @GetMapping("/{cartId}")
    public ResponseEntity<Cart> getCartItem(@PathVariable int cartId) {
        Cart cartItem = cartService.getCartItem(cartId);
        if (cartItem != null) {
            return ResponseEntity.ok(cartItem);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @GetMapping("cart/{userId}")
    public List<Cart>getcartbyuser(@PathVariable int userId){
        return this.cartService.getAllCartByUser(userId);
    }

    @DeleteMapping("cart/{pId}/{userid}")
    public void removeProduct(@PathVariable  int pId,@PathVariable int userid){
      this.cartService.removeFromCart(pId,userid);
    }
}
