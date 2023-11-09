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

        assertEquals(10, math.sum(2, 3, 5), "Yig'indi to'gri natija qaytarishi kerak");
        assertEquals(0, math.sum(), "O qaytishi kerak ");
        assertThrows(IllegalArgumentException.class, () -> math.sum(null), "null olsa exception otishi kerak throw IllegalArgumentException degan");
    }

    @Test
    void testSub() {
        assertEquals(2, math.sub(5, 3), "Ayirish to'g'ri natija qaytarishi kerak");
    }

    @Test
    void testAdd() {
        assertEquals(8, math.add(3, 5), "Qo'shish to'g'ri natija qaytarish kerak ");
    }

    @Test
    void testDiv() {
        assertEquals(2, math.div(6, 3), "Bolish to'g'ri natija qaytarishi kerak");
        assertThrows(IllegalArgumentException.class, () -> math.div(5, 0), "0 ga bo'linish exception otadi throw IllegalArgumentException");
    }

    @Test
    void testMul() {
        assertEquals(15, math.mul(3, 5), "Ko'paytma to'g'ri natija qaytarish kerak");
    }

    @Test
    void testPow() {
        assertEquals(8, math.pow(2, 3), "Darajaga o'shirish ");
    }
}
