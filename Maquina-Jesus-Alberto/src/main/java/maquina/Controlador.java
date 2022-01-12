package maquina;

import java.time.LocalDate;
import org.apache.commons.lang3.RandomStringUtils;

public class Controlador {

    //ATRIBUTOS
    private Maquina maquina;

    //COD ADMINISTRADOR 8 digitos, 1 a-z, 1 A-Z, 1 numero del 0-9, 1 "# $ % & ( ) * + , - . : ; < = > @"
    private String COD_ADMIN =(RandomStringUtils.randomAlphabetic(2).toLowerCase())
            + //2 letras minusculas
            (RandomStringUtils.randomAlphabetic(2).toUpperCase())
            + //2 letras mayusculas
            (RandomStringUtils.randomNumeric(2))
            + //2 numeros 0-9
            (RandomStringUtils.random(2, new char[]{'#', '$', '%', '&', '(', ')', '*', '+', ',', '-', '.', ':', ';', '<', '=', '>', '@'})); //Caracteres especiales

    //CONSTRUCTOR
    public Controlador(Maquina maquina) {
        this.maquina = maquina;
    }

    //METODOS
    //METODOS DE ADMINISTRADOR
    //METODO PARA COMPROBAR QUE EL CODIGO COINCIDE CON EL DE ADMINISTRADOR
    public boolean comprobarCodigoAdmin(String admin) {
        return (admin.equals(COD_ADMIN));
    }

    //METODO PARA MOSTRAR CODIGO DE BANDEJA INTRODUCIENDO EL NUMERO DE BANDEJA QUE QUIERES VER
    public String mostrarCodigoBandeja(String codProducto) {
        return (codProducto.substring(0,3));
    }

    //METODO PARA MODIFICAR EL CODIGO DE BANDEJA INTRODUCIENDO EL CODIGO DE BANDEJA QUE QUIERES MODIFICAR
    public void modificarCodBandeja(String codigoBandejaParaMod, String codBandeja) {
        for (int i = 0; i < this.maquina.getArrayBandejas().length; i++) { //Busco la bandeja que tenga ese codigo

            if (this.maquina.getArrayBandejas()[i].getCodBandeja().equalsIgnoreCase(codigoBandejaParaMod)) {
                codBandeja = codBandeja.toUpperCase(); //Lo convierto en mayusculas

                if (codBandeja.length() == 3 && codBandeja.matches("[A-Z][A-Z][A-Z]")) { //Compruebo que sean 3 de longitud y sean letras
                    this.maquina.getArrayBandejas()[i].setCodBandeja(codBandeja);
                } else {
                    throw new IllegalArgumentException("El codigo de la bandeja debe ser de 3 caracteres"); //Tiro excepcion de illegalArgument
                }
            }
        }
    }

    //METODO PARA VER LOS PRODUCTOS DE UNA BANDEJA ESPECIFICANDO EL CODIGO DE LA BANDEJA
    public Productos[] verProductosBandeja(String codBandeja) {
        int numeroBandeja = 0;
        for (int i = 0; i < this.maquina.getArrayBandejas().length; i++) { //Busco la bandeja que tenga ese codigo
            if (this.maquina.getArrayBandejas()[i].getCodBandeja().equalsIgnoreCase(codBandeja)) {
                numeroBandeja = i;
            }
        }
        return this.maquina.getArrayBandejas()[numeroBandeja].getArrayProductos();
    }

    //METODO PARA MODIFICAR PRODUCTOS DE LA BANDEJA ESPECIFICANDO EL CODIGOFINAL (AAA123)
    public void modificarProductosBandeja(String codFinal, Productos productoNuevo) {
        String codProductoParaMod = codFinal.substring(3);
        String codBandejaParaMod = codFinal.substring(0, 3);

        for (int i = 0; i < this.maquina.getArrayBandejas().length; i++) { //Busco la bandeja que tenga ese codigo
            if (this.maquina.getArrayBandejas()[i].getCodBandeja().equalsIgnoreCase(codBandejaParaMod)) {

                for (int z = 0; z < this.maquina.getArrayBandejas()[i].getArrayProductos().length; z++) {//Busco el producto para modificar
                    if (this.maquina.getArrayBandejas()[i].getArrayProductos()[z].getCodProducto().equalsIgnoreCase(codProductoParaMod)) {

                        //Modifico el producto
                        this.maquina.getArrayBandejas()[i].getArrayProductos()[z] = productoNuevo;
                    }
                }
            }
        }
    }

