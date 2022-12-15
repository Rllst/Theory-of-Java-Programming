package lab0;

import java.util.Arrays;

public class Variant11 {

    public static int[] integerTask(int number) {
        if (number > 999 || number < 100) {
            throw new IllegalArgumentException();
        }
        int sum = 0;
        int mul = 1;
        for (int i = 0; i < 3; i++) {
            sum += number % 10;
            mul *= number % 10;
            number /= 10;
        }
        return new int[]{sum, mul};
    }

    public static boolean booleanTask(int number1, int number2) {
        return (number1 + number2) % 2 == 0;
    }

    public static int[] ifTask(int a, int b) {
        if (a != b) {
            int bigger = a > b ? a : b;
            a = bigger;
            b = bigger;
        } else {
            a = 0;
            b = 0;
        }
        return new int[]{a, b};
    }
//JAVADOCS
    public static CardinalPoint caseTask(CardinalPoint start, int n1, int n2) {
        int dir = start.ordinal() + n1 + n2;
        dir = dir > 0 ? dir : dir + 4;
        dir = dir < 4 ? dir : dir - 4;
        return CardinalPoint.values()[dir];
    }

    public static int forTask(int n) {
        if (n < 0) {
            throw new IllegalArgumentException();
        }
        int res = 0;
        for (int i = n; i <= 2 * n; i++) {
            res += i * i;
        }
        return res;
    }

    public static int whileTask(int n) {
        if (n < 0) {
            throw new IllegalArgumentException();
        }
        int k = 1;
        int sum = 0;
        while (sum < n) {
            sum += k;
            k++;
        }
        return --k;
    }

    public static int[] arrayTask(int[] array, int k) {
        int[] res = new int[array.length / k - 1];
        for (int i = 1; i < array.length / k; i += 1) {
            res[i - 1] = array[k * i];
        }
        return res;
    }

    public static int[][] matrixTask(int[][] matrix, int N, int M) {
        boolean backward = false;
        int[][] res = new int[N][M];
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (backward) {
                    res[i][j] = matrix[i][M - j - 1];
                } else res[i][j] = matrix[i][j];
            }
            backward = !backward;
        }
        return res;
    }
}
