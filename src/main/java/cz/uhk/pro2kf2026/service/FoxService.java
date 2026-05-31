package cz.uhk.pro2kf2026.service;

import cz.uhk.pro2kf2026.model.Fox;
import java.util.List;

public interface FoxService {
    List<Fox> getAllFoxes();
    Fox getFox(Long id);
    void saveFox(Fox fox);
    void deleteFox(Long id);
}