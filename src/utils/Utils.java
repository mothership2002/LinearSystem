package utils;

public class Utils {

    public static String print(double[][] matrix) {
        StringBuilder sb = new StringBuilder();
        for (double[] doubles : matrix) {
            iterable(sb, doubles);
            sb.append(System.lineSeparator());
        }
        return sb.toString();
    }

    public static String print(double[] row) {
        return iterable(new StringBuilder(), row).toString();
    }


    private static StringBuilder iterable(StringBuilder sb, double[] row) {
        for (double v : row) {
            sb.append(String.format("{%6.2f} ", v));
        }
        return sb;
    }
}
