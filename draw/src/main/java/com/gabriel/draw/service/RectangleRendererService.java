package com.gabriel.draw.service;

import com.gabriel.drawfx.model.Shape;
import com.gabriel.draw.model.Rectangle;
import com.gabriel.drawfx.service.RendererService;

import java.awt.*;

public class RectangleRendererService implements RendererService {

    @Override
    public void render(Graphics g, Shape shape, boolean xor) {
        Rectangle rect = (Rectangle) shape;

        Point start = rect.getLocation();
        Point end = rect.getEnd();

        int x = Math.min(start.x, end.x);
        int y = Math.min(start.y, end.y);
        int width = Math.abs(end.x - start.x);
        int height = Math.abs(end.y - start.y);

        if (xor) {
            g.setXORMode(rect.getColor());
        } else {
            g.setColor(rect.getColor());
        }

        g.drawRect(x, y, width, height);
    }
}
