package com.mycompany.day10binarytreekeyval;

public class BinaryTreeStringInt {

  private class Node {

    String key;
    int value;
    Node left, right;

    public Node(String key, int value) {
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
  void put(String key, int value) {
    if (root==null){
      root = new Node(key, value);
      nodesCount++;
    }else{
      putToTree(root, key, value);
    }

  
  }
  
  private void putToTree(Node tree, String key, int value) {
    
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
	public int getValByKey(String key) throws RuntimeException {
    return getValByKeyFromTree(root, key);
  }

  private int getValByKeyFromTree(Node tree, String key) {
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
	
	// print out all key-value pairs (one per line) from the smallest key to the largest
  void printAllKeyValPairs() {
    printTree(root);
  }

  private void printTree(Node tree) {
    if (tree == null) {
      return;
    }
    printTree(tree.left);
    System.out.println(String.format("%s=>%d", tree.key, tree.value));
    printTree(tree.right);

  }

}
