package src.com.apps.quantitymeasurement;

public class QuantityMeasurementApp {

    public static <U extends IMeasurable> boolean demonstrateEquality(
            Quantity<U> q1, Quantity<U> q2) {
        return q1.equals(q2);
    }

    public static <U extends IMeasurable> Quantity<U> demonstrateConversion(
            Quantity<U> q, U targetUnit) {
        return q.convertTo(targetUnit);
    }

    public static <U extends IMeasurable> Quantity<U> demonstrateAddition(
            Quantity<U> q1, Quantity<U> q2) {
        return q1.add(q2);
    }

    public static <U extends IMeasurable> Quantity<U> demonstrateAddition(
            Quantity<U> q1, Quantity<U> q2, U targetUnit) {
        return q1.add(q2, targetUnit);
    }

    public static void main(String[] args) {

        // LENGTH
        Quantity<LengthUnit> l1 = new Quantity<>(1.0, LengthUnit.FEET);
        Quantity<LengthUnit> l2 = new Quantity<>(12.0, LengthUnit.INCHES);

        System.out.println("Length Equal: " + demonstrateEquality(l1, l2));
        System.out.println("Convert: " + demonstrateConversion(l1, LengthUnit.INCHES));
        System.out.println("Add: " + demonstrateAddition(l1, l2));
        System.out.println("Add Target: " +
                demonstrateAddition(l1, l2, LengthUnit.YARDS));

        // WEIGHT
        Quantity<WeightUnit> w1 = new Quantity<>(1.0, WeightUnit.KILOGRAM);
        Quantity<WeightUnit> w2 = new Quantity<>(1000.0, WeightUnit.GRAM);

        System.out.println("Weight Equal: " + demonstrateEquality(w1, w2));
        System.out.println("Convert: " + demonstrateConversion(w1, WeightUnit.GRAM));
        System.out.println("Add: " + demonstrateAddition(w1, w2));
        System.out.println("Add Target: " +
                demonstrateAddition(w1, w2, WeightUnit.POUND));
    }
}