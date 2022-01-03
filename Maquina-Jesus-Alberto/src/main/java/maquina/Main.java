package maquina;

public class Main {

    public static void main(String[] args) throws Exception {

        Monedero monedero = new Monedero();

        monedero.addMonedaUnEuro(30);

        LogsDatos.tablaMonedero(monedero); //30€

        System.out.println(monedero.getResultadoMonedasUnEuro());

        monedero.addMonedaDosEuros(2);

        LogsDatos.tablaMonedero(monedero); //34

        monedero.addMonedaDiezCentimos(4);

        LogsDatos.tablaMonedero(monedero); //34,40

        monedero.addMonedaUnCentimo(5);

        LogsDatos.tablaMonedero(monedero); //34,45

        monedero.addMonedaVeinteCentimos(1);

        LogsDatos.tablaMonedero(monedero); //34,65

        monedero.addMonedaCincuentaCentimos(1);

        LogsDatos.tablaMonedero(monedero); //35,15

        monedero.addMonedaCincoCentimos(3);

        LogsDatos.tablaMonedero(monedero); //35,30

        monedero.addBilleteCincoEuros(1);

        LogsDatos.tablaMonedero(monedero); //40,30

        monedero.addBilleteDiezEuros(3);

        LogsDatos.tablaMonedero(monedero); //70,30

        monedero.addBilleteVeinteEuros(1);

        LogsDatos.tablaMonedero(monedero); //90,30
//
////        System.out.println(monedero.getResultadoMonedasUnEuro());
////
////        monedero.removeMonedaUnEuro(23);
////
////        System.out.println(monedero.getResultadoMonedasUnEuro());
////
//        monedero.addMonedaVeinteCentimos(1);
//
//        System.out.println(monedero.getResultadoMonedasVeinteCentimos());
//
//        monedero.removeMonedaVeinteCentimos(1);
//
//        System.out.println(monedero.getResultadoMonedasVeinteCentimos());
//
//        System.out.println(monedero.getDineroTotal());
//
//        Productos primerProducto = new Productos("Manzana", 2.30, 3);
//        Productos segundoProducto = new Productos("Naranjas", 2.30, 3);
//        Productos tercerProducto = new Productos("Peras");
//        Productos cuartoProducto = new Productos("Ciruela");
//        Productos quintoProducto = new Productos("Ciruela");
//
//        Bandejas primeraBandeja = new Bandejas(new Productos[]{primerProducto, segundoProducto, tercerProducto, cuartoProducto, quintoProducto});
//
//        System.out.println(primeraBandeja);
//        System.out.println(primeraBandeja.getArrayProductos()[1].toString());
//
//        LogsDatos.tablaProductos(new Productos[]{primerProducto, segundoProducto, tercerProducto, cuartoProducto, quintoProducto});
//        LogsDatos.tablaBandejas(new Bandejas[]{primeraBandeja});
//        LogsDatos.tablaMonedero(monedero);

    }
}
