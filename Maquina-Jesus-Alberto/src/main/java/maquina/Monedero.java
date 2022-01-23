/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package maquina;

import java.time.LocalDate;
import static java.time.LocalDate.now;
import java.util.Arrays;

/**
 *
 * @author GR6
 */
public class Monedero {

    //Array de int para contar cuantas monedas y billetes hay de cada tipo
    private int dineroContadores[] = {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
    //Array de int que determina el valor de cada tipo de monedas y billetes
    private int dineroValores[] = {1, 2, 5, 10, 20, 50, 100, 200, 500, 1000, 2000};

    //Objetos tipo LocalDate inicializados a null y que recogeran la fecha determinada de la recaudacion y del añadido de monedas y billetes
    private LocalDate fechaRecaudarMonedas = null;
    private LocalDate fechaAddMonedas = null;

    //Constructor por defecto
    public Monedero() {
    }

    //Metodo que devuelve la suma del valor total del monedero
    public double getDineroTotal() {

        int dineroTotal = 0;
        for (int i = 0; i < this.dineroContadores.length; i++) {

            dineroTotal += this.dineroContadores[i] * this.dineroValores[i];
        }

        return (dineroTotal / 100.00);

    }

    //Metodo para agregar monedas
    //Se controlara que el numero de monedas y billetes introducido por parametro no sea inferior a 0
    //En el mismo metodo se calcula el valor total por cada tipo de moneda y billete
    public void addMonedas(int indice, int numeroMonedas) {
        if (numeroMonedas > 0) {
            if (!(indice > dineroContadores.length - 1)) {
                dineroContadores[indice] += numeroMonedas;
            }
        }
    }

    //Metodo para quitar monedas
    //Se controla que el numero de monedas o billetes no sea inferior a 0
    //En el mismo metodo se calcula el valor total por cada tipo de moneda y billete
    public void removeMonedas(int indice, int numeroMonedas) {
        if (numeroMonedas > 0) {
            dineroContadores[indice] -= numeroMonedas;
        }
    }

    //Metodo que tiene la maquina para devolver el cambio, devuelve la cantidad de dinero a devolver, se le pasa un entero como parametro
    public String[] dineroParaDevolver(int valorParaDevolver) {
        int dineroRestante = valorParaDevolver;
        String monedasUsadas = "";
        //Se hace una copia por si no es posible devolver la cantidad exactamente
        int[] copiaContadores = Arrays.copyOf(this.dineroContadores, this.dineroContadores.length);

        //Empieza el bucle con la longitud del array de forma inversa, es decir primero los indices mayores
        for (int i = (dineroValores.length - 1); i >= 0; i--) {
            //Comprueba que si le quitas el valor de la moneda no sea menor que 0 y que haya monedas de ese tipo
            if (dineroRestante - dineroValores[i] >= 0 && dineroContadores[i] > 0) {
                dineroRestante -= dineroValores[i];
                //Quito una moneda del contador al devolverla
                dineroContadores[i]--;
                monedasUsadas += (dineroValores[i] + ",");

                //Se suma uno para que intente hacer la misma operacion con el mismo numero
                i++;

            }
        }
        //Se convierte las monedas usadas en un String array para devolverlas
        String[] monedasParaDevolver = monedasUsadas.split(",");
        //En el caso de que no se pueda dar el cambio exactamente, se devuelve en el ultimo indice un -1 indicando que no se ha podido,
        //y pongo el contador como estaba anteriormente
        if (dineroRestante > 0) {

            monedasParaDevolver[monedasParaDevolver.length - 1] = "-1";

        }
        //Devuelve los valores antiguos al contador
        this.dineroContadores = copiaContadores;
        return monedasParaDevolver;
    }

    //Metodo para recaudar dinero dejando siempre 5 monedas y billetes de cada uno
    public void recaudarDinero() {
        //Se almacena la fecha actual cuando se ejecute el metodo
        fechaRecaudarMonedas = LocalDate.now();
        for (int i = 0; i < this.dineroContadores.length; i++) {
            //Se controla que cada posicion del array dineroContadores no supere el dinero por defecto
            if (dineroContadores[i] > 5) {
                //Se controla que que si el resultado de la resta es negativo sea positivo
                this.dineroContadores[i] = Math.abs(this.dineroContadores[i] - (this.dineroContadores[i] + 5));
            }
        }
    }

    //Metodo para añadir monedas para el cambio, se introduce un array de int como parametro
    public void addMonedasCambio(int[] monedas) {
        //Se almacena la fecha actual cuando se ejecute el metodo
        fechaAddMonedas = LocalDate.now();
        //Se hace uso del metodo addMonedas(int indice, int numeroMonedas) para añadir las monedas al array
        for (int i = 0; i < monedas.length; i++) {
            addMonedas(i, monedas[i]);
        }

    }

    //Getters 
    public int[] getDineroContadores() {
        return dineroContadores;
    }

    public int[] getDineroValores() {
        return dineroValores;
    }

    public int getContadorMonedasUnCentimo() {
        return this.dineroContadores[0];
    }

    public int getContadorMonedasDosCentimos() {
        return this.dineroContadores[1];
    }

    public int getContadorMonedasCincoCentimos() {
        return this.dineroContadores[2];
    }

    public int getContadorMonedasDiezCentimos() {
        return this.dineroContadores[3];
    }

    public int getContadorMonedasVeinteCentimos() {
        return this.dineroContadores[4];
    }

    public int getContadorMonedasCincuentaCentimos() {
        return this.dineroContadores[5];
    }

    public int getContadorMonedasUnEuro() {
        return this.dineroContadores[6];
    }

    public int getContadorMonedasDosEuros() {
        return this.dineroContadores[7];
    }

    public int getContadorBilletesCincoEuros() {
        return this.dineroContadores[8];
    }

    public int getContadorBilletesDiezEuros() {
        return this.dineroContadores[9];
    }

    public int getContadorBilletesVeinteEuros() {
        return this.dineroContadores[10];
    }

    public LocalDate getFechaRecaudarMonedas() {
        return fechaRecaudarMonedas;
    }

    public LocalDate getFechaAddMonedas() {
        return fechaAddMonedas;
    }

    //toString
    @Override
    public String toString() {
        return "Monedero{" + "dineroContadores=" + dineroContadores + ", dineroValores=" + dineroValores + '}';
    }

}
