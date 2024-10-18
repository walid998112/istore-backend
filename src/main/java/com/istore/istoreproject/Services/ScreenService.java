package com.istore.istoreproject.Services;

import com.istore.istoreproject.models.Screen;

public interface ScreenService {

    Screen saveScreen(Screen screen);

    void deleteScreenById(Long id);

    Screen updatScreen(long id, Screen screen);

    Screen findById(long id);
}
