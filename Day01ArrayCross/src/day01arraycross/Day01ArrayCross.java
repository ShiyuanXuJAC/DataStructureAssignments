package day01arraycross;

public class Day01ArrayCross {

  static int getIfExists(int[][] data, int row, int col) {
    if (row >= 0 && row < data.length && col >= 0 && col < data[row].length) {
      return data[row][col];
    }
    return 0;
  }

  static int sumOfCross(int[][] data, int row, int col) {
    int sum = 0;
    sum += getIfExists(data, row, col);
    sum += getIfExists(data, row - 1, col);
    sum += getIfExists(data, row + 1, col);
    sum += getIfExists(data, row, col - 1);
    sum += getIfExists(data, row, col + 1);
    return sum;
  }

  // Useful helper for debugging
  static void print2D(int[][] data) {
    for (int[] row : data) {
      for (int n : row) {
        System.out.print(n + "    ");
      }
      System.out.println();
    }
  }

  // Duplicate a jagged array
  static int[][] duplicateEmptyArray2D(int[][] orig2d) {
    int[][] dupl = new int[orig2d.length][];
    for (int i = 0; i < orig2d.length; i++) {
      dupl[i] = new int[orig2d[i].length];
//            System.arraycopy(orig2d[i], 0, duplicate[i], 0, orig2d[i].length);
    }
    return dupl;
  }

  static void printSmallest(int[][] arr) {
    // Part A
    int sum = Integer.MAX_VALUE;
    int smallestSumRow = -1;
    int smallestSumCol = -1;

    for (int row = 0; row < arr.length; row++) {
      for (int col = 0; col < arr[row].length; col++) {
        int currentSum = sumOfCross(arr, row, col);
        if (currentSum < sum) {
          sum = currentSum;
          smallestSumRow = row;
          smallestSumCol = col;
        }
      }
    }

    System.out.println("Part A: Smallest Sum is " + sum + " at row " + smallestSumRow + " and col " + smallestSumCol);
  }

  static int[][] getCrossSumArray(int[][] arr) {
    // Part B
    int[][] crossSumArr = new int[arr.length][];
    for (int i = 0; i < arr.length; i++) {
      crossSumArr[i] = new int[arr[i].length];
      for (int j = 0; j < arr[i].length; j++) {
        crossSumArr[i][j] = sumOfCross(arr, i, j);
      }
    }
    return crossSumArr;
  }

  public static void main(String[] args) {
    int[][] data2D = {
      {1, 3, 6, 8},
      {7, 1, 2, 3},
      {8, 3, 2, 1},
      {1, 7, 1, 9},};

    int[][] data2Djagged = {
      {1, 3, 6, 8, 9, 1},
      {7, 1, 2, 3},
      {8, 3, 2},
      {1, 7, 1, 9},};
    printSmallest(data2D);
    printSmallest(data2Djagged);

    int[][] data2Dsums = getCrossSumArray(data2D);
    System.out.println("Original Array:");
    print2D(data2D);
    System.out.println("\nNew Array (Sum of Crosses):");
    print2D(data2Dsums);

    data2Dsums = getCrossSumArray(data2Djagged);
    System.out.println("Original Array:");
    print2D(data2Djagged);
    System.out.println("\nNew Array (Sum of Crosses):");
    print2D(data2Dsums);
  }
}
