package guru.springframework.repositories.reactive;

import guru.springframework.domain.Category;
import guru.springframework.domain.UnitOfMeasure;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.data.mongo.DataMongoTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.assertEquals;
import static org.junit.jupiter.api.Assertions.*;
@RunWith(SpringRunner.class)
@DataMongoTest
public class CategoryReactiveRepositoryTest {

    @Autowired
    CategoryReactiveRepository categoryReactiveRepository;

    @Test
    public void testSaveUom() throws Exception {
        Category cat = new Category();
        cat.setDescription("Each");

        categoryReactiveRepository.save(cat).block();

        Long count = categoryReactiveRepository.count().block();

        assertEquals(Long.valueOf(1L), count);
    }

    @Test
    public void testfindByDescription() throws Exception {
        Category cat = new Category();
        cat.setDescription("Each");

        categoryReactiveRepository.save(cat).block();

        Category savedCat = categoryReactiveRepository.findByDescription("Each")
                .block();

        assertNotNull(savedCat);
    }
}