package com.istore.istoreproject.Impl;

import org.springframework.stereotype.Service;

import com.istore.istoreproject.Services.ConnectivityService;
import java.util.List;
import com.istore.istoreproject.models.Connectivity;
import com.istore.istoreproject.repositories.ConnectivityRepo;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
@SuppressWarnings("null")
public class ConnectivityServiceImpl implements ConnectivityService {

    private final ConnectivityRepo connectivityRepo;

    @Override
    public Connectivity add(Connectivity connectivity) {
        return connectivityRepo.save(connectivity);
    }

    @Override
    public void delete(long id) {
        connectivityRepo.deleteById(id);
    }

    @Override
    public List<Connectivity> getAll() {
        return connectivityRepo.findAll();
    }

}
