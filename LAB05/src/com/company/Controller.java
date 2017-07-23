package com.company;

import javafx.application.Platform;
import javafx.embed.swing.SwingFXUtils;
import javafx.fxml.FXML;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.Label;
import javafx.scene.control.ProgressBar;
import javafx.scene.control.TextField;
import javafx.scene.paint.Color;

import java.awt.geom.Point2D;
import java.awt.image.BufferedImage;
import java.util.Random;

import static com.company.Equation.calc;

public class Controller {
    @FXML
    Canvas canvas;

    @FXML
    TextField textField;

    @FXML
    ProgressBar progressBar;

    @FXML
    Label label;

    private AsyncTask task;
    private Random random;
    private Point2D singlePoint;

    @FXML
    private void handleRunBtnAction() {

        GraphicsContext gc = canvas.getGraphicsContext2D();
        drawShapes(gc);

        double a = -8;
        double b = 8;
        double c = 0;
        double d = gc.getCanvas().getHeight();

        task = new AsyncTask() {
            @Override
            public Void call() throws InterruptedException {

                random = new Random();

                double numberOfPoints = Double.parseDouble(textField.getText());
                double integralResult = 0;

                BufferedImage bi = new BufferedImage((int) gc.getCanvas().getWidth(), (int) d, BufferedImage.TYPE_INT_RGB);

                /*Point2D [] singlePoint = new Point2D[(int)numberOfPoints];
                for (Point2D s: singlePoint) {
                    s = randomPoint(a, b);
                }*/


                for (double i = 0.; i < numberOfPoints; i++) {
                    updateProgress(i, numberOfPoints);
                    singlePoint = randomPoint(a, b);
                    double x = singlePoint.getX();
                    double y = singlePoint.getY();
                    if (calc(x, y)) {
                        x = ((d - c) * (x - a) / (b - a) + c);
                        y = ((d - c) * (y - a) / (b - a) + c);
                        //gc.setFill(Color.YELLOW);
                        //gc.fillRect(x, y, 1, 1);

                        bi.setRGB((int) (x+gc.getCanvas().getWidth()/4), (int) (d - y), java.awt.Color.YELLOW.getRGB());
                        if (i % 1000 == 0)
                            gc.drawImage(SwingFXUtils.toFXImage(bi, null), 0, 0);

                        integralResult++;
                        double finalIntegralResult = integralResult;
                        Platform.runLater(new Runnable() {
                            @Override
                            public void run() {
                                label.setText("Result of integration: " + finalIntegralResult);
                            }
                        });
                    } else {
                        x = ((d - c) * (x - a) / (b - a) + c);
                        y = ((d - c) * (y - a) / (b - a) + c);
                        //gc.setFill(Color.DARKBLUE);
                        //gc.fillRect(x, y, 1, 1);

                        bi.setRGB((int) (x+gc.getCanvas().getWidth()/4), (int) (d-y), java.awt.Color.BLUE.getRGB());
                        if (i % 1000 == 0)
                            gc.drawImage(SwingFXUtils.toFXImage(bi, null), 0, 0);
                    }
                }
                return null;
            }
        };
        //gc.scale(gc.getCanvas().getWidth()/d, gc.getCanvas().getHeight()/d);
        progressBar.progressProperty().bind(task.progressProperty());
        new Thread(task).start();
    }


    @FXML
    private void handleStopBtnAction() {
        task.cancel();
    }

    private Point2D randomPoint(double min, double max) {
        return new Point2D.Double(min + (max - min) * random.nextDouble(), min + (max - min) * random.nextDouble());
    }

    private void drawShapes(GraphicsContext gc) {
        gc.setFill(Color.BLUEVIOLET);
        gc.fillRect(0, 0, gc.getCanvas().getWidth(), gc.getCanvas().getHeight());
    }
}
