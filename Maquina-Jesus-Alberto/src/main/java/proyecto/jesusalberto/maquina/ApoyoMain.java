package proyecto.jesusalberto.maquina;

import javax.swing.*;
import java.time.LocalDate;
import java.time.format.DateTimeParseException;
import java.util.Arrays;

public class ApoyoMain {
    //--------------ADMINISTRADOR-----
    //Muestra el codigo de la bandeja con un desplegable para elegir los productos
    public static void mostrarCodigoBandeja(Maquina maquina, Controlador controladorMaquina) {
        Object productosParaSeleccionar = null; //Desplegable con productos
        productosParaSeleccionar = JOptionPane.showInputDialog(null, new JTextArea(maquina.codNombreProducto()), "Show CodBandeja", JOptionPane.QUESTION_MESSAGE, null,
                maquina.codigoProducto(), maquina.codigoProducto()[0]);
        if (productosParaSeleccionar != null) {
            JOptionPane.showMessageDialog(null, controladorMaquina.mostrarCodigoBandeja(productosParaSeleccionar.toString()));
        }
    }

    //Muestra un menu para seleccionar el codigo que queremos modificar y posteriormente nos da la opcion de introducir uno nuevo
    public static void modificarCodigoBandeja(Maquina maquina, Controlador controladorMaquina) {
        Object bandejaSeleccionar = null; //Desplegable con bandejas
        bandejaSeleccionar = JOptionPane.showInputDialog(null, new JTextArea(maquina.codNombreProducto()), "Mod CodBandeja", JOptionPane.QUESTION_MESSAGE, null,
                maquina.codBandeja(), maquina.codBandeja()[0]);

        boolean verificarLetras = true;
        do { //Verifico que el nuevo codigo sea 3 letras
            String nuevoCod = JOptionPane.showInputDialog(null, "Introduce un nuevo codigo de tres letras:", "Modificacion cod Bandeja", JOptionPane.INFORMATION_MESSAGE);
            verificarLetras = true;
            try {
                if (nuevoCod != null) { //Si el usuario no presiona x o cancelar
                    controladorMaquina.modificarCodBandeja(bandejaSeleccionar.toString(), nuevoCod);
                    JOptionPane.showMessageDialog(null, new JTextArea(maquina.codNombreProducto()), "Cambio cod Bandeja", JOptionPane.PLAIN_MESSAGE);
                }
            } catch (IllegalArgumentException iae) {
                verificarLetras = !verificarLetras;
                JOptionPane.showMessageDialog(null, "El codigo debe de ser 3 letras, intentalo de nuevo", "Error letras", JOptionPane.WARNING_MESSAGE);
            }
        } while (!verificarLetras);
    }

    //Muestra un menu para poder seleccionar la bandeja y ver sus diferentes productos
    public static void verProductoBadejas(Maquina maquina, Controlador controladorMaquina) {
        Object bandejaSeleccionar = null; //Desplegable con bandejas
        bandejaSeleccionar = JOptionPane.showInputDialog(null, "De que bandeja quieres ver sus productos", "Show Productos Bandeja", JOptionPane.QUESTION_MESSAGE, null,
                maquina.codBandeja(), maquina.codBandeja()[0]);
        if (bandejaSeleccionar != null) {
            JOptionPane.showMessageDialog(null, controladorMaquina.verProductosBandeja(bandejaSeleccionar.toString()));
        }
    }

