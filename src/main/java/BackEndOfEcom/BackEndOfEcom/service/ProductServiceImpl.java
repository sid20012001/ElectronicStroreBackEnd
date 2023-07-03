package BackEndOfEcom.BackEndOfEcom.service;

import java.util.List;

import BackEndOfEcom.BackEndOfEcom.Entity.Product;
import BackEndOfEcom.BackEndOfEcom.Repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProductServiceImpl implements ProductService {

    @Autowired
    ProductRepository productRepository;



    @Override
    public Product createProduct(Product product) {
        // Additional validation or business logic can be implemented here
        return productRepository.save(product);
    }

    @Override
    public Product getProductById(Integer productId) {
        return this.productRepository.findById(productId).get();
    }

    @Override
    public List<Product> getAllProducts() {
        return productRepository.findAll();
    }

    @Override
    public Product updateProduct(Product updatedProduct) {
       Integer productId= updatedProduct.getPId();

        this.productRepository.save(updatedProduct);
        return updatedProduct;
    }

    @Override
    public void deleteProduct(Integer productId) {
        Product product = getProductById(productId);
        this.productRepository.deleteById(productId);

    }
}