    //METODO PARA VER STOCK DEL PRODUCTO INTRODUCIENDO EL COD DE PRODUCTO FINAL EJ:(AAA123)
    public int verStockProducto(String codProductoFinal) {
        int numeroBandeja = 0;
        int numeroProducto = 0;
        String codProductoParaMod = codProductoFinal.substring(3);
        String codBandejaParaMod = codProductoFinal.substring(0, 3);

        for (int i = 0; i < this.maquina.getArrayBandejas().length; i++) { //Busco la bandeja que tenga ese codigo
            if (this.maquina.getArrayBandejas()[i].getCodBandeja().equalsIgnoreCase(codBandejaParaMod)) {
                numeroBandeja = i;
            }
        }

        for (int z = 0; z < this.maquina.getArrayBandejas()[numeroBandeja].getArrayProductos().length; z++) {//Busco el producto para modificar
            if (this.maquina.getArrayBandejas()[numeroBandeja].getArrayProductos()[z].getCodProducto().equalsIgnoreCase(codProductoParaMod)) {
                numeroProducto = z;
            }
        }

        return this.maquina.getArrayBandejas()[numeroBandeja].getArrayProductos()[numeroProducto].getStock();
    }

    //METODO PARA MODIFICAR EL STOCK DEL PRODUCTO INTRODUCIENDO EL CODIGO DEL PRODUCTO FINAL (AAA123) Y EL NUMERO DE STOCK NUEVO
    public void modificarStockProducto(String codProductoFinal, int stockNuevo) {
        if (stockNuevo < 0) { //Controlo que en el metodo de cambiar stock no se introduzca ningun numero menor que 0, si eso pasa se convierte en 1
            stockNuevo = 1;
        }

        int numeroBandeja = 0;
        String codProductoParaMod = codProductoFinal.substring(3);
        String codBandejaParaMod = codProductoFinal.substring(0, 3);

        for (int i = 0; i < this.maquina.getArrayBandejas().length; i++) { //Busco la bandeja que tenga ese codigo
            if (this.maquina.getArrayBandejas()[i].getCodBandeja().equalsIgnoreCase(codBandejaParaMod)) {
                numeroBandeja = i;
            }
        }

        for (int z = 0; z < this.maquina.getArrayBandejas()[numeroBandeja].getArrayProductos().length; z++) {//Busco el producto para modificar
            if (this.maquina.getArrayBandejas()[numeroBandeja].getArrayProductos()[z].getCodProducto().equalsIgnoreCase(codProductoParaMod)) {

                this.maquina.getArrayBandejas()[numeroBandeja].getArrayProductos()[z].setStock(stockNuevo);
            }
        }
    }

    //METODO PARA VER LAS GANANCIAS DE LA MAQUINA
    public double verGananciasMaquina() {
        return this.maquina.getMonedero().getDineroTotal();
    }

    //METODO PARA RECAUDAR LAS GANANCIAS DE LA MAQUINA, TENIENDO EN CUENTA DEJAR SIEMPRE 10 MONEDAS y BILLETES PARA EL CAMBIO
    public void recaudarDineroGanancias() {
        this.maquina.getMonedero().recaudarDinero();
    }

    //MÉTODOS CLIENTE
    //METODO PARA COMPROBAR QUE EL CODIGO COINCIDE CON EL DE ALGUN PRODUCTO
    public boolean comprobarCodigoProducto(String codProducto) {
        boolean verificar= true;
        for(int i=0; i<this.maquina.codigoProducto().length;i++){
            if(!(this.maquina.codigoProducto()[i].equalsIgnoreCase(codProducto))){
                verificar=!verificar;
            }
        }
        return verificar;
    }

    //Metodo que introduciendo un producto, devuelve su precio
    public double mostrarPrecio(String codigoProducto) {
        /*La idea es que introduzca el cliente el cod del producto es decir, imaginemos que introduce AAA123 entonces se refiere a la bandeja AAA y el producto 123,
         Entonces tendrías que modificar el metodo para que introduzas un String y ese String buscarlo en los productos, si quieres guiarte mira en la línea 91, ese método hace
         exactamente lo mismo lo unico que tendrías que obtener el precio*/

        int numeroBandejas = 0;
        int numeroProductos = 0;
        String codProductoParaMod = codigoProducto.substring(3);
        String codBandejaParaMod = codigoProducto.substring(0, 3);

        for (int i = 0; i < this.maquina.getArrayBandejas().length; i++) {
            if (this.maquina.getArrayBandejas()[i].getCodBandeja().equalsIgnoreCase(codBandejaParaMod)) {
                numeroBandejas = i;
            }
        }

        for (int z = 0; z < this.maquina.getArrayBandejas()[numeroBandejas].getArrayProductos().length; z++) {//Busco el producto para modificar
            if (this.maquina.getArrayBandejas()[numeroBandejas].getArrayProductos()[z].getCodProducto().equalsIgnoreCase(codProductoParaMod)) {
                numeroProductos = z;
            }
        }

        return this.maquina.getArrayBandejas()[numeroBandejas].getArrayProductos()[numeroProductos].getPrecio();
    }

