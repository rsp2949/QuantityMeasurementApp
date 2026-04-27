package src.com.apps.quantitymeasurement;

import org.junit.Test;

import static org.junit.Assert.*;

public class QuantityMeasurementAppTest {

    @Test
    public void testEquality_KilogramToGram() {

        Weight w1 =
                new Weight(1.0, WeightUnit.KILOGRAM);

        Weight w2 =
                new Weight(1000.0, WeightUnit.GRAM);

        assertTrue(w1.equals(w2));
    }

    @Test
    public void testEquality_KilogramToKilogram_Different() {

        Weight w1 =
                new Weight(1.0, WeightUnit.KILOGRAM);

        Weight w2 =
                new Weight(2.0, WeightUnit.KILOGRAM);

        assertFalse(w1.equals(w2));
    }

    @Test
    public void testConversion_KilogramToPound() {

        Weight result =
                new Weight(1.0, WeightUnit.KILOGRAM)
                        .convertTo(WeightUnit.POUND);

        assertEquals(
                2.204,
                result.getValue(),
                0.01);
    }

    @Test
    public void testAddition_KilogramPlusGram() {

        Weight result =
                new Weight(1.0, WeightUnit.KILOGRAM)
                        .add(
                                new Weight(
                                        1000.0,
                                        WeightUnit.GRAM),
                                WeightUnit.KILOGRAM);

        assertEquals(
                2.0,
                result.getValue(),
                0.01);
    }

    @Test
    public void testNullComparison() {

        Weight w1 =
                new Weight(1.0, WeightUnit.KILOGRAM);

        assertFalse(w1.equals(null));
    }

    @Test(expected = IllegalArgumentException.class)
    public void testNullUnit() {

        new Weight(1.0, null);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testInvalidValue() {

        new Weight(Double.NaN,
                WeightUnit.KILOGRAM);
    }
}