    //Cambia un producto por otro nuevo, pide nombre, stock y precio
    public static void modificarProductosBandeja(Maquina maquina, Controlador controladorMaquina) {
        Object productosParaSeleccionar = null; //Desplegable con productos
        productosParaSeleccionar = JOptionPane.showInputDialog(null, new JTextArea(maquina.codNombreProducto()), "Show CodBandeja", JOptionPane.QUESTION_MESSAGE, null,
                maquina.codigoProducto(), maquina.codigoProducto()[0]);

        if (productosParaSeleccionar != null) {
            boolean verificarDoubleInt = true;
            do {
                verificarDoubleInt = true;
                try {
                    String nuevoNombreProducto = JOptionPane.showInputDialog(null, "Introduzca el nombre del nuevo producto:", "Nuevo producto", JOptionPane.PLAIN_MESSAGE);
                    if (nuevoNombreProducto != null) {
                        String nuevoPrecioProducto = JOptionPane.showInputDialog(null, "Introduzca el precio del nuevo producto:", "Nuevo producto", JOptionPane.PLAIN_MESSAGE);
                        if (nuevoPrecioProducto != null) {
                            String nuevoStockProducto = JOptionPane.showInputDialog(null, "Introduzca el stock del nuevo producto:", "Nuevo producto", JOptionPane.PLAIN_MESSAGE);
                            if (nuevoStockProducto != null) {
                                int precioProductoNuevo = (int)(Double.parseDouble(nuevoPrecioProducto)*100);
                                Productos nuevoProducto = new Productos(nuevoNombreProducto, precioProductoNuevo, Integer.parseInt(nuevoStockProducto));
                                controladorMaquina.modificarProductosBandeja(productosParaSeleccionar.toString(), nuevoProducto);
                            }
                        }
                    }
                } catch (NumberFormatException nfe) {
                    verificarDoubleInt = !verificarDoubleInt;
                    JOptionPane.showMessageDialog(null, "Verifica que sean numeros y no letras, intentalo de nuevo", "Error numeros", JOptionPane.WARNING_MESSAGE);
                }

            } while (!verificarDoubleInt);
        }
    }

    //Muestra una lista con todos los productos, te deja elegir y seleccionas un producto para ver el stock
    public static void verStockProducto(Maquina maquina, Controlador controladorMaquina) {
        Object productosParaSeleccionar = null; //Desplegable con productos
        productosParaSeleccionar = JOptionPane.showInputDialog(null, new JTextArea(maquina.codNombreProducto()), "Ver Stock Producto", JOptionPane.QUESTION_MESSAGE, null,
                maquina.codigoProducto(), maquina.codigoProducto()[0]);

        if (productosParaSeleccionar != null) {
            JOptionPane.showMessageDialog(null, controladorMaquina.verStockProducto(productosParaSeleccionar.toString()));
        }
    }

    //Muestra una lista con todos los productos y permite seleccionar, luego introduces el nuevo stock y se cambia
    public static void modificarStockProducto(Maquina maquina, Controlador controladorMaquina) {
        Object productosParaSeleccionar = null; //Desplegable con productos
        productosParaSeleccionar = JOptionPane.showInputDialog(null, new JTextArea(maquina.codNombreProducto()), "Mod Stock Producto", JOptionPane.QUESTION_MESSAGE, null,
                maquina.codigoProducto(), maquina.codigoProducto()[0]);

        if (productosParaSeleccionar != null) {
            boolean verificacion = true;
            do {
                verificacion = true;
                try {
                    String nuevoStockText = JOptionPane.showInputDialog(null, "Introduce un nuevo stock para el producto:", "Modificacion stock", JOptionPane.INFORMATION_MESSAGE);
                    int nuevoStock = Integer.parseInt(nuevoStockText);
                    controladorMaquina.modificarStockProducto(productosParaSeleccionar.toString(), nuevoStock);
                } catch (NumberFormatException nfe) {
                    verificacion = false;
                    JOptionPane.showMessageDialog(null, "Introduce un numero, no un a letra!");
                }
            } while (!verificacion);
        }
    }

    //Muestra las monedas y billetes de la maquina junto a su dinero total, tambien muestra las ganacias con tarjeta
    public static void verGanancias(Maquina maquina) {
        JOptionPane.showMessageDialog(null, datosGanancias(maquina), "Ganancias maquina", JOptionPane.INFORMATION_MESSAGE);
    }

