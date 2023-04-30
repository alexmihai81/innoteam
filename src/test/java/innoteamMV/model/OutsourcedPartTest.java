package innoteamMV.model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class OutsourcedPartTest {

    private OutsourcedPart outsourcedPart;

    @BeforeEach
    void setUp() {
        outsourcedPart = new OutsourcedPart(1, "A", 10.0, 4, 1, 3, "C");
    }

    @Test
    void getCompanyName() {
        assertEquals("C", outsourcedPart.getCompanyName());
    }

    @Test
    void getName(){
        assertEquals("A", outsourcedPart.getName());
    }
}