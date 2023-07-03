package BackEndOfEcom.BackEndOfEcom.service;

import BackEndOfEcom.BackEndOfEcom.Entity.Product;

import java.util.List;

public interface ProductService {

    Product createProduct(Product product);
    Product getProductById(Integer productId);
    List<Product> getAllProducts();
    Product updateProduct(Product updatedProduct);
    void deleteProduct(Integer productId);
}
