package maquina;

import org.apache.commons.lang3.RandomStringUtils;

import java.time.LocalDate;

public class Controlador {

    //VARIABLES
    private Maquina maquina;

    //Se generara el codigo de administrador que constara de: (8 digitos, 1 a-z, 1 A-Z, 1 numero del 0-9, 1 "# $ % & ( ) * + , - . : ; < = > @")
    //Para ello se usara la clase RandomStringUtils
    private String COD_ADMIN = (RandomStringUtils.randomAlphabetic(2).toLowerCase())
            + //2 letras minusculas
            (RandomStringUtils.randomAlphabetic(2).toUpperCase())
            + //2 letras mayusculas
            (RandomStringUtils.randomNumeric(2))
            + //2 numeros 0-9
            (RandomStringUtils.random(2, new char[]{'#', '$', '%', '&', '(', ')', '*', '+', ',', '-', '.', ':', ';', '<', '=', '>', '@'})); //Caracteres especiales

    //Constructor parametrizado que se la pasara una maquina
    public Controlador(Maquina maquina) {
        this.maquina = maquina;
    }

    //METODOS
    //METODOS DE ADMINISTRADOR
    //Método para comprobar que el codigo coincide con el del adminstrador
    public boolean comprobarCodigoAdmin(String admin) {
        return (admin.equals(COD_ADMIN));
    }

    //Método para mostrar el codigo de bandeja introduciendo el numero de bandeja que quieres ver
    public String mostrarCodigoBandeja(String codProducto) {
        //Devuelve una subcadena
        return (codProducto.substring(0, 3));
    }

    //Método para modificar el codigo de la bandeja introduciendo el codigo de bandeja que quieres modificar
    public void modificarCodBandeja(String codigoBandejaParaMod, String codBandeja) {

        for (int i = 0; i < this.maquina.getArrayBandejas().length; i++) {

            if (this.maquina.getArrayBandejas()[i].getCodBandeja().equalsIgnoreCase(codigoBandejaParaMod)) {
                //Lo convierte en mayusculas
                codBandeja = codBandeja.toUpperCase();

                //Comprueba que sean 3 de longitud y sean letras
                if (codBandeja.length() == 3 && codBandeja.matches("[A-Z][A-Z][A-Z]")) {
                    this.maquina.getArrayBandejas()[i].setCodBandeja(codBandeja);
                } else {
                    //Salta excepcion de tipo illegalArgument
                    throw new IllegalArgumentException("El codigo de la bandeja debe ser de 3 caracteres");
                }
            }
        }
    }

    //Método para ver los productos de una bandeja especificando el codigo de la bandeja
    public Productos[] verProductosBandeja(String codBandeja) {
        int numeroBandeja = 0;

        for (int i = 0; i < this.maquina.getArrayBandejas().length; i++) {
            if (this.maquina.getArrayBandejas()[i].getCodBandeja().equalsIgnoreCase(codBandeja)) {
                numeroBandeja = i;
            }
        }
        return this.maquina.getArrayBandejas()[numeroBandeja].getArrayProductos();
    }

    //Método para modificar productos de la bandeja especificando el codigo final Ej:(AAA123)
    public void modificarProductosBandeja(String codFinal, Productos productoNuevo) {
        String codProductoParaMod = codFinal.substring(3);
        String codBandejaParaMod = codFinal.substring(0, 3);

        //Se recorre y busca la bandeja que tenga ese codigo
        for (int i = 0; i < this.maquina.getArrayBandejas().length; i++) {
            if (this.maquina.getArrayBandejas()[i].getCodBandeja().equalsIgnoreCase(codBandejaParaMod)) {

                //Recorre el array de productos y Busca el producto para modificar
                for (int z = 0; z < this.maquina.getArrayBandejas()[i].getArrayProductos().length; z++) {
                    if (this.maquina.getArrayBandejas()[i].getArrayProductos()[z].getCodProducto().equalsIgnoreCase(codProductoParaMod)) {

                        //Mofica el producto
                        this.maquina.getArrayBandejas()[i].getArrayProductos()[z] = productoNuevo;
                    }
                }
            }
        }
    }

