package maquina;

import org.apache.commons.lang3.RandomStringUtils;

import javax.swing.*;
import java.time.LocalDate;

public class Main {

    public static void main(String[] args) throws Exception {

        Monedero monedero = new Monedero();

        monedero.addMonedaUnEuro(30);



        Productos primerProducto = new Productos("Manzana", 2.30, 3);
        Productos segundoProducto = new Productos("Naranjas", 2.30, 3);
        Productos tercerProducto = new Productos("Peras", 3.00, 9);
        Productos cuartoProducto = new Productos("Ciruela", 4.50, 8);
        Productos quintoProducto = new Productos("Limon", 1.50, 6);
        Productos sextoProducto = new Productos("Chocolate",2.60, 5);
        Productos octavoProducto = new Productos("Cereza", 4, 3);

        Bandejas primeraBandeja = new Bandejas(new Productos[]{primerProducto, segundoProducto, tercerProducto, cuartoProducto, quintoProducto});
        Bandejas segundaBaneja = new Bandejas(new Productos[]{sextoProducto, octavoProducto});
        Bandejas terceraBaneja = new Bandejas(new Productos[]{sextoProducto, octavoProducto});
        Bandejas cuartaBaneja = new Bandejas(new Productos[]{sextoProducto, octavoProducto});
        Bandejas quintaBaneja = new Bandejas(new Productos[]{sextoProducto, octavoProducto});
        Bandejas sextaBaneja = new Bandejas(new Productos[]{sextoProducto, octavoProducto});

        Maquina maquinaEjemplo = new Maquina(new Bandejas[]{primeraBandeja, segundaBaneja, terceraBaneja, cuartaBaneja, quintaBaneja, sextaBaneja},"Calle x", monedero);


        Controlador controlador = new Controlador(maquinaEjemplo);
        LogsDatos.tablaMaquina(maquinaEjemplo);

        System.out.println(controlador.comprobarDineroEfectivo(33));
        LogsDatos.tablaMaquina(maquinaEjemplo);




    }
}
