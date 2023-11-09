package uz.pdp.dataabsemigration.serice;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import uz.pdp.dataabsemigration.servie.MyMath;

import static org.junit.jupiter.api.Assertions.*;

class MyMathTest {

    MyMath math ;

    @BeforeEach
     void beforeEach() {
        math = new MyMath();
    }

    @Test
    void testSum() {

        assertEquals(10, math.sum(2, 3, 5), "Sum should return the correct result");
        assertEquals(0, math.sum(), "Sum should return 0 for an empty list of arguments");
        assertThrows(IllegalArgumentException.class, () -> math.sum(null), "Sum should throw IllegalArgumentException for null arguments");
    }

    @Test
    void testSub() {
        assertEquals(2, math.sub(5, 3), "Subtraction should return the correct result");
    }

    @Test
    void testAdd() {
        assertEquals(8, math.add(3, 5), "Addition should return the correct result");
    }

    @Test
    void testDiv() {
        assertEquals(2, math.div(6, 3), "Division should return the correct result");
        assertThrows(IllegalArgumentException.class, () -> math.div(5, 0), "Divide by zero should throw IllegalArgumentException");
    }

    @Test
    void testMul() {
        assertEquals(15, math.mul(3, 5), "Multiplication should return the correct result");
    }

    @Test
    void testPow() {
        assertEquals(8, math.pow(2, 3), "Power should return the correct result");
        assertEquals(1, math.pow(5, 0), "Any number to the power of 0 should be 1");
    }
}
