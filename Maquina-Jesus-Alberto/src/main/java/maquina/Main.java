package maquina;

public class Main {

    public static void main(String[] args) {

        Monedero monedero = new Monedero();

        monedero.addMonedaUnEuro(6);

        System.out.println(monedero.getResultadoMonedasUnEuro());

        monedero.removeMonedaUnEuro(4);

        System.out.println(monedero.getResultadoMonedasUnEuro());
        
        System.out.println(monedero.getValorTotal());
    }
}
