/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit4TestClass.java to edit this template
 */
package com.mycompany.day10binarytree;

import java.util.Iterator;
import java.util.concurrent.atomic.AtomicInteger;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author HP
 */
public class BinaryTreeOfIntsTest {

  BinaryTreeOfInts tree;

  public BinaryTreeOfIntsTest() {
  }

  @BeforeClass
  public static void setUpClass() {
  }

  @AfterClass
  public static void tearDownClass() {
  }

  @Before
  public void setUp() {
    tree = new BinaryTreeOfInts();
  }

  @After
  public void tearDown() {
  }

  /**
   * Test of put method, of class BinaryTreeOfInts.
   */
  @Test
  public void testPut() {
    System.out.println("put");
    tree.put(10);
    tree.put(2);
    tree.put(1);
    tree.put(20);
    tree.put(30);
    assertEquals(5, tree.getSize());
    assertThrows(IllegalArgumentException.class, () -> tree.put(2));
  }

  /**
   * Test of getSize method, of class BinaryTreeOfInts.
   */
  @Test
  public void testGetSize() {
    System.out.println("getSize");
    assertEquals(0, tree.getSize());
    tree.put(1);
    assertEquals(1, tree.getSize());
  }

  /**
   * Test of hasValue method, of class BinaryTreeOfInts.
   */
  @Test
  public void testHasValue() {
    System.out.println("hasValue");
    tree.put(1);
    tree.put(2);
    tree.put(3);
    assertTrue(tree.hasValue(1));
    assertFalse(tree.hasValue(4));
    
  }

  /**
   * Test of getSumOfAllValues method, of class BinaryTreeOfInts.
   */
  @Test
  public void testGetSumOfAllValues() {
    System.out.println("getSumOfAllValues");
    tree.put(10);
    tree.put(2);
    tree.put(1);
    tree.put(20);
    tree.put(30);
    assertEquals(63, tree.getSumOfAllValues());
  }

  /**
   * Test of getValuesInOrder method, of class BinaryTreeOfInts.
   */
  @Test
  public void testGetValuesInOrder() {
    System.out.println("getValuesInOrder");
    int[] expResult = {};
    int[] result = tree.getValuesInOrder();
    assertArrayEquals(expResult, result);
    tree.put(10);
    tree.put(2);
    tree.put(1);
    tree.put(20);
    tree.put(30);
    expResult = new int[]{30, 20, 10, 2, 1};
    result = tree.getValuesInOrder();
    assertArrayEquals(expResult, result);
  }

  @Test
  public void testIterator() {
    tree.put(5);
    tree.put(3);
    tree.put(8);
    tree.put(2);
    tree.put(4);
    tree.put(7);
    tree.put(9);
    int[] expectedValues = {2, 3, 4, 5, 7, 8, 9};
    int[] actualValues = new int[7];
    int index = 0;

    Iterator<Integer> iterator = tree.iterator();
    while (iterator.hasNext()) {
      actualValues[index++] = iterator.next();
    }

    assertArrayEquals(expectedValues, actualValues);
  }

  @Test
  public void testIterableWithEnhancedForLoop() {
    tree.put(5);
    tree.put(3);
    tree.put(8);
    tree.put(2);
    tree.put(4);
    tree.put(7);
    tree.put(9);
    int[] expectedValues = {2, 3, 4, 5, 7, 8, 9};
    int[] actualValues = new int[7];
    int index = 0;

    for (int value : tree) {
      actualValues[index++] = value;
    }

    assertArrayEquals(expectedValues, actualValues);

    AtomicInteger actualSum = new AtomicInteger(0);
    tree.forEach(value -> actualSum.addAndGet(value));

    assertEquals(38, actualSum.get());

  }

}