    //Devuelve un JTextAreaFormateado a nuestro gusto
    private static JTextArea datosGanancias(Maquina maquina) {
        String dineroTarjetaString = String.valueOf(maquina.getDineroTarjetas());
        String dineroTarjetaFormateado = dineroTarjetaString.substring(0, dineroTarjetaString.length() - 2) + "," +
                dineroTarjetaString.substring(dineroTarjetaString.length() - 2, dineroTarjetaString.length()); //Convertir de 4200€ a 42,00€ para el usuario


        JTextArea textArea = new JTextArea("Monedas 0.01€-->" + maquina.getMonedero().getContadorMonedasUnCentimo() + "\n"
                + "Monedas 0.02€-->" + maquina.getMonedero().getContadorMonedasDosCentimos() + "\n"
                + "Monedas 0.05€-->" + maquina.getMonedero().getContadorMonedasCincoCentimos() + "\n"
                + "Monedas 0.10€-->" + maquina.getMonedero().getContadorMonedasDiezCentimos() + "\n"
                + "Monedas 0.20€-->" + maquina.getMonedero().getContadorMonedasVeinteCentimos() + "\n"
                + "Monedas 0.50€-->" + maquina.getMonedero().getContadorMonedasCincuentaCentimos() + "\n"
                + "Monedas 1.00€-->" + maquina.getMonedero().getContadorMonedasUnEuro() + "\n"
                + "Monedas 2.00€-->" + maquina.getMonedero().getContadorMonedasDosEuros() + "\n"
                + "Billetes 5.00€-->" + maquina.getMonedero().getContadorBilletesCincoEuros() + "\n"
                + "Billetes 10.0€-->" + maquina.getMonedero().getContadorBilletesDiezEuros() + "\n"
                + "Billetes 20.0€-->" + maquina.getMonedero().getContadorBilletesVeinteEuros() + "\n\n"
                + "Dinero total monedas:" + maquina.getMonedero().getDineroTotal() + "€\n\n\n"
                + "Dinero pagado con tarjeta: " + dineroTarjetaFormateado + "€"
        );

        return textArea;
    }

    //Permite recaudar el dinero, y muestra el resultado
    public static void recaudarDinero(Maquina maquina, Controlador controladorMaquina) {
        int recaudarDinero = JOptionPane.showConfirmDialog(null, "¿Quieres recaudar el dinero?", "Recaudar dinero", JOptionPane.YES_NO_OPTION);
        if (recaudarDinero == 0) {
            controladorMaquina.recaudarDineroGanancias();
            JOptionPane.showConfirmDialog(null, datosGanancias(maquina), "Resultado recaudacion", JOptionPane.DEFAULT_OPTION);
        }
    }

    //Añade monedas, pregunta la moneda que quieres añadir y la cantidad de monedas para introducir
    public static void añadirMonedasCambio(Maquina maquina) {
        //Preguntar seleccion de monedas
        //Preguntar cuantas moendas quierea añadir
        //Repetir hasta que el administrador cancele
        Object[] monedasSeleccionar = {0.01, 0.02, 0.05, 0.10, 0.20, 0.50, 1.00, 2.00, 5.00, 10.00, 20.00};
        int[] monedasAñadidas = {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
        int monedaCantidad = 0;
        Object monedaCliente = null;
        String texto = null;
        do {
            monedaCliente = JOptionPane.showInputDialog(null, "Introduce monedas para el cambio, ",
                    "Pasarela de pago", JOptionPane.QUESTION_MESSAGE, null, monedasSeleccionar, monedasSeleccionar[0]);

            if (monedaCliente != null) {
                boolean resultado = true;

                do {
                    resultado = true;
                    texto = JOptionPane.showInputDialog("Introduzca la cantidad de la moneda: ");

                    if (texto != null) {

                        try {
                            monedaCantidad = Integer.parseInt(texto);

                        } catch (NumberFormatException nfe) {
                            resultado = false;

                            JOptionPane.showMessageDialog(null, "Error: Introduzca un digito");
                        }

                    } else {

                        break;
                    }

                } while (!resultado);

            } else {

                break;
            }


            monedasAñadidas[devolverIndiceMonedaUsada(monedaCliente)] += monedaCantidad;

        } while (monedaCliente != null || texto != null);
        maquina.getMonedero().addMonedasCambio(monedasAñadidas);
    }

    //Metodo que devuelve el indice de las monedas selecionadas
    private static int devolverIndiceMonedaUsada(Object dineroSeleccionado) {
        int indice = 0;
        double dineroSelect = Double.parseDouble(dineroSeleccionado.toString()) * 100;
        int dinero = (int) dineroSelect;
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
                indice = -1;
                break;
        }
        return indice;
    }

