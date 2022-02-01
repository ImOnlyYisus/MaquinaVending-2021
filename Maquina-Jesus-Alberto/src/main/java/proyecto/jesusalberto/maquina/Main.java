package proyecto.jesusalberto.maquina;

import javax.swing.*;
import java.time.LocalDate;
import java.time.format.DateTimeParseException;
import java.util.Arrays;

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
                                    ApoyoMain.mostrarCodigoBandeja(maquina, controladorMaquina);

                                    break;

                                case "Modificar codigo bandeja": //Muestra un menu para seleccionar el codigo que queremos modificar y posteriormente nos da la opcion de introducir uno nuevo
                                    ApoyoMain.modificarCodigoBandeja(maquina, controladorMaquina);
                                    break;

                                case "Ver productos bandeja": //Muestra un menu para poder seleccionar la bandeja y ver sus diferentes productos
                                    ApoyoMain.modificarCodigoBandeja(maquina, controladorMaquina);
                                    break;

                                case "Modificar productos bandeja": //Cambia un producto por otro nuevo, pide nombre, stock y precio
                                    ApoyoMain.modificarProductosBandeja(maquina, controladorMaquina);
                                    break;

                                case "Ver stock de producto": //Muestra una lista con todos los productos, te deja elegir y seleccionas un producto para ver el stock
                                    ApoyoMain.verStockProducto(maquina,controladorMaquina);
                                    break;

                                case "Modificar stock de producto": //Muestra una lista con todos los productos y permite seleccionar, luego introduces el nuevo stock y se cambia
                                    ApoyoMain.modificarStockProducto(maquina,controladorMaquina);
                                    break;

                                case "Ver ganancias": //Muestra las monedas y billetes de la maquina junto a su dinero total
                                    ApoyoMain.verGanancias(maquina);
                                    break;

                                case "Recaudar dinero": //Permite recaudar el dinero, y muestra el resultado
                                    ApoyoMain.verGanancias(maquina);
                                    break;

                                case "Añadir monedas cambio":
                                    ApoyoMain.añadirMonedasCambio(maquina);
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




}
