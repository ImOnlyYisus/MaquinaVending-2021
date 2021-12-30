package maquina;

public class Main {
    
    public static void main(String[] args) {
        
        Monedero monedero = new Monedero();
        
        monedero.addMonedaUnEuro(6);
        monedero.addMonedaUnEuro(6);
        
        System.out.println(monedero.getValorMonedasUnEuro());
        
    }
}
