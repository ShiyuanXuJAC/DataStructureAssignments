package com.mycompany.day09fractals;

import java.awt.Color;
import java.awt.Graphics;

enum ColorList {
  RED("Red", Color.RED),
  BLUE("Blue", Color.BLUE),
  GREEN("Green", Color.GREEN),
  YELLOW("Yellow", Color.YELLOW),
  ORANGE("Orange", Color.ORANGE);
  private final String name;
  private final Color color;

  private ColorList(String name, Color color) {
    this.name = name;
    this.color = color;
  }

  public String getName() {
    return name;
  }

  public Color getColor() {
    return color;
  }

}
public abstract class Fractal {

  protected Shape shape;

  public abstract void drawFractal(Graphics g);

  public abstract boolean setShape(Shape shape);
}
