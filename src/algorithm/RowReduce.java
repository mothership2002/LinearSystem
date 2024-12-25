package algorithm;

import base.Matrix;

public class RowReduce {

    public static void reduce(Matrix matrixObject) {
        int rowCount = matrixObject.getRow();
        int colCount = matrixObject.getColumn();
        double[][] matrix = matrixObject.getMatrix();

        int pivotRow = 0;

        for (int col = 0; col < colCount; col++) {

            int pivotRowIndex = findPivot(matrix, pivotRow, col);
            if (pivotRowIndex == -1) {
                continue;
            }

            if (pivotRowIndex != pivotRow) {
                interchangeRows(matrix, pivotRowIndex, pivotRow);
            }

            double pivot = matrix[pivotRow][col];

            normalizeRow(matrix, pivotRow, pivot);

            for (int row = 0; row < rowCount; row++) {
                if (row != pivotRow) {
                    double eliminationFactor = matrix[row][col];
                    eliminateRow(matrix, row, pivotRow, eliminationFactor);
                }
            }

            pivotRow++;
        }
    }

    private static int findPivot(double[][] matrix, int startRow, int currentColumn) {
        int pivotRow = -1;
        for (int i = startRow; i < matrix.length; i++) {
            if (matrix[i][currentColumn] != 0) {
                pivotRow = i;
                break;
            }
        }
        return pivotRow;
    }

    private static void interchangeRows(double[][] matrix, int row1, int row2) {
        if (row1 < 0 || row1 >= matrix.length || row2 < 0 || row2 >= matrix.length) {
            throw new IllegalArgumentException("Invalid row indices");
        }
        swap(matrix, row1, row2);
    }

    private static void swap(double[][] matrix, int row1, int row2) {
        double[] temp = matrix[row1];
        matrix[row1] = matrix[row2];
        matrix[row2] = temp;
    }

    private static void processRowElements(double[][] matrix, int row, RowProcessor processor) {
        for (int col = 0; col < matrix[row].length; col++) {
            processor.apply(matrix[row], col);
        }

    }

    private static void normalizeRow(double[][] matrix, int row, double pivotValue) {
        if (pivotValue == 0) {
            throw new IllegalArgumentException("Pivot value cannot be zero while normalizing the row");
        }
        processRowElements(matrix, row, (rowData, col) -> rowData[col] /= pivotValue);
    }

    private static void eliminateRow(double[][] matrix, int targetRow, int pivotRow, double factor) {
        processRowElements(matrix, targetRow, (rowData, col) -> rowData[col] -= factor * matrix[pivotRow][col]);
    }

    @FunctionalInterface
    public interface RowProcessor {
        void apply(double[] row, int col);
    }
}
