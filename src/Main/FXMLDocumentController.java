/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Main;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;
import javafx.scene.input.MouseEvent;
import javafx.scene.input.KeyEvent;

/**
 *
 * @author Malaquias
 */
public class FXMLDocumentController implements Initializable {

    @FXML // annotation para o FXML poder acessar a variável
    private Canvas canvas;

    Polyline pol;
    GraphicsContext gc;
    double x1, y1, x2, y2;
    int clicks;

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        pol = new Polyline();

        // muda o evento do clique do mouse
        canvas.setOnMouseClicked(this::cliqueNoCanvas);

        clicks = 0;

        gc = canvas.getGraphicsContext2D();

        // muda a cor do contorno das formas (a linha é composta só de contorno)
        gc.setStroke(Color.BLACK);
    }

    public void carregou() {
        // muda o evento pra quando uma tecla é pressionada
        canvas.getScene().setOnKeyPressed((KeyEvent e) -> {
            // limpa o canvas e a polyline
            gc.clearRect(0, 0, canvas.getWidth(), canvas.getHeight());
            clicks = 0;

            pol.pontos.clear();
        });
    }

    private void cliqueNoCanvas(MouseEvent e) {
        clicks++;

        // cria um ponto novo com as coordenadas do mouse
        Point p = new Point(e.getX(), e.getY());

        pol.pontos.add(p);
        pol.draw(gc);
    }
}
