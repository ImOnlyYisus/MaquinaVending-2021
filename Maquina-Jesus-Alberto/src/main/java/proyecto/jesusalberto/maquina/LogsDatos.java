package proyecto.jesusalberto.maquina;

//Clase que se ultilizara para poder visualizar los distintos datos de las clases con formato de tablas
public class LogsDatos {

    //Método para mostrar todos los datos de los productos en una tabla
    public static void tablaProductos(Productos[] arrayProductos) {
        String formatoTabla = "│ %-15s │ %-12s │ %-6.2f │ %-5d │%n";

        System.out.format("┌─────────────────────────────────────────────────┐%n");
        System.out.format("│                     PRODUCTOS                   │%n");
        System.out.format("├─────────────────┬──────────────┬────────┬───────┤%n");
        System.out.format("│ NOMBRE PRODUCTO │ COD PRODUCTO │ PRECIO │ STOCK │%n");
        System.out.format("├─────────────────┼──────────────┼────────┼───────┤%n");

        //Se recorre el array de productos y se usa System.out.format para devolver una cadena formateada utilizando el formato especificado mostrando la tabla y los productos
        for (int i = 0; i < arrayProductos.length; i++) {
            System.out.format(formatoTabla, arrayProductos[i].getNombreProducto(), arrayProductos[i].getCodProducto(), arrayProductos[i].getPrecio(), arrayProductos[i].getStock());
        }

        System.out.format("└─────────────────┴──────────────┴────────┴───────┘%n");
    }

    //Método para mostrar todos los datos de as bandejas en una tabla
    public static void tablaBandejas(Bandejas[] arrayBandejas) {
        String formatoTabla = "│ %-11s │ %-12s │ %-22s │%n";

        System.out.format("┌────────────────────────────────────────────────────┐%n");
        System.out.format("│                    BANDEJAS                  │%n");
        System.out.format("├─────────────┬──────────────┬───────────────────────┤%n");
        System.out.format("│ COD BANDEJA │ COD PRODUCTO │    NOMBRE PRODUCTO    │%n");
        System.out.format("├─────────────┼──────────────┼───────────────────────┤%n");


        //Se utiliza un for anidado para poder recorrer el array de bandejas y productos
        for (int i = 0; i < arrayBandejas.length; i++) {
            for (int z = 0; z < arrayBandejas[i].getArrayProductos().length; z++) {
                System.out.format(formatoTabla, arrayBandejas[i].getCodBandeja(), arrayBandejas[i].getArrayProductos()[z].getCodProducto(), arrayBandejas[i].getArrayProductos()[z].getNombreProducto());
            }
        }

        System.out.format("└─────────────┴──────────────┴───────────────────────┘%n");
    }

    //Método que muestra todos los datos importantes de el monedero
    public static void tablaMonedero(Monedero monedero) {
        String formatoTabla = "│ %-13d │ %-13d │ %-13d │ %-13d │ %-13d │ %-13d │ %-13d │ %-13d │ %-14d │ %-14d │%n";

        System.out.format("┌─────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────┐%n");
        System.out.format("│                                                                                    MONEDERO                                                                     │%n");
        System.out.format("├───────────────┬───────────────┬───────────────┬───────────────┬───────────────┬───────────────┬───────────────┬───────────────┬────────────────┬────────────────┤%n");
        System.out.format("│ MONEDAS 0.01€ │ MONEDAS 0.05€ │ MONEDAS 0.10€ │ MONEDAS 0.20€ │ MONEDAS 0.50€ │ MONEDAS 1.00€ │ MONEDAS 2.00€ │ BILLETE 5.00€ │ BILLETE 10.00€ │ BILLETE 20.00€ │%n");
        System.out.format("├───────────────┼───────────────┼───────────────┼───────────────┼───────────────┼───────────────┼───────────────┼───────────────┼────────────────┼────────────────┤%n");

        //Se muestran todos los contadores de las monedas y billetes
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

        System.out.format("├───────────────┴───────────────┴───────────────┴───────────────┴───────────────┴───────────────┴───────────────┴───────────────┴────────────────┴────────────────┤%n");

        formatoTabla = "│ %-11.2f                                                                                                                                                     │%n";
        System.out.format("│ DINERO TOTAL                                                                                                                                                    │%n");
        System.out.format("├─────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────┤%n");

        //Se muestra finalmente la tabla y el dinero total del monedero
        System.out.format(formatoTabla, monedero.getDineroTotal());
        System.out.format("└─────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────┘%n");
    }

    //Método que muestra todos los datos importantes de la maquina
    public static void tablaMaquina(Maquina maquina) {
        String formatoTabla = "│ %-36s │ %-36s │ %-11d │ %-10d │%n";
        System.out.format("┌────────────────────────────────────────────────────────────────────────────────────────────────────────┐%n");
        System.out.format("│                                                   MAQUINA                                              │%n");
        System.out.format("├──────────────────────────────────────┬──────────────────────────────────────┬─────────────┬────────────┤%n");
        System.out.format("│               COD MAQUINA            │               DIRECCION              │ NºPRODUCTOS │ NºBANDEJAS │%n");
        System.out.format("├──────────────────────────────────────┼──────────────────────────────────────┼─────────────┤────────────┤%n");

        System.out.format(formatoTabla, maquina.getCODIGO_MAQUINA(), maquina.getDireccion(), maquina.numeroProductosMaquina(), maquina.numeroBandejasMaquina());
        System.out.format("├─────────────────────────────────────────────┬───────────────────────────────┴─────────────┴────────────┘%n");
        System.out.format("│ TARJETAS DE LA MAQUINA                      │%n");
        System.out.format("├──────────────────┬─────┬────────────────────┤%n");
        System.out.format("│    NºTARJETA     │ CVV │ FECHA VENCIMIENTO  │%n");
        System.out.format("├──────────────────┼─────┼────────────────────┤%n");

        formatoTabla = "│ %-16s │ %-3d │ %-18s │%n";

        //Se recorre el array de tipo LocalDate de la fecha de vencimiento para mostrar los datos de las tarjetas creadas
        for (int i = 0; i < maquina.getFechaVencimientoTarjeta().length; i++) {
            System.out.format(formatoTabla, maquina.getNumeroTarjeta()[i], maquina.getCVVTarjeta()[i], maquina.getFechaVencimientoTarjeta()[i]);
        }
        System.out.format("└──────────────────┴─────┴────────────────────┘%n");
        //Se muestan las tablas restantes
        tablaMonedero(maquina.getMonedero());
        tablaBandejas(maquina.getArrayBandejas());


    }
}
