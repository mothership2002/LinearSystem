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

    public String current() {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < column; j++) {
                sb.append(String.format("{%6.2f} ", matrix[i][j])); // 6.2f는 두 자리 소수점 정렬
            }
            sb.append(System.lineSeparator()); // OS에 따라 줄 바꿈 처리 정리
        }
        return sb.toString();
    }

    public double getElement(int row, int column) {
        return matrix[row][column];
    }

    private int getLength(double value) {
        return String.valueOf(value).length();
    }
}
