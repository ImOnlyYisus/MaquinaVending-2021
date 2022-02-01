package proyecto.jesusalberto.maquina;

import javax.swing.*;

public class ApoyoMain {

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

}
