/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit5TestClass.java to edit this template
 */
package com.mycompany.day05linkedlistarray;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class LinkedListArrayOfGenericsTest {

  private LinkedListArrayOfGenerics<Integer> list;

  @BeforeAll
  public static void setUpClass() {
  }

  @AfterAll
  public static void tearDownClass() {
  }

  @BeforeEach
  public void setUp() {
  }

  @AfterEach
  public void tearDown() {
  }

  /**
   * Test of add method, of class LinkedListArrayOfStrings.
   */
  @Test
  public void testAdd() {
    System.out.println("add");

    LinkedListArrayOfGenerics<Integer> instance = new LinkedListArrayOfGenerics();
    instance.add(0);
    instance.add(1);
    assertEquals(0, instance.get(0));
    assertEquals(1, instance.get(1));
  }

  /**
   * Test of get method, of class LinkedListArrayOfStrings.
   */
  @Test
  public void testGet() {
    System.out.println("get");
    LinkedListArrayOfGenerics<Integer> instance = new LinkedListArrayOfGenerics();
    assertThrows(ArrayIndexOutOfBoundsException.class, () -> instance.get(0));
    instance.add(0);
    assertEquals(0, instance.get(0));

  }

  /**
   * Test of insertValueAtIndex method, of class LinkedListArrayOfStrings.
   */
  @Test
  public void testInsertValueAtIndex() {
    System.out.println("insertValueAtIndex");
    LinkedListArrayOfGenerics<Integer> instance = new LinkedListArrayOfGenerics();
    assertThrows(ArrayIndexOutOfBoundsException.class, () -> instance.insertValueAtIndex(0, 0));
    instance.add(0);
    assertThrows(ArrayIndexOutOfBoundsException.class, () -> instance.insertValueAtIndex(1, 1));
    instance.insertValueAtIndex(1, 0);
    assertEquals(1, instance.get(0));
    assertEquals(0, instance.get(1));
    instance.insertValueAtIndex(10, 1);
    assertEquals(10, instance.get(1));
    assertEquals(0, instance.get(2));
  }

  /**
   * Test of replaceValueAtIndex method, of class LinkedListArrayOfStrings.
   */
  @Test
  public void testReplaceValueAtIndex() {
    System.out.println("replaceValueAtIndex");

    LinkedListArrayOfGenerics<Integer> instance = new LinkedListArrayOfGenerics();
    assertThrows(ArrayIndexOutOfBoundsException.class, () -> instance.replaceValueAtIndex(0, 0));
    instance.add(10);
    instance.add(0);
    instance.add(30);
    instance.replaceValueAtIndex(20, 1);
    Integer[] array = {10, 20, 30};
    assertArrayEquals(array, instance.toArray(Integer.class));
  }

  /**
   * Test of deleteByIndex method, of class LinkedListArrayOfStrings.
   */
  @Test
  public void testDeleteByIndex() {
    System.out.println("deleteByIndex");
    LinkedListArrayOfGenerics<Integer> instance = new LinkedListArrayOfGenerics();
    instance.add(10);
    instance.add(20);
    instance.add(30);
    instance.deleteByIndex(1);
    Integer[] array = {10, 30};
    assertArrayEquals(array, instance.toArray(Integer.class));
    Integer[] array1 = {10};
    instance.deleteByIndex(1);
    assertArrayEquals(array1, instance.toArray(Integer.class));
    String[] array2 = {};
    instance.deleteByIndex(0);
    assertArrayEquals(array2, instance.toArray(Integer.class));
  }

  /**
   * Test of deleteByValue method, of class LinkedListArrayOfStrings.
   */
  @Test
  public void testDeleteByValue() {
    System.out.println("deleteByValue");
    LinkedListArrayOfGenerics<Integer> instance = new LinkedListArrayOfGenerics();
    instance.add(10);
    instance.add(20);
    instance.add(30);
    assertEquals(true, instance.deleteByValue(20));
    assertEquals(false, instance.deleteByValue(40));
    Integer[] array = {10, 30};
    assertArrayEquals(array, instance.toArray(Integer.class));
  }

  @Test
  public void testDeleteRange() {
    LinkedListArrayOfGenerics<Integer> instance = new LinkedListArrayOfGenerics();
    for (int i = 0; i < 5; i++) {
      instance.add(i);
    }
    instance.deleteRange(0, 4);
    assertEquals("[4]", instance.toString());
    for (int i = 0; i < 5; i++) {
      instance.add(i);
    }
    instance.deleteRange(1, 5);
    assertEquals("[4]", instance.toString());
    for (int i = 0; i < 5; i++) {
      instance.add(i);
    }
    instance.deleteRange(1, 4);
    assertEquals("[4,4]", instance.toString());
    assertThrows(ArrayIndexOutOfBoundsException.class, () -> instance.deleteRange(0, 3));
    assertThrows(ArrayIndexOutOfBoundsException.class, () -> instance.deleteRange(-1, 1));
    instance.deleteRange(0, 2);
    assertEquals("", instance.toString());

  }

  /**
   * Test of getSize method, of class LinkedListArrayOfStrings.
   */
  @Test
  public void testGetSize() {
    System.out.println("getSize");
    LinkedListArrayOfGenerics<Integer> instance = new LinkedListArrayOfGenerics();
    assertEquals(0, instance.getSize());
    instance.add(10);
    assertEquals(1, instance.getSize());
    instance.add(20);
    assertEquals(2, instance.getSize());
    instance.deleteByIndex(0);
    assertEquals(1, instance.getSize());
    instance.deleteByIndex(0);
    assertEquals(0, instance.getSize());
  }

  /**
   * Test of toString method, of class LinkedListArrayOfStrings.
   */
  @Test
  public void testToString() {
    System.out.println("toString");
    LinkedListArrayOfGenerics<Integer> instance = new LinkedListArrayOfGenerics();

    assertEquals("", instance.toString());
    instance.add(10);
    assertEquals("[10]", instance.toString());
    instance.add(20);
    assertEquals("[10,20]", instance.toString());
  }

  /**
   * Test of toArray method, of class LinkedListArrayOfStrings.
   */
  @Test
  public void testToArray() {
    System.out.println("toArray");
    LinkedListArrayOfGenerics<Integer> instance = new LinkedListArrayOfGenerics();
    
    Integer[] array = new Integer[0];
    assertArrayEquals(array, instance.toArray(Integer.class));
    Integer[] array1 = {10, 20, 30};
    instance.add(30);
    instance.insertValueAtIndex(10, 0);
    instance.insertValueAtIndex(20, 1);
    assertArrayEquals(array1, instance.toArray(Integer.class));
  }

  @Test
  public void testIterator() {
    System.out.println("iterator");
    LinkedListArrayOfGenerics<Integer> instance = new LinkedListArrayOfGenerics();

    for (int i = 0; i < 10; i++) {
      instance.add(i);
    }
    assertEquals(10, instance.getSize());
    StringBuilder sb = new StringBuilder();
    sb.append("[");
    for (Integer val : instance) {
      sb.append(val.toString()).append(",");
    }
    sb.deleteCharAt(sb.length() - 1).append("]");
    assertEquals(sb.toString(), instance.toString());
  }
}
