package com.mycompany.day04customhashmap;

// HashMap, key is String, value is String
import java.lang.reflect.Array;

class CustomHashMap<K extends Hashable & Comparable<K>, V> {

  private class Container {

    Container next;
    K key;
    V value;

    public Container(K key, V value, Container next) {
      this.next = next;
      this.key = key;
      this.value = value;
    }

  }

  // size must be a prime number always
  private Object[] hashTable = new Object[5];

  private int totalItems;

  private int computeHashValue(K key) { // hashing function
    return key.getHash();

  }

  void putValue(K key, V value) {
    int hash = computeHashValue(key);
    int hashTableIndex = hash % hashTable.length;
    Container container = (Container) hashTable[hashTableIndex];
    if (container == null) {
      container = new Container(key, value, null);
      hashTable[hashTableIndex] = container;
    } else {
      while (!(container.key.equals(key) || container.next == null)) {
        container = container.next;
      }
      if (container.key.equals(key)) {
        container.value = value;
        return;
      }
      Container newContainer = new Container(key, value, null);
      container.next = newContainer;
    }
    totalItems++;

  }
  // LATER: expand hashTable by about *2 when totalItems > 3*hashTable.length

  boolean hasKey(K key) {
    for (Object object : hashTable) {
      Container container = (Container) object;
      while (container != null) {
        if (container.key.equals(key)) {
          return true;
        }
        container = container.next;
      }
    }
    return false;
  }

  // throw custom unchecked KeyNotFoundException
  V getValue(K key) {
    for (Object object : hashTable) {
      Container container = (Container) object;
      while (container != null) {
        if (container.key.equals(key)) {
          return (V) container.value;
        }
        container = container.next;
      }
    }
    return null;
  }

  // throw custom unchecked KeyNotFoundException
  void deleteByKey(K key) {
    for (int i = 0; i < hashTable.length; i++) {
      Container container = (Container) hashTable[i];
      if (container == null) {
        continue;
      }
      //head node
      if (container.key.equals(key)) {
        if (container.next == null) {
          hashTable[i] = null;
        } else {
          hashTable[i] = container.next;
        }
        totalItems--;
        return;
      }
      //other nodes
      while (container.next != null) {
        //found
        if (container.next.key.equals(key)) {
          container.next = container.next.next;
          totalItems--;
          return;
        }
        container = container.next;
      }
      //not found

    }

  }

  public K[] getAllKeys(Class<K> componentType) {
    Object[] keys;
    keys = (K[]) Array.newInstance(componentType, totalItems);
    int index = 0;
    for (Object object : hashTable) {
      Container container = (Container) object;
      while (container != null) {
        keys[index] = container.key;
        index++;
        container = container.next;
      }
    }
    return (K[]) keys;

  }

  public Pair<K, V>[] getAllKeyValPairs(Class<K> keyClass, Class<V> valueClass) {
    Object[] result = (Pair<K, V>[]) Array.newInstance(Pair.class, totalItems);
    int index = 0;
    for (Object object : hashTable) {
      Container container = (Container) object;
      while (container != null) {
        result[index] = new Pair<>((K) container.key, (V) container.value);
        index++;
        container = container.next;
      }
    }
    return (Pair<K, V>[]) result;
  }

  int getSize() {
    return totalItems;
  }

  public void printDebug() {
    System.out.println("Total Items: " + getSize());
    System.out.println("HashTable Items: " + hashTable.length);
    for (int i = 0; i < hashTable.length; i++) {
      System.out.println(String.format("HashTable[%d]: ", i));
      Container container = (Container) hashTable[i];
      while (container != null) {
        System.out.print(String.format("%s => %s  ", container.key.toString(), container.value.toString()));
        container = container.next;
      }
      System.out.println();
    }

  } // print hashTable content, see example below

  @Override
  public String toString() {
    Container list = null;
    for (Object object : hashTable) {
      Container container = (Container) object;
      while (container != null) {
        //first node of list
        if (list == null) {
          list = new Container(container.key, container.value, null);
          container = container.next;
          continue;
        }
        //new head node of list
        if (list.key.compareTo(container.key) > 0) {
          Container newNode = new Container(container.key, container.value, list);
          list = newNode;
          container = container.next;
          continue;
        }
        //insert into list
        Container current = list;
        while (current.next != null && current.next.key.compareTo(container.key) <= 0) {
          current = current.next;
        }
        if (current.next == null) {
          current.next = new Container(container.key, container.value, null);
        } else {
          current.next = new Container(container.key, container.value, current.next);
        }
        container = container.next;
      }
    }

    StringBuilder sb = new StringBuilder();
    sb.append("[");
    while (list != null) {
      sb.append(list.key.toString()).append("=>").append(list.value.toString()).append(",");
      list = list.next;
    }
    if (sb.length() > 3) {
      sb.deleteCharAt(sb.length() - 1);
    }
    sb.append("]");
    return sb.toString();

  } // comma-separated key->value pair list
  // to be able to use this as validation in Unit tests keys must be sorted
  // e.g. [ Key1 => Val1, Key2 => Val2, ... ]

}
