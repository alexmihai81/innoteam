package innoteamMV.repository;

import innoteamMV.model.Product;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class InventoryRepositoryTest {
    private final InventoryRepository repository = new InventoryRepository();

    @BeforeEach
    void setUp() {

    }

    @AfterEach
    void tearDown() {
    }

    @Test
    @Tag("TestCase1")
    void TC1(){
        assertNull(repository.getProductFromString(null));
    }

    @Test
    @Tag("TestCase2")
    void TC2(){
        assertNull(repository.getProductFromString(""));
    }

    @Test
    @Tag("TestCase3")
    void TC3(){
        assertNull(repository.getProductFromString("O,8,part10,1.51,5,2,19,none"));
    }

    @Test
    @Tag("TestCase4")
    void TC4(){
        assertNotNull(repository.getProductFromString("P,5,products4,11.0,2,1,10, "));
        Product product = repository.getProductFromString("P,5,products4,11.0,2,1,10, ");
        assertEquals(product.getProductId(), 5);
        assertEquals(product.getName(), "products4");
        assertEquals(product.getPrice(), 11.0);
        assertEquals(product.getMax(), 10);
        assertEquals(product.getMin(), 1);
        assertEquals(product.getInStock(), 2);
        assertEquals(product.getAssociatedParts().size(), 0);
    }

    @Test
    @Tag("TestCase5")
    void TC5(){
        assertNotNull(repository.getProductFromString("P,6,products4,11.0,2,1,10,1"));
        Product product = repository.getProductFromString("P,6,products4,11.0,2,1,10,1");
        assertEquals(product.getProductId(), 6);
        assertEquals(product.getName(), "products4");
        assertEquals(product.getPrice(), 11.0);
        assertEquals(product.getMax(), 10);
        assertEquals(product.getMin(), 1);
        assertEquals(product.getInStock(), 2);
        assertEquals(product.getAssociatedParts().size(), 1);
    }

    @Test
    @Tag("TestCase6")
    void TC6(){
        assertNotNull(repository.getProductFromString("P,6,products4,11.0,2,1,10,100"));
        Product product = repository.getProductFromString("P,6,products4,11.0,2,1,10,100");
        assertEquals(product.getProductId(), 6);
        assertEquals(product.getName(), "products4");
        assertEquals(product.getPrice(), 11.0);
        assertEquals(product.getMax(), 10);
        assertEquals(product.getMin(), 1);
        assertEquals(product.getInStock(), 2);
        assertEquals(product.getAssociatedParts().size(), 1);
    }

    @Test
    @Tag("TestCase7")
    void TC7(){
        assertNotNull(repository.getProductFromString("P,4,products4,11.0,2,1,10,5:8:7:7"));
        Product product = repository.getProductFromString("P,6,products4,11.0,2,1,10,5:8:7:7");
        assertEquals(product.getProductId(), 6);
        assertEquals(product.getName(), "products4");
        assertEquals(product.getPrice(), 11.0);
        assertEquals(product.getMax(), 10);
        assertEquals(product.getMin(), 1);
        assertEquals(product.getInStock(), 2);
        assertEquals(product.getAssociatedParts().size(), 4);
    }
}