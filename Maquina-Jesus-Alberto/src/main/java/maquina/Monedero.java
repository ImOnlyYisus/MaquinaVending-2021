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
    private int dineroContadores[] = {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
    private double dineroValores[] = {0.01, 0.02, 0.05, 0.10, 0.20, 0.50, 1.0, 2.0, 5.0, 10.0, 20.0};

    public Monedero() {
    }

    //Metodo que devuelve la suma del valor total del monedero
    public double getDineroTotal() {

        double dineroTotal = 0;
        for (int i = 0; i<this.dineroContadores.length; i++) {

            dineroTotal += this.dineroContadores[i]*this.dineroValores[i];
        }

        return dineroTotal;

    }

    //Metodos para agregar monedas
    //Se controlara que el numero de monedas y billetes introducido por parametro no sea inferior a 0
    //En el mismo metodo se calcula el valor total por cada tipo de moneda y billete
    public void addMonedaUnEuro(int monedas) {

        if (monedas < 0) {

            System.out.println("Introduce un numero de monedas positivo");

        } else {

            this.dineroContadores[6] += monedas;

        }

    }

    public void addMonedaDosEuros(int monedas) {

        if (monedas < 0) {

            System.out.println("Introduce un numero de monedas positivo");

        } else {

            this.dineroContadores[7] += monedas;
        }

    }

    public void addMonedaUnCentimo(int monedas) {

        if (monedas < 0) {

            System.out.println("Introduce un numero de monedas positivo");

        } else {

            this.dineroContadores[0] += monedas;
        }

    }

    public void addMonedaDosCentimos(int monedas) {

        if (monedas < 0) {

            System.out.println("Introduce un numero de monedas positivo");

        } else {

            this.dineroContadores[1] += monedas;
        }

    }

    public void addMonedaCincoCentimos(int monedas) {

        if (monedas < 0) {

            System.out.println("Introduce un numero de monedas positivo");

        } else {

            this.dineroContadores[2] += monedas;
        }

    }

    public void addMonedaDiezCentimos(int monedas) {

        if (monedas < 0) {

            System.out.println("Introduce un numero de monedas positivo");

        } else {

            this.dineroContadores[3] += monedas;
        }

    }

    public void addMonedaVeinteCentimos(int monedas) {

        if (monedas < 0) {

            System.out.println("Introduce un numero de monedas positivo");

        } else {

            this.dineroContadores[4] += monedas;
        }

    }

    public void addMonedaCincuentaCentimos(int monedas) {

        if (monedas < 0) {

            System.out.println("Introduce un numero de monedas positivo");

        } else {

            this.dineroContadores[5] += monedas;
        }

    }

    public void addBilleteCincoEuros(int billetes) {

        if (billetes < 0) {

            System.out.println("Introduce un numero de billetes positivo");

        } else {

            this.dineroContadores[8] += billetes;
        }

    }

    public void addBilleteDiezEuros(int billetes) {

        if (billetes < 0) {

            System.out.println("Introduce un numero de billetes positivo");

        } else {

            this.dineroContadores[9] += billetes;
        }

    }

    public void addBilleteVeinteEuros(int billetes) {

        if (billetes < 0) {

            System.out.println("Introduce un numero de billetes positivo");

        } else {

            this.dineroContadores[10] += billetes;
        }

    }

    //Metodos para quitar monedas
    //A parte de controlar que el numero de monedas o billetes no sea inferior a 0, tambien se va a controlar que el resultado de la 
    //resta no sea un numero negativo
    //En el mismo metodo se calcula el valor total por cada tipo de moneda y billete
    public void removeMonedaUnEuro(int monedas) {

        if (monedas < 0) {

            System.out.println("Introduce un numero de monedas positivo");
        }

        if (monedas > this.dineroValores[6]) {

            System.out.println("La resta no puede ser negativa");

        } else {
            this.dineroContadores[6] -= monedas;
        }

    }

    public void removeMonedaDosEuros(int monedas) {

        if (monedas < 0) {

            System.out.println("Introduce un numero de monedas positivo");
        }

        if (monedas > this.dineroValores[7]) {

            System.out.println("La resta no puede ser negativa");

        } else {

            this.dineroContadores[7] -= monedas;
        }

    }

    public void removeMonedaUnCentimo(int monedas) {

        if (monedas < 0) {

            System.out.println("Introduce un numero de monedas positivo");
        }

        if (monedas > this.dineroValores[0]) {

            System.out.println("La resta no puede ser negativa");

        } else {

            this.dineroContadores[0] -= monedas;
        }
    }

    public void removeMonedaDosCentimos(int monedas) {

        if (monedas < 0) {

            System.out.println("Introduce un numero de monedas positivo");
        }

        if (monedas > this.dineroValores[1]) {

            System.out.println("La resta no puede ser negativa");

        } else {

            this.dineroContadores[1] -= monedas;
        }
    }

    public void removeMonedaCincoCentimos(int monedas) {

        if (monedas < 0) {

            System.out.println("Introduce un numero de monedas positivo");
        }

        if (monedas > this.dineroValores[2]) {

            System.out.println("La resta no puede ser negativa");

        } else {

            this.dineroContadores[2] -= monedas;
        }
    }

    public void removeMonedaDiezCentimos(int monedas) {

        if (monedas < 0) {

            System.out.println("Introduce un numero de monedas positivo");
        }

        if (monedas > this.dineroValores[3]) {

            System.out.println("La resta no puede ser negativa");

        } else {

            this.dineroContadores[3] -= monedas;
        }
    }

    public void removeMonedaVeinteCentimos(int monedas) {

        if (monedas < 0) {

            System.out.println("Introduce un numero de monedas positivo");
        }

        if (monedas > this.dineroValores[4]) {

            System.out.println("La resta no puede ser negativa");

        } else {

            this.dineroContadores[4] -= monedas;
        }
    }

    public void removeMonedaCincuentaCentimos(int monedas) {

        if (monedas < 0) {

            System.out.println("Introduce un numero de monedas positivo");
        }

        if (monedas > this.dineroValores[5]) {

            System.out.println("La resta no puede ser negativa");

        } else {

            this.dineroContadores[5] -= monedas;
        }

    }

    public void removeBilleteCincoEuros(int billetes) {

        if (billetes < 0) {

            System.out.println("Introduce un numero de billetes positivo");
        }

        if (billetes > this.dineroValores[8]) {

            System.out.println("La resta no puede ser negativa");

        } else {

            this.dineroContadores[8] -= billetes;
        }
    }

    public void removeBilleteDiezEuros(int billetes) {

        if (billetes < 0) {

            System.out.println("Introduce un numero de billetes positivo");
        }

        if (billetes > this.dineroValores[9]) {

            System.out.println("La resta no puede ser negativa");

        } else {

            this.dineroContadores[9] -= billetes;
        }

    }

    public void removeBilleteVeinteEuros(int billetes) {

        if (billetes < 0) {

            System.out.println("Introduce un numero de billetes positivo");
        }

        if (billetes > this.dineroValores[10]) {

            System.out.println("La resta no puede ser negativa");

        } else {

            this.dineroContadores[10] -= billetes;
        }

    }

    //Metodo para recaudar dinero dejando siempre 5 monedas y billetes de cada uno
    public void recaudarDinero() {
        for(int i=0; i<this.dineroContadores.length;i++){
            if(dineroContadores[i]>5){
                this.dineroContadores[i] = Math.abs(this.dineroContadores[i] - (this.dineroContadores[i] + 5));
            }
        }
    }

    //Getters 
    public int[] getDineroContadores() {
        return dineroContadores;
    }

    public double[] getDineroValores() {
        return dineroValores;
    }

    public int getContadorMonedasUnCentimo(){
        return this.dineroContadores[0];
    }

    public int getContadorMonedasDosCentimos(){
        return this.dineroContadores[1];
    }

    public int getContadorMonedasCincoCentimos(){
        return this.dineroContadores[2];
    }

    public int getContadorMonedasDiezCentimos(){
        return this.dineroContadores[3];
    }

    public int getContadorMonedasVeinteCentimos(){
        return this.dineroContadores[4];
    }

    public int getContadorMonedasCincuentaCentimos(){
        return this.dineroContadores[5];
    }

    public int getContadorMonedasUnEuro(){
        return this.dineroContadores[6];
    }

    public int getContadorMonedasDosEuros(){
        return this.dineroContadores[7];
    }

    public int getContadorBilletesCincoEuros(){
        return this.dineroContadores[8];
    }

    public int getContadorBilletesDiezEuros(){
        return this.dineroContadores[9];
    }

    public int getContadorBilletesVeinteEuros(){
        return this.dineroContadores[10];
    }

    @Override
    public String toString() {
        return "Monedero{" + "dineroContadores=" + dineroContadores + ", dineroValores=" + dineroValores + '}';
    }

}
