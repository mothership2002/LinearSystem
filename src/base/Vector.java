package base;

import java.util.Arrays;

public class Vector {
    private final double[] scalaVector;

    public Vector(double[] scalaVector) {
        this.scalaVector = Arrays.copyOf(scalaVector, scalaVector.length);
    }

    public int size() {
        return scalaVector.length;
    }

    public double getElement(int index) {
        if (index < 0 || index >= scalaVector.length) {
            throw new IndexOutOfBoundsException("Invalid index");
        }
        return scalaVector[index];
    }

    public double[] getValues() {
        return Arrays.copyOf(scalaVector, scalaVector.length);
    }
}