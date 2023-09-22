package com.mycompany.day04customhashmap;

import java.util.Objects;

public class CustomKey implements Hashable, Comparable<CustomKey> {

  public String key;

  public CustomKey(String key) {
    this.key = key;
  }

  @Override
  public int getHash() {
    int hash = 0;
    for (int i = 0; i < key.length(); i++) {
      // hash *= 3;
      hash <<= 1;  // same as: hash *= ...
      char c = key.charAt(i);
      hash += c;
    }
    return hash;
  }

  @Override
  public int compareTo(CustomKey compared) {
    return key.compareTo(compared.key);

  }

  @Override
  public int hashCode() {
    int hash = 7;
    hash = 83 * hash + Objects.hashCode(this.key);
    return hash;
  }

  @Override
  public boolean equals(Object obj) {
    if (this == obj) {
      return true;
    }
    if (obj == null) {
      return false;
    }
    if (getClass() != obj.getClass()) {
      return false;
    }
    final CustomKey other = (CustomKey) obj;
    return Objects.equals(this.key, other.key);
  }

  @Override
  public String toString() {
    return key;
  }
}
