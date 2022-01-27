package proyecto.jesusalberto.maquina;

import org.apache.commons.lang3.RandomStringUtils;

import java.util.Arrays;

public class Bandejas {

    //VARIABLES

    //Array de productos
    private Productos[] arrayProductos;
    //El codigo de la bandeja que estara formado por tres letras mayusculas usando la clase RandomStringUtils.randomAlphabetic().toUpperCase().
    //Ej: AGF, WQE, AAA...
    private String codBandeja = RandomStringUtils.randomAlphabetic(3).toUpperCase();

    //MÉTODOS

    //Constructor parametrizado se le pasa un array de productos
    public Bandejas(Productos[] arrayProductos) throws Exception {
        //La bandeja de productos tendra un maximo de 6 y un minimo de un producto
        if (arrayProductos.length <= 6 && arrayProductos.length > 0) {
            this.arrayProductos = arrayProductos;
        } else {
            //Saltaria una excpeción de tipo IllegalArgumentException
            throw new IllegalArgumentException("Debes de introducir de 1 a 6 tipos de productos");
        }
    }

    //Metodo en el cual pasas un producto y su indice como parametro y lo incorportas a la posición introducida
    public void setProducto(Productos producto, int indice) throws Exception {
        //El indice tiene que ser mayor o igual a 0, y dentro del rango de la longitud del array
        if (indice <= this.arrayProductos.length && indice >= 0) {
            this.arrayProductos[indice] = producto;
        } else {
            //Saltaria la excepción
            throw new IllegalArgumentException("No se encuentra el indice");
        }
    }

    //Getters y setters
    public Productos[] getArrayProductos() {
        return arrayProductos;
    }

    public void setArrayProductos(Productos[] arrayProductos) throws Exception {
        //Misma restricción que en el constructor parametrizado
        if (arrayProductos.length <= 6 && arrayProductos.length > 0) {
            this.arrayProductos = arrayProductos;
        } else {
            throw new IllegalArgumentException("Debes de introducir de 1 a 6 tipos de productos");
        }
    }

    public String getCodBandeja() {
        return codBandeja;
    }

    public void setCodBandeja(String codBandeja) {
        this.codBandeja = codBandeja;
    }

    //toString
    @Override
    public String toString() {
        return "Bandejas{"
                + "arrayProductos=" + Arrays.toString(arrayProductos)
                + ", codBandeja='" + codBandeja + '\''
                + '}';
    }
}
