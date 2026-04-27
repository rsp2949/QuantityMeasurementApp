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

        private double toBase() {
            return value * unit.getFactor();
        }

        public Length convertTo(LengthUnit targetUnit) {
            if (targetUnit == null)
                throw new IllegalArgumentException("Invalid target unit");

            double converted = toBase() / targetUnit.getFactor();
            return new Length(converted, targetUnit);
        }

        public Length add(Length other) {
            if (other == null)
                throw new IllegalArgumentException("Second operand cannot be null");

            double sumBase = this.toBase() + other.toBase();
            double result = sumBase / this.unit.getFactor();

            return new Length(result, this.unit);
        }

        public double getValue() {
            return value;
        }

        public LengthUnit getUnit() {
            return unit;
        }

        @Override
        public boolean equals(Object obj) {
            if (this == obj) return true;
            if (obj == null || getClass() != obj.getClass()) return false;

            Length other = (Length) obj;

            return Math.abs(this.toBase() - other.toBase()) < 0.0001;
        }

        @Override
        public String toString() {
            return value + " " + unit;
        }
    }

    public static Length demonstrateLengthAddition(
            Length length1,
            Length length2) {

        return length1.add(length2);
    }

    public static void main(String[] args) {

        Length l1 = new Length(1.0, LengthUnit.FEET);
        Length l2 = new Length(12.0, LengthUnit.INCHES);

        Length result = demonstrateLengthAddition(l1, l2);

        System.out.println("Result: " + result);
    }
}