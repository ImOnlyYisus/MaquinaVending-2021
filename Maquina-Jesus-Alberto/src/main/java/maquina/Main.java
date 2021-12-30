package maquina;

import jdk.swing.interop.SwingInterOpUtils;

public class Main {

    public static void main(String[] args) throws Exception {

        Monedero monedero = new Monedero();

        monedero.addMonedaUnEuro(6);

        System.out.println(monedero.getResultadoMonedasUnEuro());

        monedero.removeMonedaUnEuro(4);

        System.out.println(monedero.getResultadoMonedasUnEuro());
        
        System.out.println(monedero.getValorTotal());

        Productos primerProducto = new Productos("Manzana", 2.30, 3);
        Productos segundoProducto = new Productos("Naranjas", 2.30, 3);
        Productos tercerProducto = new Productos("Peras");
        Productos cuartoProducto = new Productos("Ciruela");
        try{
            Bandejas primeraBandeja = new Bandejas(new Productos[]{primerProducto,segundoProducto,tercerProducto,cuartoProducto});

            System.out.println(primeraBandeja);
            System.out.println(primeraBandeja.getArrayProductos()[1].toString());

        } catch (IllegalArgumentException iae){
            System.out.println("ERROR EN EL ARRAY");
        }


    }
}
