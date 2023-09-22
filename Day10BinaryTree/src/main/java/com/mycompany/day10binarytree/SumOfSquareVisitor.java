package com.mycompany.day10binarytree;

public class SumOfSquareVisitor implements Visitor {

  int sumOfSquare = 0;

  @Override
  public void visit(NodeOfInt node) {
    sumOfSquare += node.value * node.value;
  }

  public int getSumOfSquare() {
    return sumOfSquare;
  }

}
