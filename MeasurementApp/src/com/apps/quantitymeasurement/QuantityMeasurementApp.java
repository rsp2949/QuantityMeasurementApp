package src.com.apps.quantitymeasurement;

public class QuantityMeasurementApp {

    public static boolean demonstrateWeightEquality(
            Weight w1,
            Weight w2) {

        return w1.equals(w2);
    }

    public static Weight demonstrateWeightConversion(
            double value,
            WeightUnit from,
            WeightUnit to) {

        return new Weight(value, from).convertTo(to);
    }

    public static Weight demonstrateWeightAddition(
            Weight w1,
            Weight w2,
            WeightUnit target) {

        return w1.add(w2, target);
    }

    public static void main(String[] args) {

        Weight w1 =
                new Weight(1.0, WeightUnit.KILOGRAM);

        Weight w2 =
                new Weight(1000.0, WeightUnit.GRAM);

        System.out.println(
                "Equal : " +
                        demonstrateWeightEquality(w1, w2));

        System.out.println(
                "Convert : " +
                        demonstrateWeightConversion(
                                1.0,
                                WeightUnit.KILOGRAM,
                                WeightUnit.POUND));

        System.out.println(
                "Add : " +
                        demonstrateWeightAddition(
                                w1,
                                w2,
                                WeightUnit.KILOGRAM));
    }
}