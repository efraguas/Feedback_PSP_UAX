package Feedback.feedback3.ejercicio3;

import java.io.Serializable;

public class Rectangulo implements Serializable {
    private double area;
    private double perimetro;

    //Constructores
    public Rectangulo() {
        this.area = 0.0;
        this.perimetro = 0.0;
    }

    public Rectangulo(double area, double perimetro) {
        this.area = 0.0;
        this.perimetro = 0.0;
    }

    public double getArea() {
        return area;
    }

    public void setArea(double area) {
        this.area = area;
    }

    public double getPerimetro() {
        return perimetro;
    }

    public void setPerimetro(double perimetro) {
        this.perimetro = perimetro;
    }

    //Metodos


    @Override
    public String toString() {
        return String.format("================\nArea: %10.0f\nPerimetro: %5.0f\n================",getArea(),getPerimetro());
    }
}
