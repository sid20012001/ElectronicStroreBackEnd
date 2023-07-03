package BackEndOfEcom.BackEndOfEcom.service;

import BackEndOfEcom.BackEndOfEcom.Entity.Cart;
import BackEndOfEcom.BackEndOfEcom.Repository.CartRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CartServiceImpl implements CartService{

    @Autowired
    private CartRepository cartRepository;

    @Override
    public Cart addToCart(Cart cart) {
        
        return cartRepository.save(cart);
    }

    @Override
    public void removeFromCart(int pId,int userid) {
        Cart product = this.cartRepository.findByProductIdAndUserid(pId, userid);
        this.cartRepository.delete(product);
    }

    @Override
    public List<Cart> getCartItems() {
        return cartRepository.findAll();
    }

    @Override
    public Cart getCartItem(int cartId) {
        return cartRepository.findById(cartId).orElse(null);
    }
    @Override
   public List<Cart> getAllCartByUser(int userId){
       List<Cart> cart=this.cartRepository.findByUserid(userId);
       return cart;
    }

}
