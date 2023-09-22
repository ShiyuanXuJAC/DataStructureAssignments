package com.mycompany.day09fractals;

import static com.mycompany.day09fractals.WindowType.MAIN_WINDOW;
import static com.mycompany.day09fractals.WindowType.RECTANGLE_FRACTAL;
import static com.mycompany.day09fractals.WindowType.TRIANGLE_FRACTAL_CENTER;
import static com.mycompany.day09fractals.WindowType.TRIANGLE_FRACTAL_VERTEX;
import java.awt.BorderLayout;
import java.awt.Canvas;
import java.awt.Graphics;
import javax.swing.JFrame;

enum WindowType {
    MAIN_WINDOW,
    TRIANGLE_FRACTAL_CENTER,
    TRIANGLE_FRACTAL_VERTEX,
    RECTANGLE_FRACTAL
}

public class AppWindow extends JFrame {


private WindowType windowType;
//private Fractal fractal;

  public static void main(String[] args) {
    AppWindow mainWindow = new AppWindow(WindowType.MAIN_WINDOW);
    AppWindow triangleCenterWindow = new AppWindow(WindowType.TRIANGLE_FRACTAL_CENTER);
    AppWindow triangleVertexWindow = new AppWindow(WindowType.TRIANGLE_FRACTAL_VERTEX);
    AppWindow rectangleWindow = new AppWindow(WindowType.RECTANGLE_FRACTAL);

  }

  public AppWindow(WindowType windowType) {
    setLayout(new BorderLayout());
    setSize(500, 375);


    switch (windowType) {
      case MAIN_WINDOW -> {
        setTitle("Main Window");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      }
      case TRIANGLE_FRACTAL_CENTER -> {
        setTitle("Draw Triangle Fractal(center)");
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
      }
      case TRIANGLE_FRACTAL_VERTEX -> {
        setTitle("Draw Triangle Fractal(vertexes)");
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
      }
      case RECTANGLE_FRACTAL -> {
        setTitle("Draw Rectangle Fractal(cross)");
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
      }
      default ->
        throw new Error("Illegel Window Type");
    }
    
    DrawingArea drawingArea = new DrawingArea(windowType);
    add("Center", drawingArea);


    setLocationRelativeTo(null); // center on screen
    setVisible(true);

  }

  private class DrawingArea extends Canvas {
    private Fractal fractal;
    private final WindowType windowType;

    public DrawingArea(WindowType windowType) {
      this.windowType = windowType;

    }
    @Override
    public void paint(Graphics g) {
      switch (windowType) {
        case MAIN_WINDOW -> {
          return;
        }
        case TRIANGLE_FRACTAL_CENTER -> {
          fractal = new TriangleFractalCenter();
          Shape shape = new Triangle(new Point(5, getHeight() - 5), new Point(getWidth() - 5, getHeight() - 5), new Point(getWidth() / 2, 5));
          fractal.setShape(shape);
        }
        case TRIANGLE_FRACTAL_VERTEX -> {
          fractal = new TriangleFractalVertex();
          Shape shape = new Triangle(new Point(5, getHeight() - 5), new Point(getWidth() - 5, getHeight() - 5), new Point(getWidth() / 2, 5));
          fractal.setShape(shape);
        }
        case RECTANGLE_FRACTAL -> {
          fractal = new RectangleFractal();
          Shape shape = new Rectangle(new Point(5, 5), getWidth() - 10, getHeight() - 10);
          fractal.setShape(shape);
        }
        default ->
          throw new AssertionError();
      }

      fractal.drawFractal(g);
      
  }


}
}
