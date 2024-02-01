package Feedback.feedback2;


public class Suma extends Thread{
    //Atributos
    private int numero;
    private double resultado;

    //Constructor
    /**
     * Constructor de la clase Suma
     * @param numero atributo que indica el numero desde el que se calculará el sumatorio
     */
    public Suma(int numero) {
        this.numero = numero;
    }

    //Getter y Setters
    public int getNumero() {
        return numero;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }

    public double getResultado() {
        return resultado;
    }

    public void setResultado(double resultado) {
        this.resultado = resultado;
    }

    //Métodos

    /**
     * Método estático que devuelve el sumatorio de un número variable de parámetros
     * @param totales números que componen el sumatorio
     * @return sumatorio de los parámetros
     */
    public static double getTotales(double... totales) {
        double sumaTotales = 0.0;
        for(double total: totales){
            sumaTotales += total;
        }
        return sumaTotales;
    }

    /**
     * Método estático que devuelve la media aritmética de un número de parámetros variable dado
     * @param numParametros numero de parámetros que se pasan
     * @param totales parámetros que compone el sumatorio
     * @return media aritmética de los sumatorios de los parámetros entre el número total de ellos
     */
    public static double media(int numParametros, double... totales){
        double media = 0.0;
        double sumaTotales = 0.0;
        for(double total: totales){
            sumaTotales += total;
            media += total / numParametros;
        }
        return media;
    }

    /**
     * Método que genera una cadena formateada
     * @return cadena formateada compuesta por getters de la instancia
     */
    @Override
    public String toString() {
        return String.format("Suma %-10d %10.0f",getNumero(),getResultado());
    }

    /**
     * Método para iterar sobre un número variable de cadenas y darle salida por pantalla
     * @param strings parámetro variable de tipo String
     */
    public static void format(String... strings){
        for(String cadena: strings){
            System.out.println(cadena);
        }
    }

    /**
     * Método que sobreescribe el método run() que implementa la interfaz Runnable
     * calcula el sumatorio de los n números pasados como atributo de la instancia
     * de la clase Suma creada
     */
    public void run(){
        for(int i = numero; i> 0; i--){
            resultado += i;
        }
    }
}