    //Método para ver el stock del producto introduciendo el codigo de producto final Ej:(AAA123)
    public int verStockProducto(String codProductoFinal) {
        int numeroBandeja = 0;
        int numeroProducto = 0;
        String codProductoParaMod = codProductoFinal.substring(3);
        String codBandejaParaMod = codProductoFinal.substring(0, 3);

        //Busco la bandeja que tenga ese codigo
        for (int i = 0; i < this.maquina.getArrayBandejas().length; i++) {
            if (this.maquina.getArrayBandejas()[i].getCodBandeja().equalsIgnoreCase(codBandejaParaMod)) {
                numeroBandeja = i;
            }
        }
        //Busco el producto para modificar
        for (int z = 0; z < this.maquina.getArrayBandejas()[numeroBandeja].getArrayProductos().length; z++) {
            if (this.maquina.getArrayBandejas()[numeroBandeja].getArrayProductos()[z].getCodProducto().equalsIgnoreCase(codProductoParaMod)) {
                numeroProducto = z;
            }
        }

        return this.maquina.getArrayBandejas()[numeroBandeja].getArrayProductos()[numeroProducto].getStock();
    }

    //Método para modificar el stock del producto introduciendo el codigo del producto final Ej:(AAA123) y el numero de stock nuevo
    public void modificarStockProducto(String codProductoFinal, int stockNuevo) {
        //Controla que en el metodo de cambiar stock no se introduzca ningun numero menor que 0, si eso pasa se convierte en 1
        if (stockNuevo < 0) {
            stockNuevo = 1;
        }

        int numeroBandeja = 0;
        String codProductoParaMod = codProductoFinal.substring(3);
        String codBandejaParaMod = codProductoFinal.substring(0, 3);

        //Busco la bandeja que tenga ese codigo
        for (int i = 0; i < this.maquina.getArrayBandejas().length; i++) {
            if (this.maquina.getArrayBandejas()[i].getCodBandeja().equalsIgnoreCase(codBandejaParaMod)) {
                numeroBandeja = i;
            }
        }
        //Busco el producto para modificar
        for (int z = 0; z < this.maquina.getArrayBandejas()[numeroBandeja].getArrayProductos().length; z++) {
            if (this.maquina.getArrayBandejas()[numeroBandeja].getArrayProductos()[z].getCodProducto().equalsIgnoreCase(codProductoParaMod)) {

                this.maquina.getArrayBandejas()[numeroBandeja].getArrayProductos()[z].setStock(stockNuevo);
            }
        }
    }

    //Metodo que devuelve las ganancias de la maquina
    public double verGananciasMaquina() {
        return this.maquina.getMonedero().getDineroTotal();
    }

    //Método para recaudar las ganancias de la maquina, teniendo en cuenta que se deja siempre por defecto 10 monedas y billetes para poder hacer el cambio
    public void recaudarDineroGanancias() {
        this.maquina.getMonedero().recaudarDinero();
    }

    //MÉTODOS CLIENTE
    //Método para comprobar que el codigo coincide con el de algun producto
    public boolean comprobarCodigoProducto(String codProducto) {
        boolean verificar = true;
        for (int i = 0; i < this.maquina.codigoProducto().length; i++) {
            if (!(this.maquina.codigoProducto()[i].equalsIgnoreCase(codProducto))) {
                verificar = !verificar;
            }
        }
        return verificar;
    }

    //Metodo que devuelve el precio del producto introduciendolo su codigo por parametro
    public int mostrarPrecio(String codigoProducto) {

        int numeroBandejas = 0;
        int numeroProductos = 0;
        String codProductoParaMod = codigoProducto.substring(3);
        String codBandejaParaMod = codigoProducto.substring(0, 3);

        for (int i = 0; i < this.maquina.getArrayBandejas().length; i++) {
            if (this.maquina.getArrayBandejas()[i].getCodBandeja().equalsIgnoreCase(codBandejaParaMod)) {
                numeroBandejas = i;
            }
        }

        for (int z = 0; z < this.maquina.getArrayBandejas()[numeroBandejas].getArrayProductos().length; z++) {
            if (this.maquina.getArrayBandejas()[numeroBandejas].getArrayProductos()[z].getCodProducto().equalsIgnoreCase(codProductoParaMod)) {
                numeroProductos = z;
            }
        }

        return this.maquina.getArrayBandejas()[numeroBandejas].getArrayProductos()[numeroProductos].getPrecio();
    }

