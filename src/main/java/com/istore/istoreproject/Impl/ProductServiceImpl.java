package com.istore.istoreproject.Impl;

import java.util.List;

import org.springframework.stereotype.Service;

import com.istore.istoreproject.Requests.ProductRequest;
import com.istore.istoreproject.Services.CPUService;
import com.istore.istoreproject.Services.CameraService;
import com.istore.istoreproject.Services.ProductService;
import com.istore.istoreproject.Services.QuestionService;
import com.istore.istoreproject.Services.ScreenService;
import com.istore.istoreproject.models.Category;
import com.istore.istoreproject.models.Connectivity;
import com.istore.istoreproject.models.Product;
import com.istore.istoreproject.models.Question;
import com.istore.istoreproject.repositories.CategoryRepo;
import com.istore.istoreproject.repositories.ConnectivityRepo;
import com.istore.istoreproject.repositories.ImageRepo;
import com.istore.istoreproject.repositories.ProductRepo;

import jakarta.persistence.NoResultException;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
@SuppressWarnings("null")
public class ProductServiceImpl implements ProductService {
    private final ProductRepo productRepo;
    private final ConnectivityRepo connectivityRepo;
    private final CategoryRepo categoryRepo;
    private final QuestionService questionService;
    private final CPUService cpuService;
    private final CameraService cameraService;
    private final ScreenService screenService;
    private final ImageRepo imageRepo;

    @Override
    public Product saveProduct(ProductRequest productRequest) {
        List<Connectivity> connectivities = connectivityRepo.findAllById(productRequest.getConnectivityIds());
        Category category = categoryRepo.findById(productRequest.getCategoryId()).orElseThrow();
        Question question = questionService.getById(productRequest.getQuestionId());
        Product product = new Product();
        product.setCategory(category);
        product.setQuestion(question);
        product.setScreen(screenService.saveScreen(productRequest.getScreen()));
        product.setCpu(cpuService.saveCPU(productRequest.getCpu()));
        product.setCamera(cameraService.addCamera(productRequest.getCamera()));
        product.setName(productRequest.getName());
        product.setBuyLink(productRequest.getBuyLink());
        product.setPrice(productRequest.getPrice());
        product.setColor(productRequest.getColor());
        product.setQuantity(productRequest.getQuantity());
        product.setReference(productRequest.getReference());
        product.setDescription(productRequest.getDescription());
        product.setRam(productRequest.getRam());
        product.setBatteryCapacity(productRequest.getBatteryCapacity());
        product.setOperatingSystem(productRequest.getOperatingSystem());
        product.setConnectivityOptions(connectivities);
        return productRepo.save(product);
    }

    @Override
    public Product updateProduct(ProductRequest productRequest, long id) {
        List<Connectivity> connectivities = connectivityRepo.findAllById(productRequest.getConnectivityIds());
        Category category = categoryRepo.findById(productRequest.getCategoryId()).orElseThrow();
        Question question = questionService.getById(productRequest.getQuestionId());
        Product product = productRepo.findById(id).orElseThrow();
        product.getConnectivityOptions().clear();
        product.setConnectivityOptions(connectivities);
        product.setCategory(category);
        product.setQuestion(question);
        screenService.updatScreen(product.getScreen().getScreen_id(), productRequest.getScreen());
        cpuService.updateCpu(product.getCpu().getCpu_id(), productRequest.getCpu());
        cameraService.updateCamera(productRequest.getCamera(), product.getCamera().getCamera_id());
        product.setName(productRequest.getName());
        product.setPrice(productRequest.getPrice());
        product.setBuyLink(productRequest.getBuyLink());
        product.setColor(productRequest.getColor());
        product.setQuantity(productRequest.getQuantity());
        product.setReference(productRequest.getReference());
        product.setDescription(productRequest.getDescription());
        product.setRam(productRequest.getRam());
        product.setBatteryCapacity(productRequest.getBatteryCapacity());
        product.setOperatingSystem(productRequest.getOperatingSystem());
        return productRepo.save(product);
    }

    @Override
    public Product getById(long id) {
        return productRepo.findById(id).orElseThrow();
    }

    @Override
    public List<Product> findAll() {
        return productRepo.findAll();
    }

    @Override
    public List<Product> getByQuestion(long id) {
        return productRepo.findByQuestionId(id);
    }

    @Override
    public void deleteProduct(long id) {
        Product product = productRepo.findById(id)
                .orElseThrow(() -> new NoResultException("Product not found with id: " + id));
        imageRepo.deleteAll(product.getImages());
        product.getConnectivityOptions().clear();
        productRepo.deleteById(product.getProduct_id());

        if (product.getCpu() != null) {
            cpuService.deleteCPUById(product.getCpu().getCpu_id());
        }

        if (product.getCamera() != null) {
            cameraService.deleteCamera(product.getCamera().getCamera_id());
        }

        if (product.getScreen() != null) {
            screenService.deleteScreenById(product.getScreen().getScreen_id());
        }

    }

}
