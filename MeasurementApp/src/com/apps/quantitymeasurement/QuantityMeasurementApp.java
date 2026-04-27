package src.com.apps.quantitymeasurement;

public class QuantityMeasurementApp {

    public enum LengthUnit {
        FEET(12.0),
        INCHES(1.0);

        private final double conversionFactor;

        LengthUnit(double conversionFactor) {
            this.conversionFactor = conversionFactor;
        }

        public double getConversionFactor() {
            return conversionFactor;
        }
    }

    public static class Length {
        private double value;
        private LengthUnit unit;

        public Length(double value, LengthUnit unit) {
            if (unit == null) {
                throw new IllegalArgumentException("Unit cannot be null");
            }
            this.value = value;
            this.unit = unit;
        }

        private double convertToBaseUnit() {
            return value * unit.getConversionFactor();
        }

        public boolean compare(Length thatLength) {
            return Double.compare(this.convertToBaseUnit(),
                    thatLength.convertToBaseUnit()) == 0;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;

            Length that = (Length) o;
            return compare(that);
        }
    }

    public static boolean demonstrateLengthEquality(Length length1, Length length2) {
        return length1.equals(length2);
    }

    public static void demonstrateFeetEquality() {
        Length l1 = new Length(1.0, LengthUnit.FEET);
        Length l2 = new Length(1.0, LengthUnit.FEET);

        System.out.println("Input: Quantity(1.0, FEET) and Quantity(1.0, FEET)");
        System.out.println("Output: Equal (" + demonstrateLengthEquality(l1, l2) + ")");
    }

    public static void demonstrateInchesEquality() {
        Length l1 = new Length(1.0, LengthUnit.INCHES);
        Length l2 = new Length(1.0, LengthUnit.INCHES);

        System.out.println("Input: Quantity(1.0, INCHES) and Quantity(1.0, INCHES)");
        System.out.println("Output: Equal (" + demonstrateLengthEquality(l1, l2) + ")");
    }

    public static void demonstrateFeetInchesComparison() {
        Length l1 = new Length(1.0, LengthUnit.FEET);
        Length l2 = new Length(12.0, LengthUnit.INCHES);

        System.out.println("Input: Quantity(1.0, FEET) and Quantity(12.0, INCHES)");
        System.out.println("Output: Equal (" + demonstrateLengthEquality(l1, l2) + ")");
    }

    public static void main(String[] args) {
        demonstrateFeetEquality();
        demonstrateInchesEquality();
        demonstrateFeetInchesComparison();
    }
}