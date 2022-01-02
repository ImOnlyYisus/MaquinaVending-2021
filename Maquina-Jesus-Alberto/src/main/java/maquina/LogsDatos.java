package maquina;

public class LogsDatos {

    //METODO PARA MOSTRAR TODOS LOS DATOS DE LOS PRODUCTOS EN UNA TABLA
    public static void tablaProductos(Productos[] arrayProductos){
        String formatoTabla = "│ %-15s │ %-12s │ %-6.2f │ %-5d │%n";

        System.out.format("┌─────────────────────────────────────────────────┐%n");
        System.out.format("│                     PRODUCTOS                   │%n");
        System.out.format("├─────────────────┬──────────────┬────────┬───────┤%n");
        System.out.format("│ NOMBRE PRODUCTO │ COD PRODUCTO │ PRECIO │ STOCK │%n");
        System.out.format("├─────────────────┼──────────────┼────────┼───────┤%n");

        for (int i = 0; i < arrayProductos.length; i++) {
            System.out.format(formatoTabla, arrayProductos[i].getNombreProducto(), arrayProductos[i].getCodProducto(), arrayProductos[i].getPrecio(), arrayProductos[i].getStock());
        }

        System.out.format("└─────────────────┴──────────────┴────────┴───────┘%n");
    }

    //METODO PARA MOSTRAR TODOS LOS DATOS DE LOS BANDEJAS EN UNA TABLA
    public static void tablaBandejas(Bandejas[] arrayBandejas){
        String formatoTabla = "│ %-11s │ %-12s │ %-15s │%n";

        System.out.format("┌──────────────────────────────────────────────┐%n");
        System.out.format("│                    BANDEJAS                  │%n");
        System.out.format("├─────────────┬──────────────┬─────────────────┤%n");
        System.out.format("│ COD BANDEJA │ COD PRODUCTO │ NOMBRE PRODUCTO │%n");
        System.out.format("├─────────────┼──────────────┼─────────────────┤%n");


        for (int i = 0; i < arrayBandejas.length; i++) {
            for(int z = 0; z < arrayBandejas[i].getArrayProductos().length; z++) {
                System.out.format(formatoTabla, arrayBandejas[i].getCodBandeja(), arrayBandejas[i].getArrayProductos()[z].getCodProducto(), arrayBandejas[i].getArrayProductos()[z].getNombreProducto());
            }
        }

        System.out.format("└─────────────┴──────────────┴─────────────────┘%n");
    }

    //METODO QUE MUESTRA TODOS LOS DATOS IMPORTANTES DE EL MONEDERO
    public static void tablaMonedero(Monedero monedero){
        String formatoTabla = "│ %-13d │ %-13d │ %-13d │ %-13d │ %-13d │ %-13d │ %-13d │ %-13d │ %-14d │ %-14d │%n";

        System.out.format("┌─────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────┐%n");
        System.out.format("│                                                                                    MONEDERO                                                                     │%n");
        System.out.format("├───────────────┬───────────────┬───────────────┬───────────────┬───────────────┬───────────────┬───────────────┬───────────────┬────────────────┬────────────────┤%n");
        System.out.format("│ MONEDAS 0.01€ │ MONEDAS 0.05€ │ MONEDAS 0.10€ │ MONEDAS 0.20€ │ MONEDAS 0.50€ │ MONEDAS 1.00€ │ MONEDAS 2.00€ │ BILLETE 5.00€ │ BILLETE 10.00€ │ BILLETE 20.00€ │%n");
        System.out.format("├───────────────┼───────────────┼───────────────┼───────────────┼───────────────┼───────────────┼───────────────┼───────────────┼────────────────┼────────────────┤%n");

        System.out.format(formatoTabla,
                monedero.getContadorMonedasUnCentimo(),
                monedero.getContadorMonedasDosCentimos(),
                monedero.getContadorMonedasDiezCentimos(),
                monedero.getContadorMonedasVeinteCentimos(),
                monedero.getContadorMonedasCincuentaCentimos(),
                monedero.getContadorMonedasUnEuro(),
                monedero.getContadorMonedasDosEuros(),
                monedero.getContadorBilletesCincoEuros(),
                monedero.getContadorBilletesDiezEuros(),
                monedero.getContadorBilletesVeinteEuros()
        );

        System.out.format("├───────────────┴───────────────┴───────────────┴───────────────┴───────────────┴───────────────┴───────────────┴───────────────┴────────────────┴────────────────├%n");

        formatoTabla = "│ %-11.2f                                                                                                                                                     │%n";
        System.out.format("│ DINERO TOTAL                                                                                                                                                    │%n");
        System.out.format("├─────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────┤%n");

        System.out.format(formatoTabla, monedero.getDineroTotal());
        System.out.format("└─────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────┘%n");
    }
}
