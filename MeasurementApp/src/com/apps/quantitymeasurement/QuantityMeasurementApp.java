package src.com.apps.quantitymeasurement;

public class QuantityMeasurementApp {

    public enum LengthUnit {
        FEET(12.0),
        INCHES(1.0),
        YARDS(36.0),
        CENTIMETERS(0.393701);

        private final double factor;

        LengthUnit(double factor) {
            this.factor = factor;
        }

        public double getFactor() {
            return factor;
        }
    }

    public static class Length {
        private final double value;
        private final LengthUnit unit;

        public Length(double value, LengthUnit unit) {
            if (!Double.isFinite(value))
                throw new IllegalArgumentException("Invalid value");

            if (unit == null)
                throw new IllegalArgumentException("Unit cannot be null");

            this.value = value;
            this.unit = unit;
        }

        private double convertToBaseUnit() {
            return value * unit.getFactor();
        }

        public Length convertTo(LengthUnit targetUnit) {
            if (targetUnit == null)
                throw new IllegalArgumentException("Target unit cannot be null");

            double base = convertToBaseUnit();
            double converted = base / targetUnit.getFactor();

            return new Length(converted, targetUnit);
        }

        @Override
        public boolean equals(Object obj) {
            if (this == obj) return true;
            if (obj == null || getClass() != obj.getClass()) return false;

            Length other = (Length) obj;

            return Math.abs(
                    this.convertToBaseUnit() -
                            other.convertToBaseUnit()
            ) < 0.0001;
        }

        @Override
        public String toString() {
            return String.format("%.4f %s", value, unit);
        }
    }

    public static double demonstrateLengthConversion(
            double value,
            LengthUnit fromUnit,
            LengthUnit toUnit) {

        Length length = new Length(value, fromUnit);
        return length.convertTo(toUnit).value;
    }

    public static Length demonstrateLengthConversion(
            Length length,
            LengthUnit toUnit) {

        return length.convertTo(toUnit);
    }

    public static boolean demonstrateLengthEquality(
            Length l1,
            Length l2) {

        return l1.equals(l2);
    }

    public static void main(String[] args) {

        System.out.println("Feet to Inches: " +
                demonstrateLengthConversion(
                        1.0,
                        LengthUnit.FEET,
                        LengthUnit.INCHES));

        System.out.println("Yards to Feet: " +
                demonstrateLengthConversion(
                        3.0,
                        LengthUnit.YARDS,
                        LengthUnit.FEET));

        System.out.println("Inches to Yards: " +
                demonstrateLengthConversion(
                        36.0,
                        LengthUnit.INCHES,
                        LengthUnit.YARDS));

        System.out.println("Centimeters to Inches: " +
                demonstrateLengthConversion(
                        1.0,
                        LengthUnit.CENTIMETERS,
                        LengthUnit.INCHES));
    }
}