    //------------USUARIO------------------
    //Muesta el precio del articulo
    public static void mostrarPrecio(Controlador controladorMaquina, String clientePulsaBoton) {
        String precio = String.valueOf(controladorMaquina.mostrarPrecio(clientePulsaBoton));
        String precioMostrar = precio.substring(0, precio.length() - 2) + "," + precio.substring(precio.length() - 2, precio.length()); //Para mostrar el precio formateado Ej:(15,50)
        JOptionPane.showMessageDialog(null, precioMostrar + "€", "Precio [" + precioMostrar + "]",
                JOptionPane.INFORMATION_MESSAGE);
    }

    //Compra del articulo
    public static void comprarArticulo(Controlador controladorMaquina, String clientePulsaBoton) {
        String[] opcionesCompraBotones = {"EFECTIVO", "TARJETA", "CANCELAR OPERACION"};
        int opcionesCompra = JOptionPane.showOptionDialog(null, "Opciones de compra:", "Pasarela de pago", JOptionPane.YES_NO_CANCEL_OPTION, JOptionPane.INFORMATION_MESSAGE,
                null, opcionesCompraBotones, opcionesCompraBotones[0]);

        if (opcionesCompra != 2 || opcionesCompra != -1) {
            switch (opcionesCompra) {
                case 0://OPCION EFECTIVO
                    compraEfectivo(controladorMaquina, clientePulsaBoton);

                    break;
                case 1://OPCION TARJETA
                    compraTarjeta(controladorMaquina, clientePulsaBoton);
                    break;
            }
        }
    }

