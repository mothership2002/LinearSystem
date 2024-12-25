import algorithm.RowReduce;
import base.Matrix;

public class Main {
    public static void main(String[] args) {

        Matrix matrix = new Matrix(3, 4);
        matrix.setRow(0, new double[]{2, 1, -1, 8});
        matrix.setRow(1, new double[]{-3, -1, 2, -11});
        matrix.setRow(2, new double[]{-2, 1, 2, -3});

        System.out.println("Before Reduction:");
        System.out.println(matrix.current());
        RowReduce.reduce(matrix);
        System.out.println("After Reduction:");
        System.out.println(matrix.current());

    }
}