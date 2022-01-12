//package maquina;
//
//import org.apache.commons.math3.util.Precision;
//
//import javax.swing.*;
//import java.time.LocalDate;
//import java.time.format.DateTimeParseException;
//
//public class Main {
//
//    public static void main(String[] args) throws Exception {
//        //Objetos
//        Productos[] productosPrimeraBandeja = {
//                new Productos("Monster", 2.50, 10),
//                new Productos("Cocacola", 2.65, 11),
//                new Productos("Fanta", 2.10, 9),
//                new Productos("Nestea", 2.00, 10),
//                new Productos("Agua", 1.65, 11)
//        };
//
//        Productos[] productosSegundaBandeja = {
//                new Productos("Lays Sal", 3.65, 8),
//                new Productos("Ruffles Jamon", 4.00, 10),
//                new Productos("Campesinas", 3.70, 9),
//                new Productos("Cheetos", 2.98, 10)
//        };
//
//        Productos[] productosTerceraBandeja = {
//                new Productos("Nestle Blanco", 5.6, 8),
//                new Productos("Nestle Negro", 5.6, 11),
//                new Productos("Carbury Blanco", 4.4, 9),
//                new Productos("Carbury Negro", 4.4, 6),
//                new Productos("Jungly", 6.6, 8)
//        };
//
//        Productos[] productosCuartaBandeja = {
//                new Productos("Manzana", 2.6, 10),
//                new Productos("Pera", 3, 8),
//                new Productos("Platano", 2.65, 9),
//                new Productos("Fresas", 3.4, 10),
//                new Productos("Naranja", 2.5, 7)
//        };
//
//        Productos[] productosQuintaBandeja = {
//                new Productos("Manzana", 2.6, 6),
//                new Productos("Pera", 3, 11),
//                new Productos("Platano", 2.65, 9),
//                new Productos("Fresas", 3.4, 1),
//                new Productos("Naranja", 2.5, 1)
//        };
//
//        Productos[] productosSextaBandeja = {
//                new Productos("Crema Aloe", 6.5, 5),
//                new Productos("Crema Nivea", 4.8, 4),
//                new Productos("Preservativos", 4.2, 8),
//                new Productos("Satisfayer", 15.7, 4),
//                new Productos("SatisfayerMen", 15.7, 4)
//        };
//
//        Bandejas[] bandejasArray = new Bandejas[6];
//        try {
//            bandejasArray[0] = new Bandejas(productosPrimeraBandeja);
//            bandejasArray[1] = new Bandejas(productosSegundaBandeja);
//            bandejasArray[2] = new Bandejas(productosTerceraBandeja);
//            bandejasArray[3] = new Bandejas(productosCuartaBandeja);
//            bandejasArray[4] = new Bandejas(productosQuintaBandeja);
//            bandejasArray[5] = new Bandejas(productosSextaBandeja);
//        } catch (IllegalArgumentException iae) {
//            System.out.println(iae);
//        }
//
//        Monedero monederoMaquina = new Monedero();
//        for (int i = 0; i <monederoMaquina.getDineroContadores().length ; i++) {
//            monederoMaquina.addMonedas(i,5);
//        }
//
//        Maquina maquina = null;
//
//        try {
//            maquina = new Maquina(bandejasArray, "Parking x", monederoMaquina);
//        } catch (IllegalArgumentException iae) {
//            System.out.println(iae);
//        }
//
//        Controlador controladorMaquina = new Controlador(maquina);
//        //-----------------------------------------------
//        //VARIABLES
//        JTextArea textArea = new JTextArea("Monedas 0.01€-->" + maquina.getMonedero().getContadorMonedasUnCentimo() + "\n"
//                + "Monedas 0.02€-->" + maquina.getMonedero().getContadorMonedasDosCentimos() + "\n"
//                + "Monedas 0.05€-->" + maquina.getMonedero().getContadorMonedasCincoCentimos() + "\n"
//                + "Monedas 0.10€-->" + maquina.getMonedero().getContadorMonedasDiezCentimos() + "\n"
//                + "Monedas 0.20€-->" + maquina.getMonedero().getContadorMonedasVeinteCentimos() + "\n"
//                + "Monedas 0.50€-->" + maquina.getMonedero().getContadorMonedasCincuentaCentimos() + "\n"
//                + "Monedas 1.00€-->" + maquina.getMonedero().getContadorMonedasUnEuro() + "\n"
//                + "Monedas 2.00€-->" + maquina.getMonedero().getContadorMonedasUnEuro() + "\n"
//                + "Billetes 5.00€-->" + maquina.getMonedero().getContadorBilletesCincoEuros() + "\n"
//                + "Billetes 10.0€-->" + maquina.getMonedero().getContadorBilletesDiezEuros() + "\n"
//                + "Billetes 20.0€-->" + maquina.getMonedero().getContadorBilletesVeinteEuros() + "\n\n"
//                + "Dinero total:" + maquina.getMonedero().getDineroTotal()
//        );
//
//        String[] botonesAdmin = {"Mostrar codigo bandeja",
//                "Modificar codigo bandeja",
//                "Ver productos bandeja",
//                "Modificar productos bandeja",
//                "Ver stock de producto",
//                "Modificar stock de producto",
//                "Ver ganancias",
//                "Recaudar dinero"
//        };
//
//        Object productosParaSeleccionar = null; //Desplegable con productos
//        Object bandejaSeleccionar = null; //Desplegable con bandejas
//        String clientePulsaBoton = "";
//        //----------------------------------------------
//
//        System.out.println(controladorMaquina.getCOD_ADMIN());
//        LogsDatos.tablaMaquina(maquina);
//        //Condición para que se repita el programa cada vez que realiza una accion
//        do {
//
//            clientePulsaBoton = JOptionPane.showInputDialog(null, new JTextArea(maquina.codNombreProducto()));
//
//            if (clientePulsaBoton != null) { //En el caso de que no le de a cancelar o "x"
//                //Se comprueba si la contraseña es para ser administrador o no
//                if (controladorMaquina.comprobarCodigoAdmin(clientePulsaBoton)) { //El codigo de administrador es correcto, pasa al menú
//
//                    Object optAdmin = null;
//
//                    do {//Bucle que repite el menu de adminstrador hasta que pulse x o cancelar
//
//                        optAdmin = JOptionPane.showInputDialog(null, "Elige una opción Sr.Admin", "MENU ADMIN", JOptionPane.QUESTION_MESSAGE, null, botonesAdmin, botonesAdmin[0]);
//
//                        if (optAdmin != null) { //Si no pulsa la x para salir
//                            switch (optAdmin.toString()) {
//                                case "Mostrar codigo bandeja": //Muestra el codigo de la bandeja con un desplegable para elegir los productos
//                                    productosParaSeleccionar = JOptionPane.showInputDialog(null, new JTextArea(maquina.codNombreProducto()), "Show CodBandeja", JOptionPane.QUESTION_MESSAGE, null,
//                                            maquina.codigoProducto(), maquina.codigoProducto()[0]);
//                                    if (productosParaSeleccionar != null) {
//                                        JOptionPane.showMessageDialog(null, controladorMaquina.mostrarCodigoBandeja(productosParaSeleccionar.toString()));
//                                    }
//
//                                    break;
//
//                                case "Modificar codigo bandeja": //Muestra un menu para seleccionar el codigo que queremos modificar y posteriormente nos da la opcion de introducir uno nuevo
//                                    bandejaSeleccionar = JOptionPane.showInputDialog(null, new JTextArea(maquina.codNombreProducto()), "Mod CodBandeja", JOptionPane.QUESTION_MESSAGE, null,
//                                            maquina.codBandeja(), maquina.codBandeja()[0]);
//
//                                    boolean verificarLetras = true;
//                                    do { //Verifico que el nuevo codigo sea 3 letras
//                                        String nuevoCod = JOptionPane.showInputDialog(null, "Introduce un nuevo codigo de tres letras:", "Modificacion cod Bandeja", JOptionPane.INFORMATION_MESSAGE);
//                                        verificarLetras = true;
//                                        try {
//                                            if (nuevoCod != null) { //Si el usuario no presiona x o cancelar
//                                                controladorMaquina.modificarCodBandeja(bandejaSeleccionar.toString(), nuevoCod);
//                                                JOptionPane.showMessageDialog(null, new JTextArea(maquina.codNombreProducto()), "Cambio cod Bandeja", JOptionPane.PLAIN_MESSAGE);
//                                            }
//                                        } catch (IllegalArgumentException iae) {
//                                            verificarLetras = !verificarLetras;
//                                            JOptionPane.showMessageDialog(null, "El codigo debe de ser 3 letras, intentalo de nuevo", "Error letras", JOptionPane.WARNING_MESSAGE);
//                                        }
//                                    } while (!verificarLetras);
//                                    break;
//
//                                case "Ver productos bandeja": //Muestra un menu para poder seleccionar la bandeja y ver sus diferentes productos
//                                    bandejaSeleccionar = JOptionPane.showInputDialog(null, "De que bandeja quieres ver sus productos", "Show Productos Bandeja", JOptionPane.QUESTION_MESSAGE, null,
//                                            maquina.codBandeja(), maquina.codBandeja()[0]);
//                                    if (bandejaSeleccionar != null) {
//                                        JOptionPane.showMessageDialog(null, controladorMaquina.verProductosBandeja(bandejaSeleccionar.toString()));
//                                    }
//                                    break;
//
//                                case "Modificar productos bandeja": //Modificar este metodo !!!!!! NO TOCAR
//                                    productosParaSeleccionar = JOptionPane.showInputDialog(null, new JTextArea(maquina.codNombreProducto()), "Show CodBandeja", JOptionPane.QUESTION_MESSAGE, null,
//                                            maquina.codigoProducto(), maquina.codigoProducto()[0]);
//
//                                    if (productosParaSeleccionar != null) {
//                                        boolean verificarDoubleInt = true;
//                                        do {
//                                            verificarDoubleInt = true;
//                                            try {
//                                                String nuevoNombreProducto = JOptionPane.showInputDialog(null, "Introduzca el nombre del nuevo producto:", "Nuevo producto", JOptionPane.PLAIN_MESSAGE);
//                                                if (nuevoNombreProducto != null) {
//                                                    String nuevoPrecioProducto = JOptionPane.showInputDialog(null, "Introduzca el precio del nuevo producto:", "Nuevo producto", JOptionPane.PLAIN_MESSAGE);
//                                                    if (nuevoPrecioProducto != null) {
//                                                        String nuevoStockProducto = JOptionPane.showInputDialog(null, "Introduzca el stock del nuevo producto:", "Nuevo producto", JOptionPane.PLAIN_MESSAGE);
//                                                        if (nuevoStockProducto != null) {
//                                                            Productos nuevoProducto = new Productos(nuevoNombreProducto, Double.parseDouble(nuevoPrecioProducto), Integer.parseInt(nuevoStockProducto));
//                                                            controladorMaquina.modificarProductosBandeja(productosParaSeleccionar.toString(), nuevoProducto);
//                                                        }
//                                                    }
//                                                }
//                                            } catch (NumberFormatException nfe) {
//                                                verificarDoubleInt = !verificarDoubleInt;
//                                                JOptionPane.showMessageDialog(null, "Verifica que sean numeros y no letras, intentalo de nuevo", "Error numeros", JOptionPane.WARNING_MESSAGE);
//                                            }
//
//                                        } while (!verificarDoubleInt);
//                                    }
//                                    break;
//
//                                case "Ver stock de producto": //Muestra una lista con todos los productos, te deja elegir y seleccionas un producto para ver el stock
//                                    productosParaSeleccionar = JOptionPane.showInputDialog(null, new JTextArea(maquina.codNombreProducto()), "Ver Stock Producto", JOptionPane.QUESTION_MESSAGE, null,
//                                            maquina.codigoProducto(), maquina.codigoProducto()[0]);
//
//                                    if (productosParaSeleccionar != null) {
//                                        JOptionPane.showMessageDialog(null, controladorMaquina.verStockProducto(productosParaSeleccionar.toString()));
//                                    }
//                                    break;
//
//                                case "Modificar stock de producto": //Muestra una lista con todos los productos y permite seleccionar, luego introduces el nuevo stock y se cambia
//                                    productosParaSeleccionar = JOptionPane.showInputDialog(null, new JTextArea(maquina.codNombreProducto()), "Mod Stock Producto", JOptionPane.QUESTION_MESSAGE, null,
//                                            maquina.codigoProducto(), maquina.codigoProducto()[0]);
//
//                                    if (productosParaSeleccionar != null) {
//                                        boolean verificacion = true;
//                                        do {
//                                            verificacion = true;
//                                            try {
//                                                String nuevoStockText = JOptionPane.showInputDialog(null, "Introduce un nuevo stock para el producto:", "Modificacion stock", JOptionPane.INFORMATION_MESSAGE);
//                                                int nuevoStock = Integer.parseInt(nuevoStockText);
//                                                controladorMaquina.modificarStockProducto(productosParaSeleccionar.toString(), nuevoStock);
//                                            } catch (NumberFormatException nfe) {
//                                                verificacion = false;
//                                                JOptionPane.showMessageDialog(null, "Introduce un numero, no un a letra!");
//                                            }
//                                        } while (!verificacion);
//                                    }
//                                    break;
//
//                                case "Ver ganancias": //Muestra las monedas y billetes de la maquina junto a su dinero total
//                                    JOptionPane.showMessageDialog(null, textArea, "Ganancias maquina", JOptionPane.INFORMATION_MESSAGE);
//                                    break;
//
//                                case "Recaudar dinero": //Permite recaudar el dinero, y muestra el resultado
//                                    int recaudarDinero = JOptionPane.showConfirmDialog(null, "¿Quieres recaudar el dinero?", "Recaudar dinero", JOptionPane.YES_NO_OPTION);
//                                    if (recaudarDinero == 0) {
//                                        controladorMaquina.recaudarDineroGanancias();
//                                        JOptionPane.showConfirmDialog(null, textArea, "Resultado recaudacion", JOptionPane.DEFAULT_OPTION);
//                                    }
//                                    break;
//
//                                default:
//                                    break;
//
//                            }
//                        }
//
//                    } while (optAdmin != null);
//
//                } else { //MENU CLIENTE
//
//                    if (controladorMaquina.comprobarCodigoProducto(clientePulsaBoton)) {
//                        String[] botones = {"VER PRECIO", "COMPRAR", "SALIR"};
//                        int opt = JOptionPane.showOptionDialog(null, "¿Que quieres hacer?", "Cliente menu", JOptionPane.YES_NO_CANCEL_OPTION, JOptionPane.PLAIN_MESSAGE, null, botones, botones[0]);
//                        if (controladorMaquina.verStockProducto(clientePulsaBoton) != 0) {
//
//                            if (opt != 2 || opt != -1) {
//                                switch (opt) {
//                                    case 0: //CASO DE MOSTRAR PRECIO
//                                        JOptionPane.showMessageDialog(null, controladorMaquina.mostrarPrecio(clientePulsaBoton) + "€", "Precio [" + clientePulsaBoton + "]",
//                                                JOptionPane.INFORMATION_MESSAGE);
//                                        break;
//                                    case 1: //CASO DE PASARELA DE PAGO
//                                        String[] opcionesCompraBotones = {"EFECTIVO", "TARJETA", "CANCELAR OPERACION"};
//                                        int opcionesCompra = JOptionPane.showOptionDialog(null, "Opciones de compra:", "Pasarela de pago", JOptionPane.YES_NO_CANCEL_OPTION, JOptionPane.INFORMATION_MESSAGE,
//                                                null, opcionesCompraBotones, opcionesCompraBotones[0]);
//
//                                        if (opcionesCompra != 2 || opcionesCompra != -1) {
//                                            switch (opcionesCompra) {
//                                                case 0://OPCION EFECTIVO
//                                                    Object[] dineroValores = {0.01, 0.02, 0.05, 0.10, 0.20, 0.50, 1.0, 2.0, 5.0, 10.0, 20.0};
//                                                    int[] monedasAñadidas = {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
//                                                    double dineroIntroducidoTotal = 0;
//
//                                                    while (Precision.round(Math.nextUp(dineroIntroducidoTotal),2) <= Precision.round((controladorMaquina.mostrarPrecio(clientePulsaBoton)),2)) {
//
//                                                        Object monedaCliente = JOptionPane.showInputDialog(null, "Introduce monedas, " + dineroIntroducidoTotal + "/" +controladorMaquina.mostrarPrecio(clientePulsaBoton)+ "restantes", "Pasarela de pago", JOptionPane.QUESTION_MESSAGE, null, dineroValores, dineroValores[0]);
//
//                                                        if (monedaCliente != null) {
//                                                            System.out.println(monedaCliente);
//                                                            System.out.println(devolverIndiceMonedaUsada(Double.parseDouble(monedaCliente.toString())));
//                                                            monedasAñadidas[devolverIndiceMonedaUsada((Double.parseDouble(monedaCliente.toString())))]++;
//                                                            for (int i = 0; i < monedasAñadidas.length; i++) {
//                                                                dineroIntroducidoTotal += monedasAñadidas[i] * Double.parseDouble(dineroValores[i].toString());
//                                                                dineroIntroducidoTotal=Precision.round(Math.nextUp(dineroIntroducidoTotal),2);
//                                                            }
//                                                        }
//
//                                                    }
//
//                                                    if (controladorMaquina.comprarArticulo(clientePulsaBoton, monedasAñadidas, null, null, 0)) {
//                                                        JOptionPane.showMessageDialog(null, "Producto correctamente pagado, su producto se encuentra en el deposito. Recogelo!");
//                                                    } else {
//                                                        JOptionPane.showMessageDialog(null, "Error en la compra, su tarjeta no coinciden", "Error tarjeta", JOptionPane.WARNING_MESSAGE);
//                                                    }
//
//                                                    break;
//                                                case 1://OPCION TARJETA
//                                                    String numeroTarjeta = JOptionPane.showInputDialog(null, "Introduce el numero de tarjeta:", "Numero tarjeta", JOptionPane.PLAIN_MESSAGE);
//                                                    String fechaVencimientoText;
//                                                    String CVVText;
//                                                    LocalDate fechaVencimiento = null;
//                                                    int CVV = 0;
//                                                    boolean verificarFormato = true;
//
//                                                    do {
//                                                        verificarFormato = true;
//                                                        fechaVencimientoText = JOptionPane.showInputDialog(null, "Introduce la fecha de vencimiento (yyyy-mm-dd):", "Fecha vencimiento", JOptionPane.PLAIN_MESSAGE);
//                                                        try {
//                                                            fechaVencimiento = LocalDate.parse(fechaVencimientoText);
//                                                        } catch (DateTimeParseException dtpe) {
//                                                            JOptionPane.showMessageDialog(null, "Error en el formato de la fecha, intentalo de nuevo", "Error fecha", JOptionPane.WARNING_MESSAGE);
//                                                            verificarFormato = !verificarFormato;
//                                                        }
//                                                    } while (!verificarFormato);
//                                                    do {
//                                                        verificarFormato = true;
//
//
//                                                        CVVText = JOptionPane.showInputDialog(null, "Introduce el CVV:", "CVV", JOptionPane.PLAIN_MESSAGE);
//                                                        try {
//                                                            CVV = Integer.parseInt(CVVText);
//                                                        } catch (NumberFormatException nfe) {
//                                                            JOptionPane.showMessageDialog(null, "Error en el formato del CVV, intentalo de nuevo", "Error CVV", JOptionPane.WARNING_MESSAGE);
//                                                            verificarFormato = !verificarFormato;
//                                                        }
//
//                                                    } while (!verificarFormato);
//                                                    if (controladorMaquina.comprarArticulo(clientePulsaBoton, null, numeroTarjeta, fechaVencimiento, CVV)) {
//                                                        JOptionPane.showMessageDialog(null, "Producto correctamente pagado, su producto se encuentra en el deposito. Recogelo!");
//                                                        LogsDatos.tablaProductos(productosSextaBandeja);
//                                                    } else {
//                                                        JOptionPane.showMessageDialog(null, "Error en la compra, su tarjeta no coinciden", "Error tarjeta", JOptionPane.WARNING_MESSAGE);
//                                                        JOptionPane.showMessageDialog(null, "Saliendo de la pasarela intruso!", "Error tarjeta", JOptionPane.WARNING_MESSAGE);
//
//                                                    }
//                                                    break;
//                                            }
//                                        }
//                                        break;
//                                }
//                            }
//                        } else {
//                            JOptionPane.showMessageDialog(null, "No hay stock", "No stock", JOptionPane.WARNING_MESSAGE);
//                        }
//                    } else {
//                        JOptionPane.showMessageDialog(null, "Ese producto no existe, intentalo de nuevo", "Error de producto", JOptionPane.ERROR_MESSAGE);
//                    }
//
//                }
//            }
//        } while (clientePulsaBoton != null);
//    }
//
//    private static int devolverIndiceMonedaUsada(double dineroSeleccionado) {
//        int indice = 0;
//        dineroSeleccionado= dineroSeleccionado*100;
//        int dinero= (int)dineroSeleccionado;
//        switch (dinero) {
//            case 1:
//                indice = 0;
//                break;
//            case 2:
//                indice = 1;
//                break;
//            case 5:
//                indice = 2;
//                break;
//            case 10:
//                indice = 3;
//                break;
//            case 20:
//                indice = 4;
//                break;
//            case 50:
//                indice = 5;
//                break;
//            case 100:
//                indice = 6;
//                break;
//            case 200:
//                indice = 7;
//                break;
//            case 500:
//                indice = 8;
//                break;
//            case 1000:
//                indice = 9;
//                break;
//            case 2000:
//                indice = 10;
//                break;
//            default:
//                indice=-1;
//                break;
//        }
//        return indice;
//    }
//}
