package proyecto.jesusalberto.maquina;

import javax.swing.*;

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
                                    ApoyoMain.verStockProducto(maquina, controladorMaquina);
                                    break;

                                case "Modificar stock de producto": //Muestra una lista con todos los productos y permite seleccionar, luego introduces el nuevo stock y se cambia
                                    ApoyoMain.modificarStockProducto(maquina, controladorMaquina);
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
                                        ApoyoMain.mostrarPrecio(controladorMaquina, clientePulsaBoton);
                                        break;
                                    case 1: //CASO DE PASARELA DE PAGO
                                        ApoyoMain.comprarArticulo(controladorMaquina, clientePulsaBoton);
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
