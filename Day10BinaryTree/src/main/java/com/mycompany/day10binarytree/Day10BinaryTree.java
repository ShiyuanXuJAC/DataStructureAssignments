package com.mycompany.day10binarytree;

public class Day10BinaryTree {

    public static void main(String[] args) {
      BinaryTreeOfInts tree = new BinaryTreeOfInts();
      for (int i = 0; i < 10; i++) {
        tree.put(i);
      }

      //SumVisitor
      SumVisitor sumVisitor = new SumVisitor();
      tree.accept(sumVisitor);

      int sum = sumVisitor.getSum();
      System.out.println("sum: " + sum);

      //SumOfSquareVisitor
      SumOfSquareVisitor sumOfSquareVisitor = new SumOfSquareVisitor();
      tree.accept(sumOfSquareVisitor);

      int sumOfSquare = sumOfSquareVisitor.getSumOfSquare();
      System.out.println("sum of square: " + sumOfSquare);
    }


}
