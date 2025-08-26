package com.gabriel.draw.view;

import com.gabriel.draw.controller.DrawingWindowController;
import com.gabriel.drawfx.model.Drawing;
import com.gabriel.drawfx.ShapeMode;
import com.gabriel.drawfx.service.AppService;

import javax.swing.*;
import java.awt.*;

public class DrawingFrame extends JFrame {

    public DrawingFrame(AppService appService){
        DrawingWindowController drawingWindowController = new DrawingWindowController(appService);
        this.addWindowListener(drawingWindowController);
        this.addWindowFocusListener(drawingWindowController);
        this.addWindowStateListener(drawingWindowController);

        JButton lineButton = new JButton("Line");
        JButton rectButton = new JButton("Rectangle");
        JButton ellipseButton = new JButton("Ellipse");

        JPanel buttonPanel = new JPanel();
        buttonPanel.add(lineButton);
        buttonPanel.add(rectButton);
        buttonPanel.add(ellipseButton);

        DrawingView drawingView = new DrawingView(appService);

        this.setLayout(new BorderLayout());
        this.add(buttonPanel, BorderLayout.NORTH);
        this.add(drawingView, BorderLayout.CENTER);

        lineButton.addActionListener(e -> appService.setShapeMode(ShapeMode.Line));
        rectButton.addActionListener(e -> appService.setShapeMode(ShapeMode.Rectangle));
        ellipseButton.addActionListener(e -> appService.setShapeMode(ShapeMode.Ellipse));
    }
}
