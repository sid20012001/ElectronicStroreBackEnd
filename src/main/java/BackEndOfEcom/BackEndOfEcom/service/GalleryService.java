package BackEndOfEcom.BackEndOfEcom.service;

import BackEndOfEcom.BackEndOfEcom.Entity.Gallery;

import java.util.List;

public interface GalleryService  {

    Gallery createGallery(Gallery gallery);
    Gallery getGalleryById(Integer galleryId);

    List<Gallery> getGalleryByProduct(Integer cId);


    List<Gallery> getAllGalleries();

    void deleteGallery(Integer galleryId);

}
