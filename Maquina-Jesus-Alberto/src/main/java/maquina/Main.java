package maquina;

public class Main {

    public static void main(String[] args) throws Exception {

        Monedero monedero = new Monedero();

        monedero.addMonedaUnEuro(30);

//        System.out.println(monedero.getResultadoMonedasUnEuro());
//
//        monedero.removeMonedaUnEuro(23);
//
//        System.out.println(monedero.getResultadoMonedasUnEuro());
//
        monedero.addMonedaVeinteCentimos(1);

        System.out.println(monedero.getResultadoMonedasVeinteCentimos());

        monedero.removeMonedaVeinteCentimos(1);

        System.out.println(monedero.getResultadoMonedasVeinteCentimos());

        System.out.println(monedero.getDineroTotal());

        Productos primerProducto = new Productos("Manzana", 2.30, 3);
        Productos segundoProducto = new Productos("Naranjas", 2.30, 3);
        Productos tercerProducto = new Productos("Peras");
        Productos cuartoProducto = new Productos("Ciruela");
        Productos quintoProducto = new Productos("Ciruela");

        Bandejas primeraBandeja = new Bandejas(new Productos[]{primerProducto, segundoProducto, tercerProducto, cuartoProducto, quintoProducto});

        System.out.println(primeraBandeja);
        System.out.println(primeraBandeja.getArrayProductos()[1].toString());

        LogsDatos.tablaProductos(new Productos[]{primerProducto, segundoProducto, tercerProducto, cuartoProducto, quintoProducto});
        LogsDatos.tablaBandejas(new Bandejas[]{primeraBandeja});
        LogsDatos.tablaMonedero(monedero);

    }
}
