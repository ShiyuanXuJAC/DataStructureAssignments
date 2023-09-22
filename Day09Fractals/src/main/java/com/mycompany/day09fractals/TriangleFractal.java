package com.mycompany.day09fractals;

import java.awt.Graphics;

public abstract class TriangleFractal extends Fractal {

//  protected Triangle triangle;
  @Override
  public abstract void drawFractal(Graphics g);

  @Override
  public boolean setShape(Shape shape) {
    if (shape instanceof Triangle) {
      this.shape = shape;
      return true;
    }
    return false;
  }
}
