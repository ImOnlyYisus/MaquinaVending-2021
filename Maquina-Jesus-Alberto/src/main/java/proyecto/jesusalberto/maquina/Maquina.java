package proyecto.jesusalberto.maquina;

import java.time.LocalDate;
import java.util.UUID;

public class Maquina {

    //VARIABLES
    //El codigo identificativo de la maquina usando, para ello se usa el método UUID.randomUUID().ToString()
    //Es un método proporcionado por javaJDK para generar automáticamente una clave primaria UUID(Identificador universal único) 
    private final String CODIGO_MAQUINA = UUID.randomUUID().toString();
    //Array de Bandejas
    private Bandejas[] arrayBandejas;

    private String direccion;
    //Se utilizara la clase Monedero
    private Monedero monedero;
    private int dineroTarjetas = 420;

    //Tarjetas guardadas, con sus correspondientes numeros y fecha de vencimiento usando arrays
    private final String[] numeroTarjeta = new String[]{"1111222233334444", "2222111144445555", "3333222211110000"};
    //Array de tipo Localdate que almaecenara las fechas de vencimiento
    private final LocalDate[] fechaVencimientoTarjeta = new LocalDate[]{
        LocalDate.of(2024, 04, 15),
        LocalDate.of(2023, 01, 05),
        LocalDate.of(2022, 10, 13)
    };
    //Array tipo int que almacenara el código de seguridad de las tarjetas de crédito, normalmente son de 3 digitos
    private final int[] CVVTarjeta = new int[]{111, 222, 333};

    //Constructor parametrizado que se le pasaa un array de bandejas, la direción y un monedero
    public Maquina(Bandejas[] arrayBandejas, String direccion, Monedero monedero) {
        //El maximo de bandejas es de 20 y el minimo de 6
        if (arrayBandejas.length <= 20 && arrayBandejas.length >= 6) {
            this.arrayBandejas = arrayBandejas;
        } else {
            //Salta una excepción de tipo IllegalArgumentException
            throw new IllegalArgumentException("HAS INTRODUCIDO UN NUMERO ERRONEO DE BANDEJAS, SON MINIMO 6 MAXIMO 20");
        }
        this.direccion = direccion;
        this.monedero = monedero;
    }

    //METODOS
    //Método que devuelve el codigo del producto y su bandeja unificandolo
    public String[] codigoProducto() {
        //Se crea un array de String inicializandolo con el numero de prodcutos obtenidos con el método numeroProductosMaquina()
        String[] codFinal = new String[numeroProductosMaquina()];
        int contadorProductos = 0;
        //For anidado que recorre el array de bandejas y productos
        for (int i = 0; i < arrayBandejas.length; i++) {
            //Se cre un array de String con el tamaño del array de bandejas
            String[] codBandeja = new String[arrayBandejas.length];
            //Se almacena el codigo de la bandeja
            codBandeja[i] = arrayBandejas[i].getCodBandeja();

            //Se recorre el array de productos accediento a traves de cada una de las bandejas
            for (int z = 0; z < arrayBandejas[i].getArrayProductos().length; z++) {

                //Ademas de contar el numero de productos, se unificaran el codigo de la bandeja y del producto
                codFinal[contadorProductos] = "" + codBandeja[i] + arrayBandejas[i].getArrayProductos()[z].getCodProducto();
                contadorProductos++;
            }
        }
        return codFinal;
    }

    //Metodo que devuelve el string con el nombre y el codigo para mostrarlo con JOption
    public String codNombreProducto() {
        String productos = "";
        //For anidado que recorrera el array de bandejas y productos para poder mostrarlos con JOption mostrando su nombre, codigo de bandeja y codigo de producto
        //Se aplican tabuladores y saltos de linea para su legibilidad
        for (int i = 0; i < getArrayBandejas().length; i++) {
            for (int z = 0; z < getArrayBandejas()[i].getArrayProductos().length; z++) {

                String nombreProducto = getArrayBandejas()[i].getArrayProductos()[z].getNombreProducto();
                String codigoProducto = getArrayBandejas()[i].getCodBandeja() + getArrayBandejas()[i].getArrayProductos()[z].getCodProducto();
                String precio = "" + getArrayBandejas()[i].getArrayProductos()[z].getPrecio();

                precio = precio.substring(0, precio.length() - 2) + "," + precio.substring(precio.length() - 2, precio.length());
                productos += " " + nombreProducto + "[" + codigoProducto + "] " + precio + "€\t\t";
            }
            productos += "\n\n";
        }
        return productos;
    }

    //Metodo que devuelve en forma de array los codigos de las bandejas
    public String[] codBandeja() {
        //Se crea un array de String inicializandolo con el tamaño de la bandejas
        String[] codBandeja = new String[this.getArrayBandejas().length];
        //Se recorre el array de bandejas y se obtiene el codigo de cada una de ellas
        for (int i = 0; i < this.getArrayBandejas().length; i++) {
            codBandeja[i] = this.getArrayBandejas()[i].getCodBandeja();
        }
        return codBandeja;
    }

    //Método para ver cuantos productos totales contiene la maquina
    public int numeroProductosMaquina() {
        int contadorProductos = 0;
        //Se hace un for anidado para poder acceder a los productos de cada una de las bandejas
        for (int i = 0; i < arrayBandejas.length; i++) {
            for (int z = 0; z < arrayBandejas[i].getArrayProductos().length; z++) {
                contadorProductos++;
            }
        }

        return contadorProductos;
    }

    //Método que devuelve el numero total de bandejas 
    public int numeroBandejasMaquina() {
        return arrayBandejas.length;
    }

    //Metodo para añadir dinero cuando compras con tarjeta
    public void recaudarTarjeta(int dinero) {
        dineroTarjetas += dinero;
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

    public int getDineroTarjetas() {
        return dineroTarjetas;
    }

    //Se cumpliran las mismas restricciones que en el constructor
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

    //toString
    @Override
    public String toString() {
        return "Maquina{" + "CODIGO_MAQUINA=" + CODIGO_MAQUINA + ", arrayBandejas=" + arrayBandejas + ", direccion=" + direccion + ", monedero=" + monedero + ", numeroTarjeta=" + numeroTarjeta + ", fechaVencimientoTarjeta=" + fechaVencimientoTarjeta + ", CVVTarjeta=" + CVVTarjeta + '}';
    }

}
