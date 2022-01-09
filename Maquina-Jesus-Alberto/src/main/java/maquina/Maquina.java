package maquina;

import org.apache.commons.lang3.RandomStringUtils;

import java.time.LocalDate;
import java.util.UUID;

public class Maquina {

    //ATRIBUTOS CLASE MAQUINA
    private final String CODIGO_MAQUINA = UUID.randomUUID().toString(); //CODIGO IDENTIFICATIVO DE LA MAQUINA
    private Bandejas[] arrayBandejas;

    private String direccion;
    //private final int numeroBandejas = arrayBandejas.length;
    private Monedero monedero;

    //Tarjetas guardadas
    private final String[] numeroTarjeta = new String[]{"1111222233334444","2222111144445555","3333222211110000"};
    private final LocalDate[] fechaVencimientoTarjeta= new LocalDate[]{
            LocalDate.of(2024,04,15),
            LocalDate.of(2023,01,05),
            LocalDate.of(2022,10,13)
    };
    private final int[] CVVTarjeta= new int[]{111,222,333};

    //Constructor de prueba versión plus, necesita arreglos
    public Maquina(Bandejas[] arrayBandejas, String direccion, Monedero monedero) {
        if (arrayBandejas.length <= 20 && arrayBandejas.length >= 6) {
            this.arrayBandejas = arrayBandejas;
        } else {
            throw new IllegalArgumentException("HAS INTRODUCIDO UN NUMERO ERRONEO DE BANDEJAS, SON MINIMO 6 MAXIMO 20");
        }
        this.direccion = direccion;
        this.monedero = monedero;
    }

    //METODOS
    //METODO QUE DEVUELVE EL CODIGO DE PRODUCTO Y SU BANDEJA UNIFICANDOLO EN UNO SOLO
    public String[] codigoProducto() {
        String[] codFinal = new String[numeroProductosMaquina()];
        int contadorProductos = 0;
        for (int i = 0; i < arrayBandejas.length; i++) {
            String[] codBandeja = new String[arrayBandejas.length];
            codBandeja[i] = arrayBandejas[i].getCodBandeja();

            for (int z = 0; z < arrayBandejas[i].getArrayProductos().length; z++) {

                codFinal[contadorProductos] = "" + codBandeja[i] + arrayBandejas[i].getArrayProductos()[z].getCodProducto();
                contadorProductos++;
            }
        }
        return codFinal;
    }

    //Metodo que devuelve el string con el nombre y el codigo para mostrarlo en JOPTION
    public String codNombreProducto() {
        String productos="";
        for(int i=0; i < getArrayBandejas().length; i++){
            for (int z=0; z<getArrayBandejas()[i].getArrayProductos().length; z++){
                productos+="■ "+getArrayBandejas()[i].getArrayProductos()[z].getNombreProducto()+"["+
                        getArrayBandejas()[i].getCodBandeja()+getArrayBandejas()[i].getArrayProductos()[z].getCodProducto()+"]\t\t";
            }
            productos+="\n\n";
        }
        return productos;
    }

    //Metodo que devuelve en forma de array los codigos de la bandejas
    public String[] codBandeja(){
       String[] codBandeja= new String[this.getArrayBandejas().length];
       for(int i=0; i<this.getArrayBandejas().length; i++){
           codBandeja[i]= this.getArrayBandejas()[i].getCodBandeja();
       }
       return codBandeja;
    }

    //METODO PARA VER CUANTOS PRODUCTOS TOTALES CONTIENE LA MAQUINA
    public int numeroProductosMaquina() {
        int contadorProductos = 0;
        for (int i = 0; i < arrayBandejas.length; i++) {
            for (int z = 0; z < arrayBandejas[i].getArrayProductos().length; z++) {
                contadorProductos++;
            }
        }

        return contadorProductos;
    }

    //METODO PARA VER CUANTAS BANDEJAS TIENE EN TOTAL
    public int numeroBandejasMaquina(){
        return arrayBandejas.length;
    }

    //Getters y Setters
    public String getCODIGO_MAQUINA() {
        return CODIGO_MAQUINA;
    }

    public Bandejas[] getArrayBandejas() {
        return arrayBandejas;
    }

    public String getDireccion() {
        return direccion;
    }

    public Monedero getMonedero() {
        return monedero;
    }

    public String[] getNumeroTarjeta() {
        return numeroTarjeta;
    }

    public LocalDate[] getFechaVencimientoTarjeta() {
        return fechaVencimientoTarjeta;
    }

    public int[] getCVVTarjeta() {
        return CVVTarjeta;
    }

    public void setArrayBandejas(Bandejas[] arrayBandejas) {
         if (arrayBandejas.length <= 20 && arrayBandejas.length >= 6) {
            this.arrayBandejas = arrayBandejas;
        } else {
            throw new IllegalArgumentException("HAS INTRODUCIDO UN NUMERO ERRONEO DE BANDEJAS, SON MINIMO 6 MAXIMO 20");
        }
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public void setMonedero(Monedero monedero) {
        this.monedero = monedero;
    }


    @Override
    public String toString() {
        return "Maquina{" + "CODIGO_MAQUINA=" + CODIGO_MAQUINA + ", arrayBandejas=" + arrayBandejas + ", direccion=" + direccion + ", monedero=" + monedero + ", numeroTarjeta=" + numeroTarjeta + ", fechaVencimientoTarjeta=" + fechaVencimientoTarjeta + ", CVVTarjeta=" + CVVTarjeta + '}';
    }

    

}
