package src.com.apps.quantitymeasurement;

public class Quantity<U extends IMeasurable> {

    private final double value;
    private final U unit;

    public Quantity(double value, U unit) {
        if (unit == null || !Double.isFinite(value)) {
            throw new IllegalArgumentException("Invalid input");
        }
        this.value = value;
        this.unit = unit;
    }

    public double getValue() {
        return value;
    }

    public U getUnit() {
        return unit;
    }

    // Convert to another unit
    public Quantity<U> convertTo(U targetUnit) {
        double baseValue = unit.convertToBaseUnit(value);
        double converted = targetUnit.convertFromBaseUnit(baseValue);
        return new Quantity<>(converted, targetUnit);
    }

    // Add (same unit result)
    public Quantity<U> add(Quantity<U> other) {
        double sumBase = this.unit.convertToBaseUnit(this.value)
                + other.unit.convertToBaseUnit(other.value);

        double result = this.unit.convertFromBaseUnit(sumBase);
        return new Quantity<>(result, this.unit);
    }

    // Add with target unit
    public Quantity<U> add(Quantity<U> other, U targetUnit) {
        double sumBase = this.unit.convertToBaseUnit(this.value)
                + other.unit.convertToBaseUnit(other.value);

        double result = targetUnit.convertFromBaseUnit(sumBase);
        return new Quantity<>(result, targetUnit);
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || !(obj instanceof Quantity)) return false;

        Quantity<?> that = (Quantity<?>) obj;

        // Prevent cross-category comparison
        if (this.unit.getClass() != that.unit.getClass()) return false;

        double thisBase = this.unit.convertToBaseUnit(this.value);
        double thatBase = that.unit.convertToBaseUnit(that.value);

        return Double.compare(thisBase, thatBase) == 0;
    }

    @Override
    public String toString() {
        return value + " " + unit.getUnitName();
    }
}
