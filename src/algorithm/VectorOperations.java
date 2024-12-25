package algorithm;

import base.Vector;

public class VectorOperations {

    public static double[][] multiplyWithMatrix(Vector vector, double[][] matrix) {
        double[] scalaVector = vector.getValues();

        if (matrix.length == 0 || matrix[0].length != scalaVector.length) {
            throw new IllegalArgumentException("Matrix column size must match the size of scalaVector.");
        }

        double[][] result = new double[matrix.length][matrix[0].length];
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                result[i][j] = matrix[i][j] * scalaVector[j];
            }
        }
        return result;
    }

    public static double[] calculateRowSums(double[][] matrix) {
        double[] result = new double[matrix.length];
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                result[i] += matrix[i][j];
            }
        }
        return result;
    }
}