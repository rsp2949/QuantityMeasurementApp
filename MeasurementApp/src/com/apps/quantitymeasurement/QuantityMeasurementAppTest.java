package src.com.apps.quantitymeasurement;

import org.junit.Test;

import static org.junit.Assert.*;

public class QuantityMeasurementAppTest {

    @Test
    public void testEquality_FeetToFeet_SameValue() {
        QuantityMeasurementApp.Length l1 =
                new QuantityMeasurementApp.Length(1.0,
                        QuantityMeasurementApp.LengthUnit.FEET);

        QuantityMeasurementApp.Length l2 =
                new QuantityMeasurementApp.Length(1.0,
                        QuantityMeasurementApp.LengthUnit.FEET);

        assertTrue(l1.equals(l2));
    }

    @Test
    public void testEquality_InchToInch_SameValue() {
        QuantityMeasurementApp.Length l1 =
                new QuantityMeasurementApp.Length(1.0,
                        QuantityMeasurementApp.LengthUnit.INCHES);

        QuantityMeasurementApp.Length l2 =
                new QuantityMeasurementApp.Length(1.0,
                        QuantityMeasurementApp.LengthUnit.INCHES);

        assertTrue(l1.equals(l2));
    }

    @Test
    public void testEquality_FeetToInch_EquivalentValue() {
        QuantityMeasurementApp.Length l1 =
                new QuantityMeasurementApp.Length(1.0,
                        QuantityMeasurementApp.LengthUnit.FEET);

        QuantityMeasurementApp.Length l2 =
                new QuantityMeasurementApp.Length(12.0,
                        QuantityMeasurementApp.LengthUnit.INCHES);

        assertTrue(l1.equals(l2));
    }

    @Test
    public void testEquality_DifferentValue() {
        QuantityMeasurementApp.Length l1 =
                new QuantityMeasurementApp.Length(2.0,
                        QuantityMeasurementApp.LengthUnit.FEET);

        QuantityMeasurementApp.Length l2 =
                new QuantityMeasurementApp.Length(1.0,
                        QuantityMeasurementApp.LengthUnit.FEET);

        assertFalse(l1.equals(l2));
    }

    @Test
    public void testEquality_NullComparison() {
        QuantityMeasurementApp.Length l1 =
                new QuantityMeasurementApp.Length(1.0,
                        QuantityMeasurementApp.LengthUnit.FEET);

        assertFalse(l1.equals(null));
    }

    @Test
    public void testEquality_SameReference() {
        QuantityMeasurementApp.Length l1 =
                new QuantityMeasurementApp.Length(1.0,
                        QuantityMeasurementApp.LengthUnit.FEET);

        assertTrue(l1.equals(l1));
    }

    @Test(expected = IllegalArgumentException.class)
    public void testEquality_NullUnit() {
        new QuantityMeasurementApp.Length(1.0, null);
    }
}