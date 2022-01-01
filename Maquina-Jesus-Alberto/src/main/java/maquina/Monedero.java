/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package maquina;

import java.util.logging.Logger;

/**
 *
 * @author GR6
 */
public class Monedero {

    //Contadores de monedas
    private int contadorMonedasUnEuro;
    private int contadorMonedasDosEuros;
    private int contadorMonedasUnCentimo;
    private int contadorMonedasDosCentimos;
    private int contadorMonedasCincoCentimos;
    private int contadorMonedasDiezCentimos;
    private int contadorMonedasVeinteCentimos;
    private int contadorMonedasCincuentaCentimos;
    //Contadores de billetes
    private int contadorBilletesCincoEuros;
    private int contadorBilletesDiezEuros;
    private int contadorBilletesVeinteEuros;

    //Variables que almacenan el valor de cada tipo de moneda y billete
    private final static int valorMonedasUnEuro = 1;
    private final static int valorMonedasDosEuros = 2;
    private final static double valorMonedasUnCentimo = 0.01;
    private final static double valorMonedasDosCentimos = 0.02;
    private final static double valorMonedasCincoCentimos = 0.05;
    private final static double valorMonedasDiezCentimos = 0.10;
    private final static double valorMonedasVeinteCentimos = 0.20;
    private final static double valorMonedasCincuentaCentimos = 0.50;
    private final static int valorBilletesCincoEuros = 5;
    private final static int valorBilletesDiezEuros = 10;
    private final static int valorBilletesVeinteEuros = 20;

    //Variables que alamcenaran el resultado del valor total de las monedas y billetes
    private int resultadoMonedasUnEuro;
    private int resultadoMonedasDosEuros;
    private double resultadoMonedasUnCentimo;
    private double resultadoMonedasDosCentimos;
    private double resultadoMonedasCincoCentimos;
    private double resultadoMonedasDiezCentimos;
    private double resultadoMonedasVeinteCentimos;
    private double resultadoMonedasCincuentaCentimos;
    private int resultadoBilletesCincoEuros;
    private int resultadoBilletesDiezEuros;
    private int resultadoBilletesVeinteEuros;

    public Monedero() {
    }

    //Metodo que devuelve la suma del valor total del monedero
    public double getDineroTotal() {

         double dineroTotal = this.resultadoMonedasUnEuro
                + this.resultadoMonedasDosEuros
                + this.resultadoMonedasUnCentimo
                + this.resultadoMonedasDosCentimos
                + this.resultadoMonedasCincoCentimos
                + this.resultadoMonedasDiezCentimos
                + this.resultadoMonedasVeinteCentimos
                + this.resultadoMonedasCincuentaCentimos
                + this.resultadoBilletesCincoEuros
                + this.resultadoBilletesDiezEuros
                + this.resultadoBilletesVeinteEuros;

        return dineroTotal;

    }


    //Métodos para agregar monedas
    //Se controlara que el numero de monedas y billetes introducido por parametro no sea inferior a 0
    //En el mismo metodo se calcula el valor total por cada tipo de moneda y billete
    public void addMonedaUnEuro(int monedas) {

        if (monedas < 0) {

            System.out.println("Introduce un numero de monedas positivo");

        } else {

            this.contadorMonedasUnEuro = monedas;
            resultadoMonedasUnEuro = this.contadorMonedasUnEuro * valorMonedasUnEuro;

        }

    }

    public void addMonedaDosEuros(int monedas) {

        if (monedas < 0) {

            System.out.println("Introduce un numero de monedas positivo");

        } else {

            this.contadorMonedasDosEuros = monedas;
            resultadoMonedasDosEuros = this.contadorMonedasDosEuros * valorMonedasDosEuros;
        }

    }

    public void addMonedaUnCentimo(int monedas) {

        if (monedas < 0) {

            System.out.println("Introduce un numero de monedas positivo");

        } else {

            this.contadorMonedasUnCentimo = monedas;
            resultadoMonedasUnCentimo = this.contadorMonedasUnCentimo * valorMonedasUnCentimo;
        }

    }

