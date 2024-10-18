package com.istore.istoreproject.Impl;

import org.springframework.stereotype.Service;

import com.istore.istoreproject.Services.CPUService;
import com.istore.istoreproject.models.CPU;
import com.istore.istoreproject.repositories.CPURepo;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
@SuppressWarnings("null")
public class CPUServiceImpl implements CPUService {

    private final CPURepo CPURepo;

    @Override
    public CPU saveCPU(CPU cpu) {
        return CPURepo.save(cpu);
    }

    @Override
    public CPU updateCpu(Long id, CPU cpu) {
        CPU cpu2 = CPURepo.findById(id).orElseThrow();
        cpu2.setModel(cpu.getModel());
        cpu2.setCorsNumber(cpu.getCorsNumber());
        cpu2.setSpeed(cpu.getSpeed());
        return CPURepo.save(cpu2);
    }

    @Override
    public void deleteCPUById(Long id) {
        CPURepo.deleteById(id);
    }

    @Override
    public CPU findById(long id) {
        return CPURepo.findById(id).orElseThrow();
    }

}
