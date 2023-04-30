package innoteamMV.repository;

import innoteamMV.model.OutsourcedPart;
import innoteamMV.service.InventoryService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.MockedConstruction;
import org.mockito.Mockito;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.mockito.Mockito.mockConstruction;
import static org.mockito.Mockito.times;

public class RepositoryIntegrationTest {

    private InventoryRepository inventoryRepository = new InventoryRepository();
    private InventoryService inventoryService;

    @BeforeEach
    public void setUp(){
        inventoryService = new InventoryService(inventoryRepository);
    }

    @Test
    public void test1(){
        try(MockedConstruction<OutsourcedPart> mock = mockConstruction(OutsourcedPart.class)){
            OutsourcedPart outsourcedPart = new OutsourcedPart(20, "TestPart1",
                    10.9, 2, 1, 4, "ABB");
            Mockito.when(outsourcedPart.getName()).thenReturn("TestPart1");
            assertNull(inventoryService.lookupPart(outsourcedPart.getName()));
            Mockito.verify(outsourcedPart, times(1)).getName();
        }
    }

    @Test
    public void test2(){
        try(MockedConstruction<OutsourcedPart> mock = mockConstruction(OutsourcedPart.class)){
            OutsourcedPart outsourcedPart = new OutsourcedPart(6, "p3", 1.0,
                    11, 1, 13,"ebgef");
            Mockito.when(outsourcedPart.getName()).thenReturn("p3");
            assertEquals("p3", inventoryService.lookupPart(outsourcedPart.getName()).getName());
            assertEquals(6, inventoryService.lookupPart(outsourcedPart.getName()).getPartId());
            assertEquals(1.0, inventoryService.lookupPart(outsourcedPart.getName()).getPrice());
            assertEquals(1, inventoryService.lookupPart(outsourcedPart.getName()).getMin());
            assertEquals(13, inventoryService.lookupPart(outsourcedPart.getName()).getMax());
            Mockito.verify(outsourcedPart, times(5)).getName();
        }
    }
}
