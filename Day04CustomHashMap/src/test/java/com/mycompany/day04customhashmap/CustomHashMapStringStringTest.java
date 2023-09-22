package com.mycompany.day04customhashmap;

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
public class CustomHashMapStringStringTest {

  public CustomHashMapStringStringTest() {
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
   * Test of putValue method, of class CustomHashMapStringString.
   */
  @Test
  public void testPutValue() {
    System.out.println("putValue");
    CustomHashMapStringString instance = new CustomHashMapStringString();

    instance.putValue("key1", "value1");
    assertEquals("[key1=>value1]", instance.toString());
    instance.putValue("key2", "value2");
    assertEquals("[key1=>value1,key2=>value2]", instance.toString());
    instance.putValue("key3", "value3");
    assertEquals("[key1=>value1,key2=>value2,key3=>value3]", instance.toString());
    for (int i = 0; i < 10; i++) {
      instance.putValue("key" + i, "value" + i);
    }
    assertEquals("[key0=>value0,key1=>value1,key2=>value2,key3=>value3,key4=>value4,key5=>value5,key6=>value6,key7=>value7,key8=>value8,key9=>value9]", instance.toString());
    for (int i = 0; i < 10; i++) {
      instance.putValue("key" + i, "val" + i);
    }
    assertEquals("[key0=>val0,key1=>val1,key2=>val2,key3=>val3,key4=>val4,key5=>val5,key6=>val6,key7=>val7,key8=>val8,key9=>val9]", instance.toString());
  }

  /**
   * Test of hasKey method, of class CustomHashMapStringString.
   */
  @Test
  public void testHasKey() {
    System.out.println("hasKey");
    CustomHashMapStringString instance = new CustomHashMapStringString();
    assertEquals(false, instance.hasKey("key"));

    for (int i = 0; i < 10; i++) {
      instance.putValue("key" + i, "val" + i);
    }
    assertEquals(false, instance.hasKey("key"));
    for (int i = 0; i < 10; i++) {
      assertEquals(true, instance.hasKey("key" + i));
    }
  }

  /**
   * Test of getValue method, of class CustomHashMapStringString.
   */
  @Test
  public void testGetValue() {
    System.out.println("getValue");
    CustomHashMapStringString instance = new CustomHashMapStringString();
    assertEquals(null, instance.getValue("key"));
    for (int i = 0; i < 10; i++) {
      instance.putValue("key" + i, "val" + i);
    }
    instance.printDebug();
    assertEquals(null, instance.getValue("key"));
    for (int i = 0; i < 10; i++) {
      assertEquals("val" + i, instance.getValue("key" + i));
    }
  }

  /**
   * Test of deleteByKey method, of class CustomHashMapStringString.
   */
  @Test
  public void testDeleteByKey() {
    System.out.println("deleteByKey");
    CustomHashMapStringString instance = new CustomHashMapStringString();
    instance.deleteByKey("key");
    for (int i = 0; i < 100; i++) {
      instance.putValue("key" + i, "val" + i);
    }
    instance.printDebug();
    for (int i = 0; i < 34; i++) {
      int index = i * 3;
      instance.deleteByKey("key" + index);
      assertEquals(null, instance.getValue("key" + index));
    }
    instance.printDebug();
    for (int i = 0; i < 33; i++) {
      int index = i * 3 + 1;
      instance.deleteByKey("key" + index);
      assertEquals(null, instance.getValue("key" + index));
    }
    instance.printDebug();
    for (int i = 0; i < 33; i++) {
      int index = i * 3 + 2;
      instance.deleteByKey("key" + index);
      assertEquals(null, instance.getValue("key" + index));
    }
    instance.printDebug();
    assertEquals("[]", instance.toString());
  }

  /**
   * Test of getAllKeys method, of class CustomHashMapStringString.
   */
  @Test
  public void testGetAllKeys() {
    System.out.println("getAllKeys");
    CustomHashMapStringString instance = new CustomHashMapStringString();
    String[] expResult = new String[0];
    String[] result = instance.getAllKeys();
    assertArrayEquals(expResult, result);
    instance.putValue("key0", "val0");
    expResult = new String[]{"key0"};
    assertArrayEquals(expResult, instance.getAllKeys());
    expResult = new String[]{"key0", "key1"};
    instance.putValue("key1", "val1");
    assertArrayEquals(expResult, instance.getAllKeys());
  }

  /**
   * Test of getAllKeyValPairs method, of class CustomHashMapStringString.
   */
  @Test
  public void testGetAllKeyValPairs() {
    System.out.println("getAllKeyValPairs");
    CustomHashMapStringString instance = new CustomHashMapStringString();
    Pair[] expResult = new Pair[0];
    Pair[] result = instance.getAllKeyValPairs();
    assertArrayEquals(expResult, result);
    expResult = new Pair[10];
    for (int i = 0; i < 10; i++) {
      expResult[i] = new Pair("key" + i, "val" + i);
      instance.putValue("key" + i, "val" + i);
    }
    result = instance.getAllKeyValPairs();
    assertEquals(expResult.length, result.length);
  }

  /**
   * Test of getSize method, of class CustomHashMapStringString.
   */
  @Test
  public void testGetSize() {
    System.out.println("getSize");
    CustomHashMapStringString instance = new CustomHashMapStringString();
    int expResult = 0;
    int result = instance.getSize();
    assertEquals(expResult, result);
    instance.putValue("key", "val");
    assertEquals(1, instance.getSize());
  }

  /**
   * Test of printDebug method, of class CustomHashMapStringString.
   */
//  @Test
//  public void testPrintDebug() {
//    System.out.println("printDebug");
//    CustomHashMapStringString instance = new CustomHashMapStringString();
//    instance.printDebug();
//    // TODO review the generated test code and remove the default call to fail.
//    fail("The test case is a prototype.");
//  }

  /**
   * Test of toString method, of class CustomHashMapStringString.
   */
  @Test
  public void testToString() {
    System.out.println("toString");
    CustomHashMapStringString instance = new CustomHashMapStringString();
    String expResult = "[]";
    String result = instance.toString();
    assertEquals(expResult, result);
    instance.putValue("key0", "val0");
    assertEquals("[key0=>val0]", instance.toString());
    instance.putValue("key1", "val1");
    assertEquals("[key0=>val0,key1=>val1]", instance.toString());
    instance.putValue("key", "val");
    assertEquals("[key=>val,key0=>val0,key1=>val1]", instance.toString());
  }

}
