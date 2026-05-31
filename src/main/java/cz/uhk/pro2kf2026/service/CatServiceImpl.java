package cz.uhk.pro2kf2026.service;

import cz.uhk.pro2kf2026.model.Cat;
import cz.uhk.pro2kf2026.repository.CatRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class CatServiceImpl implements CatService { // Teď už interface najde!

    private final CatRepository catRepository;

    @Autowired
    public CatServiceImpl(CatRepository catRepository) {
        this.catRepository = catRepository;
    }

    @Override
    public Cat getCat(long id) {
        return catRepository.findById(id).orElse(null);
    }

    @Override
    public void saveCat(Cat cat) {
        catRepository.save(cat);
    }

    @Override
    public void deleteCat(long id) {
        catRepository.deleteById(id);
    }

    @Override
    public List<Cat> getAllCats() {
        return catRepository.findAll();
    }
}