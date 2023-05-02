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
    @Tag("testeValideBVA")
    void addInhousePartValid() {
        assertEquals("", Part.isValidPart("M", Float.MAX_VALUE, 2, 1, 3, ""));
        StringBuilder nameS = new StringBuilder();
        for(int i = 0; i < 255; i++){
            nameS.append("a");
        }
        assertEquals("", Part.isValidPart(nameS.toString(), 10, 2, 1, 3, ""));
    }

    @Test
    @Tag("testeInvalideBVA")
    void addPartInvalid() {
        assertEquals("A name has not been entered. ", Part.isValidPart("", 10, 2, 1, 3, ""));
        assertEquals("The price must be greater than 0. ", Part.isValidPart("M123", 0, 2, 1, 3, ""));
    }

    @Test
    @Tag("testValideECP")
    void addOutsourcePart() {
        assertEquals("Piesa 1", part.getName());
        assertEquals("Piesa 2", part2.getName());
        assertEquals("A", part2.getCompanyName());
        assertEquals("", Part.isValidPart("Piesa 2", 100, 3, 1, 4, ""));
        assertEquals("", Part.isValidPart(name, price, inStock, min, max, ""));
    }

    @Test
    @Tag("testeInvalideECP")
    void addOutsourcePartInvalid(){
        assertEquals("Inventory level is higher than the maximum value. ", Part.isValidPart(name, price, 10, min, max, ""));
    }

    @ParameterizedTest
    @MethodSource
    @Tag("testeInvalideECP")
    void addPart3(String name, double price, int inStock, int min, int max) {
        assertEquals("A name has not been entered. ", Part.isValidPart(name, price, inStock, min, max, ""));
    }
    @Tag("generatorParameterized")
    private static Stream<Arguments> addPart3() {
        return Stream.of(
                arguments("", 10, 3, 1, 4)
        );
    }
    @Tag("test4")
    @Test
    void isValiPart4(){
        assertEquals("The Min value must be less than the Max value. Inventory level is higher than the maximum value. ",
                Part.isValidPart("Piesa", 10, 4, 3, 1, ""));

    }

    @Disabled
    void testAdd(){
        assertEquals("Inventory level must be higher than 0. ", Part.isValidPart(name, price, 0, min, max, ""));
    }

}