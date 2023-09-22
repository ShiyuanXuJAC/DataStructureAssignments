package com.mycompany.day09fractals;

import java.awt.Graphics;

public class RectangleFractal extends Fractal {

//  protected Rectangle rectangle;

  @Override
  public void drawFractal(Graphics g) {
    if (shape == null) {
      return;
    }
    g.setColor(ColorList.values()[0].getColor());
    shape.drawShape(g);
    drawFractalCross(g, (Rectangle) shape, 1);
    
  }
  
  private void drawFractalCross(Graphics g, Rectangle previous, int level) {
    if (previous.crossDrawable()) {
      g.setColor(ColorList.values()[level % ColorList.values().length].getColor());
      Rectangle[] rects = previous.drawCross(g);
      for (Rectangle rect : rects) {
        drawFractalCross(g, rect, level + 1);
      }
    }
  }

  @Override
  public boolean setShape(Shape shape) {
    if (shape instanceof Rectangle) {
      this.shape = shape;
      return true;
    }
    return false;
  }

}
