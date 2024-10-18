package com.istore.istoreproject.Impl;

import org.springframework.stereotype.Service;

import com.istore.istoreproject.Services.CameraService;
import com.istore.istoreproject.models.Camera;
import com.istore.istoreproject.repositories.CameraRepo;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
@SuppressWarnings("null")
public class CameraServiceImpl implements CameraService {

    private final CameraRepo cameraRepo;

    @Override
    public Camera addCamera(Camera camera) {
        return cameraRepo.save(camera);
    }

    @Override
    public Camera getById(long id) {
        return cameraRepo.findById(id).orElseThrow();
    }

    @Override
    public Camera updateCamera(Camera camera, long id) {
        Camera camera2 = cameraRepo.findById(id).orElseThrow();
        camera2.setBackResol(camera.getBackResol());
        camera2.setFrontResol(camera.getFrontResol());
        return cameraRepo.save(camera2);

    }

    @Override
    public void deleteCamera(long id) {
        cameraRepo.deleteById(id);
    }

}
