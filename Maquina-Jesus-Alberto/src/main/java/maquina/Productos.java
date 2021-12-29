package maquina;

//UTILIDAD PARA GENERAR RANDOMS
import org.apache.commons.lang3.RandomStringUtils;

public class Productos {
    private String nombreProducto;
    //COD_PRODUCTO --> EJEMPLO 000, 021, 542...
    private String codProducto = RandomStringUtils.randomNumeric(3); //Esto podría introducirse al crear el producto
    private double precio = 2.5; //PRECIO POR DEFECTO 2,5€
    private int stock;

    //CONSTRUCTOR PARAMETRIZADO CON (nombre producto, cod producto, precio y stock)
    public Productos(String nombreProducto, String codProducto, double precio, int stock) {
        this.nombreProducto = nombreProducto;
        this.codProducto = codProducto;
        this.precio = precio;
        this.stock = stock;
    }

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

    //GETTERS AND SETTERS
    //-- NOMBRE PRODUCTO --
    public String getNombreProducto() {
        return nombreProducto;
    }

    public void setNombreProducto(String nombreProducto) {
        this.nombreProducto = nombreProducto;
    }

    //-- COD_PRODUCTO --
    public String getCodProducto() {
        return codProducto;
    }

    public void setCodProducto(String codProducto) {
        this.codProducto = codProducto;
    }

    //-- PRECIO --
    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    //-- STOCK --
    public int getStock() {
        return stock;
    }

    public void setStock(int stock) {
        this.stock = stock;
    }

    //TO STRING
    @Override
    public String toString() {
        return "Productos{" +
                "nombreProducto='" + nombreProducto + '\'' +
                ", codProducto='" + codProducto + '\'' +
                ", precio=" + precio +
                ", stock=" + stock +
                '}';
    }
}
