package com.mycompany.day10binarytree;

import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.Stack;
import java.util.function.Consumer;

public class BinaryTreeOfInts implements Iterable<Integer> {
  
  private NodeOfInt root;
  private int nodesCount;

  private class BinaryTreeOfIntsIterator implements Iterator<Integer> {

    private Stack<NodeOfInt> stack = new Stack<>();
    NodeOfInt current;

    public BinaryTreeOfIntsIterator() {
      putLeftTree(root);
      if (!stack.isEmpty()) {
        current = stack.pop();
      }
    }

    private void putLeftTree(NodeOfInt tree) {
      while (tree != null) {
        stack.push(tree);
        tree = tree.left;
      }
    }

    @Override
    public boolean hasNext() {
      return current != null || !stack.isEmpty();

    }

    @Override
    public Integer next() {
      if (current == null) {
        throw new NoSuchElementException();
      }
      if (current.right != null) {
        putLeftTree(current.right);
      }
      Integer result = current.value;
      if (!stack.isEmpty()){
        current = stack.pop();
      } else {
        current = null;
      }

      return result;
    }


  }

  @Override
  public Iterator<Integer> iterator() {
    return new BinaryTreeOfIntsIterator();
  }

  @Override
  public void forEach(Consumer<? super Integer> action) {
    forEach(root, action);
  }

  private void forEach(NodeOfInt node, Consumer<? super Integer> action) {
    if (node != null) {
      forEach(node.left, action);
      action.accept(node.value);
      forEach(node.right, action);
    }
  }

//  private class NodeOfInt {
//
//    int value; // could also be key, value pair
//    NodeOfInt left, right;
//
//    public NodeOfInt(int value) {
//      this.value = value;
//      left=null;
//      right=null;              
//    }
//    
//  }
  // throws exception if put attempts to insert value that already exists (a duplicate)
  void put(int value) throws IllegalArgumentException {
    if (root==null) {
      root = new NodeOfInt(value);
    } else {
      putToTree(root, value);

    }
    nodesCount++;

  }

  private void putToTree(NodeOfInt tree, int value) {
    
    if (value == tree.value) {
        throw new IllegalArgumentException();
    }

    if (value < tree.value) {
      //left subtree
      if (tree.left != null) {
        putToTree(tree.left, value);
      } else {
        tree.left = new NodeOfInt(value);
      }
    } else {
      //right subtree
      if (tree.right != null) {
        putToTree(tree.right, value);
      } else {
        tree.right = new NodeOfInt(value);
      }
    }
    
  }

	public int getSize() {
    return nodesCount;
  }

  public boolean hasValue(int val) {

    return isValInTree(root, val);

  }

  private boolean isValInTree(NodeOfInt tree, int val) {
    if (tree == null) {
      return false;
    }
    if (val == tree.value) {
      return true;
    }
    if (val < tree.value) {
      return isValInTree(tree.left, val);
    } else {
      return isValInTree(tree.right, val);
    }
  }
	
	// uses recursion to compute the sum of all values in the entire tree
	public int getSumOfAllValues() {
    return getSumOfThisAndSubNodes(root);
  }

  // private helper recursive method to implement the above method
  private int getSumOfThisAndSubNodes(NodeOfInt node) {
    if (node == null) {
      return 0;
    }
    return node.value + getSumOfThisAndSubNodes(node.left) + getSumOfThisAndSubNodes(node.right);
  }
	
	// uses recursion to collect all values from largest to smallest
  int[] getValuesInOrder() { // from largest to smallest
    resultArray = new int[nodesCount];
    resultIndex = 0;
    if (root != null) {
      collectValuesInOrder(root);
    }
    return resultArray;
	}
	// private helper recursive method to implement the above method
	private void collectValuesInOrder(NodeOfInt node) {
    if (node.right != null) {
      collectValuesInOrder(node.right);
    }
    resultArray[resultIndex] = node.value;
    resultIndex++;
    if (node.left != null) {
      collectValuesInOrder(node.left);
    }
  }
  // data structures used to make collecting values in order easier
  private int[] resultArray;
  private int resultIndex;

  public void accept(Visitor visitor) {
    if (root != null) {
      accept(visitor, root);
    }
  }

  private void accept(Visitor visitor, NodeOfInt node) {
    if (node != null) {
      node.accept(visitor); // 让访问者访问当前节点
      accept(visitor, node.left); // 递归访问左子树
      accept(visitor, node.right); // 递归访问右子树
    }
  }

}
