package maquina;

import java.util.UUID;

public class Maquina {
    //ATRIBUTOS CLASE MAQUINA
    private final String CODIGO_MAQUINA = UUID.randomUUID().toString(); //CODIGO IDENTIFICATIVO DE LA MAQUINA
    private Bandejas[] arrayBandejas;

    //CONSTRUCTOR DE PRUEBA (FALTAN MUCHOS ATRIBUTOS)
    public Maquina(Bandejas[] arrayBandejas) {
        if(arrayBandejas.length<=20 && arrayBandejas.length>=6){
            this.arrayBandejas = arrayBandejas;
        } else{
            throw new IllegalArgumentException("HAS INTRODUCIDO UN NUMERO ERRONEO DE BADEJAS, SON MINIMO 6 MAXIMO 20");
        }

    }

    //METODOS
    //METODO QUE DEVUELVE EL CODIGO DE PRODUCTO Y SU BANDEJA UNIFICANDOLO EN UNO SOLO
    public String[] codigoProducto(){
        String[] codFinal = new String[numeroProductosMaquina()];
        int contadorProductos=0;
        for(int i = 0; i<arrayBandejas.length; i++) {
            String[] codBandeja = new String[arrayBandejas.length];
            codBandeja[i] = arrayBandejas[i].getCodBandeja();

            for (int z = 0; z < arrayBandejas[i].getArrayProductos().length; z++) {

                codFinal[contadorProductos] ="" + codBandeja[i]+ arrayBandejas[i].getArrayProductos()[z].getCodProducto();
                contadorProductos++;
            }
        }
        return codFinal;
    }

    //METODO PARA VER CUANTOS PRODUCTOS TOTALES CONTIENE LA MAQUINA
    public int numeroProductosMaquina(){
        int contadorProductos = 0;
        for(int i= 0; i<arrayBandejas.length; i++){
            for(int z=0; z<arrayBandejas[i].getArrayProductos().length ; z++){
                contadorProductos++;
            }
        }

        return contadorProductos;
    }



}
