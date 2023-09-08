/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit4TestClass.java to edit this template
 */
package day02arraylistownimpl;

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
public class CustomArrayOfIntsTest {

  public CustomArrayOfIntsTest() {
  }

  @BeforeClass
  public static void setUpClass() {
  }

  @AfterClass
  public static void tearDownClass() {
  }

  @Before
  public void setUp() {
  }

  @After
  public void tearDown() {
  }

  /**
   * Test of size method, of class CustomArrayOfInts.
   */
  @Test
  public void testSize() {
    System.out.println("size");
    CustomArrayOfInts instance = new CustomArrayOfInts();
    int expResult = 0;
    int result = instance.size();
    assertEquals(expResult, result);
    // TODO review the generated test code and remove the default call to fail.
//    fail("The test case is a prototype.");
  }

  /**
   * Test of add method, of class CustomArrayOfInts.
   */
  @Test
  public void testAdd() {
    System.out.println("add");
    int value = 0;
    CustomArrayOfInts instance = new CustomArrayOfInts();
    instance.add(value);
    // TODO review the generated test code and remove the default call to fail.
    int expResult = 0;
    int result = instance.get(0);
    assertEquals(expResult, result);
//    fail("The test case is a prototype.");
  }

  /**
   * Test of deleteByIndex method, of class CustomArrayOfInts.
   */
  @Test
  public void testDeleteByIndex() {
    System.out.println("deleteByIndex");
    int index = 0;
    CustomArrayOfInts instance = new CustomArrayOfInts();
    assertThrows(ArrayIndexOutOfBoundsException.class, () -> instance.deleteByIndex(index));
    for (int i=0;i<100;i++){
      instance.add(i);
    }
    for (int i = 0; i < 50; i++) {
      instance.deleteByIndex(i);
    }
    
    assertEquals(50, instance.size());
  }

  /**
   * Test of deleteByValue method, of class CustomArrayOfInts.
   */
  @Test
  public void testDeleteByValue() {
    System.out.println("deleteByValue");
    int value = 0;
    CustomArrayOfInts instance = new CustomArrayOfInts();

    boolean result = instance.deleteByValue(value);
    assertEquals(false, result);

    instance.add(value);
    result = instance.deleteByValue(value);
    assertEquals(true, result);
    assertEquals(0, instance.size());
  }

  /**
   * Test of insertValueAtIndex method, of class CustomArrayOfInts.
   */
  @Test
  public void testInsertValueAtIndex() {
    System.out.println("insertValueAtIndex");
    CustomArrayOfInts instance = new CustomArrayOfInts();
    for (int i=0;i<100;i++){
      instance.insertValueAtIndex(i, i);
    }
    instance.insertValueAtIndex(90, 9);
    assertEquals(101, instance.size());
    assertEquals(90, instance.get(9));
  }

  /**
   * Test of clear method, of class CustomArrayOfInts.
   */
  @Test
  public void testClear() {
    System.out.println("clear");
    CustomArrayOfInts instance = new CustomArrayOfInts();
    for (int i = 0; i < 100; i++) {
      instance.add(i);
    }
    instance.clear();
    assertEquals(0, instance.size());
  }

  /**
   * Test of get method, of class CustomArrayOfInts.
   */
  @Test
  public void testGet() {
    System.out.println("get");
    int index = 0;
    CustomArrayOfInts instance = new CustomArrayOfInts();
    instance.add(0);
    int expResult = 0;
    int result = instance.get(index);
    assertEquals(expResult, result);
  }

  /**
   * Test of getSlice method, of class CustomArrayOfInts.
   */
  @Test
  public void testGetSlice() {
    System.out.println("getSlice");
    int startIdx = 0;
    int length = 0;
    CustomArrayOfInts instance = new CustomArrayOfInts();
    int[] expResult = {};
    int[] result = instance.getSlice(startIdx, length);
    assertArrayEquals(expResult, result);
    for (int i = 0; i < 100; i++) {
      instance.add(i);
    }
    result = instance.getSlice(10, 10);
    expResult = new int[]{10, 11, 12, 13, 14, 15, 16, 17, 18, 19};
    assertArrayEquals(expResult, result);
  }

  /**
   * Test of toString method, of class CustomArrayOfInts.
   */
  @Test
  public void testToString() {
    System.out.println("toString");
    CustomArrayOfInts instance = new CustomArrayOfInts();
    String expResult = "[]";
    String result = instance.toString();

    instance.add(0);
    instance.add(-2);
    expResult = "[0, -2]";
    result = instance.toString();
    assertEquals(expResult, result);
  }

}
