package maquina;

import org.apache.commons.lang3.RandomStringUtils;

import javax.swing.*;
import java.time.LocalDate;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) throws Exception {

        Scanner teclado = new Scanner(System.in);
        //Objetos
        Productos[] productosPrimeraBandeja = {
            new Productos("Monster", 2.50, 10),
            new Productos("Cocacola", 2.65, 11),
            new Productos("Fanta", 2.10, 9),
            new Productos("Nestea", 2.00, 10),
            new Productos("Agua", 1.65, 11)
        };

        Productos[] productosSegundaBandeja = {
            new Productos("Lays Sal", 3.65, 8),
            new Productos("Ruffles Jamon", 4.00, 10),
            new Productos("Lays campesinas", 3.70, 9),
            new Productos("Cheetos", 2.98, 10)
        };

        Productos[] productosTerceraBandeja = {
            new Productos("Nestle Blanco", 5.6, 8),
            new Productos("Nestle Negro", 5.6, 11),
            new Productos("Carbury Blanco", 4.4, 9),
            new Productos("Carbury Negro", 4.4, 6),
            new Productos("Jungly", 6.6, 8)
        };

        Productos[] productosCuartaBandeja = {
            new Productos("Manzana", 2.6, 10),
            new Productos("Pera", 3, 8),
            new Productos("Platano", 2.65, 9),
            new Productos("Fresas", 3.4, 10),
            new Productos("Naranja", 2.5, 7)
        };

        Productos[] productosQuintaBandeja = {
            new Productos("Manzana", 2.6, 6),
            new Productos("Pera", 3, 11),
            new Productos("Platano", 2.65, 9),
            new Productos("Fresas", 3.4, 1),
            new Productos("Naranja", 2.5, 1)
        };

        Productos[] productosSextaBandeja = {
            new Productos("Crema Aloe", 6.5, 5),
            new Productos("Crema Nivea", 4.8, 4),
            new Productos("Preservativos Durex", 4.2, 8),
            new Productos("Jueguete femenino", 15.7, 4),
            new Productos("Jueguete masculino", 15.7, 4)
        };

        Bandejas[] bandejasArray = new Bandejas[6];
        try {
            bandejasArray[0] = new Bandejas(productosPrimeraBandeja);
            bandejasArray[1] = new Bandejas(productosSegundaBandeja);
            bandejasArray[2] = new Bandejas(productosTerceraBandeja);
            bandejasArray[3] = new Bandejas(productosCuartaBandeja);
            bandejasArray[4] = new Bandejas(productosQuintaBandeja);
            bandejasArray[5] = new Bandejas(productosSextaBandeja);
        } catch (IllegalArgumentException iae) {
            System.out.println(iae);
        }

        Monedero monederoMaquina = new Monedero();

        Maquina maquina = null;

        try {
            maquina = new Maquina(bandejasArray, "Parking x", monederoMaquina);
        } catch (IllegalArgumentException iae) {
            System.out.println(iae);
        }

        Controlador controladorMaquina = new Controlador(maquina);
        //-----------------------------------------------
        //VARIABLES
        JTextArea textArea = new JTextArea("Monedas 0.01€-->"+ maquina.getMonedero().getContadorMonedasUnCentimo()+"\n"+
                "Monedas 0.02€-->"+ maquina.getMonedero().getContadorMonedasDosCentimos()+"\n"+
                "Monedas 0.05€-->"+ maquina.getMonedero().getContadorMonedasCincoCentimos()+"\n"+
                "Monedas 0.10€-->"+ maquina.getMonedero().getContadorMonedasDiezCentimos()+"\n"+
                "Monedas 0.20€-->"+ maquina.getMonedero().getContadorMonedasVeinteCentimos()+"\n"+
                "Monedas 0.50€-->"+ maquina.getMonedero().getContadorMonedasCincuentaCentimos()+"\n"+
                "Monedas 1.00€-->"+ maquina.getMonedero().getContadorMonedasUnEuro()+"\n"+
                "Monedas 2.00€-->"+ maquina.getMonedero().getContadorMonedasUnEuro()+"\n"+
                "Billetes 5.00€-->"+ maquina.getMonedero().getContadorBilletesCincoEuros()+"\n"+
                "Billetes 10.0€-->"+ maquina.getMonedero().getContadorBilletesDiezEuros()+"\n"+
                "Billetes 20.0€-->"+ maquina.getMonedero().getContadorBilletesVeinteEuros()+"\n\n"+
                "Dinero total:"+maquina.getMonedero().getDineroTotal()
        );

        String[] botonesAdmin= {"Mostrar codigo bandeja",
                "Modificar codigo bandeja",
                "Ver productos bandeja",
                "Modificar productos bandeja",
                "Ver stock de producto",
                "Modificar stock de producto",
                "Ver ganancias",
                "Recaudar dinero"
        };

        Object productosParaSeleccionar= null; //Desplegable con productos
        Object bandejaSeleccionar = null; //Desplegable con bandejas
        //----------------------------------------------

        System.out.println(controladorMaquina.getCOD_ADMIN());
        String clientePulsaBoton = JOptionPane.showInputDialog(null, new JTextArea(maquina.codNombreProducto()));

        //Se comprueba si la contraseña es para ser administrador o no
        if (controladorMaquina.comprobarCodigoAdmin(clientePulsaBoton)) { //El codigo de administrador es correcto, pasa al menú
            Object optAdmin= JOptionPane.showInputDialog(null,"Elige una opción Sr.Admin", "MENU ADMIN",JOptionPane.QUESTION_MESSAGE,null,botonesAdmin,botonesAdmin[0]);

            if(optAdmin!=null){ //Si no pulsa la x para salir
                switch (optAdmin.toString()) {
                    case "Mostrar codigo bandeja": //Muestra el codigo de la bandeja con un desplegable para elegir los productos
                        productosParaSeleccionar= JOptionPane.showInputDialog(null,new JTextArea(maquina.codNombreProducto()), "Show CodBandeja",JOptionPane.QUESTION_MESSAGE,null,
                                maquina.codigoProducto(),maquina.codigoProducto()[0]);

                        JOptionPane.showMessageDialog(null, controladorMaquina.mostrarCodigoBandeja(productosParaSeleccionar.toString()));
                        break;

                    case "Modificar codigo bandeja": //Muestra un menu para seleccionar el codigo que queremos modificar y posteriormente nos da la opcion de introducir uno nuevo
                        bandejaSeleccionar= JOptionPane.showInputDialog(null,new JTextArea(maquina.codNombreProducto()), "Mod CodBandeja",JOptionPane.QUESTION_MESSAGE,null,
                                maquina.codBandeja(),maquina.codBandeja()[0]);
                        String nuevoCod= JOptionPane.showInputDialog(null, "Introduce un nuevo codigo de tres letras:","Modificacion cod Bandeja", JOptionPane.INFORMATION_MESSAGE);

                        if(nuevoCod!=null){
                            controladorMaquina.modificarCodBandeja(bandejaSeleccionar.toString(),nuevoCod);
                        }
                        break;

                    case "Ver productos bandeja": //Muestra un menu para poder seleccionar la bandeja y ver sus diferentes productos
                        bandejaSeleccionar= JOptionPane.showInputDialog(null,"De que bandeja quieres ver sus productos", "Show Productos Bandeja",JOptionPane.QUESTION_MESSAGE,null,
                                maquina.codBandeja(),maquina.codBandeja()[0]);
                        JOptionPane.showMessageDialog(null, controladorMaquina.verProductosBandeja(bandejaSeleccionar.toString()));
                        break;

                    case "Modificar productos bandeja": //Modificar este metodo !!!!!! NO TOCAR
                        break;

                    case "Ver stock de producto": //Muestra una lista con todos los productos, te deja elegir y seleccionas un producto para ver el stock
                        productosParaSeleccionar= JOptionPane.showInputDialog(null,new JTextArea(maquina.codNombreProducto()), "Ver Stock Producto",JOptionPane.QUESTION_MESSAGE,null,
                                maquina.codigoProducto(),maquina.codigoProducto()[0]);

                        if(productosParaSeleccionar!=null){
                            JOptionPane.showMessageDialog(null, controladorMaquina.verStockProducto(productosParaSeleccionar.toString()));
                        }
                        break;

                    case "Modificar stock de producto": //Muestra una lista con todos los productos y permite seleccionar, luego introduces el nuevo stock y se cambia
                        productosParaSeleccionar= JOptionPane.showInputDialog(null,new JTextArea(maquina.codNombreProducto()), "Mod Stock Producto",JOptionPane.QUESTION_MESSAGE,null,
                                maquina.codigoProducto(),maquina.codigoProducto()[0]);

                        if(productosParaSeleccionar!=null){
                            boolean verificacion= true;
                            do{
                                verificacion=true;
                                try {
                                    String nuevoStockText = JOptionPane.showInputDialog(null, "Introduce un nuevo stock para el producto:","Modificacion stock",JOptionPane.INFORMATION_MESSAGE);
                                    int nuevoStock= Integer.parseInt(nuevoStockText);
                                    controladorMaquina.modificarStockProducto(productosParaSeleccionar.toString(),nuevoStock);
                                }catch(NumberFormatException nfe){
                                    verificacion=false;
                                    JOptionPane.showMessageDialog(null,"Introduce un numero, no un a letra!");
                                }
                            }while(!verificacion);
                        }
                        break;

                    case "Ver ganancias": //Muestra las monedas y billetes de la maquina junto a su dinero total
                        JOptionPane.showMessageDialog(null,textArea,"Ganancias maquina",JOptionPane.INFORMATION_MESSAGE);
                        break;

                    case "Recaudar dinero": //Permite recaudar el dinero, y muestra el resultado
                        int recaudarDinero= JOptionPane.showConfirmDialog(null,"¿Quieres recaudar el dinero?", "Recaudar dinero", JOptionPane.YES_NO_OPTION);
                        if(recaudarDinero==0){
                            controladorMaquina.recaudarDineroGanancias();
                            JOptionPane.showConfirmDialog(null, textArea,"Resultado recaudacion",JOptionPane.DEFAULT_OPTION);
                        }
                        break;

                    default:
                        break;

                }
            }


        } else { //FALTA ESTO
            if(controladorMaquina.comprobarCodigoProducto(clientePulsaBoton)){

            }else{
                JOptionPane.showMessageDialog(null,"Ese producto no existe, intentalo de nuevo","Error de producto",JOptionPane.ERROR_MESSAGE);
            }

        }
    }
}
