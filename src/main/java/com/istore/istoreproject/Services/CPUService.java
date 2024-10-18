package com.istore.istoreproject.Services;

import com.istore.istoreproject.models.CPU;

public interface CPUService {

    CPU saveCPU(CPU cpu);

    CPU updateCpu(Long id, CPU cpu);

    void deleteCPUById(Long id);

    CPU findById(long id);
    
}
