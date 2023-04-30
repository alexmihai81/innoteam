package innoteamMV.repository;

import innoteamMV.model.InhousePart;
import innoteamMV.model.Inventory;
import innoteamMV.model.Part;
import innoteamMV.model.Product;
import org.junit.Before;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

public class InventoryRepositoryMockTest {
    @Mock
    private InventoryRepository inventoryRepository;

    @BeforeEach
    public void setUp(){
        inventoryRepository = mock(InventoryRepository.class);
    }

    @Test
    public void Test1(){
        Mockito.when(inventoryRepository.lookupPart("300")).thenReturn(null);
        assertNull(inventoryRepository.lookupPart("300"));
        Mockito.verify(inventoryRepository, times(1)).lookupPart("300");
    }

    @Test
    public void Test2(){
        Mockito.when(inventoryRepository.lookupPart("11")).thenReturn(new InhousePart(11, "part12",
                1.89, 3, 1, 8, 124));
        assertNotNull(inventoryRepository.lookupPart("11"));
        assertEquals(11, inventoryRepository.lookupPart("11").getPartId());
        assertEquals("part12", inventoryRepository.lookupPart("11").getName());
        assertEquals(1.89, inventoryRepository.lookupPart("11").getPrice());
        assertEquals(3, inventoryRepository.lookupPart("11").getInStock());
        assertEquals(1, inventoryRepository.lookupPart("11").getMin());
        assertEquals(8, inventoryRepository.lookupPart("11").getMax());
        Mockito.verify(inventoryRepository, times(7)).lookupPart("11");
    }
}
