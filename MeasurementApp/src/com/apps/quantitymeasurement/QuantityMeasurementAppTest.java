package src.com.apps.quantitymeasurement;

import org.junit.Test;

import static org.junit.Assert.*;

public class QuantityMeasurementAppTest {

    @Test
    public void testConvertToBaseUnit_InchesToFeet() {

        assertEquals(
                12.0,
                LengthUnit.INCHES.convertToBaseUnit(12.0),
                0.001);
    }

    @Test
    public void testConvertFromBaseUnit_FeetToInches() {

        assertEquals(
                12.0,
                LengthUnit.INCHES.convertFromBaseUnit(12.0),
                0.001);
    }

    @Test
    public void testQuantityLengthRefactored_Equality() {

        Length l1 =
                new Length(1.0, LengthUnit.FEET);

        Length l2 =
                new Length(12.0, LengthUnit.INCHES);

        assertTrue(l1.equals(l2));
    }

    @Test
    public void testQuantityLengthRefactored_ConvertTo() {

        Length result =
                new Length(1.0, LengthUnit.FEET)
                        .convertTo(LengthUnit.INCHES);

        assertEquals(
                12.0,
                result.getValue(),
                0.01);
    }

    @Test
    public void testQuantityLengthRefactored_Add() {

        Length l1 =
                new Length(1.0, LengthUnit.FEET);

        Length l2 =
                new Length(12.0, LengthUnit.INCHES);

        Length result =
                l1.add(l2, LengthUnit.FEET);

        assertEquals(
                2.0,
                result.getValue(),
                0.01);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testQuantityLengthRefactored_NullUnit() {

        new Length(1.0, null);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testQuantityLengthRefactored_InvalidValue() {

        new Length(Double.NaN, LengthUnit.FEET);
    }
}