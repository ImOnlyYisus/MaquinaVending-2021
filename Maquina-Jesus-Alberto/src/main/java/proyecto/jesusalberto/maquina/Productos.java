package proyecto.jesusalberto.maquina;

import org.apache.commons.lang3.RandomStringUtils;

public class Productos {

    //VARIABLES
    private String nombreProducto;
    //El codigo de producto estara compuesto por tres digitos que se generaran de forma aleatoria con la clase RandomStringUtils.randomNumeric(). 
    //Ej: 000, 021, 542...
    private String codProducto = RandomStringUtils.randomNumeric(3);

    //El precio por defecto es de 2,5€, es un entero para que no haya perdida de datos con double por la persitencia de datos
    private int precio = 25;

    private int stock;

    //MÉTODOS

    //Constructor parametrizado (nombre producto, cod producto, precio y stock)
    public Productos(String nombreProducto, String codProducto, int precio, int stock) {
        this.nombreProducto = nombreProducto;
        this.codProducto = codProducto;

        //El precio tiene que se mayor a 0
        if (precio > 0) {
            this.precio = precio;
        }

        //El stock tiene que ser positivo
        if (stock >= 0) {
            this.stock = stock;
        }
    }

    //Constructor parametrizado con (nombre producto, precio y stock)
    public Productos(String nombreProducto, int precio, int stock) {
        this.nombreProducto = nombreProducto;

        //Mismas restricciones que en el primer constructor
        if (precio > 0) {
            this.precio = precio;
        }

        if (stock >= 0) {
            this.stock = stock;
        }
    }

    //Constructor parametrizado solo con el nombre del producto, el stock se establece a 0 y el precio se dejo por defecto como precio minimo 2,5€
    public Productos(String nombreProducto) {
        this.nombreProducto = nombreProducto;

    }

    //Getters y setters
    public String getNombreProducto() {
        return nombreProducto;
    }

    public void setNombreProducto(String nombreProducto) {
        this.nombreProducto = nombreProducto;
    }

    public String getCodProducto() {
        return codProducto;
    }

    public void setCodProducto(String codProducto) {
        this.codProducto = codProducto;
    }

    //Los setters de precio y stock cumpliran con las rectricciones del constructor parametrizado
    public int getPrecio() {
        return precio;
    }

    public void setPrecio(int precio) {

        if (precio > 0) {
            this.precio = precio;
        }
    }

    public int getStock() {
        return stock;
    }

    public void setStock(int stock) {

        if (stock >= 0) {
            this.stock = stock;
        }
    }

    //toString
    @Override
    public String toString() {
        return "Productos{"
                + "nombreProducto='" + nombreProducto + '\''
                + ", codProducto='" + codProducto + '\''
                + ", precio=" + precio
                + ", stock=" + stock
                + '}';
    }
}
