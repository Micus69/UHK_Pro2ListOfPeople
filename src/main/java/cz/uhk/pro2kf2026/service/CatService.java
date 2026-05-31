package cz.uhk.pro2kf2026.service;

import cz.uhk.pro2kf2026.model.Cat;
import java.util.List;

public interface CatService {
    Cat getCat(long id);
    void saveCat(Cat cat);
    void deleteCat(long id);
    List<Cat> getAllCats();
}