    public void addMonedaDosCentimos(int monedas) {

        if (monedas < 0) {

            System.out.println("Introduce un numero de monedas positivo");

        } else {

            this.contadorMonedasDosCentimos = monedas;
            resultadoMonedasDosCentimos = this.contadorMonedasDosCentimos * valorMonedasDosCentimos;
        }

    }

    public void addMonedaCincoCentimos(int monedas) {

        if (monedas < 0) {

            System.out.println("Introduce un numero de monedas positivo");

        } else {

            this.contadorMonedasCincoCentimos = monedas;
            resultadoMonedasCincoCentimos = this.contadorMonedasCincoCentimos * valorMonedasCincoCentimos;
        }

    }

    public void addMonedaDiezCentimos(int monedas) {

        if (monedas < 0) {

            System.out.println("Introduce un numero de monedas positivo");

        } else {

            this.contadorMonedasDiezCentimos = monedas;

            resultadoMonedasDiezCentimos = this.contadorMonedasDiezCentimos * valorMonedasDiezCentimos;
        }

    }

    public void addMonedaVeinteCentimos(int monedas) {

        if (monedas < 0) {

            System.out.println("Introduce un numero de monedas positivo");

        } else {

            this.contadorMonedasVeinteCentimos = monedas;

            resultadoMonedasVeinteCentimos = this.contadorMonedasVeinteCentimos * valorMonedasVeinteCentimos;
        }

    }

    public void addBilleteCincoEuros(int billetes) {

        if (billetes < 0) {

            System.out.println("Introduce un numero de billetes positivo");

        } else {

            this.contadorBilletesCincoEuros = billetes;
            resultadoBilletesCincoEuros = this.contadorBilletesCincoEuros * valorBilletesCincoEuros;
        }

    }

    public void addBilleteDiezEuros(int billetes) {

        if (billetes < 0) {

            System.out.println("Introduce un numero de billetes positivo");

        } else {

            this.contadorBilletesDiezEuros = billetes;
            resultadoBilletesDiezEuros = this.contadorBilletesDiezEuros * valorBilletesDiezEuros;
        }

    }

    public void addBilleteVeinteEuros(int billetes) {

        if (billetes < 0) {

            System.out.println("Introduce un numero de billetes positivo");

        } else {

            this.contadorBilletesVeinteEuros = billetes;
            resultadoBilletesVeinteEuros = this.contadorBilletesVeinteEuros * valorBilletesVeinteEuros;
        }

    }

    //Métodos para quitar monedas
    //A parte de controlar que el numero de monedas o billetes no sea inferior a 0, tambien se va a controlar que el resultado de la 
    //resta no sea un numero negativo
    //En el mismo metodo se calcula el valor total por cada tipo de moneda y billete
    public void removeMonedaUnEuro(int monedas) {

        if (monedas < 0) {

            System.out.println("Introduce un numero de monedas positivo");
        }

        if (monedas > this.contadorMonedasUnEuro) {

            System.out.println("La resta no puede ser negativa");

        } else {

            this.contadorMonedasUnEuro -= monedas;
            resultadoMonedasUnEuro = this.contadorMonedasUnEuro - valorMonedasUnEuro;
        }

    }

    public void removeMonedaDosEuros(int monedas) {

        if (monedas < 0) {

            System.out.println("Introduce un numero de monedas positivo");
        }

        if (monedas > this.contadorMonedasDosEuros) {

            System.out.println("La resta no puede ser negativa");

        } else {

            this.contadorMonedasDosEuros -= monedas;
            resultadoMonedasDosEuros = this.contadorMonedasDosEuros - valorMonedasDosEuros;
        }

    }

    public void removeMonedaUnCentimo(int monedas) {

        if (monedas < 0) {

            System.out.println("Introduce un numero de monedas positivo");
        }

        if (monedas > this.contadorMonedasUnCentimo) {

            System.out.println("La resta no puede ser negativa");

        } else {

            this.contadorMonedasUnCentimo -= monedas;
            resultadoMonedasUnCentimo = this.contadorMonedasUnCentimo - valorMonedasUnCentimo;
        }
    }

