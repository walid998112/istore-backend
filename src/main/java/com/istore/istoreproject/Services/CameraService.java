package com.istore.istoreproject.Services;

import com.istore.istoreproject.models.Camera;

public interface CameraService {
    
    Camera addCamera(Camera camera);

    Camera getById(long id);

    Camera updateCamera(Camera camera, long id);

    void deleteCamera(long id);
}
