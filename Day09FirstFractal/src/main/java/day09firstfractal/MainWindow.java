package day09firstfractal;

import java.awt.BorderLayout;
import java.awt.Canvas;
import java.awt.Graphics;
import javax.swing.JFrame;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author HP
 */
public class MainWindow extends JFrame {

  public static void main(String[] args) {
    MainWindow mainWindowsForDrawing = new MainWindow();

  }

  public MainWindow() {
    setLayout(new BorderLayout());
    setSize(500, 375);
    setTitle("First windows to draw in");
    DrawingArea drawingArea = new DrawingArea();
    add("Center", drawingArea);
    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    setLocationRelativeTo(null); // center on screen
    setVisible(true);

  }

  private class DrawingArea extends Canvas {

    @Override
    public void paint(Graphics g) {

      drawFractal(g, 10, getWidth() - 10, 0, 10);
    }
  }

  private void drawFractal(Graphics g, int fromX, int toX, int levelY, int stepY) {
    g.drawLine(fromX, (levelY + 1) * stepY, toX , (levelY + 1) * stepY);
    int nextLength = (toX - fromX) / 3;
    if (nextLength > 0) {

      drawFractal(g, fromX, fromX + nextLength, levelY + 1, stepY);
      drawFractal(g, toX - nextLength, toX, levelY + 1, stepY);
    }
  }

}
