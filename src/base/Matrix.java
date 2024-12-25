package base;

import lombok.Getter;

@Getter
public class Matrix {

    private final int row;
    private final int column;

    private final double[][] matrix;

    public Matrix(int row, int column) {
        this.row = row;
        this.column = column;
        matrix = new double[row][column];
    }

    public void setRow(int row, double[] rowData) {
        if (column >= 0) System.arraycopy(rowData, 0, matrix[row], 0, column);
    }

    public String getInfo() {
        return "row count : " + row + ", column count : " + column;
    }



    public double getElement(int row, int column) {
        return matrix[row][column];
    }

    private int getLength(double value) {
        return String.valueOf(value).length();
    }
}
