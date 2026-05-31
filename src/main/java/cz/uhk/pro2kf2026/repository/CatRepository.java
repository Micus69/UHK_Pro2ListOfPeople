package cz.uhk.pro2kf2026.repository;

import cz.uhk.pro2kf2026.model.Cat;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface CatRepository extends JpaRepository<Cat, Long> {

    // Spring sám na pozadí vygeneruje SQL dotaz: SELECT * FROM cats WHERE user_id = ?
    List<Cat> findByUserId(Long userId);

    // Pokud bys chtěl vyhledávat kočky podle jména: SELECT * FROM cats WHERE name = ?
    List<Cat> findByName(String name);
}