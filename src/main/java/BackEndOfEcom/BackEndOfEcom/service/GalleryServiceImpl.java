package BackEndOfEcom.BackEndOfEcom.service;

import BackEndOfEcom.BackEndOfEcom.Entity.Gallery;
import BackEndOfEcom.BackEndOfEcom.Entity.Product;
import BackEndOfEcom.BackEndOfEcom.Repository.CategoryRepository;
import BackEndOfEcom.BackEndOfEcom.Repository.GalleryRepository;
import BackEndOfEcom.BackEndOfEcom.Repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class GalleryServiceImpl implements GalleryService{

    @Autowired
    GalleryRepository galleryRepository;

    @Autowired
    ProductRepository productRepository;

    @Override
    public Gallery createGallery(Gallery gallery) {
        this.galleryRepository.save(gallery);
        return gallery;
    }

    @Override
    public Gallery getGalleryById(Integer galleryId) {
        this.galleryRepository.findById(galleryId);
        return this.galleryRepository.findById(galleryId).get();
    }

    @Override
    public List<Gallery> getGalleryByProduct(Integer pId) {

       Product product= this.productRepository.findById(pId).get();
        List<Gallery>galleries=product.getGlist();
        return galleries;
    }

    @Override
    public List<Gallery> getAllGalleries() {
        return this.galleryRepository.findAll();
    }

    @Override
    public void deleteGallery(Integer galleryId) {

    }
}
