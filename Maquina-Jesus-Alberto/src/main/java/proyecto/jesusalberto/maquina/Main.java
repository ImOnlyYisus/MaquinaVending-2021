package proyecto.jesusalberto.maquina;

import javax.swing.*;
import java.time.LocalDate;
import java.time.format.DateTimeParseException;

public class Main {

    public static void main(String[] args) throws Exception {
        //Objetos
        Bandejas[] bandejasArray = new Bandejas[6];
        try {
            bandejasArray[0] = new Bandejas(new Productos[]{
                    new Productos("Monster", 250, 10),
                    new Productos("Cocacola", 265, 11),
                    new Productos("Fanta", 210, 9),
                    new Productos("Nestea", 200, 10),
                    new Productos("Agua", 165, 11)
            });
            bandejasArray[1] = new Bandejas(new Productos[]{
                    new Productos("Lays Sal", 365, 8),
                    new Productos("Ruffles Jamon", 400, 10),
                    new Productos("Campesinas", 370, 9),
                    new Productos("Cheetos", 298, 10)
            });
            bandejasArray[2] = new Bandejas(new Productos[]{
                    new Productos("Nestle Blanco", 560, 8),
                    new Productos("Nestle Negro", 560, 11),
                    new Productos("Carbury Blanco", 440, 9),
                    new Productos("Carbury Negro", 440, 6),
                    new Productos("Jungly", 660, 8)
            });
            bandejasArray[3] = new Bandejas(new Productos[]{
                    new Productos("Manzana", 260, 10),
                    new Productos("Pera", 300, 8),
                    new Productos("Platano", 265, 9),
                    new Productos("Fresas", 340, 10),
                    new Productos("Naranja", 250, 7)
            });
            bandejasArray[4] = new Bandejas(new Productos[]{
                    new Productos("Manzana", 260, 6),
                    new Productos("Pera", 300, 11),
                    new Productos("Platano", 265, 9),
                    new Productos("Fresas", 340, 1),
                    new Productos("Naranja", 250, 1)
            });
            bandejasArray[5] = new Bandejas(new Productos[]{
                    new Productos("Crema Aloe", 650, 5),
                    new Productos("Crema Nivea", 480, 4),
                    new Productos("Preservativos", 420, 8),
                    new Productos("Satisfayer", 1570, 4),
                    new Productos("SatisfayerMen", 1570, 4)
            });
        } catch (IllegalArgumentException iae) {
            System.out.println(iae);
        }

        Maquina maquina = null;

        try {
            maquina = new Maquina(bandejasArray, "Parking x", new Monedero());
        } catch (IllegalArgumentException iae) {
            System.out.println(iae);
        }

        for (int i = 0; i < maquina.getMonedero().getDineroContadores().length; i++) {
            maquina.getMonedero().addMonedas(i, 5);
        }

        Controlador controladorMaquina = new Controlador(maquina);
        //-----------------------------------------------
        //VARIABLES

        String[] botonesAdmin = {"Mostrar codigo bandeja",
                "Modificar codigo bandeja",
                "Ver productos bandeja",
                "Modificar productos bandeja",
                "Ver stock de producto",
                "Modificar stock de producto",
                "Ver ganancias",
                "Recaudar dinero",
                "Añadir monedas cambio"
        };

        Object productosParaSeleccionar = null; //Desplegable con productos
        Object bandejaSeleccionar = null; //Desplegable con bandejas
        String clientePulsaBoton = "";
        //----------------------------------------------

        System.out.println(controladorMaquina.getCOD_ADMIN());
        //Condición para que se repita el programa cada vez que realiza una accion
        do {

            clientePulsaBoton = JOptionPane.showInputDialog(null, new JTextArea(maquina.codNombreProducto()));

            if (clientePulsaBoton != null) { //En el caso de que no le de a cancelar o "x"
                //Se comprueba si la contraseña es para ser administrador o no
                if (controladorMaquina.comprobarCodigoAdmin(clientePulsaBoton)) { //El codigo de administrador es correcto, pasa al menú

                    Object optAdmin = null;

                    do {//Bucle que repite el menu de adminstrador hasta que pulse x o cancelar

                        optAdmin = JOptionPane.showInputDialog(null, "Elige una opción Sr.Admin", "MENU ADMIN", JOptionPane.QUESTION_MESSAGE, null, botonesAdmin, botonesAdmin[0]);

                        if (optAdmin != null) { //Si no pulsa la x para salir
                            switch (optAdmin.toString()) {
                                case "Mostrar codigo bandeja": //Muestra el codigo de la bandeja con un desplegable para elegir los productos
                                    productosParaSeleccionar = JOptionPane.showInputDialog(null, new JTextArea(maquina.codNombreProducto()), "Show CodBandeja", JOptionPane.QUESTION_MESSAGE, null,
                                            maquina.codigoProducto(), maquina.codigoProducto()[0]);
                                    if (productosParaSeleccionar != null) {
                                        JOptionPane.showMessageDialog(null, controladorMaquina.mostrarCodigoBandeja(productosParaSeleccionar.toString()));
                                    }

                                    break;

                                case "Modificar codigo bandeja": //Muestra un menu para seleccionar el codigo que queremos modificar y posteriormente nos da la opcion de introducir uno nuevo
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
                                    break;

                                case "Ver productos bandeja": //Muestra un menu para poder seleccionar la bandeja y ver sus diferentes productos
                                    bandejaSeleccionar = JOptionPane.showInputDialog(null, "De que bandeja quieres ver sus productos", "Show Productos Bandeja", JOptionPane.QUESTION_MESSAGE, null,
                                            maquina.codBandeja(), maquina.codBandeja()[0]);
                                    if (bandejaSeleccionar != null) {
                                        JOptionPane.showMessageDialog(null, controladorMaquina.verProductosBandeja(bandejaSeleccionar.toString()));
                                    }
                                    break;

                                case "Modificar productos bandeja": //Modificar este metodo !!!!!! NO TOCAR
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
                                                            Productos nuevoProducto = new Productos(nuevoNombreProducto, Integer.parseInt(nuevoPrecioProducto), Integer.parseInt(nuevoStockProducto));
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
                                    break;

                                case "Ver stock de producto": //Muestra una lista con todos los productos, te deja elegir y seleccionas un producto para ver el stock
                                    productosParaSeleccionar = JOptionPane.showInputDialog(null, new JTextArea(maquina.codNombreProducto()), "Ver Stock Producto", JOptionPane.QUESTION_MESSAGE, null,
                                            maquina.codigoProducto(), maquina.codigoProducto()[0]);

                                    if (productosParaSeleccionar != null) {
                                        JOptionPane.showMessageDialog(null, controladorMaquina.verStockProducto(productosParaSeleccionar.toString()));
                                    }
                                    break;

                                case "Modificar stock de producto": //Muestra una lista con todos los productos y permite seleccionar, luego introduces el nuevo stock y se cambia
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
                                    break;

                                case "Ver ganancias": //Muestra las monedas y billetes de la maquina junto a su dinero total
                                    JOptionPane.showMessageDialog(null, datosGanancias(maquina), "Ganancias maquina", JOptionPane.INFORMATION_MESSAGE);
                                    break;

                                case "Recaudar dinero": //Permite recaudar el dinero, y muestra el resultado
                                    int recaudarDinero = JOptionPane.showConfirmDialog(null, "¿Quieres recaudar el dinero?", "Recaudar dinero", JOptionPane.YES_NO_OPTION);
                                    if (recaudarDinero == 0) {
                                        controladorMaquina.recaudarDineroGanancias();
                                        JOptionPane.showConfirmDialog(null, datosGanancias(maquina), "Resultado recaudacion", JOptionPane.DEFAULT_OPTION);
                                    }
                                    break;

                                case "Añadir monedas cambio":
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
                                    break;

                                default:
                                    break;

                            }
                        }

                    } while (optAdmin != null);

                } else { //MENU CLIENTE

                    if (controladorMaquina.comprobarCodigoProducto(clientePulsaBoton)) {
                        String[] botones = {"VER PRECIO", "COMPRAR", "SALIR"};
                        int opt = JOptionPane.showOptionDialog(null, "¿Que quieres hacer?", "Cliente menu", JOptionPane.YES_NO_CANCEL_OPTION, JOptionPane.PLAIN_MESSAGE, null, botones, botones[0]);
                        if (controladorMaquina.verStockProducto(clientePulsaBoton) != 0) {

                            if (opt != 2 || opt != -1) {
                                switch (opt) {
                                    case 0: //CASO DE MOSTRAR PRECIO
                                        String precio = String.valueOf(controladorMaquina.mostrarPrecio(clientePulsaBoton));
                                        String precioMostrar = precio.substring(0, precio.length() - 2) + "," + precio.substring(precio.length() - 2, precio.length()); //Para mostrar el precio formateado Ej:(15,50)
                                        JOptionPane.showMessageDialog(null, precioMostrar + "€", "Precio [" + precioMostrar + "]",
                                                JOptionPane.INFORMATION_MESSAGE);
                                        break;
                                    case 1: //CASO DE PASARELA DE PAGO
                                        String[] opcionesCompraBotones = {"EFECTIVO", "TARJETA", "CANCELAR OPERACION"};
                                        int opcionesCompra = JOptionPane.showOptionDialog(null, "Opciones de compra:", "Pasarela de pago", JOptionPane.YES_NO_CANCEL_OPTION, JOptionPane.INFORMATION_MESSAGE,
                                                null, opcionesCompraBotones, opcionesCompraBotones[0]);

                                        if (opcionesCompra != 2 || opcionesCompra != -1) {
                                            switch (opcionesCompra) {
                                                case 0://OPCION EFECTIVO
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
                                                                    JOptionPane.showMessageDialog(null, dineroDevueltoDouble[i]);
                                                                }
                                                            }
                                                            JOptionPane.showMessageDialog(null, "Producto correctamente pagado, su producto se encuentra en el deposito. Recogelo!");

                                                        } else {
                                                            JOptionPane.showMessageDialog(null, "Error en la compra, la maquina no posee cambio suficiente", "Error cambio", JOptionPane.WARNING_MESSAGE);
                                                        }
                                                    } else {
                                                        JOptionPane.showMessageDialog(null, "Ha cancelado la operación", "Error operacion", JOptionPane.WARNING_MESSAGE);
                                                    }

                                                    break;
                                                case 1://OPCION TARJETA
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
                                                    break;
                                            }
                                        }
                                        break;
                                }
                            }
                        } else {
                            JOptionPane.showMessageDialog(null, "No hay stock", "No stock", JOptionPane.WARNING_MESSAGE);
                        }
                    } else {
                        JOptionPane.showMessageDialog(null, "Ese producto no existe, intentalo de nuevo", "Error de producto", JOptionPane.ERROR_MESSAGE);
                    }

                }
            }
        } while (clientePulsaBoton != null);
    }

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
}
