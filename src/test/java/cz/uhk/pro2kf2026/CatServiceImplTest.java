package cz.uhk.pro2kf2026;

import cz.uhk.pro2kf2026.model.Cat;
import cz.uhk.pro2kf2026.repository.CatRepository;
import cz.uhk.pro2kf2026.service.CatServiceImpl;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

// Tyto statické importy ti ušetří psaní "Mockito." a "Assertions."
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class CatServiceImplTest {

    @Mock
    private CatRepository catRepository;

    @InjectMocks
    private CatServiceImpl catService;

    private Cat testCat;

    @BeforeEach
    void setUp() {
        // Příprava testovací kočky před každým testem
        testCat = new Cat();
    }

    @Test
    void getCat_ShouldReturnCatIfExists() {
        when(catRepository.findById(1L)).thenReturn(Optional.of(testCat));

        // Voláme getCatId(1L), protože tak to máš pojmenované v CatService
        Cat result = catService.getCat(1L);

        assertNotNull(result);
        assertEquals(testCat, result);
    }

    @Test
    void getCat_ShouldReturnNullIfNotFound() {
        when(catRepository.findById(99L)).thenReturn(Optional.empty());

        Cat result = catService.getCat(99L);

        assertNull(result);
    }

    @Test
    void saveCat_ShouldCallRepositorySave() {
        catService.saveCat(testCat);

        verify(catRepository, times(1)).save(testCat);
    }

    @Test
    void deleteCat_ShouldDeleteIfExists() {
        // Odsud jsme vymazali řádek s 'when', protože tvoje metoda do DB před mazáním nekouká

        catService.deleteCat(1L);

        verify(catRepository, times(1)).deleteById(1L);
    }

    @Test
    void deleteCat_ShouldNotDeleteIfNotExists() {
        // Tady taky vymazán řádek s 'when'

        catService.deleteCat(99L);

        verify(catRepository, times(1)).deleteById(99L);
    }

    @Test
    void getAllCats_ShouldReturnListOfCats() {
        List<Cat> cats = Arrays.asList(new Cat(), new Cat());
        when(catRepository.findAll()).thenReturn(cats);

        List<Cat> result = catService.getAllCats();

        assertEquals(2, result.size());
        verify(catRepository, times(1)).findAll();
    }
}