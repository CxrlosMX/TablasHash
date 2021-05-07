/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tablashash;

import java.util.Arrays;

/**
 *
 * @author El Camaleon
 */
public class TablasHash {

    String[] arreglo;
    int tamanio;
    int c;

    //Contructor 
    public TablasHash(int tam) {
        tamanio = tam;
        arreglo = new String[tam]; //Le asignamos valores a nuestro arreglo
        Arrays.fill(arreglo, "-1"); //Cuando el arreglo tenga un -1 quiere decir que el arreglo aun no tiene nada
    }

    public void funcionHash(String[] cadenaArreglo, String[] arreglo) { //La funcion Hash sirve para asignar una clave
        int i;
        for (i = 0; i < cadenaArreglo.length; i++) {
            String elemento = cadenaArreglo[i];
            int indiceArreglo = Integer.parseInt(elemento) % (arreglo.length - 1);
            System.out.println("El indice es " + indiceArreglo + " para el elemento o valor " + elemento);
            //Tratando las colisiones
            while (arreglo[indiceArreglo] != "-1") { //Esto es en caso que el indice donde queramos ingresar el dato este ocupado
                indiceArreglo++;
                System.out.println("Ocurrio una Colisión en el Indice " + (indiceArreglo - 1) + " cambiar al indice " + indiceArreglo);
                indiceArreglo %= tamanio;
            }
            arreglo[indiceArreglo] = elemento;

        }
    }

    //Metodo para mostrar la Tabla de Hash
    public void Mostrar() {
        int incremento = 0, i, j;
        for (i = 0; i < 1; i++) {
            incremento += 8;
            for (j = 0; j < 71; j++) {
                System.out.print("-");
            }
            System.out.println();
            for (j = incremento - 8; j < incremento; j++) {
                System.out.format("|%3s " + " ", j);
            }
            System.out.println("|");
            for (int n = 0; n < 71; n++) {
                System.out.print("-");
            }
            System.out.println();

            for (j = incremento - 8; j < incremento; j++) {
                if (arreglo[j].equals("-1")) {
                    System.out.print("|    ");
                } else {
                    System.out.print(String.format("| %3s " + " ", arreglo[j]));
                }
            }
            System.out.println("|");
            for (j = 0; j < 71; j++) {
                System.out.print("-");
            }
            System.out.println();
        }
    }

    //Método para buscar una clave
    public String buscarClave(String elemento) {
        
        int indiceArreglo = Integer.parseInt(elemento) % (arreglo.length - 1);
        int contador = 0;

        while (arreglo[indiceArreglo] != "-1") {
            if (arreglo[indiceArreglo] == elemento) {
                System.out.println("El elemento  " + elemento + " fue encontrado en el indice " + indiceArreglo);
                return arreglo[indiceArreglo];
            }
            indiceArreglo++;
            indiceArreglo %= tamanio;
            contador++;
            if (contador > arreglo.length - 1) {
                break;
            }
        }

        return null;
    }

    public static void main(String[] args) {
        TablasHash hash = new TablasHash(8);
        String[] elementos = {"20", "33", "21", "10", "12", "14", "56", "100"};
        hash.funcionHash(elementos, hash.arreglo);
        hash.Mostrar();
        String buscado=hash.buscarClave("100");
       if(buscado==null){
           System.out.println("El elemento "+buscado + " no se encuntra dentro del arregl");
       }
    }

}
