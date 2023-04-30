package innoteamMV.service;

import innoteamMV.model.Inventory;
import innoteamMV.model.OutsourcedPart;
import innoteamMV.repository.InventoryRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.*;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

public class InventoryServiceMockTest {

    @BeforeEach
    public void setUp(){
    }

    @Test
    public void test1(){
        try(MockedConstruction<InventoryService> mock = mockConstruction(InventoryService.class)){
            InventoryService inventoryService = new InventoryService(new InventoryRepository());
            Mockito.when(inventoryService.lookupPart("200")).thenReturn(null);
            assertNull(inventoryService.lookupPart("200"));
            Mockito.verify(inventoryService, times(1)).lookupPart("200");
        };

    }

    @Test
    public void test2(){
        try(MockedConstruction<InventoryService> mock = mockConstruction(InventoryService.class)){
            InventoryService inventoryService = new InventoryService(new InventoryRepository());
            Mockito.when(inventoryService.lookupPart("6")).thenReturn(new OutsourcedPart(6, "p3", 1.0,
                    11, 1, 13,"ebgef"));
            assertNull(inventoryService.lookupPart("200"));
            assertEquals("p3", inventoryService.lookupPart("6").getName());
            assertEquals(6, inventoryService.lookupPart("6").getPartId());
            assertEquals(1.0, inventoryService.lookupPart("6").getPrice());
            assertEquals(1, inventoryService.lookupPart("6").getMin());
            assertEquals(13, inventoryService.lookupPart("6").getMax());
            Mockito.verify(inventoryService, times(1)).lookupPart("200");
            Mockito.verify(inventoryService, times(5)).lookupPart("6");
        };

    }
}
