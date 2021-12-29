package maquina;

//UTILIDAD PARA GENERAR RANDOMS
import org.apache.commons.lang3.RandomStringUtils;

import java.util.Locale;

public class Bandejas {
    private Productos[] arrayProductos;
    //COD BANDEJA --> EJEMPLO AGF, WQE, AAA...
    private String codBandeja = RandomStringUtils.randomAlphabetic(3).toUpperCase();

    //CONSTRUCTOR PARAMETRIZADO CON UN ARRAY DE PRODUCTOS
    public Bandejas(Productos[] arrayProductos) throws Exception {
        //MAXIMO 6 TIPOS DE PRODUCTOS EN UNA BANDEJA Y MINIMO 1
        if(arrayProductos.length<=6 && arrayProductos.length>0) {
            this.arrayProductos = arrayProductos;
        } else{
            throw new Exception("Debes de introducir de 1 a 6 tipos de productos"); //EXCEPCION QUE SALTA
        }
    }

    
}
