package byteDance;

/**
 * Created by lizeyang on 2020/5/16.
 * 以log(m+n)的时间复杂度完成矩阵搜索
 */
public class test45 {
    //行列均使用二分查找，时间复杂度O(logm+logn)
    public static boolean test(int[][] matrix, int target) {
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
            return false;
        }
        return search(matrix, 0, matrix.length - 1, 0, matrix[0].length - 1, target);
    }

    public static boolean search(int[][] matrix, int xStart, int xEnd, int yStart, int yEnd, int target) {
        if (xStart > xEnd || yStart > yEnd) {
            return false;
        }
        int index = (xStart + xEnd) >> 1;
        int res = binarySearch(matrix[index], yStart, yEnd, target);
        if (matrix[index][res] == target) {
            return true;
        }
        return search(matrix, xStart, index - 1, yStart, yEnd, target) || search(matrix, index + 1, xEnd, yStart, yEnd, target);
    }

    public static int binarySearch(int[] matrix, int l, int r, int target) {
        while (l < r) {
            int mid = (l + r) >> 1;
            if (matrix[mid] == target) {
                return mid;
            } else if (matrix[mid] < target) {
                l = mid + 1;
            } else {
                r = mid - 1;
            }
        }
        return l;
    }

    public static void main(String[] args) {
        int[][] matrix = {{1, 4, 7, 11, 15}, {2, 5, 8, 12, 19}, {3, 6, 9, 16, 22}, {10, 13, 14, 17, 24}, {18, 21, 23, 26, 30}};
        int target = 20;
        System.out.println(test(matrix, target));
    }
}
