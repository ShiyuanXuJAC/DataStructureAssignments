package com.mycompany.day09fractals;

import java.awt.Graphics;

public class Point {
  private int x;
  private int y;

  public Point() {
  }

  public void drawLineTo(Graphics g, Point point) {
    g.drawLine(x, y, point.getX(), point.getY());
  }

  public Point halfPointTo(Point point) {
//    return new Point((x + point.getX()) / 2, (y + point.getY()) / 2);
    return wayPointTo(point, 0.5);
  }

  public Point wayPointTo(Point point, Double multiple) {
    Point p = new Point();
    p.setX((int) (this.x + (point.getX() - x) * multiple));
    p.setY((int) (this.y + (point.getY() - y) * multiple));
    return p;

  }

  public int distanceTo(Point point) {
    return (int) Math.sqrt(Math.pow(x - point.getX(), 2) + Math.pow(y - point.getY(), 2));
  }

  public int getX() {
    return x;
  }

  public void setX(int x) {
    this.x = x;
  }

  public int getY() {
    return y;
  }

  public void setY(int y) {
    this.y = y;
  }

  public Point(int x, int y) {
    this.x = x;
    this.y = y;
  }

}
