package maquina;

import java.time.LocalDate;
import java.util.UUID;

public class Maquina {

    //ATRIBUTOS CLASE MAQUINA
    private final String CODIGO_MAQUINA = UUID.randomUUID().toString(); //CODIGO IDENTIFICATIVO DE LA MAQUINA
    private Bandejas[] arrayBandejas;

    //Posibles atributos
    private String direccion;
    private final int numeroBandejas = arrayBandejas.length;
    private Monedero monedero;
    private boolean depositoMaquina;
    private int numeroTarjeta[];
    private LocalDate fechaVencimientoTarjeta[];
    private int CVVTarjeta[];

    //Constructor de prueba version plus, necesita arreglos
    public Maquina(Bandejas[] arrayBandejas, String direccion, Monedero monedero, boolean depositoMaquina, int[] numeroTarjeta, LocalDate[] fechaVencimientoTarjeta, int[] CVVTarjeta) {
        if (arrayBandejas.length <= 20 && arrayBandejas.length >= 6) {
            this.arrayBandejas = arrayBandejas;
        } else {
            throw new IllegalArgumentException("HAS INTRODUCIDO UN NUMERO ERRONEO DE BANDEJAS, SON MINIMO 6 MAXIMO 20");
        }
        this.direccion = direccion;
        this.monedero = monedero;
        this.depositoMaquina = depositoMaquina;
        this.numeroTarjeta = numeroTarjeta;
        this.fechaVencimientoTarjeta = fechaVencimientoTarjeta;
        this.CVVTarjeta = CVVTarjeta;
    }

    //CONSTRUCTOR DE PRUEBA (FALTAN MUCHOS ATRIBUTOS)
    public Maquina(Bandejas[] arrayBandejas) {
        if (arrayBandejas.length <= 20 && arrayBandejas.length >= 6) {
            this.arrayBandejas = arrayBandejas;
        } else {
            throw new IllegalArgumentException("HAS INTRODUCIDO UN NUMERO ERRONEO DE BANDEJAS, SON MINIMO 6 MAXIMO 20");
        }

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

    public int getNumeroBandejas() {
        return numeroBandejas;
    }

    public Monedero getMonedero() {
        return monedero;
    }

    public boolean isDepositoMaquina() {
        return depositoMaquina;
    }

    public int[] getNumeroTarjeta() {
        return numeroTarjeta;
    }

    public LocalDate[] getFechaVencimientoTarjeta() {
        return fechaVencimientoTarjeta;
    }

    public int[] getCVVTarjeta() {
        return CVVTarjeta;
    }

    public void setArrayBandejas(Bandejas[] arrayBandejas) {
        this.arrayBandejas = arrayBandejas;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public void setMonedero(Monedero monedero) {
        this.monedero = monedero;
    }

    public void setDepositoMaquina(boolean depositoMaquina) {
        this.depositoMaquina = depositoMaquina;
    }

    public void setNumeroTarjeta(int[] numeroTarjeta) {
        this.numeroTarjeta = numeroTarjeta;
    }

    public void setFechaVencimientoTarjeta(LocalDate[] fechaVencimientoTarjeta) {
        this.fechaVencimientoTarjeta = fechaVencimientoTarjeta;
    }

    public void setCVVTarjeta(int[] CVVTarjeta) {
        this.CVVTarjeta = CVVTarjeta;
    }

    @Override
    public String toString() {
        return "Maquina{" + "CODIGO_MAQUINA=" + CODIGO_MAQUINA + ", arrayBandejas=" + arrayBandejas + ", direccion=" + direccion + ", numeroBandejas=" + numeroBandejas + ", monedero=" + monedero + ", depositoMaquina=" + depositoMaquina + ", numeroTarjeta=" + numeroTarjeta + ", fechaVencimientoTarjeta=" + fechaVencimientoTarjeta + ", CVVTarjeta=" + CVVTarjeta + '}';
    }

}
