/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit5TestClass.java to edit this template
 */
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
public class CustomHashMapTest {

  public CustomHashMapTest() {
  }

  private static CustomHashMap<CustomKey,String> instance ;
  @BeforeAll
  public static void setUpClass() {

  }

  @AfterAll
  public static void tearDownClass() {
  }

  @BeforeEach
  public void setUp() {
    instance = new CustomHashMap<>();
  }

  @AfterEach
  public void tearDown() {
  }

  /**
   * Test of putValue method, of class CustomHashMap.
   */
  @Test
  public void testPutValue() {
    System.out.println("putValue");

    instance.putValue(new CustomKey("key1"), "value1");
    assertEquals("[key1=>value1]", instance.toString());
    instance.putValue(new CustomKey("key2"), "value2");
    assertEquals("[key1=>value1,key2=>value2]", instance.toString());
    instance.putValue(new CustomKey("key3"), "value3");
    assertEquals("[key1=>value1,key2=>value2,key3=>value3]", instance.toString());
    for (int i = 0; i < 10; i++) {
      instance.putValue(new CustomKey("key" + i), "value" + i);
    }
    assertEquals("[key0=>value0,key1=>value1,key2=>value2,key3=>value3,key4=>value4,key5=>value5,key6=>value6,key7=>value7,key8=>value8,key9=>value9]", instance.toString());
    for (int i = 0; i < 10; i++) {
      instance.putValue(new CustomKey("key" + i), "val" + i);
    }
    assertEquals("[key0=>val0,key1=>val1,key2=>val2,key3=>val3,key4=>val4,key5=>val5,key6=>val6,key7=>val7,key8=>val8,key9=>val9]", instance.toString());
  }

  /**
   * Test of hasKey method, of class CustomHashMap.
   */
  @Test
  public void testHasKey() {
    System.out.println("hasKey");
    assertEquals(false, instance.hasKey(new CustomKey("key")));

    for (int i = 0; i < 10; i++) {
      instance.putValue(new CustomKey("key" + i), "val" + i);
    }
    assertEquals(false, instance.hasKey(new CustomKey("key")));
    for (int i = 0; i < 10; i++) {
      assertEquals(true, instance.hasKey(new CustomKey("key" + i)));
    }
  }

  /**
   * Test of getValue method, of class CustomHashMap.
   */
  @Test
  public void testGetValue() {
    System.out.println("getValue");
    assertEquals(null, instance.getValue(new CustomKey("key")));
    for (int i = 0; i < 10; i++) {
      instance.putValue(new CustomKey("key" + i), "val" + i);
    }
    instance.printDebug();
    assertEquals(null, instance.getValue(new CustomKey("key")));
    for (int i = 0; i < 10; i++) {
      assertEquals("val" + i, instance.getValue(new CustomKey("key" + i)));
    }
  }

  /**
   * Test of deleteByKey method, of class CustomHashMap.
   */
  @Test
  public void testDeleteByKey() {
    System.out.println("deleteByKey");
    instance.deleteByKey(new CustomKey("key"));
    for (int i = 0; i < 100; i++) {
      instance.putValue(new CustomKey("key" + i), "val" + i);
    }
    instance.printDebug();
    for (int i = 0; i < 34; i++) {
      int index = i * 3;
      instance.deleteByKey(new CustomKey("key" + index));
      assertEquals(null, instance.getValue(new CustomKey("key" + index)));
    }
    instance.printDebug();
    for (int i = 0; i < 33; i++) {
      int index = i * 3 + 1;
      instance.deleteByKey(new CustomKey("key" + index));
      assertEquals(null, instance.getValue(new CustomKey("key" + index)));
    }
    instance.printDebug();
    for (int i = 0; i < 33; i++) {
      int index = i * 3 + 2;
      instance.deleteByKey(new CustomKey("key" + index));
      assertEquals(null, instance.getValue(new CustomKey("key" + index)));
    }
    instance.printDebug();
    assertEquals("[]", instance.toString());
  }

  /**
   * Test of getAllKeys method, of class CustomHashMap.
   */
  @Test
  public void testGetAllKeys() {
    System.out.println("getAllKeys");
    CustomKey[] expResult = new CustomKey[0];
    CustomKey[] result = instance.getAllKeys(CustomKey.class);
    assertEquals(expResult.length, result.length);
    
    expResult = new CustomKey[10];
    for (int i=0;i<10;i++){
      expResult[i]=new CustomKey("key"+i);
      instance.putValue(expResult[i], "val"+i);
    }
    instance.printDebug();
    result = instance.getAllKeys(CustomKey.class);
    assertEquals(expResult.length, result.length);


  }

  /**
   * Test of getAllKeyValPairs method, of class CustomHashMap.
   */
  @Test
  public void testGetAllKeyValPairs() {
    System.out.println("getAllKeyValPairs");
    Class<CustomKey> keyClass = CustomKey.class;
    Class<String> valueClass = String.class;
    Pair<CustomKey, String>[] result = instance.getAllKeyValPairs(keyClass, valueClass);
    assertEquals(0, result.length);
    Pair<CustomKey, String>[] expResult = new Pair[10];
    for (int i = 0; i < 10; i++) {
      expResult[i] = new Pair(new CustomKey("key" + i), "val" + i);
      instance.putValue(new CustomKey("key" + i), "val" + i);
    }
    result = instance.getAllKeyValPairs(keyClass, valueClass);
    assertEquals(expResult.length, result.length);
  }

  /**
   * Test of getSize method, of class CustomHashMap.
   */
  @Test
  public void testGetSize() {
    System.out.println("getSize");
    int expResult = 0;
    int result = instance.getSize();
    assertEquals(expResult, result);
    instance.putValue(new CustomKey("key"), "val");
    assertEquals(1, instance.getSize());
  }

  /**
   * Test of printDebug method, of class CustomHashMap.
   */
//  @Test
//  public void testPrintDebug() {
//    System.out.println("printDebug");
//    CustomHashMap instance = new CustomHashMap();
//    instance.printDebug();
//    // TODO review the generated test code and remove the default call to fail.
//    fail("The test case is a prototype.");
//  }

  /**
   * Test of toString method, of class CustomHashMap.
   */
  @Test
  public void testToString() {
    System.out.println("toString");
    String expResult = "[]";
    String result = instance.toString();
    assertEquals(expResult, result);
    instance.putValue(new CustomKey("key0"), "val0");
    assertEquals("[key0=>val0]", instance.toString());
    instance.putValue(new CustomKey("key1"), "val1");
    assertEquals("[key0=>val0,key1=>val1]", instance.toString());
    instance.putValue(new CustomKey("key"), "val");
    assertEquals("[key=>val,key0=>val0,key1=>val1]", instance.toString());
  }

}
