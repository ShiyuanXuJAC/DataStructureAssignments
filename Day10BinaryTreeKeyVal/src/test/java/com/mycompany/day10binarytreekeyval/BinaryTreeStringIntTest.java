/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit5TestClass.java to edit this template
 */
package com.mycompany.day10binarytreekeyval;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 *
 * @author HP
 */
public class BinaryTreeStringIntTest {
  BinaryTreeStringInt tree;
  public BinaryTreeStringIntTest() {
  }

  @BeforeAll
  public static void setUpClass() {
  }

  @AfterAll
  public static void tearDownClass() {
  }

  @BeforeEach
  public void setUp() {
    tree = new BinaryTreeStringInt();
  }

  @AfterEach
  public void tearDown() {
  }

  /**
   * Test of put method, of class BinaryTreeStringInt.
   */
  @Test
  public void testPutGetPrint() {
    System.out.println("put");
    assertEquals(0, tree.getSize());
    tree.put("bbb", 10);
    tree.put("abb", 2);
    tree.put("aba", 1);
    tree.put("bbc", 20);
    tree.put("bbd", 30);
    //modify
    tree.put("bbb", 100);

    assertEquals(5, tree.getSize());

    assertEquals(100, tree.getValByKey("bbb"));
    assertEquals(2, tree.getValByKey("abb"));
    assertEquals(1, tree.getValByKey("aba"));
    assertEquals(20, tree.getValByKey("bbc"));
    assertEquals(30, tree.getValByKey("bbd"));

    assertThrows(RuntimeException.class, () -> tree.getValByKey("key"));

    tree.printAllKeyValPairs();
  }


}
