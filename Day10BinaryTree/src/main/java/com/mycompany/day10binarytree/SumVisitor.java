/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.day10binarytree;

public class SumVisitor implements Visitor {

  private int sum = 0;

  @Override
  public void visit(NodeOfInt node) {
    sum += node.value;
  }

  public int getSum() {
    return sum;
  }
}