    public void removeMonedaDosCentimos(int monedas) {

        if (monedas < 0) {

            System.out.println("Introduce un numero de monedas positivo");
        }

        if (monedas > this.contadorMonedasDosCentimos) {

            System.out.println("La resta no puede ser negativa");

        } else {

            this.contadorMonedasDosCentimos -= monedas;
            resultadoMonedasDosCentimos = this.contadorMonedasDosCentimos - valorMonedasDosCentimos;
        }
    }

    public void removeMonedaCincoCentimos(int monedas) {

        if (monedas < 0) {

            System.out.println("Introduce un numero de monedas positivo");
        }

        if (monedas > this.contadorMonedasCincoCentimos) {

            System.out.println("La resta no puede ser negativa");

        } else {

            this.contadorMonedasCincoCentimos -= monedas;
            resultadoMonedasCincoCentimos = this.contadorMonedasCincoCentimos - valorMonedasCincoCentimos;
        }
    }

    public void removeMonedaDiezCentimos(int monedas) {

        if (monedas < 0) {

            System.out.println("Introduce un numero de monedas positivo");
        }

        if (monedas > this.contadorMonedasDiezCentimos) {

            System.out.println("La resta no puede ser negativa");

        } else {

            this.contadorMonedasDiezCentimos -= monedas;
            resultadoMonedasDiezCentimos = this.contadorMonedasDiezCentimos - valorMonedasDiezCentimos;
        }
    }

    public void removeMonedaVeinteCentimos(int monedas) {

        if (monedas < 0) {

            System.out.println("Introduce un numero de monedas positivo");
        }

        if (monedas > this.contadorMonedasVeinteCentimos) {

            System.out.println("La resta no puede ser negativa");

        } else {

            this.contadorMonedasVeinteCentimos -= monedas;
            resultadoMonedasVeinteCentimos = this.contadorMonedasVeinteCentimos - valorMonedasVeinteCentimos;
        }
    }

    public void removeBilleteCincoEuros(int billetes) {

        if (billetes < 0) {

            System.out.println("Introduce un numero de billetes positivo");
        }

        if (billetes > this.contadorBilletesCincoEuros) {

            System.out.println("La resta no puede ser negativa");

        } else {

            this.contadorBilletesCincoEuros -= billetes;
            resultadoBilletesCincoEuros = this.contadorBilletesCincoEuros - valorBilletesCincoEuros;
        }
    }

    public void removeBilleteDiezEuros(int billetes) {

        if (billetes < 0) {

            System.out.println("Introduce un numero de billetes positivo");
        }

        if (billetes > this.contadorBilletesDiezEuros) {

            System.out.println("La resta no puede ser negativa");

        } else {

            this.contadorMonedasDiezCentimos -= billetes;
            resultadoBilletesDiezEuros = this.contadorBilletesDiezEuros - valorBilletesDiezEuros;
        }

    }

    public void removeBilleteVeinteEuros(int billetes) {

        if (billetes < 0) {

            System.out.println("Introduce un numero de billetes positivo");
        }

        if (billetes > this.contadorBilletesVeinteEuros) {

            System.out.println("La resta no puede ser negativa");

        } else {

            this.contadorBilletesVeinteEuros -= billetes;
            resultadoBilletesVeinteEuros = this.contadorBilletesVeinteEuros / valorBilletesVeinteEuros;
        }

    }

    //Getters de los contadores 
    public int getContadorMonedasUnEuro() {
        return contadorMonedasUnEuro;
    }

    public int getContadorMonedasDosEuros() {
        return contadorMonedasDosEuros;
    }

    public int getContadorMonedasUnCentimo() {
        return contadorMonedasUnCentimo;
    }

    public int getContadorMonedasDosCentimos() {
        return contadorMonedasDosCentimos;
    }