    //Método que accede a la clase monedero y muestra el dinero total en efectivo a traves del método getDineroTotal()
    //Cambio a int el parametro dinero
    public boolean comprobarDineroEfectivo(int dinero) {
        /*La idea de este metodo es que introduzcamos un double o una cantidad de dinero y compruebe que la maquina puede pagar ese producto y devolver el cambio con las monedas
        que tenga la maquina, es decir devolvería true o false segun si se puede o no se puede debido a que la maquina no tiene suficiente para cambiar*/

        boolean resultado = true;
        Monedero monedero=this.maquina.getMonedero();
        String[] monederoDevolucion = monedero.dineroParaDevolver(dinero);
        if(monederoDevolucion[monederoDevolucion.length-1].equalsIgnoreCase("-1")){
            resultado=!resultado;
        }
        return resultado;

    }

    //Metodo que suma el contador de monedas del monedero segun lo que paguen
    public void sumaContadoresDineroCompra(int [] addContadoresMonedas){
        for(int i=0; i<this.maquina.getMonedero().getDineroContadores().length; i++){
            System.out.println(this.maquina.getMonedero().getContadorBilletesVeinteEuros());
            this.maquina.getMonedero().addMonedas(i,addContadoresMonedas[i]);
            System.out.println(this.maquina.getMonedero().getContadorBilletesVeinteEuros());
        }
    }

    //Metodo que te devuelve el cambio
    //Cambio a int el parametro dinero
    public int[] devolucionDinero(int dinero){
        int[] monedasIntercambio = new int[this.maquina.getMonedero().dineroParaDevolver(dinero).length];
        for(int i=0; i<monedasIntercambio.length; i++){
            monedasIntercambio[i]= Integer.parseInt(this.maquina.getMonedero().dineroParaDevolver(dinero)[i]);
        }
        return monedasIntercambio;
    }

    //Método que accede a una tarjeta y muestra su información
    public boolean comprobarTarjeta(String numeroTarjeta, LocalDate fechaVencimiento, int CVV) {
        /*Este metodo se refiere a que tienes que comprobar que los diferentes datos como son "Numero tarjeta, CVV y fecha de vencimiento" son iguales a los que tiene
         la maquina guardados como atributos*/
        boolean comprobacion = true;
        for (int i = 0; i < this.maquina.getNumeroTarjeta().length; i++) {
            if(numeroTarjeta.equalsIgnoreCase(this.maquina.getNumeroTarjeta()[i]) && fechaVencimiento.equals(this.maquina.getFechaVencimientoTarjeta()[i]) && CVV== this.maquina.getCVVTarjeta()[i]){
                comprobacion=true;
                break;
            }else{
                comprobacion=!comprobacion;
            }
        }
        return comprobacion;

    }

    public boolean comprobarStock(String codigoProducto) {
        boolean comprobacion = true;
        if(!(verStockProducto(codigoProducto)>=1)){
            return comprobacion= false;
        }
        return comprobacion;

    }

    //Modificar stock
    public boolean comprarArticulo(String codigoProducto, int[] contadoresMonedasIntroducidas,String numeroTarjeta, LocalDate fechaVencimiento, int CVV) {
        boolean resultado=true;
        if(codigoProducto!=null){
            if(comprobarStock(codigoProducto)) {
                if (contadoresMonedasIntroducidas != null) { //EFECTIVO
                    int [] contadoresMonedas = contadoresMonedasIntroducidas;
                    
                    //Mofifico el array a int
                    int monedasValores[] = {100, 200, 500, 10, 20, 50, 1, 2, 5, 10, 20};
                    double dineroTotal = 0;

                    for(int i=0; i<contadoresMonedas.length; i++){  //Cuento cuanto dinero se introduce en la maquina en total
                        dineroTotal+=contadoresMonedas[i]*monedasValores[i];
                    }

                    if(comprobarDineroEfectivo((dineroTotal-mostrarPrecio(codigoProducto)))){
                        System.out.println("si llega");
//                        sumaContadoresDineroCompra(contadoresMonedas);
                    }else {resultado=!resultado;}
                }
                else if (numeroTarjeta != null && fechaVencimiento != null && CVV != 0) { //-----TARJETA----
                    if(!comprobarTarjeta(numeroTarjeta,fechaVencimiento,CVV)){
                        resultado=!resultado;

                    }else {
                        modificarStockProducto(codigoProducto,(verStockProducto(codigoProducto)-1)); //bajo el stock del producto
                    }
                } else{resultado=!resultado;}
            }else{
                resultado=!resultado;
            }
        }else {resultado=!resultado;}

        return resultado;
    }

    //GETTERS
    public Maquina getMaquina() {
        return maquina;
    }

    public String getCOD_ADMIN() {
        return COD_ADMIN;
    }

}
