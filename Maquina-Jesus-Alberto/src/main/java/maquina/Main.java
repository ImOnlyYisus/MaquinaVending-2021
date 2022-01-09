package maquina;

import org.apache.commons.lang3.RandomStringUtils;

import javax.swing.*;
import java.time.LocalDate;

public class Main {

    public static void main(String[] args) throws Exception {
        //Objetos
        Productos[] productosPrimeraBandeja = {
                new Productos("Monster", 2.50, 10),
                new Productos("Cocacola", 2.65, 11),
                new Productos("Fanta", 2.10, 9),
                new Productos("Nestea", 2.00, 10),
                new Productos("Agua",1.65,11)
        };

        Productos[] productosSegundaBandeja ={
                new Productos("Lays Sal",3.65, 8),
                new Productos("Ruffles Jamon", 4.00, 10),
                new Productos("Lays campesinas", 3.70, 9),
                new Productos("Cheetos", 2.98, 10)
        };

        Productos[] productosTerceraBandeja ={
                new Productos("Nestle Blanco",5.6,8),
                new Productos("Nestle Negro",5.6,11),
                new Productos("Carbury Blanco",4.4,9),
                new Productos("Carbury Negro",4.4,6),
                new Productos("Jungly",6.6,8)
        };

        Productos[] productosCuartaBandeja ={
                new Productos("Manzana",2.6,10),
                new Productos("Pera",3,8),
                new Productos("Platano",2.65,9),
                new Productos("Fresas",3.4,10),
                new Productos("Naranja",2.5,7)
        };

        Productos[] productosQuintaBandeja ={
                new Productos("Manzana",2.6,6),
                new Productos("Pera",3,11),
                new Productos("Platano",2.65,9),
                new Productos("Fresas",3.4,1),
                new Productos("Naranja",2.5,1)
        };

        Productos[] productosSextaBandeja ={
                new Productos("Crema Aloe",6.5,5),
                new Productos("Crema Nivea", 4.8,4),
                new Productos("Preservativos Durex",4.2,8),
                new Productos("Jueguete femenino",15.7,4),
                new Productos("Jueguete masculino", 15.7, 4)
        };

        Bandejas[] bandejasArray = new Bandejas[6];
        try{
            bandejasArray[0] = new Bandejas(productosPrimeraBandeja);
            bandejasArray[1] = new Bandejas(productosSegundaBandeja);
            bandejasArray[2] = new Bandejas(productosTerceraBandeja);
            bandejasArray[3] = new Bandejas(productosCuartaBandeja);
            bandejasArray[4] = new Bandejas(productosQuintaBandeja);
            bandejasArray[5] = new Bandejas(productosSextaBandeja);
        }catch (IllegalArgumentException iae){
            System.out.println(iae);
        }

        Monedero monederoMaquina = new Monedero();

        Maquina maquina=null;

        try {
            maquina = new Maquina(bandejasArray, "Parking x", monederoMaquina);
        } catch (IllegalArgumentException iae) {
            System.out.println(iae);
        }

        Controlador controladorMaquina = new Controlador(maquina);


        JOptionPane.showInputDialog(null, new JTextArea(maquina.codNombreProducto()));
    }
}
