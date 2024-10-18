package com.istore.istoreproject.Impl;

import org.springframework.stereotype.Service;

import com.istore.istoreproject.Services.ScreenService;
import com.istore.istoreproject.models.Screen;
import com.istore.istoreproject.repositories.ScreenRepo;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
@SuppressWarnings("null")
public class ScreenServiceImpl implements ScreenService {

    private final ScreenRepo screenRepo;

    @Override
    public Screen saveScreen(Screen screen) {
        return screenRepo.save(screen);
    }

    @Override
    public void deleteScreenById(Long id) {
        screenRepo.deleteById(id);
    }

    @Override
    public Screen updatScreen(long id, Screen screen) {
        Screen dbScreen = screenRepo.findById(id).orElseThrow();
        dbScreen.setResolution(screen.getResolution());
        dbScreen.setSize(screen.getSize());
        dbScreen.setType(screen.getType());
        return screenRepo.save(dbScreen);
    }

    @Override
    public Screen findById(long id) {
        return screenRepo.findById(id).orElseThrow();
    }

}
