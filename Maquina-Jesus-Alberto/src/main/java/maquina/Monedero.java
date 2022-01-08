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
        for (int i = 0; this.dineroContadores.length < 10; i++) {

            dineroTotal = i;
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
            this.dineroContadores[6] *= this.dineroValores[6];

        }

    }

    public void addMonedaDosEuros(int monedas) {

        if (monedas < 0) {

            System.out.println("Introduce un numero de monedas positivo");

        } else {

            this.dineroContadores[7] += monedas;
            this.dineroContadores[7] *= this.dineroValores[7];
        }

    }

    public void addMonedaUnCentimo(int monedas) {

        if (monedas < 0) {

            System.out.println("Introduce un numero de monedas positivo");

        } else {

            this.dineroContadores[0] += monedas;
            this.dineroContadores[0] *= this.dineroValores[0];
        }

    }

    public void addMonedaDosCentimos(int monedas) {

        if (monedas < 0) {

            System.out.println("Introduce un numero de monedas positivo");

        } else {

            this.dineroContadores[1] += monedas;
            this.dineroContadores[1] *= this.dineroValores[1];
        }

    }

    public void addMonedaCincoCentimos(int monedas) {

        if (monedas < 0) {

            System.out.println("Introduce un numero de monedas positivo");

        } else {

            this.dineroContadores[2] += monedas;
            this.dineroContadores[2] *= this.dineroValores[2];
        }

    }

    public void addMonedaDiezCentimos(int monedas) {

        if (monedas < 0) {

            System.out.println("Introduce un numero de monedas positivo");

        } else {

            this.dineroContadores[3] += monedas;
            this.dineroContadores[3] *= this.dineroValores[3];
        }

    }

    public void addMonedaVeinteCentimos(int monedas) {

        if (monedas < 0) {

            System.out.println("Introduce un numero de monedas positivo");

        } else {

            this.dineroContadores[4] += monedas;
            this.dineroContadores[4] *= this.dineroValores[4];
        }

    }

    public void addMonedaCincuentaCentimos(int monedas) {

        if (monedas < 0) {

            System.out.println("Introduce un numero de monedas positivo");

        } else {

            this.dineroContadores[5] += monedas;
            this.dineroContadores[5] *= this.dineroValores[5];
        }

    }

    public void addBilleteCincoEuros(int billetes) {

        if (billetes < 0) {

            System.out.println("Introduce un numero de billetes positivo");

        } else {

            this.dineroContadores[8] += billetes;
            this.dineroContadores[8] *= this.dineroValores[8];
        }

    }

    public void addBilleteDiezEuros(int billetes) {

        if (billetes < 0) {

            System.out.println("Introduce un numero de billetes positivo");

        } else {

            this.dineroContadores[9] += billetes;
            this.dineroContadores[9] *= this.dineroValores[9];
        }

    }

    public void addBilleteVeinteEuros(int billetes) {

        if (billetes < 0) {

            System.out.println("Introduce un numero de billetes positivo");

        } else {

            this.dineroContadores[10] += billetes;
            this.dineroContadores[10] *= this.dineroValores[10];
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
            this.dineroContadores[6] *= this.dineroValores[6];
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
            this.dineroContadores[7] *= this.dineroValores[7];
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
            this.dineroContadores[0] *= this.dineroValores[0];
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
            this.dineroContadores[1] *= this.dineroValores[1];
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
            this.dineroContadores[2] *= this.dineroValores[2];
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
            this.dineroContadores[3] *= this.dineroValores[3];
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
            this.dineroContadores[4] *= this.dineroValores[4];
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
            this.dineroContadores[5] *= this.dineroValores[5];
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
            this.dineroContadores[8] *= this.dineroValores[8];
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
            this.dineroContadores[9] *= this.dineroValores[9];
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
            this.dineroContadores[10] *= this.dineroValores[10];
        }

    }

    //Metodo para recaudar dinero dejando siempre 10 monedas y 2 billetes de cada
    public void recaudarDinero() {
        if (this.dineroContadores[8] > 2) {
            this.dineroContadores[8] = Math.abs(this.dineroContadores[8] - (this.dineroContadores[8] + 2));
            this.dineroContadores[8] *= this.dineroValores[8];
        }
        if (this.dineroContadores[9] > 2) {
            this.dineroContadores[9] = Math.abs(this.dineroContadores[9] - (this.dineroContadores[9] + 2));
            this.dineroContadores[9] *= this.dineroValores[9];
        }
        if (this.dineroContadores[10] > 2) {
            this.dineroContadores[10] = Math.abs(this.dineroContadores[10] - (this.dineroContadores[10] + 2));
            this.dineroContadores[10] *= this.dineroValores[10];
        }
        if (this.dineroContadores[2] > 10) {
            this.dineroContadores[2] = Math.abs(this.dineroContadores[2] - (this.dineroContadores[2] + 10));
            this.dineroContadores[2] *= this.dineroValores[2];
        }
        if (this.dineroContadores[3] > 10) {
            this.dineroContadores[3] = Math.abs(this.dineroContadores[3] - (this.dineroContadores[3] + 10));
            this.dineroContadores[3] *= this.dineroValores[3];
        }
        if (this.dineroContadores[4] > 10) {
            this.dineroContadores[4] = Math.abs(this.dineroContadores[4] - (this.dineroContadores[4] + 10));
            this.dineroContadores[4] *= this.dineroValores[4];
        }
        if (this.dineroContadores[5] > 10) {
            this.dineroContadores[5] = Math.abs(this.dineroContadores[5] - (this.dineroContadores[5] + 10));
            this.dineroContadores[5] *= this.dineroValores[5];
        }
        if (this.dineroContadores[6] > 10) {
            this.dineroContadores[6] = Math.abs(this.dineroContadores[6] - (this.dineroContadores[6] + 10));
            this.dineroContadores[6] *= this.dineroValores[6];
        }
        if (this.dineroContadores[7] > 10) {
            this.dineroContadores[7] = Math.abs(this.dineroContadores[7] - (this.dineroContadores[9] + 10));
            this.dineroContadores[7] *= this.dineroValores[7];
        }

        getDineroTotal();
    }

    //Getters 
    public int[] getDineroContadores() {
        return dineroContadores;
    }

    public double[] getDineroValores() {
        return dineroValores;
    }

    @Override
    public String toString() {
        return "Monedero{" + "dineroContadores=" + dineroContadores + ", dineroValores=" + dineroValores + '}';
    }

}
