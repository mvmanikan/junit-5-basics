package io.kavinmaha;

import org.junit.jupiter.api.*;
import org.junit.jupiter.api.condition.EnabledOnJre;
import org.junit.jupiter.api.condition.EnabledOnOs;
import org.junit.jupiter.api.condition.OS;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assumptions.*;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
class MathUtilsTest {

    MathUtils mathUtils;

    @BeforeAll
    void initClean(){
        System.out.println("Cleaning process starts");
    }
    @BeforeEach
    void init() {
        mathUtils = new MathUtils();
    }

    @AfterEach
    void cleanUp(){
        System.out.println("Cleaning up....");
    }

    @Nested
    @DisplayName("Add two numbers")
    class AddCases{
        @Test
        void testAdd() {
            int expected = 2;
            int actual = mathUtils.add(1, 1);
            assertEquals(expected, actual, "The add is not correct!");
            System.out.println("This is a test run");
            //fail("not implemented");
        }

        @Test
        void testAddition() {
            assertEquals(4,mathUtils.add(2, 2),"The add is not correct!");
        }
    }


    @Test
    @DisplayName("Multiply 2 Numbers")
    @Tag("Mani")
    void testMultiple(){
        assertAll(
                () -> assertEquals(4,mathUtils.multiply(2,2)),
                () -> assertEquals(0,mathUtils.multiply(2,0)),
                () -> assertEquals(-2,mathUtils.multiply(2,-1))
        );
    }

    @Test
    @EnabledOnOs(OS.WINDOWS)
    void testDivide() {
        //MathUtils mathUtils = new MathUtils();
        //assertThrows(NullPointerException.class, () -> mathUtils.divide(1, 0));
        boolean isServerUp = true;
        assumeTrue(isServerUp);
        assertThrows(ArithmeticException.class, () -> mathUtils.divide(1, 0));
    }

    //@Test
    @RepeatedTest(3)
    void testComputeCircleRadius() {
        //MathUtils mathUtils = new MathUtils();
        assertEquals(314.1592653589793, mathUtils.computeCircleRadius(10), "Radius of the Circle is not correct");
    }

    @Test
    @DisplayName("Failed Testcase")
    @Disabled
    void disable(){
        System.out.println("Failed Testcase");
    }


}