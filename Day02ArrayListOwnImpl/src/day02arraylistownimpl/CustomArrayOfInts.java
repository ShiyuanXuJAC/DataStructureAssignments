/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package day02arraylistownimpl;
public class CustomArrayOfInts {

  private int[] data = new int[2]; // only grows by doubling size, never shrinks
  private int size = 0; // how many items do you really have

  public int size() {
    return size;
  }

  public void add(int value) {
    if (data.length <= size) {
      expandArray();
    }
    data[size++] = value;

  }
  public void deleteByIndex(int index) {
    if (index < 0 || index >= size) {
      throw new ArrayIndexOutOfBoundsException();
    }
    for (int i = index; i < size - 1; i++) {
      data[i] = data[i + 1];
    }
    size--;
  }

  public boolean deleteByValue(int value) {
// delete first value matching, true if value found, false otherwise
    for (int i = 0; i < size; i++) {
      if (data[i] == value) {
        deleteByIndex(i);
        return true;
      }
    }
    return false;
  }

  public void insertValueAtIndex(int value, int index) {
    if (index < 0 || index > size) {
      throw new ArrayIndexOutOfBoundsException();
    }
    if (data.length <= size) {
      expandArray();
    }
    for (int i = size; i > index; i--) {
      data[i] = data[i - 1];
    }
    data[index] = value;
    size++;
  }
	public void clear() {
    size = 0;
  }

  public int get(int index) {
    if (index < 0 || index >= size) {
      throw new ArrayIndexOutOfBoundsException();
    }
    return data[index];
  } // may throw ArrayIndexOutOfBoundsException

  public int[] getSlice(int startIdx, int length) {
    if (startIdx < 0 || startIdx + length > size) {
      throw new ArrayIndexOutOfBoundsException();
    }
    int[] slice = new int[length];
    for (int i = 0; i < length; i++) {
      slice[i] = data[startIdx + i];
    }
    return slice;
  }
	
	@Override
  public String toString() {
    StringBuilder sb = new StringBuilder("[");
    for (int i = 0; i < size; i++) {
      sb.append(data[i]).append(", ");
    }
    if (sb.length() > 2) {
      sb.delete(sb.length() - 2, sb.length());
    }
    sb.append("]");
    return sb.toString();
  }

  private void expandArray() {
    int[] newData = new int[data.length * 2];
    for (int i = 0; i < size; i++) {
      newData[i] = data[i];
    }
    data = newData;
  }
}
