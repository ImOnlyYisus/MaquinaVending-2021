/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package maquina;

import javax.swing.*;

/**
 *
 * @author GR6
 */

//Main de prueba cambiando las monedas de double a int
public class Prueba2 {

    public static void main(String[] args) throws Exception {
        //Objetos
        Productos[] productosPrimeraBandeja = {
                new Productos("Monster", 250, 10),
                new Productos("Cocacola", 265, 11),
                new Productos("Fanta", 210, 9),
                new Productos("Nestea", 200, 10),
                new Productos("Agua", 165, 11)
        };

        Productos[] productosSegundaBandeja = {
                new Productos("Lays Sal", 365, 8),
                new Productos("Ruffles Jamon", 400, 10),
                new Productos("Campesinas", 370, 9),
                new Productos("Cheetos", 298, 10)
        };

        Productos[] productosTerceraBandeja = {
                new Productos("Nestle Blanco", 560, 8),
                new Productos("Nestle Negro", 560, 11),
                new Productos("Carbury Blanco", 440, 9),
                new Productos("Carbury Negro", 440, 6),
                new Productos("Jungly", 660, 8)
        };

        Productos[] productosCuartaBandeja = {
                new Productos("Manzana", 260, 10),
                new Productos("Pera", 300, 8),
                new Productos("Platano", 265, 9),
                new Productos("Fresas", 340, 10),
                new Productos("Naranja", 250, 7)
        };

        Productos[] productosQuintaBandeja = {
                new Productos("Manzana", 260, 6),
                new Productos("Pera", 300, 11),
                new Productos("Platano", 265, 9),
                new Productos("Fresas", 340, 1),
                new Productos("Naranja", 250, 1)
        };

        Productos[] productosSextaBandeja = {
                new Productos("Crema Aloe", 650, 5),
                new Productos("Crema Nivea", 480, 4),
                new Productos("Preservativos", 420, 8),
                new Productos("Satisfayer", 1570, 4),
                new Productos("SatisfayerMen", 1570, 4)
        };

        Bandejas[] bandejasArray = new Bandejas[6];
        try {
            bandejasArray[0] = new Bandejas(productosPrimeraBandeja);
            bandejasArray[1] = new Bandejas(productosSegundaBandeja);
            bandejasArray[2] = new Bandejas(productosTerceraBandeja);
            bandejasArray[3] = new Bandejas(productosCuartaBandeja);
            bandejasArray[4] = new Bandejas(productosQuintaBandeja);
            bandejasArray[5] = new Bandejas(productosSextaBandeja);
        } catch (IllegalArgumentException iae) {
            System.out.println(iae);
        }

        Monedero monederoMaquina = new Monedero();
        for (int i = 0; i <monederoMaquina.getDineroContadores().length ; i++) {
            monederoMaquina.addMonedas(i,10);
        }

        Maquina maquina = null;

        try {
            maquina = new Maquina(bandejasArray, "Parking x", monederoMaquina);
        } catch (IllegalArgumentException iae) {
            System.out.println(iae);
        }

        Controlador controladorMaquina = new Controlador(maquina);

        //PRUEBAS TODOS
//        System.out.println(monederoMaquina.getDineroTotal()); //Funciona

//        String[] dineroDevolver = monederoMaquina.dineroParaDevolver(430); //Funciona
//        for (int i = 0; i < dineroDevolver.length; i++) {
//            System.out.println(dineroDevolver[i]);
//        }

//        monederoMaquina.recaudarDinero();//Funciona

//        System.out.println(controladorMaquina.verGananciasMaquina()); //Funciona
//        controladorMaquina.recaudarDineroGanancias(); //Funciona

//        System.out.println(((double)(controladorMaquina.mostrarPrecio(maquina.codigoProducto()[1]))/100)); //Funciona

//        System.out.println(controladorMaquina.comprobarDineroEfectivo(430)); //Funciona

//        int[] devolucionMonedas = controladorMaquina.devolucionDinero(430); //Funciona
//        for (int i = 0; i <devolucionMonedas.length ; i++) {
//            System.out.println(devolucionMonedas[i]);
//        }
//        int dineroIntroducidoTotal=2000;
//        int clientePulsaBoton=250;
//        double dineroRestante= dineroIntroducidoTotal - ((double)clientePulsaBoton/100);
//        System.out.println(dineroRestante);
        Object[] monedasSeleccionar = {0.01, 0.02, 0.05, 0.10, 0.20, 0.50, 1.00, 2.00, 5.00, 10.00, 20.00};
        Object monedaCliente = JOptionPane.showInputDialog(null, "Introduce monedas, restantes",
                "Pasarela de pago", JOptionPane.QUESTION_MESSAGE, null, monedasSeleccionar, monedasSeleccionar[0]);
        System.out.println(monedaCliente.getClass());
        System.out.println(devolverIndiceMonedaUsada(monedaCliente));


    }
    private static int devolverIndiceMonedaUsada(Object dineroSeleccionado) {
        int indice = 0;
        double dineroSelect=Double.parseDouble(dineroSeleccionado.toString())*100;
        int dinero= (int)dineroSelect;
        switch (dinero) {
            case 1:
                indice = 0;
                break;
            case 2:
                indice = 1;
                break;
            case 5:
                indice = 2;
                break;
            case 10:
                indice = 3;
                break;
            case 20:
                indice = 4;
                break;
            case 50:
                indice = 5;
                break;
            case 100:
                indice = 6;
                break;
            case 200:
                indice = 7;
                break;
            case 500:
                indice = 8;
                break;
            case 1000:
                indice = 9;
                break;
            case 2000:
                indice = 10;
                break;
            default:
                indice=-1;
                break;
        }
        return indice;
    }
}
