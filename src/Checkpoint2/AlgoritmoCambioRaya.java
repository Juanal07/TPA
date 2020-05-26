package Checkpoint2;

public class AlgoritmoCambioRaya {

    private int seleccionar (int[] valores, int[] cantidades, int cantidad, int acumulado) {

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
    }//seleccionar

    public boolean cambioMinimo(int[] valores, int[] cantidades, int cantidad, int[] cambio) {

        int acumulado = 0;//inicializo lo que lleva acumulado el cambio
        int posMoneda = 0;//inicializo la posicion de la moneda a insertar en el cambio
        boolean haySol = true;//inicializo si hay solucion a true, ya habra tiempo de que se ponga a false
        while ((acumulado < cantidad) && haySol) { //si aun no hemos llegado a la cantidad y existe una moneda en la que no nos pasemos seguimos en el bucle
            posMoneda = seleccionar (valores, cantidades, cantidad, acumulado); //escojo la moneda adecuada en cada iteracion
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
        return haySol;
    }//cambioMin


    public void mostrarArray (int[] array){
        // Para mostrar la solución
        System.out.print("[");
        for (int i=0; i<array.length; i++)
             System.out.print(array[i] + ", ");
        System.out.println("]");
    }

    public static void main(String[] args) {
        //TO DO: Instanciar e inicializar convenientemente los arrays siguientes:
        int[] valores = {200, 100, 50, 20, 10, 5, 2, 1}; //Array que alamacena los valores de las diferentes monedas
        int[] cantidades = {1, 1, 1, 1, 1, 1, 1, 1}; //Array que almacena cuantas monedas de cada valor existen
        int[] cambio= {0,0,0,0,0,0,0,0}; //Array que almacena el resultado: el num. de monedas de cada valor que usaremos

        int cantidad = 289; //Variable para almacenar el cambio que se quiere devolver
        boolean resultado = false; //Variable para saber si hay solución al problema

        AlgoritmoCambioRaya cm = new AlgoritmoCambioRaya();
        resultado = cm.cambioMinimo(valores, cantidades, cantidad, cambio);
        if (resultado)
            cm.mostrarArray(cambio);
        else
            System.out.println("No hay solución.\n");

        System.out.println("** FIN **");
        System.out.println("** Añadido por parte de J.A Raya para comprobaciones **");
        cm.mostrarArray((cambio));



    }//main
}//class