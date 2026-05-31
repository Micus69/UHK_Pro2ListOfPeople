package cz.uhk.pro2kf2026.repository;

import cz.uhk.pro2kf2026.model.Fox;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FoxRepository extends JpaRepository<Fox, Long> {

}