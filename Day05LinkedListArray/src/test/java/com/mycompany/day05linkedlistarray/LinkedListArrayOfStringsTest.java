package com.mycompany.day05linkedlistarray;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class LinkedListArrayOfStringsTest {

  public LinkedListArrayOfStringsTest() {
  }

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
    String value = "";
    LinkedListArrayOfStrings instance = new LinkedListArrayOfStrings();
    instance.add(value);
    instance.add("value");
    assertEquals("", instance.get(0));
    assertEquals("value", instance.get(1));
  }

  /**
   * Test of get method, of class LinkedListArrayOfStrings.
   */
  @Test
  public void testGet() {
    System.out.println("get");
    LinkedListArrayOfStrings instance = new LinkedListArrayOfStrings();
    assertThrows(ArrayIndexOutOfBoundsException.class, () -> instance.get(0));
    instance.add("");
    assertEquals("", instance.get(0));

  }

  /**
   * Test of insertValueAtIndex method, of class LinkedListArrayOfStrings.
   */
  @Test
  public void testInsertValueAtIndex() {
    System.out.println("insertValueAtIndex");
    LinkedListArrayOfStrings instance = new LinkedListArrayOfStrings();
    assertThrows(ArrayIndexOutOfBoundsException.class, () -> instance.insertValueAtIndex("", 0));
    instance.add("value0");
    assertThrows(ArrayIndexOutOfBoundsException.class, () -> instance.insertValueAtIndex("", 1));
    instance.insertValueAtIndex("value", 0);
    assertEquals("value", instance.get(0));
    assertEquals("value0", instance.get(1));
    instance.insertValueAtIndex("", 1);
    assertEquals("", instance.get(1));
    assertEquals("value0", instance.get(2));
  }

  /**
   * Test of replaceValueAtIndex method, of class LinkedListArrayOfStrings.
   */
  @Test
  public void testReplaceValueAtIndex() {
    System.out.println("replaceValueAtIndex");
    String value = "";
    int index = 0;
    LinkedListArrayOfStrings instance = new LinkedListArrayOfStrings();
    assertThrows(ArrayIndexOutOfBoundsException.class, () -> instance.replaceValueAtIndex(value, index));
    instance.add("aaa");
    instance.add("");
    instance.add("ccc");
    instance.replaceValueAtIndex("bbb", 1);
    String[] array = {"aaa", "bbb", "ccc"};
    assertArrayEquals(array, instance.toArray());
  }

  /**
   * Test of deleteByIndex method, of class LinkedListArrayOfStrings.
   */
  @Test
  public void testDeleteByIndex() {
    System.out.println("deleteByIndex");
    LinkedListArrayOfStrings instance = new LinkedListArrayOfStrings();
    instance.add("aaa");
    instance.add("bbb");
    instance.add("ccc");
    instance.deleteByIndex(1);
    String[] array = {"aaa", "ccc"};
    assertArrayEquals(array, instance.toArray());
    String[] array1 = {"aaa"};
    instance.deleteByIndex(1);
    assertArrayEquals(array1, instance.toArray());
    String[] array2 = {};
    instance.deleteByIndex(0);
    assertArrayEquals(array2, instance.toArray());
  }

  /**
   * Test of deleteByValue method, of class LinkedListArrayOfStrings.
   */
  @Test
  public void testDeleteByValue() {
    System.out.println("deleteByValue");
    LinkedListArrayOfStrings instance = new LinkedListArrayOfStrings();
    instance.add("aaa");
    instance.add("bbb");
    instance.add("ccc");
    assertEquals(true, instance.deleteByValue("bbb"));
    assertEquals(false, instance.deleteByValue("ddd"));
    String[] array = {"aaa", "ccc"};
    assertArrayEquals(array, instance.toArray());
  }

  @Test
  public void testDeleteRange() {
    LinkedListArrayOfStrings instance = new LinkedListArrayOfStrings();
    for (int i = 0; i < 5; i++) {
      instance.add("val" + i);
    }
    instance.deleteRange(0, 4);
    assertEquals("[val4]", instance.toString());
    for (int i = 0; i < 5; i++) {
      instance.add("val" + i);
    }
    instance.deleteRange(1, 5);
    assertEquals("[val4]", instance.toString());
    for (int i = 0; i < 5; i++) {
      instance.add("val" + i);
    }
    instance.deleteRange(1, 4);
    assertEquals("[val4,val4]", instance.toString());
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
    LinkedListArrayOfStrings instance = new LinkedListArrayOfStrings();
    assertEquals(0, instance.getSize());
    instance.add("");
    assertEquals(1, instance.getSize());
    instance.add("value");
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
    LinkedListArrayOfStrings instance = new LinkedListArrayOfStrings();
    
    assertEquals("", instance.toString());
    instance.add("");
    assertEquals("[]", instance.toString());
    instance.add("value");
    assertEquals("[,value]", instance.toString());
  }

  /**
   * Test of toArray method, of class LinkedListArrayOfStrings.
   */
  @Test
  public void testToArray() {
    System.out.println("toArray");
    LinkedListArrayOfStrings instance = new LinkedListArrayOfStrings();
    String[] array = new String[0];
    assertArrayEquals(array, instance.toArray());
    String[] array1 = {"aaa", "bbb", "ccc"};
    instance.add("ccc");
    instance.insertValueAtIndex("aaa", 0);
    instance.insertValueAtIndex("bbb", 1);
    assertArrayEquals(array1, instance.toArray());
  }

  @Test
  public void testIterator() {
    System.out.println("iterator");
    LinkedListArrayOfStrings instance = new LinkedListArrayOfStrings();

    for (int i = 0; i < 10; i++) {
      instance.add("val" + i);
    }
    assertEquals(10, instance.getSize());
    StringBuilder sb = new StringBuilder();
    sb.append("[");
    for (String val : instance) {
      sb.append(val).append(",");
    }
    sb.deleteCharAt(sb.length() - 1).append("]");
    assertEquals(sb.toString(), instance.toString());
  }
}
