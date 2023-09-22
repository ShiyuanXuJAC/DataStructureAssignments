/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.day10binarytree;
public class NodeOfInt {

  int value; // could also be key, value pair
  NodeOfInt left, right;

  public NodeOfInt(int value) {
    this.value = value;
    left = null;
    right = null;
  }

  void accept(Visitor visitor) {
    visitor.visit(this);
  }
}
