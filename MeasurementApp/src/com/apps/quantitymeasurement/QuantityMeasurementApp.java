package src.com.apps.quantitymeasurement;

public class QuantityMeasurementApp {

    public static boolean demonstrateLengthEquality(
            Length l1,
            Length l2) {

        return l1.equals(l2);
    }

    public static Length demonstrateLengthConversion(
            double value,
            LengthUnit fromUnit,
            LengthUnit toUnit) {

        Length length =
                new Length(value, fromUnit);

        return length.convertTo(toUnit);
    }

    public static Length demonstrateLengthAddition(
            Length l1,
            Length l2,
            LengthUnit targetUnit) {

        return l1.add(l2, targetUnit);
    }

    public static void main(String[] args) {

        Length l1 =
                new Length(1.0, LengthUnit.FEET);

        Length l2 =
                new Length(12.0, LengthUnit.INCHES);

        System.out.println(
                "Equal : " +
                        demonstrateLengthEquality(l1, l2));

        System.out.println(
                "Convert : " +
                        demonstrateLengthConversion(
                                1.0,
                                LengthUnit.YARDS,
                                LengthUnit.FEET));

        System.out.println(
                "Add : " +
                        demonstrateLengthAddition(
                                l1,
                                l2,
                                LengthUnit.YARDS));
    }
}