package com.mycompany.day09fractals;

import java.awt.Graphics;

public class Triangle implements Shape {

  private final int MIN_SIZE = 5;

  private Point point1;
  private Point point2;
  private Point point3;

  public Triangle(Point point1, Point point2, Point point3) {
    this.point1 = point1;
    this.point2 = point2;
    this.point3 = point3;
  }

  public Point getPoint1() {
    return point1;
  }

  public void setPoint1(Point point1) {
    this.point1 = point1;
  }

  public Point getPoint2() {
    return point2;
  }

  public void setPoint2(Point point2) {
    this.point2 = point2;
  }

  public Point getPoint3() {
    return point3;
  }

  public void setPoint3(Point point3) {
    this.point3 = point3;
  }

  public boolean drawable() {
    int d1 = point1.distanceTo(point2);
    int d2 = point2.distanceTo(point3);
    int d3 = point3.distanceTo(point1);
    return (d1 > MIN_SIZE && d2 > MIN_SIZE && d3 > MIN_SIZE && d1 + d2 > d3 && d1 + d3 > d2 && d2 + d3 > d1);
  }

  @Override
  public void drawShape(Graphics g) {
    if (!drawable()) {
      return;
    }
    point1.drawLineTo(g, point2);
    point2.drawLineTo(g, point3);
    point3.drawLineTo(g, point1);
  }
}
