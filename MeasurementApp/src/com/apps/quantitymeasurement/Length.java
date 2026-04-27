package src.com.apps.quantitymeasurement;

public class Length {

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

    public Length convertTo(LengthUnit targetUnit) {

        if (targetUnit == null)
            throw new IllegalArgumentException("Invalid target unit");

        double base = unit.convertToBaseUnit(value);
        double converted = targetUnit.convertFromBaseUnit(base);

        return new Length(converted, targetUnit);
    }

    public Length add(Length other) {
        return add(other, this.unit);
    }

    public Length add(Length other, LengthUnit targetUnit) {

        if (other == null)
            throw new IllegalArgumentException("Other length is null");

        if (targetUnit == null)
            throw new IllegalArgumentException("Target unit is null");

        double totalBase =
                unit.convertToBaseUnit(value) +
                        other.unit.convertToBaseUnit(other.value);

        double result =
                targetUnit.convertFromBaseUnit(totalBase);

        return new Length(result, targetUnit);
    }

    @Override
    public boolean equals(Object obj) {

        if (this == obj) return true;

        if (obj == null || getClass() != obj.getClass())
            return false;

        Length other = (Length) obj;

        double thisBase =
                unit.convertToBaseUnit(value);

        double otherBase =
                other.unit.convertToBaseUnit(other.value);

        return Math.abs(thisBase - otherBase) < 0.01;
    }

    public double getValue() {
        return value;
    }

    public LengthUnit getUnit() {
        return unit;
    }

    @Override
    public String toString() {
        return value + " " + unit;
    }
}