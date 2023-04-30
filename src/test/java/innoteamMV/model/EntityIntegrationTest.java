package innoteamMV.model;

import innoteamMV.repository.InventoryRepository;
import innoteamMV.service.InventoryService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

public class EntityIntegrationTest {

    private InventoryRepository inventoryRepository;
    private InventoryService inventoryService;
    private OutsourcedPart outsourcedPart;

    @BeforeEach
    public void setUp(){
        outsourcedPart = new OutsourcedPart(1, "A", 10.0, 4, 1, 3, "C");
        inventoryRepository = new InventoryRepository();
        inventoryService = new InventoryService(inventoryRepository);
    }

    @Test
    public void test1(){

        assertNull(inventoryRepository.lookupPart(outsourcedPart.getName()));
        assertNull(inventoryService.lookupPart(outsourcedPart.getName()));
    }

    @Test
    public void test2(){
        inventoryRepository.deletePart(outsourcedPart);
        assertEquals(14, inventoryRepository.getAllParts().size() + inventoryRepository.getAllProducts().size());
        inventoryService.deletePart(outsourcedPart);
        assertEquals(14, inventoryService.getAllParts().size() + inventoryService.getAllProducts().size());
    }
}
