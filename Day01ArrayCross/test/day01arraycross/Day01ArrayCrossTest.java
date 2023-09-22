/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit4TestClass.java to edit this template
 */
package day01arraycross;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Optional;
import java.util.function.Predicate;
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
public class Day01ArrayCrossTest {

  public Day01ArrayCrossTest() {
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

  @org.junit.jupiter.api.Test
  @Test
  public void Test() {
    Map<String, String> map = new HashMap<>();
    map.put("key1", "value1");
    map.put("key2", null);
    map.put("key3", "value3");
    map.put("key4", null);
    map.put("key5", "value5");

    // 使用 Stream 遍历 Map，并使用 Optional 过滤和打印不为空的值
    map.forEach((key, value) -> {
      Optional.ofNullable(value).ifPresent(val -> System.out.println("Key: " + key + ", Value: " + val));
      Optional.ofNullable(value).ifPresent(System.out::println);
    });
    map.values().stream().filter(val -> val != null).forEach(System.out::println);
    ArrayList<String> list = new ArrayList<>();
    list.add("value1");
    list.add(null);
    list.add("value2");
    list.stream().filter(val -> val != null).forEach(System.out::println);
    list.stream().forEach((val) -> {
      Optional.ofNullable(val).ifPresent(System.out::println);
    });
    assertTrue(true);
  }
  /**
   * Test of getIfExists method, of class Day01ArrayCross.
   */
//  @Test
//  public void testGetIfExists() {
//    System.out.println("getIfExists");
//    int[][] data = null;
//    int row = 0;
//    int col = 0;
//    int expResult = 0;
//    int result = Day01ArrayCross.getIfExists(data, row, col);
//    assertEquals(expResult, result);
//    // TODO review the generated test code and remove the default call to fail.
//    fail("The test case is a prototype.");
//  }
//
//  /**
//   * Test of sumOfCross method, of class Day01ArrayCross.
//   */
//  @Test
//  public void testSumOfCross() {
//    System.out.println("sumOfCross");
//    int[][] data = null;
//    int row = 0;
//    int col = 0;
//    int expResult = 0;
//    int result = Day01ArrayCross.sumOfCross(data, row, col);
//    assertEquals(expResult, result);
//    // TODO review the generated test code and remove the default call to fail.
//    fail("The test case is a prototype.");
//  }
//
//  /**
//   * Test of print2D method, of class Day01ArrayCross.
//   */
//  @Test
//  public void testPrint2D() {
//    System.out.println("print2D");
//    int[][] data = null;
//    Day01ArrayCross.print2D(data);
//    // TODO review the generated test code and remove the default call to fail.
//    fail("The test case is a prototype.");
//  }
//
//  /**
//   * Test of duplicateEmptyArray2D method, of class Day01ArrayCross.
//   */
//  @Test
//  public void testDuplicateEmptyArray2D() {
//    System.out.println("duplicateEmptyArray2D");
//    int[][] orig2d = null;
//    int[][] expResult = null;
//    int[][] result = Day01ArrayCross.duplicateEmptyArray2D(orig2d);
//    assertArrayEquals(expResult, result);
//    // TODO review the generated test code and remove the default call to fail.
//    fail("The test case is a prototype.");
//  }
//
//  /**
//   * Test of printSmallest method, of class Day01ArrayCross.
//   */
//  @Test
//  public void testPrintSmallest() {
//    System.out.println("printSmallest");
//    int[][] arr = null;
//    Day01ArrayCross.printSmallest(arr);
//    // TODO review the generated test code and remove the default call to fail.
//    fail("The test case is a prototype.");
//  }
//
//  /**
//   * Test of getCrossSumArray method, of class Day01ArrayCross.
//   */
//  @Test
//  public void testGetCrossSumArray() {
//    System.out.println("getCrossSumArray");
//    int[][] arr = null;
//    int[][] expResult = null;
//    int[][] result = Day01ArrayCross.getCrossSumArray(arr);
//    assertArrayEquals(expResult, result);
//    // TODO review the generated test code and remove the default call to fail.
//    fail("The test case is a prototype.");
//  }
//
//  /**
//   * Test of main method, of class Day01ArrayCross.
//   */
//  @Test
//  public void testMain() {
//    System.out.println("main");
//    String[] args = null;
//    Day01ArrayCross.main(args);
//    // TODO review the generated test code and remove the default call to fail.
//    fail("The test case is a prototype.");
//  }

}
