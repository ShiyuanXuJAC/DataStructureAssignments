/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package fibcached;

import java.util.HashMap;

class FibCached {

  FibCached() {
    fibsCached.put(0, 0L); // #0
    fibsCached.put(1, 1L); // #1
  }

  private HashMap<Integer, Long> fibsCached = new HashMap<>();
//  private int fibsCompCount = 2; // may not be needed
  // in a correct caching implementation fibsCompCount will end up the same as fibsCached.size();

  // when you implement caching, make this method print out the number of fib values it had to compute (as opposed to take from cache)
  public long getNthFib(int n) {
    if (n < 0) {
      throw new IllegalArgumentException("Fibonacci index cannot be negative");
    }
    if (fibsCached.containsKey(n)) {
      return fibsCached.get(n);
    }
    long fib = computeNthFib(n);
    fibsCached.put(n, fib);
    return fib;
  }

  // You can find implementation online, recursive or non-recursive.
  // For 100% solution you should use values in fibsCached as a starting point
  // instead of always starting from the first two values of 0, 1.
  private long computeNthFib(int n) {
    return getNthFib(n - 1) + getNthFib(n - 2);
  }

  // You are allowed to add another private method for fibonacci generation
  // if you want to use recursive approach. I recommend non-recursive though.
  // How many fibonacci numbers has your code computed as opposed to returned cached?
  // Use this in your testing to make sure your caching actually works properly.
  public int getCountOfFibsComputed() {
    return fibsCached.size();
  }

  @Override
  public String toString() {
    StringBuilder str = new StringBuilder();
    for (int i : fibsCached.keySet()) {
      str.append(fibsCached.get(i));
      str.append(",");
    }
    int length = str.length();
    if (length > 0) {
      str.deleteCharAt(length - 1);
    }
    return str.toString();
  }
  // returns all cached Fib values, comma-space-separated on a single line
  public static void main(String[] args) {
    FibCached fibCached = new FibCached();
    long fib = fibCached.getNthFib(20);

    System.out.println("Count of Fibonacci numbers computed: " + fibCached.getCountOfFibsComputed());
    System.out.println("Cached Fibonacci numbers: " + fibCached.toString());
  }

}
