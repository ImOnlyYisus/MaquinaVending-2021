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
}