    //Caso de compra en efectivo
    private static void compraEfectivo(Controlador controladorMaquina, String clientePulsaBoton) {
        Object[] monedasSeleccionar = {0.01, 0.02, 0.05, 0.10, 0.20, 0.50, 1.00, 2.00, 5.00, 10.00, 20.00};
        int[] monedasValores = {1, 2, 5, 10, 20, 50, 100, 200, 500, 1000, 2000};
        int[] monedasAñadidas = {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0};

        int dineroIntroducidoTotal = 0;
        int precioTotal = controladorMaquina.mostrarPrecio(clientePulsaBoton);

        do {
            int dineroRestante = (precioTotal - dineroIntroducidoTotal);
            String dineroRestanteString = String.valueOf(dineroRestante);
            String dineroRestanteUsuario = (dineroRestanteString.length() > 2) ? dineroRestanteString.substring(0, dineroRestanteString.length() - 2) + ","
                    + dineroRestanteString.substring(dineroRestanteString.length() - 2, dineroRestanteString.length()) + "€" :
                    (dineroRestanteString + " centimos");
            Object monedaCliente = JOptionPane.showInputDialog(null, "Introduce monedas, " + dineroRestanteUsuario + "restantes",
                    "Pasarela de pago", JOptionPane.QUESTION_MESSAGE, null, monedasSeleccionar, monedasSeleccionar[0]);

            if (monedaCliente != null) {
                monedasAñadidas[devolverIndiceMonedaUsada(monedaCliente)]++;
                dineroIntroducidoTotal += monedasValores[devolverIndiceMonedaUsada(monedaCliente)];
            } else {
                break;
            }
        } while (!(dineroIntroducidoTotal >= precioTotal));
        if (!(dineroIntroducidoTotal < precioTotal)) {
            if (controladorMaquina.comprarArticulo(clientePulsaBoton, monedasAñadidas, null, null, 0)) {
                controladorMaquina.sumaContadoresDineroCompra(monedasAñadidas);
                if (dineroIntroducidoTotal > precioTotal) {
                    JOptionPane.showMessageDialog(null, "Recoja su cambio");
                    int[] dineroDevuelto = controladorMaquina.devolucionDinero((dineroIntroducidoTotal - precioTotal));

                    double[] dineroDevueltoDouble = new double[dineroDevuelto.length];
                    for (int i = 0; i < dineroDevuelto.length; i++) {
                        dineroDevueltoDouble[i] = ((double) dineroDevuelto[i]) / 100;
                    }
                    JOptionPane.showMessageDialog(null, Arrays.toString(dineroDevueltoDouble));
                }
                JOptionPane.showMessageDialog(null, "Producto correctamente pagado, su producto se encuentra en el deposito. Recogelo!");

            } else {
                JOptionPane.showMessageDialog(null, "Error en la compra, la maquina no posee cambio suficiente", "Error cambio", JOptionPane.WARNING_MESSAGE);
            }
        } else {
            JOptionPane.showMessageDialog(null, "Ha cancelado la operación", "Error operacion", JOptionPane.WARNING_MESSAGE);
        }
    }

    //Caso de compra con tarjeta
    private static void compraTarjeta(Controlador controladorMaquina, String clientePulsaBoton) {
        String numeroTarjeta = JOptionPane.showInputDialog(null, "Introduce el numero de tarjeta:", "Numero tarjeta", JOptionPane.PLAIN_MESSAGE);
        String fechaVencimientoText;
        String CVVText;
        LocalDate fechaVencimiento = null;
        int CVV = 0;
        boolean verificarFormato = true;

        do {
            verificarFormato = true;
            fechaVencimientoText = JOptionPane.showInputDialog(null, "Introduce la fecha de vencimiento (yyyy-mm-dd):", "Fecha vencimiento", JOptionPane.PLAIN_MESSAGE);
            try {
                fechaVencimiento = LocalDate.parse(fechaVencimientoText);
            } catch (DateTimeParseException dtpe) {
                JOptionPane.showMessageDialog(null, "Error en el formato de la fecha, intentalo de nuevo", "Error fecha", JOptionPane.WARNING_MESSAGE);
                verificarFormato = !verificarFormato;
            }
        } while (!verificarFormato);
        do {
            verificarFormato = true;


            CVVText = JOptionPane.showInputDialog(null, "Introduce el CVV:", "CVV", JOptionPane.PLAIN_MESSAGE);
            try {
                CVV = Integer.parseInt(CVVText);
            } catch (NumberFormatException nfe) {
                JOptionPane.showMessageDialog(null, "Error en el formato del CVV, intentalo de nuevo", "Error CVV", JOptionPane.WARNING_MESSAGE);
                verificarFormato = !verificarFormato;
            }

        } while (!verificarFormato);
        if (controladorMaquina.comprarArticulo(clientePulsaBoton, null, numeroTarjeta, fechaVencimiento, CVV)) {
            JOptionPane.showMessageDialog(null, "Producto correctamente pagado, su producto se encuentra en el deposito. Recogelo!");
        } else {
            JOptionPane.showMessageDialog(null, "Error en la compra, su tarjeta no coinciden", "Error tarjeta", JOptionPane.WARNING_MESSAGE);
            JOptionPane.showMessageDialog(null, "Saliendo de la pasarela intruso!", "Error tarjeta", JOptionPane.WARNING_MESSAGE);

        }
    }

}
