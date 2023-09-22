package com.mycompany.day09fractals;

import java.awt.Graphics;

public class TriangleFractalCenter extends TriangleFractal {

  @Override
  public void drawFractal(Graphics g) {
    drawFractalTriangleCenter(g, (Triangle) this.shape, 0);
  }

  public void drawFractalTriangleCenter(Graphics g, Triangle triangle, int level) {
    if (triangle.drawable()) {
      g.setColor(ColorList.values()[level % ColorList.values().length].getColor());
      triangle.drawShape(g);
      Point p1 = triangle.getPoint1().halfPointTo(triangle.getPoint2());
      Point p2 = triangle.getPoint2().halfPointTo(triangle.getPoint3());
      Point p3 = triangle.getPoint3().halfPointTo(triangle.getPoint1());

      Triangle next = new Triangle(p1, p2, p3);
      drawFractalTriangleCenter(g, next, level + 1);
    }

  }

}
