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

    public Monedero(int contadorMonedasUnEuro, int contadorMonedasDosEuros, int contadorMonedasUnCentimo, int contadorMonedasDosCentimos, int contadorMonedasCincoCentimos, int contadorMonedasDiezCentimos, int contadorMonedasVeinteCentimos, int contadorMonedasCincuentaCentimos, int contadorBilletesCincoEuros, int contadorBilletesDiezEuros, int contadorBilletesVeinteEuros) {
        this.contadorMonedasUnEuro = contadorMonedasUnEuro;
        this.contadorMonedasDosEuros = contadorMonedasDosEuros;
        this.contadorMonedasUnCentimo = contadorMonedasUnCentimo;
        this.contadorMonedasDosCentimos = contadorMonedasDosCentimos;
        this.contadorMonedasCincoCentimos = contadorMonedasCincoCentimos;
        this.contadorMonedasDiezCentimos = contadorMonedasDiezCentimos;
        this.contadorMonedasVeinteCentimos = contadorMonedasVeinteCentimos;
        this.contadorMonedasCincuentaCentimos = contadorMonedasCincuentaCentimos;
        this.contadorBilletesCincoEuros = contadorBilletesCincoEuros;
        this.contadorBilletesDiezEuros = contadorBilletesDiezEuros;
        this.contadorBilletesVeinteEuros = contadorBilletesVeinteEuros;
    }

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
    public void addMonedaUnEuro(int monedas) {

        this.contadorMonedasUnEuro = monedas;
    }

    public void addMonedaDosEuros(int monedas) {

       
        this.contadorMonedasDosEuros = monedas;
    }

    public void addMonedaUnCentimo(int monedas) {

       
        this.contadorMonedasUnCentimo = monedas;
    }

    public void addMonedaDosCentimos(int monedas) {

       
        this.contadorMonedasDosCentimos = monedas;
    }

    public void addMonedaCincoCentimos(int monedas) {

     
        this.contadorMonedasCincoCentimos = monedas;
    }

    public void addMonedaDiezCentimos(int monedas) {

        this.contadorMonedasDiezCentimos = monedas;
    }

    public void addMonedaVeinteCentimos(int monedas) {

        this.contadorMonedasVeinteCentimos = monedas;
    }

    public void addBilleteCincoEuros(int billetes) {

        this.contadorBilletesCincoEuros = billetes;

    }

    public void addBilleteDiezEuros(int billetes) {

        this.contadorBilletesDiezEuros = billetes;

    }

    public void addBilleteVeinteEuros(int billetes) {

        this.contadorBilletesVeinteEuros = billetes;

    }

    //Métodos para quitar monedas
    public void removeMonedaUnEuro(int monedas) {

        this.contadorMonedasUnEuro -= monedas;
    }

    public void removeMonedaDosEuros(int monedas) {

        this.contadorMonedasDosEuros -= monedas;
    }

    public void removeMonedaUnCentimo(int monedas) {

        this.contadorMonedasUnCentimo -= monedas;
    }

    public void removeMonedaDosCentimos(int monedas) {

        this.contadorMonedasDosCentimos -= monedas;
    }

    public void removeMonedaCincoCentimos(int monedas) {

        this.contadorMonedasCincoCentimos -= monedas;
    }

    public void removeMonedaDiezCentimos(int monedas) {

        this.contadorMonedasDiezCentimos -= monedas;
    }

    public void removeMonedaVeinteCentimos(int monedas) {

        this.contadorMonedasVeinteCentimos -= monedas;
    }

    public void removeBilleteCincoEuros(int billetes) {

        this.contadorBilletesCincoEuros -= billetes;

    }

    public void removeBilleteDiezEuros(int billetes) {

        this.contadorBilletesDiezEuros -= billetes;

    }

    public void removeBilleteVeinteEuros(int billetes) {

        this.contadorBilletesVeinteEuros -= billetes;

    }

    //Getters y setters
    public int getContadorMonedasUnEuro() {
        return contadorMonedasUnEuro;
    }

    public void setContadorMonedasUnEuro(int contadorMonedasUnEuro) {
        this.contadorMonedasUnEuro = contadorMonedasUnEuro;
    }

    public int getContadorMonedasDosEuros() {
        return contadorMonedasDosEuros;
    }

    public void setContadorMonedasDosEuros(int contadorMonedasDosEuros) {
        this.contadorMonedasDosEuros = contadorMonedasDosEuros;
    }

    public int getContadorMonedasUnCentimo() {
        return contadorMonedasUnCentimo;
    }

    public void setContadorMonedasUnCentimo(int contadorMonedasUnCentimo) {
        this.contadorMonedasUnCentimo = contadorMonedasUnCentimo;
    }

    public int getContadorMonedasDosCentimos() {
        return contadorMonedasDosCentimos;
    }

    public void setContadorMonedasDosCentimos(int contadorMonedasDosCentimos) {
        this.contadorMonedasDosCentimos = contadorMonedasDosCentimos;
    }

    public int getContadorMonedasCincoCentimos() {
        return contadorMonedasCincoCentimos;
    }

    public void setContadorMonedasCincoCentimos(int contadorMonedasCincoCentimos) {
        this.contadorMonedasCincoCentimos = contadorMonedasCincoCentimos;
    }

    public int getContadorMonedasDiezCentimos() {
        return contadorMonedasDiezCentimos;
    }

    public void setContadorMonedasDiezCentimos(int contadorMonedasDiezCentimos) {
        this.contadorMonedasDiezCentimos = contadorMonedasDiezCentimos;
    }

    public int getContadorMonedasVeinteCentimos() {
        return contadorMonedasVeinteCentimos;
    }

    public void setContadorMonedasVeinteCentimos(int contadorMonedasVeinteCentimos) {
        this.contadorMonedasVeinteCentimos = contadorMonedasVeinteCentimos;
    }

    public int getContadorMonedasCincuentaCentimos() {
        return contadorMonedasCincuentaCentimos;
    }

    public void setContadorMonedasCincuentaCentimos(int contadorMonedasCincuentaCentimos) {
        this.contadorMonedasCincuentaCentimos = contadorMonedasCincuentaCentimos;
    }

    public int getContadorBilletesCincoEuros() {
        return contadorBilletesCincoEuros;
    }

    public void setContadorBilletesCincoEuros(int contadorBilletesCincoEuros) {
        this.contadorBilletesCincoEuros = contadorBilletesCincoEuros;
    }

    public int getContadorBilletesDiezEuros() {
        return contadorBilletesDiezEuros;
    }

    public void setContadorBilletesDiezEuros(int contadorBilletesDiezEuros) {
        this.contadorBilletesDiezEuros = contadorBilletesDiezEuros;
    }

    public int getContadorBilletesVeinteEuros() {
        return contadorBilletesVeinteEuros;
    }

    public void setContadorBilletesVeinteEuros(int contadorBilletesVeinteEuros) {
        this.contadorBilletesVeinteEuros = contadorBilletesVeinteEuros;
    }

    @Override
    public String toString() {
        return "Monedero{" + "contadorMonedasUnEuro=" + contadorMonedasUnEuro + ", contadorMonedasDosEuros=" + contadorMonedasDosEuros + ", contadorMonedasUnCentimo=" + contadorMonedasUnCentimo + ", contadorMonedasDosCentimos=" + contadorMonedasDosCentimos + ", contadorMonedasCincoCentimos=" + contadorMonedasCincoCentimos + ", contadorMonedasDiezCentimos=" + contadorMonedasDiezCentimos + ", contadorMonedasVeinteCentimos=" + contadorMonedasVeinteCentimos + ", contadorMonedasCincuentaCentimos=" + contadorMonedasCincuentaCentimos + ", contadorBilletesCincoEuros=" + contadorBilletesCincoEuros + ", contadorBilletesDiezEuros=" + contadorBilletesDiezEuros + ", contadorBilletesVeinteEuros=" + contadorBilletesVeinteEuros + '}';
    }
   
    
}
