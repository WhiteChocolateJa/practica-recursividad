
void main() {
    // Prueba factorial iterativo
    IO.println("=== Factorial Iterativo ===");
    IO.println("factorial(5) = " + factorial(5));
    IO.println("factorial(10) = " + factorial(10));

    // Prueba factorial de cola
    IO.println("\n=== Factorial Cola ===");
    IO.println("factorialCola(5) = " + factorialCola(5, 1));
    IO.println("factorialCola(10) = " + factorialCola(10, 1));

    // Prueba contar movimientos Hanoi
    IO.println("\n=== Hanoi: contar movimientos ===");
    IO.println("Hanoi con 3 discos = " + contarHanoi(3) + " movimientos");
    IO.println("Hanoi con 5 discos = " + contarHanoi(5) + " movimientos");

    // Prueba potencia rapida
    IO.println("\n=== Potencia Rapida ===");
    IO.println("2^10 = " + potenciaRapida(2, 10));
    IO.println("3^5 = " + potenciaRapida(3, 5));

    // Prueba invertir cadena
    IO.println("\n=== Invertir Cadena ===");
    IO.println("invertir('hola') = " + invertir("hola"));
    IO.println("invertir('recursion') = " + invertir("recursion"));

    // Prueba contar unos
    IO.println("\n=== Contar Unos ===");
    int[] arreglo1 = {1, 0, 1, 1, 0, 1};
    int[] arreglo2 = {0, 0, 1, 0, 1, 0};
    IO.println("arreglo {1,0,1,1,0,1} tiene " + contarUnosIterativo(arreglo1) + " unos");
    IO.println("arreglo {0,0,1,0,1,0} tiene " + contarUnosIterativo(arreglo2) + " unos");
}


// forma iterativa del algoritmo factorial (Ejercicio 1, tarea 4).
public static long factorial(int n) {
    long resultado = 1;

    for (int i = 2; i <= n; i++) {
        resultado = resultado * i;
    }

    return resultado;
}
/*
TAREA #4:
En forma iterativa la complejidad temporal sigue siendo O(n), porque el bucle depende
de n, si n = 1,000,000 entonces va a haber 999,999 iteraciones. Entonces
el tiempo crece linealmente.

La complejidad espacial de la versión iterativa es O(1) porque
solo utiliza un número fijo de variables, independientemente
del tamaño de la entrada, y no genera estructuras adicionales
en memoria como la pila de llamadas.

El costo que desaparece es el espacio en la pila de llamadas.
La versión iterativa solo necesita una variable sin
importar qué tan grande sea n.
*/


// versión con recursividad de cola (Ejercicio 1, tarea 5).
public static long factorialCola(int n, long acumulador) {
    if (n <= 1) {
        return acumulador;
    }
    return factorialCola(n - 1, acumulador * n);
}
/*
¿Cómo funciona?
La función recibe dos cosas, el número n y un acumulador
que guarda el resultado. En cada paso, en vez de esperar para
multiplicar después, multiplica de una vez el acumulador
por n y pasa ese nuevo resultado a la siguiente llamada
con n-1. Esto se repite hasta que n llega a 1, y en ese momento
la función devuelve el acumulador, que ya tiene el factorial completo.

¿Por qué Java no garantiza la optimización?
Aunque la función está escrita como recursividad de cola (porque
la llamada recursiva es lo último que se hace y no quedan
operaciones pendientes), en Java no se garantiza una optimización
automática de estas llamadas. Esto significa que cada llamada
recursiva aún se guarda en la pila de ejecución, acumulando memoria
a medida que n crece. Por eso, a pesar de la mejora en la forma del
algoritmo, el uso de espacio sigue siendo O(n) y no O(1).
*/


// tarea 18
public static long contarHanoi(int n) {
    long resultado = 1;

    for (int i = 0; i < n; i++) {
        resultado = resultado * 2;
    }

    return resultado - 1;
}


// tarea 20
public static int potenciaRapida(int x, int n) {
    if (n == 0) return 1;
    if (n % 2 == 0) {
        int mitad = potenciaRapida(x, n / 2);
        return mitad * mitad;
    }
    return x * potenciaRapida(x, n - 1);
}


// tarea 21
public static String invertir(String s) {
    String resultado = "";
    for (int i = s.length() - 1; i >= 0; i--) {
        resultado = resultado + s.charAt(i);
    }
    return resultado;
}
/*
Esto sigue siendo O(n²) en tiempo estricto por las concatenaciones,
pero elimina el costo extra de substring y la pila recursiva,
reduciendo el espacio a O(1). Si se quisiera O(n) verdadero
en tiempo, se usaría StringBuilder, pero esta versión ya
demuestra el cambio de diseño de forma clara.
*/


// tarea 22
public static int contarUnosIterativo(int[] a) {
    int contador = 0;
    for (int i = 0; i < a.length; i++) {
        if (a[i] == 1) contador++;
    }
    return contador;
}