    public int getContadorMonedasCincoCentimos() {
        return contadorMonedasCincoCentimos;
    }

    public int getContadorMonedasDiezCentimos() {
        return contadorMonedasDiezCentimos;
    }

    public int getContadorMonedasVeinteCentimos() {
        return contadorMonedasVeinteCentimos;
    }

    public int getContadorMonedasCincuentaCentimos() {
        return contadorMonedasCincuentaCentimos;
    }

    public int getContadorBilletesCincoEuros() {
        return contadorBilletesCincoEuros;
    }

    public int getContadorBilletesDiezEuros() {
        return contadorBilletesDiezEuros;
    }

    public int getContadorBilletesVeinteEuros() {
        return contadorBilletesVeinteEuros;
    }

    //Getters del valor de las monedas y billetes
    public int getResultadoMonedasUnEuro() {
        return resultadoMonedasUnEuro;
    }

    public int getResultadoMonedasDosEuros() {
        return resultadoMonedasDosEuros;
    }

    public double getResultadoMonedasUnCentimo() {
        return resultadoMonedasUnCentimo;
    }

    public double getResultadoMonedasDosCentimos() {
        return resultadoMonedasDosCentimos;
    }

    public double getResultadoMonedasCincoCentimos() {
        return resultadoMonedasCincoCentimos;
    }

    public double getResultadoMonedasDiezCentimos() {
        return resultadoMonedasDiezCentimos;
    }

    public double getResultadoMonedasVeinteCentimos() {
        return resultadoMonedasVeinteCentimos;
    }

    public double getResultadoMonedasCincuentaCentimos() {
        return resultadoMonedasCincuentaCentimos;
    }

    public int getResultadoBilletesCincoEuros() {
        return resultadoBilletesCincoEuros;
    }

    public int getResultadoBilletesDiezEuros() {
        return resultadoBilletesDiezEuros;
    }

    public int getResultadoBilletesVeinteEuros() {
        return resultadoBilletesVeinteEuros;
    }

    @Override
    public String toString() {
        return "Monedero{" + "contadorMonedasUnEuro=" + contadorMonedasUnEuro + ", contadorMonedasDosEuros=" + contadorMonedasDosEuros + ", contadorMonedasUnCentimo=" + contadorMonedasUnCentimo + ", contadorMonedasDosCentimos=" + contadorMonedasDosCentimos + ", contadorMonedasCincoCentimos=" + contadorMonedasCincoCentimos + ", contadorMonedasDiezCentimos=" + contadorMonedasDiezCentimos + ", contadorMonedasVeinteCentimos=" + contadorMonedasVeinteCentimos + ", contadorMonedasCincuentaCentimos=" + contadorMonedasCincuentaCentimos + ", contadorBilletesCincoEuros=" + contadorBilletesCincoEuros + ", contadorBilletesDiezEuros=" + contadorBilletesDiezEuros + ", contadorBilletesVeinteEuros=" + contadorBilletesVeinteEuros + ", resultadoMonedasUnEuro=" + resultadoMonedasUnEuro + ", resultadoMonedasDosEuros=" + resultadoMonedasDosEuros + ", resultadoMonedasUnCentimo=" + resultadoMonedasUnCentimo + ", resultadoMonedasDosCentimos=" + resultadoMonedasDosCentimos + ", resultadoMonedasCincoCentimos=" + resultadoMonedasCincoCentimos + ", resultadoMonedasDiezCentimos=" + resultadoMonedasDiezCentimos + ", resultadoMonedasVeinteCentimos=" + resultadoMonedasVeinteCentimos + ", resultadoMonedasCincuentaCentimos=" + resultadoMonedasCincuentaCentimos + ", resultadoBilletesCincoEuros=" + resultadoBilletesCincoEuros + ", resultadoBilletesDiezEuros=" + resultadoBilletesDiezEuros + ", resultadoBilletesVeinteEuros=" + resultadoBilletesVeinteEuros + '}';
    }

}
