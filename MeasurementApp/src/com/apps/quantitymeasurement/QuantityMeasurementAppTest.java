import org.junit.Test;
import static org.junit.Assert.*;

public class QuantityUC12Test {

    @Test
    public void testSubtraction_SameUnit() {
        Quantity<LengthUnit> q1 = new Quantity<>(5.0, LengthUnit.FEET);
        Quantity<LengthUnit> q2 = new Quantity<>(2.0, LengthUnit.FEET);

        Quantity<LengthUnit> result = q1.subtract(q2);

        assertEquals(3.0, result.getValue(), 0.01);
    }

    @Test
    public void testSubtraction_CrossUnit() {
        Quantity<LengthUnit> q1 = new Quantity<>(10.0, LengthUnit.FEET);
        Quantity<LengthUnit> q2 = new Quantity<>(6.0, LengthUnit.INCHES);

        Quantity<LengthUnit> result = q1.subtract(q2);

        assertEquals(9.5, result.getValue(), 0.01);
    }

    @Test
    public void testSubtraction_TargetUnit() {
        Quantity<LengthUnit> q1 = new Quantity<>(1.0, LengthUnit.FEET);
        Quantity<LengthUnit> q2 = new Quantity<>(6.0, LengthUnit.INCHES);

        Quantity<LengthUnit> result = q1.subtract(q2, LengthUnit.INCHES);

        assertEquals(6.0, result.getValue(), 0.01);
    }

    @Test
    public void testDivision_Basic() {
        Quantity<WeightUnit> q1 = new Quantity<>(10.0, WeightUnit.KILOGRAM);
        Quantity<WeightUnit> q2 = new Quantity<>(5.0, WeightUnit.KILOGRAM);

        double result = q1.divide(q2);

        assertEquals(2.0, result, 0.01);
    }

    @Test
    public void testDivision_CrossUnit() {
        Quantity<VolumeUnit> q1 = new Quantity<>(1.0, VolumeUnit.LITRE);
        Quantity<VolumeUnit> q2 = new Quantity<>(500.0, VolumeUnit.MILLILITRE);

        double result = q1.divide(q2);

        assertEquals(2.0, result, 0.01);
    }

    @Test(expected = ArithmeticException.class)
    public void testDivision_ByZero() {
        Quantity<WeightUnit> q1 = new Quantity<>(10.0, WeightUnit.KILOGRAM);
        Quantity<WeightUnit> q2 = new Quantity<>(0.0, WeightUnit.KILOGRAM);

        q1.divide(q2);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testDifferentTypes_Subtraction() {
        Quantity<LengthUnit> l = new Quantity<>(1.0, LengthUnit.FEET);
        Quantity<WeightUnit> w = new Quantity<>(1.0, WeightUnit.KILOGRAM);

        l.subtract((Quantity) w);
    }
}