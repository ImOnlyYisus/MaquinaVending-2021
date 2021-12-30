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

    public Monedero() {
    }

    //Metodo que devuelve la suma de todos los contadores
    public double getDineroTotal() {

        double dineroTotal = this.contadorMonedasUnEuro
                + this.contadorMonedasDosEuros
                + this.contadorMonedasUnCentimo
                + this.contadorMonedasDosCentimos
                + this.contadorMonedasCincoCentimos
                + this.contadorMonedasDiezCentimos
                + this.contadorMonedasVeinteCentimos
                + this.contadorMonedasCincuentaCentimos
                + this.contadorBilletesCincoEuros
                + this.contadorBilletesDiezEuros
                + this.contadorBilletesVeinteEuros;

        return dineroTotal;

    }

    //Métodos para agregar monedas
    //Se controlara que el numero de monedas y billetes introducido por parametro no sea inferior a 0
    public void addMonedaUnEuro(int monedas) {

        if (monedas < 0) {

            System.out.println("Introduce un numero de monedas positivo");

        } else {

            this.contadorMonedasUnEuro = monedas;
        }

    }

    public void addMonedaDosEuros(int monedas) {

        if (monedas < 0) {

            System.out.println("Introduce un numero de monedas positivo");

        } else {

            this.contadorMonedasDosEuros = monedas;
        }

    }

    public void addMonedaUnCentimo(int monedas) {

        if (monedas < 0) {

            System.out.println("Introduce un numero de monedas positivo");

        } else {

            this.contadorMonedasUnCentimo = monedas;
        }

    }

    public void addMonedaDosCentimos(int monedas) {

        if (monedas < 0) {

            System.out.println("Introduce un numero de monedas positivo");

        } else {

            this.contadorMonedasDosCentimos = monedas;
        }

    }

    public void addMonedaCincoCentimos(int monedas) {

        if (monedas < 0) {

            System.out.println("Introduce un numero de monedas positivo");

        } else {

            this.contadorMonedasCincoCentimos = monedas;
        }

    }

    public void addMonedaDiezCentimos(int monedas) {

        if (monedas < 0) {

            System.out.println("Introduce un numero de monedas positivo");

        } else {

            this.contadorMonedasDiezCentimos = monedas;
        }

    }

    public void addMonedaVeinteCentimos(int monedas) {

        if (monedas < 0) {

            System.out.println("Introduce un numero de monedas positivo");

        } else {

            this.contadorMonedasVeinteCentimos = monedas;
        }

    }

    public void addBilleteCincoEuros(int billetes) {

        if (billetes < 0) {

            System.out.println("Introduce un numero de billetes positivo");

        } else {

            this.contadorBilletesCincoEuros = billetes;
        }

    }

    public void addBilleteDiezEuros(int billetes) {

        if (billetes < 0) {

            System.out.println("Introduce un numero de billetes positivo");

        } else {

            this.contadorBilletesDiezEuros = billetes;
        }

    }

    public void addBilleteVeinteEuros(int billetes) {

        if (billetes < 0) {

            System.out.println("Introduce un numero de billetes positivo");

        } else {

            this.contadorBilletesVeinteEuros = billetes;
        }

    }

    //Métodos para quitar monedas
    //A parte de controlar que el numero de monedas o billetes no sea inferior a 0, tambien se va a controlar que el resultado de la 
    //resta no sea un numero negativo
    public void removeMonedaUnEuro(int monedas) {

        if (monedas < 0) {

            System.out.println("Introduce un numero de monedas positivo");
        }

        if (monedas > this.contadorMonedasUnEuro) {

            System.out.println("La resta no puede ser negativa");

        } else {

            this.contadorMonedasUnEuro -= monedas;
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
        }

    }

    //Getters y setters
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

    @Override
    public String toString() {
        return "Monedero{" + "contadorMonedasUnEuro=" + contadorMonedasUnEuro + ", contadorMonedasDosEuros=" + contadorMonedasDosEuros + ", contadorMonedasUnCentimo=" + contadorMonedasUnCentimo + ", contadorMonedasDosCentimos=" + contadorMonedasDosCentimos + ", contadorMonedasCincoCentimos=" + contadorMonedasCincoCentimos + ", contadorMonedasDiezCentimos=" + contadorMonedasDiezCentimos + ", contadorMonedasVeinteCentimos=" + contadorMonedasVeinteCentimos + ", contadorMonedasCincuentaCentimos=" + contadorMonedasCincuentaCentimos + ", contadorBilletesCincoEuros=" + contadorBilletesCincoEuros + ", contadorBilletesDiezEuros=" + contadorBilletesDiezEuros + ", contadorBilletesVeinteEuros=" + contadorBilletesVeinteEuros + '}';
    }

}
