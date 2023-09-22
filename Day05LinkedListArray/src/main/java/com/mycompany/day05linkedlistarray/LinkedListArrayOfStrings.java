package com.mycompany.day05linkedlistarray;

import java.util.Iterator;
import java.util.NoSuchElementException;

class LinkedListArrayOfStrings implements  Iterable<String>{

  class LinkedListIterator implements Iterator<String> {
    private Container current=start;
    @Override
    public boolean hasNext(){
      return current != null ;
    }
    @Override
    public String next(){
      if (hasNext()) {

        String value = current.value;
        current = current.next;
        return value;
      }
      throw new NoSuchElementException();
    }
  }
  @Override
    public Iterator<String> iterator() {
        return new LinkedListIterator();
    }
  
  
  
  
  private class Container {

    Container next;
    String value;

    public Container(String value) {
      this.value = value;
      this.next = null;
    }

  }

  private Container start, end;
  private int size;

  public LinkedListArrayOfStrings() {
    this.size = 0;
    this.start = null;
    this.end = null;
  }

  public void add(String value) {
    Container container = new Container(value);
    if (size == 0) {
      this.start = container;
    } else {
      this.end.next = container;
    }
    this.end = container;
    size++;
  }

  public String get(int index) {
    if (!isValidIndex(index)) {
      throw new ArrayIndexOutOfBoundsException();
    }
    Container container = getContainerByIndex(index);
    return container.value;

  }

  public void insertValueAtIndex(String value, int index) {
    if (!isValidIndex(index)) {
      throw new ArrayIndexOutOfBoundsException();
    }
    Container container = new Container(value);
    if (index == 0) {
      container.next=start;
      start=container;
    }else{
      Container beforeInsert = getContainerByIndex(index - 1);
      container.next = beforeInsert.next;
      beforeInsert.next = container;
    }
    size++;

  }

  public void replaceValueAtIndex(String value, int index) {
    if (!isValidIndex(index)) {
      throw new ArrayIndexOutOfBoundsException();
    }
    getContainerByIndex(index).value=value;

  } // put

  public void deleteByIndex(int index) {
    if (!isValidIndex(index)) {
      throw new ArrayIndexOutOfBoundsException();
    }
    if (size==1){
      start=null;
      end = null;
      size = 0;
      return;
    }
    if (index==0) {
    start=start.next;
    } else if (index == size - 1) {
      end = getContainerByIndex(index - 1);
      end.next = null;
    }else{
      Container beforeDelete = getContainerByIndex(index - 1);
      beforeDelete.next = beforeDelete.next.next;
    }
    size--;
  }
  
  public void deleteRange(int startIndex, int count) {
  if (!isValidIndex(startIndex) || !isValidIndex(startIndex+count-1)) {
      throw new ArrayIndexOutOfBoundsException();
    }
  if (startIndex==0){
    for (int i=0;i<count;i++){
      start = start.next;
    }
  } else {
    Container beforeDel = start;
    for (int i = 0; i < startIndex - 1; i++) {
      beforeDel = beforeDel.next;
    }
    for (int i = 0; i < count; i++) {
      beforeDel.next = beforeDel.next.next;
    }
    if (startIndex + count == size) {
      end = beforeDel;
    }
    }

    size -= count;
  }

  public boolean deleteByValue(String value) {

    for (int i = 0; i < size; i++) {
      if (get(i).equals(value)) {
        deleteByIndex(i);
        return true;
      }
    }
    return false;
  } // delete first value found

  public int getSize() {
    return size;
  }

  @Override
  public String toString() {
// comma-separated values list similar to: [5,8,11]
    if (size == 0) {
      return "";
    }
    StringBuilder sb=new StringBuilder();
    sb.append("[");
    Container container=start;
    for (int i=0;i<size;i++){
      sb.append(container.value).append(",");
      container=container.next;
    }
    if (sb.length() > 1) {
      sb.delete(sb.length() - 1, sb.length());
    }
    sb.append("]");
    return sb.toString();
  }

  public String[] toArray() {
    String[] array = new String[size];
    Container container = start;
    for (int i = 0; i < size; i++) {
      array[i] = container.value;
      container = container.next;
    }
    return array;

  } // could be used for Unit testing

  private boolean isValidIndex(int index) {
    return (index >= 0 && index < size);
  }

  private Container getContainerByIndex(int index) {
    if (!isValidIndex(index)) {
      return null;
    }
    Container container = this.start;
    for (int i = 0; i < index; i++) {
      container = container.next;
    }
    return container;
  }

}
