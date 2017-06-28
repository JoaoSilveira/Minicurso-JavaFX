/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Main;

import java.util.ArrayList;
import java.util.List;
import javafx.scene.canvas.GraphicsContext;

/**
 *
 * @author Malaquias
 */
public class Polyline {

    public List<Point> pontos = new ArrayList<>();

    public void draw(GraphicsContext c) {
        Point p = null;

        for (Point ponto : pontos) {
            if (p == null) {
                // pega o primeiro ponto
                p = ponto;
                continue;
            }
            
            // desenha linha com P(k) e P(k - 1)
            c.strokeLine(p.x, p.y, ponto.x, ponto.y);
            p = ponto;
        }
    }
}
