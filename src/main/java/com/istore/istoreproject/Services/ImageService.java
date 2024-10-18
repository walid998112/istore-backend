package com.istore.istoreproject.Services;

import org.springframework.web.multipart.MultipartFile;

import com.istore.istoreproject.models.Image;

import java.util.List;

public interface ImageService {

    void addImages(List<MultipartFile> image, long product_id);

    void addImage(MultipartFile file, long productId);

    List<Image> getByProductId(long productId);

    void deleteImage(long id);
    
}
