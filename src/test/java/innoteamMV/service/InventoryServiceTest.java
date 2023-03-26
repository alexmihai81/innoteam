package innoteamMV.service;

import innoteamMV.model.OutsourcedPart;
import innoteamMV.model.Part;
import org.junit.jupiter.api.*;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.params.provider.Arguments.arguments;

class InventoryServiceTest {
    private String name;
    private double price;
    private int inStock;
    private int min;
    private int max;
    private String companyName;
    private OutsourcedPart part;
    private OutsourcedPart part2;


    @BeforeEach
    void setUp() {
        name = "Piesa 1";
        price = 10;
        inStock = 3;
        min = 1;
        max = 4;
        companyName = "A";
        part = new OutsourcedPart(0, name, price, inStock, min, max, companyName);
        part2 = new OutsourcedPart(1, "Piesa 2", 100, 5, 1, 4, companyName);
    }

    @AfterEach
    void tearDown() {
    }

    @Test
    void addInhousePartValid() {
        assertEquals("", Part.isValidPart("M", 10, 2, 1, 3, ""));
        assertEquals("", Part.isValidPart("M123", 10, 2, 1, 3, ""));
    }

    @Test
    void addPartInvalid() {
        assertEquals("A name has not been entered. ", Part.isValidPart("", 10, 2, 1, 3, ""));
        assertEquals("The price must be greater than 0. ", Part.isValidPart("M123", -1, 2, 1, 3, ""));
    }

    @Test
    void addOutsourcePart() {
        assertEquals("Piesa 1", part.getName());
        assertEquals("Piesa 2", part2.getName());
        assertEquals("A", part2.getCompanyName());
        assertEquals("", Part.isValidPart(name, price, inStock, min, max, ""));
    }

    @RepeatedTest(2)
    void addOutsourcePartInvalid(){
        assertEquals("Inventory level is higher than the maximum value. ", Part.isValidPart(name, price, 10, min, max, ""));
    }

    @ParameterizedTest
    @MethodSource
    void addPart3(String name, double price, int inStock, int min, int max) {
        assertEquals("A name has not been entered. ", Part.isValidPart(name, price, inStock, min, max, ""));
    }

    private static Stream<Arguments> addPart3() {
        return Stream.of(
                arguments("", 10, 3, 1, 4)
        );
    }

    @Disabled
    void testAdd(){
        assertEquals("Inventory level must be higher than 0. ", Part.isValidPart(name, price, 0, min, max, ""));
    }

}