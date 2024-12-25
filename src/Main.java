import algorithm.VectorOperations;
import base.Vector;
import base.Matrix;
import utils.Utils;

import static utils.Utils.print;

public class Main {
    public static void main(String[] args) {

        Matrix matrix = new Matrix(3, 2);
        matrix.setRow(0, new double[]{2, -3});
        matrix.setRow(1, new double[]{8, 0});
        matrix.setRow(2, new double[]{-5, 2});

//        System.out.println("Before Reduction:");
//        System.out.println(matrix.current());
//        RowReduce.reduce(matrix);
//        System.out.println("After Reduction:");
//        System.out.println(matrix.current());

        System.out.println(print(matrix.getMatrix()));
        Vector vector = new Vector(new double[]{4, 7});
        double[][] result = VectorOperations.multiplyWithMatrix(vector, matrix.getMatrix());
        System.out.println(print(result));
        System.out.println(print(VectorOperations.calculateRowSums(result)));
    }
}