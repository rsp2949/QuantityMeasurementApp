package src.com.apps.quantitymeasurement;

import org.junit.Test;

import static org.junit.Assert.*;

public class QuantityMeasurementAppTest {

    @Test
    public void testAddition_SameUnit_FeetPlusFeet() {

        QuantityMeasurementApp.Length l1 =
                new QuantityMeasurementApp.Length(
                        1.0,
                        QuantityMeasurementApp.LengthUnit.FEET);

        QuantityMeasurementApp.Length l2 =
                new QuantityMeasurementApp.Length(
                        2.0,
                        QuantityMeasurementApp.LengthUnit.FEET);

        QuantityMeasurementApp.Length result = l1.add(l2);

        assertEquals(3.0, result.getValue(), 0.0001);
        assertEquals(
                QuantityMeasurementApp.LengthUnit.FEET,
                result.getUnit());
    }

    @Test
    public void testAddition_CrossUnit_FeetPlusInches() {

        QuantityMeasurementApp.Length l1 =
                new QuantityMeasurementApp.Length(
                        1.0,
                        QuantityMeasurementApp.LengthUnit.FEET);

        QuantityMeasurementApp.Length l2 =
                new QuantityMeasurementApp.Length(
                        12.0,
                        QuantityMeasurementApp.LengthUnit.INCHES);

        QuantityMeasurementApp.Length result = l1.add(l2);

        assertEquals(2.0, result.getValue(), 0.0001);
    }

    @Test
    public void testAddition_CrossUnit_InchPlusFeet() {

        QuantityMeasurementApp.Length l1 =
                new QuantityMeasurementApp.Length(
                        12.0,
                        QuantityMeasurementApp.LengthUnit.INCHES);

        QuantityMeasurementApp.Length l2 =
                new QuantityMeasurementApp.Length(
                        1.0,
                        QuantityMeasurementApp.LengthUnit.FEET);

        QuantityMeasurementApp.Length result = l1.add(l2);

        assertEquals(24.0, result.getValue(), 0.0001);
    }

    @Test
    public void testAddition_WithZero() {

        QuantityMeasurementApp.Length l1 =
                new QuantityMeasurementApp.Length(
                        5.0,
                        QuantityMeasurementApp.LengthUnit.FEET);

        QuantityMeasurementApp.Length l2 =
                new QuantityMeasurementApp.Length(
                        0.0,
                        QuantityMeasurementApp.LengthUnit.INCHES);

        QuantityMeasurementApp.Length result = l1.add(l2);

        assertEquals(5.0, result.getValue(), 0.0001);
    }

    @Test
    public void testAddition_NegativeValues() {

        QuantityMeasurementApp.Length l1 =
                new QuantityMeasurementApp.Length(
                        5.0,
                        QuantityMeasurementApp.LengthUnit.FEET);

        QuantityMeasurementApp.Length l2 =
                new QuantityMeasurementApp.Length(
                        -2.0,
                        QuantityMeasurementApp.LengthUnit.FEET);

        QuantityMeasurementApp.Length result = l1.add(l2);

        assertEquals(3.0, result.getValue(), 0.0001);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testAddition_NullSecondOperand() {

        QuantityMeasurementApp.Length l1 =
                new QuantityMeasurementApp.Length(
                        1.0,
                        QuantityMeasurementApp.LengthUnit.FEET);

        l1.add(null);
    }
}