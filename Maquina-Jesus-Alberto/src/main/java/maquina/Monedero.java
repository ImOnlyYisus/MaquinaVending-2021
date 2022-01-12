/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package maquina;

import java.util.Arrays;

/**
 *
 * @author GR6
 */
public class Monedero {

    //Contadores de monedas
    private int dineroContadores[] = {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
    //Modifico el array a int
    private int dineroValores[] = {1, 2, 5, 10, 20, 50, 100, 200, 500, 1000, 2000};

    public Monedero() {
    }

    //Metodo que devuelve la suma del valor total del monedero
    //Cambio el tipo de dato a int
    public double getDineroTotal() {

        int dineroTotal = 0;
        for (int i = 0; i<this.dineroContadores.length; i++) {

            dineroTotal += this.dineroContadores[i]*this.dineroValores[i];
        }

        return (dineroTotal/100.00);

    }

    //Metodos para agregar monedas
    //Se controlara que el numero de monedas y billetes introducido por parametro no sea inferior a 0
    //En el mismo metodo se calcula el valor total por cada tipo de moneda y billete
    public void addMonedas(int indice, int numeroMonedas){
        if(numeroMonedas>0) {
            if(!(indice>dineroContadores.length-1)) {
                dineroContadores[indice] += numeroMonedas;
            }
        }
    }

    //Metodos para quitar monedas
    //A parte de controlar que el numero de monedas o billetes no sea inferior a 0, tambien se va a controlar que el resultado de la 
    //resta no sea un numero negativo
    //En el mismo metodo se calcula el valor total por cada tipo de moneda y billete
    public void removeMonedas(int indice, int numeroMonedas){
        if(numeroMonedas>0){
            dineroContadores[indice]-=numeroMonedas;
        }
    }

    //Metodo que tiene la maquina para devolver el cambio, devuelve la cantidad de dinero a devolver
    //Cambio el tipo de dato a int
    public String[] dineroParaDevolver(int valorParaDevolver){
       //Cambio el tipo de dato a int
        int dineroRestante=valorParaDevolver;
        String monedasUsadas="";
        int[] copiaContadores= Arrays.copyOf(this.dineroContadores, this.dineroContadores.length); //Hacer una copia por si no es posible devolver la cantidad exactamente

        for(int i=(dineroValores.length-1); i>=0; i--){ //Empiezo el bucle con el la longitud del array de forma inversa, es decir primero los indices mayores
            if(dineroRestante-dineroValores[i]>=0 && dineroContadores[i]>0){// Compruebo que si le quitas el valor de la moneda no sea menor que 0 y que haya monedas de ese tipo
                dineroRestante-=dineroValores[i];
                dineroContadores[i]--;  //Quito una moneda del contador al devolverla
                monedasUsadas+=(dineroValores[i]+",");

                i++; //Para que intente hacer la misma operacion con el mismo numero

            }
        }

        String[] monedasParaDevolver=monedasUsadas.split(","); //Convierto las monedas usadas en un String array para devolverlas
        if(dineroRestante>0){//En el caso de que no se pueda dar el cambio exactamente, se devuelve en el ultimo indice un -1 indicando que no se ha podido, y pongo el contador como estaba anteriormente

            monedasParaDevolver[monedasParaDevolver.length-1]="-1";

        }
        this.dineroContadores=copiaContadores; //Devuelvo los valores antiguos al contador
        return monedasParaDevolver;
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

    public int[] getDineroValores() {
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
