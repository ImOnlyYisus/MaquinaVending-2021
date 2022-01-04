package maquina;

public class Main {

    public static void main(String[] args) throws Exception {

        Monedero monedero = new Monedero();

        monedero.addMonedaUnEuro(30);


        System.out.println(monedero.getResultadoMonedasUnEuro());

        monedero.removeMonedaUnEuro(23);

        System.out.println(monedero.getResultadoMonedasUnEuro());

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
        Productos sextoProducto = new Productos("Ciruela");
        Productos octavoProducto = new Productos("Ciruela");

        Bandejas primeraBandeja = new Bandejas(new Productos[]{primerProducto, segundoProducto, tercerProducto, cuartoProducto, quintoProducto});
        Bandejas segundaBaneja = new Bandejas(new Productos[]{sextoProducto, octavoProducto});

        System.out.println(primeraBandeja);
        System.out.println(primeraBandeja.getArrayProductos()[1].toString());

        LogsDatos.tablaProductos(new Productos[]{primerProducto, segundoProducto, tercerProducto, cuartoProducto, quintoProducto});
        LogsDatos.tablaBandejas(new Bandejas[]{primeraBandeja});
        LogsDatos.tablaMonedero(monedero);

        Maquina maquinaEjemplo = new Maquina(new Bandejas[]{primeraBandeja, segundaBaneja});

        //IMPRIMIR TODOS LOS CODIGOS DE LA MAQUINA
        System.out.println(maquinaEjemplo.numeroProductosMaquina());
        for(int i=0; i< maquinaEjemplo.codigoProducto().length ; i++){
            System.out.println(maquinaEjemplo.codigoProducto()[i]);
        }

    }
}
