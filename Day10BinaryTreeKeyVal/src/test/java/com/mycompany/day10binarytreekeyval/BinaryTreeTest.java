/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit5TestClass.java to edit this template
 */
package com.mycompany.day10binarytreekeyval;

import java.util.Iterator;
import java.util.NoSuchElementException;
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
public class BinaryTreeTest {
  BinaryTree<Integer, String> binaryTree = new BinaryTree<>();
  public BinaryTreeTest() {
  }

  @BeforeAll
  public static void setUpClass() {
  }

  @AfterAll
  public static void tearDownClass() {
  }

  @BeforeEach
  public void setUp() {
    binaryTree = new BinaryTree<>();
  }

  @AfterEach
  public void tearDown() {
  }

  /**
   * Test of iterator method, of class BinaryTree.
   */
  @Test
  public void testIterator() {
    System.out.println("iterator");
    Iterator<Pair<Integer, String>> iterator;
    iterator = binaryTree.iterator();
    assertFalse(iterator.hasNext());
    
    binaryTree.put(2, "Two");
    binaryTree.put(1, "One");
    binaryTree.put(3, "Three");

    int count = 1;
    for (Pair<Integer, String> pair : binaryTree) {
      assertEquals(count, pair.key);
      count++;
    }

    iterator = binaryTree.iterator();

    assertTrue(iterator.hasNext());
    Pair<Integer, String> pair1 = iterator.next();
    assertEquals(1, pair1.key);
    assertEquals("One", pair1.value);

    assertTrue(iterator.hasNext());

    Pair<Integer, String> pair2 = iterator.next();
    assertEquals(2, pair2.key);
    assertEquals("Two", pair2.value);

    assertTrue(iterator.hasNext());

    Pair<Integer, String> pair3 = iterator.next();
    assertEquals(3, pair3.key);
    assertEquals("Three", pair3.value);

    assertFalse(iterator.hasNext());

//    assertThrows(NoSuchElementException.class, () -> iterator.next());
    try {
      iterator.next();
      fail("Expected NoSuchElementException was not thrown");
    } catch (NoSuchElementException e) {
      assertTrue(e instanceof NoSuchElementException);
    }
  }

  /**
   * Test of put method, of class BinaryTree.
   */
  @Test
  public void testPutAndGet() {
    System.out.println("put & get");
    binaryTree.put(1, "One");
    binaryTree.put(2, "Two");
    binaryTree.put(3, "Three");

    assertEquals(3, binaryTree.getSize());

    assertEquals("One", binaryTree.getValByKey(1));
    assertEquals("Two", binaryTree.getValByKey(2));
    assertEquals("Three", binaryTree.getValByKey(3));
  }

  /**
   * Test of getSize method, of class BinaryTree.
   */
  @Test
  public void testGetSize() {
    System.out.println("getSize");
    assertEquals(0, binaryTree.getSize());
    binaryTree.put(1, "One");
    binaryTree.put(2, "Two");
    binaryTree.put(3, "Three");
    assertEquals(3, binaryTree.getSize());
  }

  /**
   * Test of getValByKey method, of class BinaryTree.
   */
  @Test
  public void testGetValByKey() {
    System.out.println("getValByKey");
    binaryTree.put(1, "One");
    binaryTree.put(2, "Two");
    binaryTree.put(3, "Three");

    assertEquals("One", binaryTree.getValByKey(1));
    assertEquals("Two", binaryTree.getValByKey(2));
    assertEquals("Three", binaryTree.getValByKey(3));
  }

  /**
   * Test of getKeysInOrder method, of class BinaryTree.
   */
  @Test
  public void testGetKeysInOrder() {
    System.out.println("getKeysInOrder");
    binaryTree.put(3, "Three");
    binaryTree.put(1, "One");
    binaryTree.put(2, "Two");

    Integer[] keys = binaryTree.getKeysInOrder();

    assertEquals(1, keys[0]);
    assertEquals(2, keys[1]);
    assertEquals(3, keys[2]);
  }

  /**
   * Test of printAllKeyValPairs method, of class BinaryTree.
   */
  @Test
  public void testPrintAllKeyValPairs() {
    System.out.println("printAllKeyValPairs");
    binaryTree.put(3, "Three");
    binaryTree.put(1, "One");
    binaryTree.put(2, "Two");
    binaryTree.printAllKeyValPairs();
  }

}
