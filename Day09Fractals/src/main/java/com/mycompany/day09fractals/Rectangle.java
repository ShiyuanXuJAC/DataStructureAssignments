package com.mycompany.day09fractals;

import java.awt.Graphics;

public class Rectangle implements Shape {

  private Point startPoint;
  private int width;
  private int height;

  public Rectangle() {
  }

  public Rectangle(Point startPoint, int width, int height) {
    this.startPoint = startPoint;
    this.width = width;
    this.height = height;
  }

  public Point getStartPoint() {
    return startPoint;
  }

  public void setStartPoint(Point startPoint) {
    this.startPoint = startPoint;
  }

  public int getWidth() {
    return width;
  }

  public void setWidth(int width) {
    this.width = width;
  }

  public int getHeight() {
    return height;
  }

  public void setHeight(int height) {
    this.height = height;
  }

  @Override
  public void drawShape(Graphics g) {
    Point p1 = new Point(startPoint.getX(), startPoint.getY() + height);
    Point p2 = new Point(startPoint.getX() + width, startPoint.getY() + height);
    Point p3 = new Point(startPoint.getX() + width, startPoint.getY());
    startPoint.drawLineTo(g, p1);
    p1.drawLineTo(g, p2);
    p2.drawLineTo(g, p3);
    p3.drawLineTo(g, startPoint);
  }
  
  public boolean crossDrawable(){
    return width>10 && height >10;
  }
  public Rectangle[] drawCross(Graphics g) {

    Point p1 = startPoint;
    Point p2 = new Point(p1.getX(), (int) (p1.getY() + height * 0.6));
    Point p3 = new Point((int) (p1.getX() + width * 0.6), (int) (p1.getY() + height * 0.6));
    Point p4 = new Point((int) (p1.getX() + width * 0.6), p1.getY());

    int newWidth = (int) (width * 0.4);
    int newHeight = (int) (height * 0.4);

    Point pn1 = new Point(p1.getX(), p1.getY() + newHeight);
    Point pn2 = new Point(p1.getX() + newWidth, p1.getY() + newHeight);
    Point pn3 = new Point(p1.getX() + newWidth, p1.getY());
    pn1.drawLineTo(g, pn2);
    pn2.drawLineTo(g, pn3);

    pn1 = new Point(p2.getX() + newWidth, p2.getY());
    pn2 = new Point(p2.getX() + newWidth, p2.getY() + newHeight);
    p2.drawLineTo(g, pn1);
    pn1.drawLineTo(g, pn2);

    pn1 = new Point(p3.getX(), p3.getY() + newHeight);
    pn2 = new Point(p3.getX() + newWidth, p3.getY());
    p3.drawLineTo(g, pn1);
    p3.drawLineTo(g, pn2);

    pn1 = new Point(p4.getX(), p4.getY() + newHeight);
    pn2 = new Point(p4.getX() + newWidth, p4.getY() + newHeight);
    p4.drawLineTo(g, pn1);
    pn1.drawLineTo(g, pn2);

    Rectangle subRect1 = new Rectangle(p1, newWidth, newHeight);
    Rectangle subRect2 = new Rectangle(p2, newWidth, newHeight);
    Rectangle subRect3 = new Rectangle(p3, newWidth, newHeight);
    Rectangle subRect4 = new Rectangle(p4, newWidth, newHeight);
    Rectangle[] subRects={subRect1,subRect2,subRect3,subRect4};
    return subRects;
    
  }

}