    //Método que accede a la clase monedero y devuelve un booleano si hay dinero disponible en el monedero
    public boolean comprobarDineroEfectivo(int dinero) {
        boolean resultado = true;
        Monedero monedero = this.maquina.getMonedero();
        String[] monederoDevolucion = monedero.dineroParaDevolver(dinero);
        if (monederoDevolucion[monederoDevolucion.length - 1].equalsIgnoreCase("-1")) {
            resultado = !resultado;
        }
        return resultado;

    }

    //Metodo que suma el contador de monedas del monedero segun lo que paguen
    public void sumaContadoresDineroCompra(int[] addContadoresMonedas) {
        for (int i = 0; i < this.maquina.getMonedero().getDineroContadores().length; i++) {
            this.maquina.getMonedero().addMonedas(i, addContadoresMonedas[i]);
        }
    }

    //Metodo que te devuelve el cambio introduciendo el dinero como parametro
    public int[] devolucionDinero(int dinero) {
        int[] monedasIntercambio = new int[this.maquina.getMonedero().dineroParaDevolver(dinero).length];
        for (int i = 0; i < monedasIntercambio.length; i++) {
            monedasIntercambio[i] = Integer.parseInt(this.maquina.getMonedero().dineroParaDevolver(dinero)[i]);
        }
        return monedasIntercambio;
    }

    //Método que accede a una tarjeta y muestra su información
    public boolean comprobarTarjeta(String numeroTarjeta, LocalDate fechaVencimiento, int CVV) {
        boolean comprobacion = true;
        //Este metodo comprueba que los diferentes datos como son "Numero tarjeta, CVV y fecha de vencimiento" son iguales a los que tiene la maquina guardados como atributos
        for (int i = 0; i < this.maquina.getNumeroTarjeta().length; i++) {
            if (numeroTarjeta.equalsIgnoreCase(this.maquina.getNumeroTarjeta()[i]) && fechaVencimiento.equals(this.maquina.getFechaVencimientoTarjeta()[i]) && CVV == this.maquina.getCVVTarjeta()[i]) {
                comprobacion = true;
                break;
            } else {
                comprobacion = !comprobacion;
            }
        }
        return comprobacion;

    }

    //Método que devuelve un booleano para comprobar si hay o no stock introduciendo el codigo del producto
    public boolean comprobarStock(String codigoProducto) {
        boolean comprobacion = true;
        //Se comprueba si el stock es negativo
        if (!(verStockProducto(codigoProducto) >= 1)) {
            return comprobacion = false;
        }
        return comprobacion;

    }

    //Método que devuelve un booleano para saber si se ha podido realizar o no la compra de un producto
    //Se pasa como parametro el codigo del producto, un array de los contadores de monedas introducids, el numero de tarjeta, su fecha de vencimiento y codigo de seguridad
    public boolean comprarArticulo(String codigoProducto, int[] contadoresMonedasIntroducidas, String numeroTarjeta, LocalDate fechaVencimiento, int CVV) {
        boolean resultado = true;
        if (codigoProducto != null) {
            if (comprobarStock(codigoProducto)) {
                //Pago en efectivo  
                if (contadoresMonedasIntroducidas != null) {
                    int[] contadoresMonedas = contadoresMonedasIntroducidas;

                    int monedasValores[] = {1, 2, 5, 10, 20, 50, 100, 200, 500, 1000, 2000};
                    int dineroTotal = 0;

                    //Cuenta cuanto dinero se introduce en la maquina en total
                    for (int i = 0; i < contadoresMonedas.length; i++) {
                        dineroTotal += contadoresMonedas[i] * monedasValores[i];
                    }

                    if (comprobarDineroEfectivo((dineroTotal - mostrarPrecio(codigoProducto)))) {
//                        sumaContadoresDineroCompra(contadoresMonedas);
                    } else {
                        resultado = !resultado;
                    }
                    //Pago con tarjeta
                } else if (numeroTarjeta != null && fechaVencimiento != null && CVV != 0) {
                    if (!comprobarTarjeta(numeroTarjeta, fechaVencimiento, CVV)) {
                        resultado = !resultado;

                    } else {
                        //Se resta uno al stock del producto
                        modificarStockProducto(codigoProducto, (verStockProducto(codigoProducto) - 1));
                    }
                } else {
                    resultado = !resultado;
                }
            } else {
                resultado = !resultado;
            }
        } else {
            resultado = !resultado;
        }

        return resultado;
    }

    //Getters
    public Maquina getMaquina() {
        return maquina;
    }

    public String getCOD_ADMIN() {
        return COD_ADMIN;
    }

}
