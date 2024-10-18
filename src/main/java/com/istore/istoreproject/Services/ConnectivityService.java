package com.istore.istoreproject.Services;

import com.istore.istoreproject.models.Connectivity;

import java.util.List;

public interface ConnectivityService {

    Connectivity add(Connectivity connectivity);

    void delete(long id);

    List<Connectivity> getAll();
}
