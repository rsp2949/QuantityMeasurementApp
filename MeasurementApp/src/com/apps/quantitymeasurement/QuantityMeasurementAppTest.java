package src.com.apps.quantitymeasurement;

import org.junit.Test;

import static org.junit.Assert.*;

public class QuantityMeasurementAppTest {

    @Test
    public void testConversion_FeetToInches() {
        assertEquals(
                12.0,
                QuantityMeasurementApp
                        .demonstrateLengthConversion(
                                1.0,
                                QuantityMeasurementApp.LengthUnit.FEET,
                                QuantityMeasurementApp.LengthUnit.INCHES),
                0.0001);
    }

    @Test
    public void testConversion_InchesToFeet() {
        assertEquals(
                2.0,
                QuantityMeasurementApp
                        .demonstrateLengthConversion(
                                24.0,
                                QuantityMeasurementApp.LengthUnit.INCHES,
                                QuantityMeasurementApp.LengthUnit.FEET),
                0.0001);
    }

    @Test
    public void testConversion_YardsToInches() {
        assertEquals(
                36.0,
                QuantityMeasurementApp
                        .demonstrateLengthConversion(
                                1.0,
                                QuantityMeasurementApp.LengthUnit.YARDS,
                                QuantityMeasurementApp.LengthUnit.INCHES),
                0.0001);
    }

    @Test
    public void testConversion_CentimetersToInches() {
        assertEquals(
                1.0,
                QuantityMeasurementApp
                        .demonstrateLengthConversion(
                                2.54,
                                QuantityMeasurementApp.LengthUnit.CENTIMETERS,
                                QuantityMeasurementApp.LengthUnit.INCHES),
                0.01);
    }

    @Test
    public void testConversion_ZeroValue() {
        assertEquals(
                0.0,
                QuantityMeasurementApp
                        .demonstrateLengthConversion(
                                0.0,
                                QuantityMeasurementApp.LengthUnit.FEET,
                                QuantityMeasurementApp.LengthUnit.INCHES),
                0.0001);
    }

    @Test
    public void testConversion_NegativeValue() {
        assertEquals(
                -12.0,
                QuantityMeasurementApp
                        .demonstrateLengthConversion(
                                -1.0,
                                QuantityMeasurementApp.LengthUnit.FEET,
                                QuantityMeasurementApp.LengthUnit.INCHES),
                0.0001);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testConversion_InvalidUnit() {
        QuantityMeasurementApp
                .demonstrateLengthConversion(
                        1.0,
                        null,
                        QuantityMeasurementApp.LengthUnit.FEET);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testConversion_NaNValue() {
        QuantityMeasurementApp
                .demonstrateLengthConversion(
                        Double.NaN,
                        QuantityMeasurementApp.LengthUnit.FEET,
                        QuantityMeasurementApp.LengthUnit.INCHES);
    }
}