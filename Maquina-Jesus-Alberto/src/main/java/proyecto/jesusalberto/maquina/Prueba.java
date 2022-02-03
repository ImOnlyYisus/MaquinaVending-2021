/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proyecto.jesusalberto.maquina;

import javax.swing.JOptionPane;
import javax.swing.JTextArea;

/**
 *
 * @author GR6
 */
public class Prueba {

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
                                int precioProductoNuevo = (int) (Double.parseDouble(nuevoPrecioProducto) * 100);
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

    //Muestra una lista con todos los productos y permite seleccionar, luego introduces el nuevo stock y se cambia
    public static void modificarStockProducto(Maquina maquina, Controlador controladorMaquina) {
        Object productosParaSeleccionar = null; //Desplegable con productos
        productosParaSeleccionar = JOptionPane.showInputDialog(null, new JTextArea(maquina.codNombreProducto()), "Mod Stock Producto", JOptionPane.QUESTION_MESSAGE, null,
                maquina.codigoProducto(), maquina.codigoProducto()[0]);

        if (productosParaSeleccionar != null) {
            boolean verificacion = true;
            int nuevoStock = 0;
            do {
                do {
                    String nuevoStockText = JOptionPane.showInputDialog(null, "Introduce un nuevo stock para el producto:", "Modificacion stock", JOptionPane.INFORMATION_MESSAGE);
                    verificacion = true;
                    try {

                        //Si el usuario no presiona x o cancelar
                        if (nuevoStockText != null) {
                            //String nuevoStockText = JOptionPane.showInputDialog(null, "Introduce un nuevo stock para el producto:", "Modificacion stock", JOptionPane.INFORMATION_MESSAGE);
                            nuevoStock = Integer.parseInt(nuevoStockText);
                        }

                    } catch (NumberFormatException nfe) {
                        verificacion = false;
                        JOptionPane.showMessageDialog(null, "Introduce un numero, no un a letra!");
                    }
                } while (!verificacion);
                if (nuevoStock > 0 && nuevoStock <= 15) {
                    controladorMaquina.modificarStockProducto(productosParaSeleccionar.toString(), nuevoStock);
                } else {
                    JOptionPane.showMessageDialog(null, "El stock máximo es de 15");
                }

            } while (nuevoStock < 0 || nuevoStock > 15);

        }
    }
}
