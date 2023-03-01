package mainpkg;
public class Circulo {
    public double PI = 3.1416;
    public double radio;

    public Circulo() {
        radio = 0.00;
    }

    public void setRadio(double radioIn) {
        radio = radioIn;
    }

    public double getRadio() {
        return radio;
    }

    public double areaCirculo() {
        double area;
        area = PI * (radio * radio);
        return area;
    }

}