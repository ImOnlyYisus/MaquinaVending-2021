package maquina;

//UTILIDAD PARA GENERAR RANDOMS
import org.apache.commons.lang3.RandomStringUtils;

public class Productos {
    private String nombreProducto;
    //COD_PRODUCTO --> EJEMPLO 000, 021, 542...
    private final String COD_PRODUCTO = RandomStringUtils.randomNumeric(3); //Esto podría introducirse al crear el producto
    private double precio = 2.5; //PRECIO POR DEFECTO 2,5€
    private int stock;

    //CONSTRUCTOR PARAMETRIZADO CON (nombre producto, precio y stock)
    public Productos(String nombreProducto, double precio, int stock) {
        this.nombreProducto = nombreProducto;
        this.precio = precio;
        this.stock = stock;
    }

    //CONSTRUCTOR PARAMETRIZADO SOLO CON EL NOMBRE, EL STOCK SE ESTABLECE A 0 Y EL PRECIO SE DEJA EN UN MINIMO QUE SON 2,5€
    public Productos(String nombreProducto) {
        this.nombreProducto = nombreProducto;

    }
}
