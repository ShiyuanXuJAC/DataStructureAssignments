package com.mycompany.day09fractals;

import java.awt.Graphics;

public class TriangleFractalVertex extends TriangleFractal {

  @Override
  public void drawFractal(Graphics g) {
    Triangle triangle = (Triangle) this.shape;
    if (triangle.drawable()) {
      g.setColor(ColorList.values()[0].getColor());
      triangle.drawShape(g);
      drawNextLevel(g, triangle, 1);
    }
  }
  
  private void drawNextLevel(Graphics g, Triangle previous, int level) {
    Point p12 = previous.getPoint1().halfPointTo(previous.getPoint2());
    Point p23 = previous.getPoint2().halfPointTo(previous.getPoint3());
    Point p13 = previous.getPoint3().halfPointTo(previous.getPoint1());
    
    Triangle current = new Triangle(p12, p23, p13);

    if (!current.drawable()) {
      return;
    }
    g.setColor(ColorList.values()[level % ColorList.values().length].getColor());
    current.drawShape(g);

    Triangle triangle1 = new Triangle(previous.getPoint1(), p12, p13);
    Triangle triangle2 = new Triangle(previous.getPoint2(), p12, p23);
    Triangle triangle3 = new Triangle(previous.getPoint3(), p13, p23);

    drawNextLevel(g, triangle1, level + 1);
    drawNextLevel(g, triangle2, level + 1);
    drawNextLevel(g, triangle3, level + 1);


  }

}
