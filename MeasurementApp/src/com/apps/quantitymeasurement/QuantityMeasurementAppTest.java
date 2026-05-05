package src.com.apps.quantitymeasurement;

import org.junit.Test;
import static org.junit.Assert.*;

public class QuantityTest {

    @Test
    public void testLengthEquality() {
        Quantity<LengthUnit> a = new Quantity<>(1.0, LengthUnit.FEET);
        Quantity<LengthUnit> b = new Quantity<>(12.0, LengthUnit.INCHES);
        assertTrue(a.equals(b));
    }

    @Test
    public void testWeightEquality() {
        Quantity<WeightUnit> a = new Quantity<>(1.0, WeightUnit.KILOGRAM);
        Quantity<WeightUnit> b = new Quantity<>(1000.0, WeightUnit.GRAM);
        assertTrue(a.equals(b));
    }

    @Test
    public void testCrossCategory() {
        Quantity<LengthUnit> l = new Quantity<>(1.0, LengthUnit.FEET);
        Quantity<WeightUnit> w = new Quantity<>(1.0, WeightUnit.KILOGRAM);
        assertFalse(l.equals(w));
    }

    @Test
    public void testAddition() {
        Quantity<LengthUnit> a = new Quantity<>(1.0, LengthUnit.FEET);
        Quantity<LengthUnit> b = new Quantity<>(12.0, LengthUnit.INCHES);
        assertEquals(new Quantity<>(2.0, LengthUnit.FEET), a.add(b));
    }
}