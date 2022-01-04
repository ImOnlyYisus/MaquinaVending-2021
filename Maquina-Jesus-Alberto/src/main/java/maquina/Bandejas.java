package maquina;

//UTILIDAD PARA GENERAR RANDOMS
import org.apache.commons.lang3.RandomStringUtils;

import java.util.Arrays;

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
            throw new IllegalArgumentException("Debes de introducir de 1 a 6 tipos de productos"); //EXCEPCION QUE SALTA
        }
    }

    //GETTERS
    //-- COD BANDEJA --
    public String getCodBandeja() {
        return codBandeja;
    }

    //-- ARRAY PRODUCTOS
    public Productos[] getArrayProductos() {
        return arrayProductos;
    }

    public void setArrayProductos(Productos[] arrayProductos) throws Exception {
        //MAXIMO 6 TIPOS DE PRODUCTOS EN UNA BANDEJA Y MINIMO 1
        if(arrayProductos.length<=6 && arrayProductos.length>0) {
            this.arrayProductos = arrayProductos;
        } else{
            throw new IllegalArgumentException("Debes de introducir de 1 a 6 tipos de productos"); //EXCEPCION QUE SALTA
        }
    }

    //METODOS
    //METODO EL CUAL PASAS UN PRODUCTO Y LO INCORPORAS EN LA POSICIÓN INTRODUCIDA
    public void setProducto(Productos producto, int indice) throws Exception {
        //Tiene que ser el indice mayor o igual a 0, y dentro del rango de la longitud del array
        if(indice<=this.arrayProductos.length && indice>=0){
            this.arrayProductos[indice] = producto;
        } else{
            throw new IllegalArgumentException("No se encuentra el indice"); //EXCEPCION QUE SALTA
        }
    }

    //TO STRING

    @Override
    public String toString() {
        return "Bandejas{" +
                "arrayProductos=" + Arrays.toString(arrayProductos) +
                ", codBandeja='" + codBandeja + '\'' +
                '}';
    }
}
