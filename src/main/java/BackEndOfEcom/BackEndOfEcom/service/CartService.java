package BackEndOfEcom.BackEndOfEcom.service;

import BackEndOfEcom.BackEndOfEcom.Entity.Cart;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface CartService {
        Cart addToCart(Cart cart);
        void removeFromCart(int pId,int userid);
        List<Cart> getCartItems();
        Cart getCartItem(int cartId);

        List<Cart> getAllCartByUser(int userId);


}
