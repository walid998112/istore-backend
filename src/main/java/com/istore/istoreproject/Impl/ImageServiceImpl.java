package com.istore.istoreproject.Impl;

import java.io.IOException;
import java.util.Base64;
import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.istore.istoreproject.Services.ImageService;
import com.istore.istoreproject.models.Image;
import com.istore.istoreproject.models.Product;
import com.istore.istoreproject.repositories.ImageRepo;
import com.istore.istoreproject.repositories.ProductRepo;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class ImageServiceImpl implements ImageService {

    private final ImageRepo imageRepo;
    private final ProductRepo productRepo;

    @Override
    public void addImages(List<MultipartFile> images, long product_id) {
        Product product = productRepo.findById(product_id).orElseThrow();
        images.forEach(img -> {
            try {
                Image image = new Image();
                image.setUrl("data:" + img.getContentType() + ";base64,"
                        + Base64.getEncoder().encodeToString(img.getBytes()));
                image.setType(img.getContentType());
                image.setProduct(product);
                imageRepo.save(image);
            } catch (IOException e) {
                e.printStackTrace();
            }
        });

    }

    @Override
    public void addImage(MultipartFile image, long productId) {
        Product product = productRepo.findById(productId).orElseThrow();
        try {
            Image newImage = new Image();
            newImage.setUrl("data:" + image.getContentType() + ";base64,"
                    + Base64.getEncoder().encodeToString(image.getBytes()));
            newImage.setType(image.getContentType());
            newImage.setProduct(product);
            imageRepo.save(newImage);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public List<Image> getByProductId(long productId) {
        return imageRepo.findByProductId(productId);
    }

    @Override
    public void deleteImage(long id) {
        imageRepo.deleteById(id);
    }

}
