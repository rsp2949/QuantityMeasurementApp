package src.com.apps.quantitymeasurement;

import org.junit.Test;

import static org.junit.Assert.*;

public class QuantityMeasurementAppTest {

    @Test
    public void testEquality_YardToYard_SameValue() {
        QuantityMeasurementApp.Length a =
                new QuantityMeasurementApp.Length(1.0,
                        QuantityMeasurementApp.LengthUnit.YARDS);

        QuantityMeasurementApp.Length b =
                new QuantityMeasurementApp.Length(1.0,
                        QuantityMeasurementApp.LengthUnit.YARDS);

        assertTrue(a.equals(b));
    }

    @Test
    public void testEquality_YardToFeet_EquivalentValue() {
        QuantityMeasurementApp.Length a =
                new QuantityMeasurementApp.Length(1.0,
                        QuantityMeasurementApp.LengthUnit.YARDS);

        QuantityMeasurementApp.Length b =
                new QuantityMeasurementApp.Length(3.0,
                        QuantityMeasurementApp.LengthUnit.FEET);

        assertTrue(a.equals(b));
    }

    @Test
    public void testEquality_YardToInches_EquivalentValue() {
        QuantityMeasurementApp.Length a =
                new QuantityMeasurementApp.Length(1.0,
                        QuantityMeasurementApp.LengthUnit.YARDS);

        QuantityMeasurementApp.Length b =
                new QuantityMeasurementApp.Length(36.0,
                        QuantityMeasurementApp.LengthUnit.INCHES);

        assertTrue(a.equals(b));
    }

    @Test
    public void testEquality_CentimeterToInches_EquivalentValue() {
        QuantityMeasurementApp.Length a =
                new QuantityMeasurementApp.Length(1.0,
                        QuantityMeasurementApp.LengthUnit.CENTIMETERS);

        QuantityMeasurementApp.Length b =
                new QuantityMeasurementApp.Length(0.393701,
                        QuantityMeasurementApp.LengthUnit.INCHES);

        assertTrue(a.equals(b));
    }

    @Test
    public void testEquality_CentimeterToFeet_NonEquivalent() {
        QuantityMeasurementApp.Length a =
                new QuantityMeasurementApp.Length(1.0,
                        QuantityMeasurementApp.LengthUnit.CENTIMETERS);

        QuantityMeasurementApp.Length b =
                new QuantityMeasurementApp.Length(1.0,
                        QuantityMeasurementApp.LengthUnit.FEET);

        assertFalse(a.equals(b));
    }

    @Test
    public void testEquality_SameReference() {
        QuantityMeasurementApp.Length a =
                new QuantityMeasurementApp.Length(2.0,
                        QuantityMeasurementApp.LengthUnit.YARDS);

        assertTrue(a.equals(a));
    }

    @Test
    public void testEquality_NullComparison() {
        QuantityMeasurementApp.Length a =
                new QuantityMeasurementApp.Length(2.0,
                        QuantityMeasurementApp.LengthUnit.YARDS);

        assertFalse(a.equals(null));
    }

    @Test(expected = IllegalArgumentException.class)
    public void testEquality_NullUnit() {
        new QuantityMeasurementApp.Length(1.0, null);
    }
}