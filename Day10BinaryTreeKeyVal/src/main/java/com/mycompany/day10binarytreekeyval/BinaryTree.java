package com.mycompany.day10binarytreekeyval;

import java.lang.reflect.Array;
import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.Stack;

class Pair<K extends Comparable, V> {

  K key;
  V value;

  public Pair(K key, V value) {
    this.key = key;
    this.value = value;
  }

}

public class BinaryTree<K extends Comparable, V> implements Iterable<Pair<K, V>> {

  @Override
  public Iterator<Pair<K, V>> iterator() {
    return new IteratorBinaryTree();
  }

  private class IteratorBinaryTree implements Iterator<Pair<K, V>> {

    private Stack<Node> stack = new Stack<>();
    private Node current;

    public IteratorBinaryTree() {
      pushLeft(root);

      current = stack.isEmpty() ? root : stack.pop();
    }

    private void pushLeft(Node node) {
      while (node != null) {
        stack.push(node);
        node = node.left;
      }
    }

    @Override
    public boolean hasNext() {
      return current != null || !stack.isEmpty();
    }

    @Override
    public Pair<K, V> next() {
      if (!hasNext()) {
        throw new NoSuchElementException();
      }
      Pair<K, V> pair = new Pair<>(current.key, current.value);

      if (current.right != null) {
        pushLeft(current.right);
      }
      current = stack.isEmpty() ? null : stack.pop();
      return pair;
    }


  }

  private class Node {

    K key;
    V value;
    Node left, right;

    public Node(K key, V value) {
      this.key = key;
      this.value = value;
      left=null;
      right=null;
    }
    
  }

  Node root;
  private int nodesCount;

  // if put attempts to insert a key that already exists then value is updated (no exception is thrown)
  // values may be duplicates but keys may not
  void put(K key, V value) {
    if (root==null){
      root = new Node(key, value);
      nodesCount++;
    }else{
      putToTree(root, key, value);
    }

  
  }
  
  private void putToTree(Node tree, K key, V value) {
    
    if (key.equals(tree.key)) {
      tree.value = value;
      return;
    }

    if (key.compareTo(tree.key) < 0) {
      //left subtree
      if (tree.left != null) {
        putToTree(tree.left, key, value);
      } else {
        tree.left = new Node(key, value);
        nodesCount++;
      }
    } else {
      //right subtree
      if (tree.right != null) {
        putToTree(tree.right, key, value);
      } else {
        tree.right = new Node(key, value);
        nodesCount++;
      }
    }
    
  }
  public int getSize() {
    return nodesCount;
  }

	// throws exception if key is not found, otherwise returns the value
	public V getValByKey(K key) throws RuntimeException {
    return getValByKeyFromTree(root, key);
  }

  private V getValByKeyFromTree(Node tree, K key) {
    if (key.equals(tree.key)) {
      return tree.value;
    }

    if (key.compareTo(tree.key) < 0) {
      //left subtree
      if (tree.left != null) {
        return getValByKeyFromTree(tree.left, key);
      } else {
        throw new RuntimeException("key not found");
      }
    } else {
      //right subtree
      if (tree.right != null) {
        return getValByKeyFromTree(tree.right, key);
      } else {
        throw new RuntimeException("key not found");
      }
    }
  }

  private K[] keys;
  int keyIndex;

  K[] getKeysInOrder() {
    if (nodesCount == 0) {
      return keys;
    }
    keys = (K[]) Array.newInstance(root.key.getClass(), nodesCount);
    keyIndex = 0;
    putKeysToArray(root);
    return keys;
  }

  private void putKeysToArray(Node tree) {
    if (tree.left != null) {
      putKeysToArray(tree.left);
    }
    keys[keyIndex] = tree.key;
    keyIndex++;
    if (tree.right != null) {
      putKeysToArray(tree.right);
    }
  }

//  private Pair<K, V>[] pairs;
//  private int pairIndex;

//  private Pair<K, V>[] getPairsInOrder() {
//    if (nodesCount == 0) {
//      return pairs;
//    }
//    Pair<K, V> pair = new Pair<>(root.key, root.value);
//    pairs = (Pair<K, V>[]) Array.newInstance(pair.getClass(), pairIndex);
//    pairIndex = 0;
//    putPairsToArray(root);
//    return pairs;
//  }
//
//  private void putPairsToArray(Node tree) {
//    if (tree.left != null) {
//      putPairsToArray(tree.left);
//    }
//    pairs[pairIndex] = new Pair<>(tree.key, tree.value);
//    pairIndex++;
//    if (tree.right != null) {
//      putPairsToArray(tree.right);
//    }
//  }
	
	// print out all key-value pairs (one per line) from the smallest key to the largest
  void printAllKeyValPairs() {
    printTree(root);
  }

  private void printTree(Node tree) {
    if (tree == null) {
      return;
    }
    printTree(tree.left);
    System.out.println(String.format("%s=>%s", tree.key.toString(), tree.value.toString()));
    printTree(tree.right);

  }

}
