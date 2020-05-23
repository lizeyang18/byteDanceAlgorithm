package byteDance;

/**
 * Created by lizeyang on 2020/5/14.
 * 螺旋打印矩阵:给定一个正整数 n，生成一个包含 1 到 n2 所有元素，且元素按顺时针顺序螺旋排列的正方形矩阵。
 * input:3
 * output:
 * 1 2 3
 * 8 9 4
 * 7 6 5
 */
public class test23 {
    public static int[][] test(int n) {
        int[][] matrix = new int[n][n];
        int count = 1, j = 0;
        while (count <= n * n) {
            for (int i = j; i < n - j; i++) {
                matrix[j][i] = count++;
            }
            for (int i = j + 1; i < n - j; i++) {
                matrix[i][n - j - 1] = count++;
            }
            for (int i = n - j - 2; i >= j; i--) {
                matrix[n - j - 1][i] = count++;
            }
            for (int i = n - j - 2; i > j; i--) {
                matrix[i][j] = count++;
            }
            j++;
        }
        return matrix;
    }

    public static void main(String[] args) {
        int n = 4;
        int[][] res = test(n);
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                System.out.print(res[i][j] + " ");
            }
            System.out.println();
        }
    }
}
