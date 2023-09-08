/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package day01universalarrays;

import java.util.Scanner;

public class Day01UniversalArrays {


  static int getInt(Scanner sc, String message) {
    do {
      System.out.print(message);
        if (sc.hasNextInt()){
          return sc.nextInt();
        } else {
          sc.next();
        }
    } while (true);
  }
  static void inputArray(int[] data) {
    Scanner sc = new Scanner(System.in);
    for (int i = 0; i < data.length; i++) {
      data[i] = getInt(sc, String.format("Enter value column %d:", i + 1));
    }
//    sc.close();

  }

  ;

static void inputArray(int[][] data2d) {
  Scanner sc = new Scanner(System.in);
  for (int i = 0; i < data2d.length; i++) {
    for (int j = 0; j < data2d[i].length; j++) {
      data2d[i][j] = getInt(sc, String.format("Enter value row %d column %d:", i + 1, j + 1));
    }
  }
  }

static int getLength(int n){
  int count=n>0?0:1;
  while (n != 0) {
    n/=10;
    count++;
  }
  return count;
}
static int getMaxLength(int[] arr){
  int max=0;
  for (int i=0;i<arr.length;i++){
    int len = getLength(arr[i]);
    if (max < len) {
      max = len;
    }
  }
  return max;
}
  static void printArray(int[] data) {
    int len = getMaxLength(data);
    String str = "";
    for (int n : data) {
      str += String.format("%" + len + "d,", n);
    }
    if (str.length() > 0) {
      str = str.substring(0, str.length() - 1);
    }
    System.out.println("single dimensional array:");
    System.out.println(str);

  }

  static void printArray(int[][] data2d) {
    //find max col
    int cols = 0;
    for (int[] row : data2d) {
      if (cols < row.length) {
        cols = row.length;
      }
    }
    if (cols == 0) {
      return;
    }
    //lengths for cols
    int[] lengths = new int[cols];

    for (int[] row : data2d) {
      for (int j = 0; j < row.length; j++) {
        int len = getLength(row[j]);
        if (lengths[j] < len) {
          lengths[j] = len;
        }
      }
    }
    //output
    System.out.println("two dimensional array:");
    for (int[] row : data2d) {
      String str = "";
      for (int j = 0; j < row.length; j++) {
        str += String.format("%" + lengths[j] + "d,", row[j]);
      }
      str = str.substring(0, str.length() - 1);
      System.out.println(str);
    }

  }

  private static boolean inArray(int n, int[] arr) {
    for (int data : arr) {
      if (n == data) {
        return true;
      }
    }
    return false;
  }

  private static boolean inArray(int n, int[][] arr) {
    for (int[] row : arr) {
      for (int data : row) {
        if (n == data) {
          return true;
        }
      }
    }
    return false;
  }
  static int[] findDuplicates(int[] a1, int[] a2) {
    int[] dupl = new int[0];
    for (int n : a1) {
      if (inArray(n, a2) && !inArray(n, dupl)) {
        int[] duplTemp = new int[dupl.length + 1];
        System.arraycopy(dupl, 0, duplTemp, 0, dupl.length);
        duplTemp[duplTemp.length - 1] = n;
        dupl = duplTemp;
      }
    }
    return dupl;
  }

  static int[] findDuplicates(int[][] a1, int[][] a2) {
    int[] dupl = new int[0];
    for (int[] row : a1) {
      for (int n : row) {
        if (inArray(n, a2) && !inArray(n, dupl)) {
          int[] duplTemp = new int[dupl.length + 1];
          System.arraycopy(dupl, 0, duplTemp, 0, dupl.length);
          duplTemp[duplTemp.length - 1] = n;
          dupl = duplTemp;
        }
      }
    }
    return dupl;
  }
  public static void main(String[] args) {

//    int[] data = new int[5];
//    inputArray(data);
//    printArray(data);
//
//    int[][] data2d = new int[2][3];
//    inputArray(data2d);
//    printArray(data2d);

//    int[][] jaggedArray = {{151, 2, -3},
//    {4, -5},
//    {6, 7, -58188, 9}
//    };
//    printArray(jaggedArray);

    int[] a1 = {1, 2, 3, 2, 3, 5};
    int[] a2 = {7, 5, 3, 3, 0};
    int[] dupl = findDuplicates(a1, a2);
    System.out.println(java.util.Arrays.toString(dupl));

    int[][] ad1 = {
      {1, 2, 3},
      {3, 2, 2}
    };
    int[][] ad2 = {
      {0, -52, 3},
      {4, -4154},
      {6, 7, 2, 9}
    };
    int[] dupl2 = findDuplicates(ad1, ad2);
    System.out.println(java.util.Arrays.toString(dupl2));


  }

}
