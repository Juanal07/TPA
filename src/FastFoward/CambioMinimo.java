package FastFoward;

import java.math.BigDecimal;

public class CambioMinimo {

    public static int seleccionarMoneda(BigDecimal[] monedas, BigDecimal acumulado, BigDecimal cambio) {

        int devolver = -1;
        int i = 0;
        boolean condicion = true;
        while (condicion && i < monedas.length) {
            if (acumulado.add(monedas[i]).compareTo(cambio) == -1 || acumulado.add(monedas[i]).compareTo(cambio) == 0 ) {
                condicion = false;
            } else {
                i++;
            }
        }
        if (i==8 && condicion==true){
            i=-1;
        }
        return i;
    }

    public static boolean cambioMin(BigDecimal[] monedas, BigDecimal cambio, int[] solucion) {

        BigDecimal acumulado = new BigDecimal("0");
        int posMoneda = 0;
        boolean haySol = true;
        while (!(acumulado.compareTo(cambio)==0) && haySol) {
            posMoneda = seleccionarMoneda(monedas, acumulado, cambio);
            if (posMoneda == -1) {
                haySol      = false;
                solucion[0] = -1;
            } else {
                solucion[posMoneda] = solucion[posMoneda] + 1;
                acumulado           = acumulado.add(monedas[posMoneda]);
            }
        }

        return haySol;
    }//cambioMin

//    n=parte entera del cambio
//    La complejidad es O(n) = n/2+7 es decir n/2

    public static void main(String[] args) {

        BigDecimal[] monedas = {new BigDecimal("2"), new BigDecimal("1"), new BigDecimal("0.5"), new BigDecimal("0.2"), new BigDecimal("0.1"), new BigDecimal("0.05"), new BigDecimal("0.02"),new BigDecimal("0.01")};
        BigDecimal cambio = new BigDecimal("5.89");
        int[] solucion = {0, 0, 0, 0, 0, 0, 0, 0};
        int num=0;
        System.out.println(cambioMin(monedas, cambio, solucion));
        for (int i = 0; i < solucion.length; i++) {
            System.out.print(solucion[i] + " ,");
            num+=solucion[i];

        }
        System.out.println();
        System.out.println("Número de monedas: "+num);

    }
}
