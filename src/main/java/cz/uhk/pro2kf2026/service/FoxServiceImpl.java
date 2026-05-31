package cz.uhk.pro2kf2026.service;

import cz.uhk.pro2kf2026.model.Fox;
import cz.uhk.pro2kf2026.repository.FoxRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FoxServiceImpl implements FoxService {

    private final FoxRepository foxRepository;

    @Autowired
    public FoxServiceImpl(FoxRepository foxRepository) {
        this.foxRepository = foxRepository;
    }

    @Override
    public List<Fox> getAllFoxes() {
        return foxRepository.findAll();
    }

    @Override
    public Fox getFox(Long id) {
        return foxRepository.findById(id).orElse(null);
    }

    @Override
    public void saveFox(Fox fox) {
        foxRepository.save(fox);
    }

    @Override
    public void deleteFox(Long id) {
        foxRepository.deleteById(id);
    }
}