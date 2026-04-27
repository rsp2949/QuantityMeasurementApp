package src.com.apps.quantitymeasurement;

import org.junit.Test;

import static org.junit.Assert.*;

public class QuantityMeasurementAppTest {

    @Test
    public void testAddition_ExplicitTargetUnit_Feet() {

        QuantityMeasurementApp.Length l1 =
                new QuantityMeasurementApp.Length(
                        1.0,
                        QuantityMeasurementApp.LengthUnit.FEET);

        QuantityMeasurementApp.Length l2 =
                new QuantityMeasurementApp.Length(
                        12.0,
                        QuantityMeasurementApp.LengthUnit.INCHES);

        QuantityMeasurementApp.Length result =
                l1.add(l2,
                        QuantityMeasurementApp.LengthUnit.FEET);

        assertEquals(2.0, result.getValue(), 0.0001);
    }

    @Test
    public void testAddition_ExplicitTargetUnit_Inches() {

        QuantityMeasurementApp.Length l1 =
                new QuantityMeasurementApp.Length(
                        1.0,
                        QuantityMeasurementApp.LengthUnit.FEET);

        QuantityMeasurementApp.Length l2 =
                new QuantityMeasurementApp.Length(
                        12.0,
                        QuantityMeasurementApp.LengthUnit.INCHES);

        QuantityMeasurementApp.Length result =
                l1.add(l2,
                        QuantityMeasurementApp.LengthUnit.INCHES);

        assertEquals(24.0, result.getValue(), 0.0001);
    }

    @Test
    public void testAddition_ExplicitTargetUnit_Yards() {

        QuantityMeasurementApp.Length l1 =
                new QuantityMeasurementApp.Length(
                        1.0,
                        QuantityMeasurementApp.LengthUnit.FEET);

        QuantityMeasurementApp.Length l2 =
                new QuantityMeasurementApp.Length(
                        12.0,
                        QuantityMeasurementApp.LengthUnit.INCHES);

        QuantityMeasurementApp.Length result =
                l1.add(l2,
                        QuantityMeasurementApp.LengthUnit.YARDS);

        assertEquals(0.6667, result.getValue(), 0.01);
    }

    @Test
    public void testAddition_ExplicitTargetUnit_Centimeters() {

        QuantityMeasurementApp.Length l1 =
                new QuantityMeasurementApp.Length(
                        1.0,
                        QuantityMeasurementApp.LengthUnit.INCHES);

        QuantityMeasurementApp.Length l2 =
                new QuantityMeasurementApp.Length(
                        1.0,
                        QuantityMeasurementApp.LengthUnit.INCHES);

        QuantityMeasurementApp.Length result =
                l1.add(l2,
                        QuantityMeasurementApp.LengthUnit.CENTIMETERS);

        assertEquals(5.08, result.getValue(), 0.05);
    }

    @Test
    public void testAddition_ExplicitTargetUnit_WithZero() {

        QuantityMeasurementApp.Length l1 =
                new QuantityMeasurementApp.Length(
                        5.0,
                        QuantityMeasurementApp.LengthUnit.FEET);

        QuantityMeasurementApp.Length l2 =
                new QuantityMeasurementApp.Length(
                        0.0,
                        QuantityMeasurementApp.LengthUnit.INCHES);

        QuantityMeasurementApp.Length result =
                l1.add(l2,
                        QuantityMeasurementApp.LengthUnit.YARDS);

        assertEquals(1.6667, result.getValue(), 0.01);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testAddition_ExplicitTargetUnit_NullTargetUnit() {

        QuantityMeasurementApp.Length l1 =
                new QuantityMeasurementApp.Length(
                        1.0,
                        QuantityMeasurementApp.LengthUnit.FEET);

        QuantityMeasurementApp.Length l2 =
                new QuantityMeasurementApp.Length(
                        12.0,
                        QuantityMeasurementApp.LengthUnit.INCHES);

        l1.add(l2, null);
    }
}