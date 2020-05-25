package Checkpoint2;

import java.math.BigDecimal;

public class CambioMinimo {

    public static int seleccionarMoneda(int[] valores, int[] cantidades, int cantidad, int acumulado) {


        int i = 0;//inicializo iterador que recorre los valores
        boolean condicion = true;
        while (condicion && i < valores.length) {
            if ((acumulado + valores[i] <= cantidad) && (cantidades[i] > 0)) {//si la moneda es adecuada osea no nos hemos pasado nos salimos del bucle
                condicion = false;
            } else {//si nos pasamos de grande con la moneda probamos una mas pequeña
                i++;
            }
        }
        if (i == valores.length) {//si recorremos el array completo sin exito devolvemos -1
            i = -1;
        }
        return i;
    }

    public static int[] cambioMin(int[] valores, int[] cantidades, int cantidad) {

        int[] cambio = {0, 0, 0, 0, 0, 0};//inicializo el cambio
        int acumulado = 0;//inicializo lo que lleva acumulado el cambio
        int posMoneda = 0;//inicializo la posicion de la moneda a insertar en el cambio
        boolean haySol = true;//inicializo si hay solucion a true, ya habra tiempo de que se ponga a false
        while ((acumulado < cantidad) && haySol) { //si aun no hemos llegado a la cantidad y existe una moneda en la que no nos pasemos seguimos en el bucle
            posMoneda = seleccionarMoneda(valores, cantidades, cantidad, acumulado); //escojo la moneda adecuada en cada iteracion
            if (posMoneda == -1) {//si no hay monedas disponibles no hay solucion
                haySol    = false;//cambiamos el valor para salirnos del bucle
                cambio[0] = -1;//devolvemos en la 1ª posicion un -1 tal y como indica el enunciado
            } else {
                cambio[posMoneda] = cambio[posMoneda] + 1;//sumo 1 a la moneda que acabamos de usar
                acumulado         = acumulado + valores[posMoneda];//sumo al valor acumulado el valor de la moneda que hemos cogido
                cantidades[posMoneda]--;//resto 1 en las monedas disponibles
            }
        }
        System.out.println("Monedas disponibles");//este for es para mostrar el estado de las monedas que quedan tras entregar el cambio
        for (int i = 0; i < cantidades.length; i++) {
            System.out.print(cantidades[i] + " ,");
        }
        System.out.println();

        return cambio;
    }//cambioMin

    public static void main(String[] args) {

        int[] valores = {100, 50, 20, 10, 5, 1};
        int[] cantidades = {5, 10, 16, 25, 50, 100};
        int cantidad = 137;//para un numero mayor que 1920 nos quedamos sin monedas para el cambio

        int numMonedas = 0;

        int[] cambio = cambioMin(valores, cantidades, cantidad);

        System.out.println("Cambio");
        for (int i = 0; i < cambio.length; i++) {
            System.out.print(cambio[i] + " ,");
            numMonedas += cambio[i];
        }
        System.out.println();
        System.out.println("Número de monedas usadas: " + numMonedas);
    }
}
