package src.com.apps.quantitymeasurement;

public class Weight {

    private final double value;
    private final WeightUnit unit;

    public Weight(double value, WeightUnit unit) {

        if (!Double.isFinite(value))
            throw new IllegalArgumentException("Invalid value");

        if (unit == null)
            throw new IllegalArgumentException("Unit cannot be null");

        this.value = value;
        this.unit = unit;
    }

    public double getValue() {
        return value;
    }

    public WeightUnit getUnit() {
        return unit;
    }

    public Weight convertTo(WeightUnit targetUnit) {

        double base = unit.convertToBaseUnit(value);
        double converted = targetUnit.convertFromBaseUnit(base);

        return new Weight(converted, targetUnit);
    }

    public Weight add(Weight other) {
        return add(other, this.unit);
    }

    public Weight add(Weight other, WeightUnit targetUnit) {

        double totalBase =
                this.unit.convertToBaseUnit(this.value) +
                        other.unit.convertToBaseUnit(other.value);

        double result =
                targetUnit.convertFromBaseUnit(totalBase);

        return new Weight(result, targetUnit);
    }

    @Override
    public boolean equals(Object obj) {

        if (this == obj) return true;

        if (obj == null || getClass() != obj.getClass())
            return false;

        Weight other = (Weight) obj;

        double thisBase =
                unit.convertToBaseUnit(value);

        double otherBase =
                other.unit.convertToBaseUnit(other.value);

        return Math.abs(thisBase - otherBase) < 0.001;
    }

    @Override
    public String toString() {
        return value + " " + unit;
    }
}
