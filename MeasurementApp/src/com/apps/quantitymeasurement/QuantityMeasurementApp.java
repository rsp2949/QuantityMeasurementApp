package src.com.apps.quantitymeasurement;

public class QuantityMeasurementApp {

    public enum LengthUnit {
        FEET(12.0),
        INCHES(1.0),
        YARDS(36.0),
        CENTIMETERS(0.393701);

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
            return Double.compare(
                    this.convertToBaseUnit(),
                    thatLength.convertToBaseUnit()
            ) == 0;
        }

        @Override
        public boolean equals(Object obj) {
            if (this == obj) return true;
            if (obj == null || getClass() != obj.getClass()) return false;

            Length other = (Length) obj;
            return compare(other);
        }
    }

    public static boolean demonstrateLengthEquality(Length l1, Length l2) {
        return l1.equals(l2);
    }

    public static void demonstrateLengthComparison(
            double value1, LengthUnit unit1,
            double value2, LengthUnit unit2) {

        Length l1 = new Length(value1, unit1);
        Length l2 = new Length(value2, unit2);

        System.out.println("Input: Quantity(" + value1 + ", " + unit1 +
                ") and Quantity(" + value2 + ", " + unit2 + ")");
        System.out.println("Output: Equal (" +
                demonstrateLengthEquality(l1, l2) + ")");
    }

    public static void main(String[] args) {
        demonstrateLengthComparison(1.0, LengthUnit.YARDS,
                3.0, LengthUnit.FEET);

        demonstrateLengthComparison(1.0, LengthUnit.YARDS,
                36.0, LengthUnit.INCHES);

        demonstrateLengthComparison(1.0, LengthUnit.CENTIMETERS,
                0.393701, LengthUnit.INCHES);

        demonstrateLengthComparison(30.48, LengthUnit.CENTIMETERS,
                1.0, LengthUnit.FEET);
    }
}