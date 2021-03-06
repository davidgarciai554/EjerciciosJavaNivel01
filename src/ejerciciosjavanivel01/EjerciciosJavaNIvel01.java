/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ejerciciosjavanivel01;

import java.util.Arrays;

/**
 *
 * @author usuario
 */
public class EjerciciosJavaNIvel01 {

    int[] listaMax = {120, 100, 1, 150};

    public int[] maximos(int[] lista) {
        int max = lista[0], max2 = lista[0], posMax = 0;
        for (int i = 0; i < lista.length; i++) {
            if (lista[i] > max) {
                max2 = max;
                max = lista[i];
            } else if (max2 < lista[i] && lista[i] != max) {
                max2 = lista[i];
            }

        }
        int[] maxs = {max, max2};
        return maxs;
    }

    public boolean Palindromo(String frase) {
        frase = frase.toUpperCase();
        frase = quita(frase);
        int i = 0;
        while (i < frase.length() / 2 && frase.charAt(i) == frase.charAt(frase.length() - (i + 1))) {
            i++;
        }
        if (i == frase.length() / 2) {
            return true;
        }
        return false;
    }

    public boolean Isograma(String frase) {
        frase = frase.toUpperCase();
        frase = quita(frase);
        int i = 0, a = 0;
        while (i < frase.length() && frase.charAt(i) != frase.charAt(frase.length() - (i + 1))) {
            while (a < frase.length() && frase.charAt(i) != frase.charAt(frase.length() - (a + 1))) {
                a++;
            }
            i++;
        }
        if (i == frase.length()) {
            return true;
        }
        return false;
    }

    public void imprimeMes(int a) {
        int dias = 1;
        int fila = 0;
        a = a % 7;
        boolean columna1 = true;
        while (dias <= 31) {
            fila = 0;
            while (fila < 7 && dias <= 31) {
                if (columna1) {
                    for (int k = 0; k < a; k++) {
                        System.out.print("XX ");
                        fila++;
                        columna1 = false;
                    }
                }
                if (dias < 10 && fila < 7) {
                    System.out.print(dias + "  ");
                    fila++;
                    dias++;
                } else {
                    System.out.print(dias + " ");
                    fila++;
                    dias++;
                }
            }
            if (dias <= 31) {
                System.out.println();
            }
        }
        for (int k = 0; k < 7 - fila; k++) {
            System.out.print("XX ");
        }
    }

    private boolean anagrama(String palabra, String palabra1) {
        palabra = palabra.toUpperCase();
        palabra1 = palabra1.toUpperCase();
        palabra = quita(palabra);
        palabra1 = quita(palabra1);
        if (palabra.length() == palabra1.length()) {
            for (int i = 0; i < palabra.length(); i++) {
                int a = 0;
                while (a < palabra1.length() && palabra.charAt(i) != palabra1.charAt(a)) {
                    a++;
                }
                if (a == palabra1.length()) {
                    return false;
                } else {
                    palabra1 = palabra1.substring(0, a) + palabra1.substring(a + 1);
                }
            }
            if (palabra1.length() == 0) {
                return true;
            }
        }
        return false;
    }

    public String acronimo(String palabra) {
        palabra = palabra.toUpperCase();
        String acronimo = "";
        String[] prohibidas = {"Y", "E", "DE", "LA", "LAS"};
        String espacio = " ", palabraActual = "";
        acronimo += palabra.charAt(0);
        int a = 0, j = 0;
        //Elimina palabras prohibidas
        while (j < palabra.length()) {
            while (j < palabra.length() && palabra.charAt(j) != ' ') {
                j++;
            }
            palabraActual = palabra.substring(a, j);
            int k = 0;
            while (k < prohibidas.length) {
                if (palabraActual.equals(prohibidas[k])) {
                    palabra = palabra.substring(0, a) + palabra.substring(j + 1);
                    j -= palabraActual.length() + 1;
                }
                k++;
            }
            j++;
            a = j;

        }
        System.out.println(palabra);
        //Saca el acronimo
        for (int i = 0; i < palabra.length(); i++) {
            if (palabra.charAt(i) == espacio.charAt(0)) {
                acronimo += palabra.charAt(i + 1);
            }
        }

        return acronimo;
    }
    
    private String quita(String frase) {
        String auxiliar = "";
        for (int i = 0; i < frase.length(); i++) {
            if (frase.charAt(i) != ' ') {
                auxiliar = auxiliar + frase.charAt(i);
            }
        }
        return auxiliar;
    }
    
    
    int[][] arrayDoble = {{1, 10, 2}, {3, 4, 5}, {6, 7, 8}};

    public boolean sudoku(int[][] array) {
        int[] sudoku = new int[array.length * array.length];
        
        // Transformamos el array doble a uno simple
        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array.length; j++) {
                sudoku[array.length * i + j] = array[i][j];
            }
        }
        
        Arrays.sort(sudoku);//Ordenamos el array
        
        // Aqui comprobamos que esta entre todos los valores 
        // y comprobamos que esta en el rango 1-9
        System.out.println(Arrays.toString(sudoku));
        for (int i = 0; i < sudoku.length; i++) {
            if (sudoku[i] == i + 1) {
                return false;
            }
        }
        
        return true;
    }
    
    int[] arrayPalomero = {2, 1, 4, 3, 4};

    public int palomero(int[] arrayPalom) {
        for (int i = 0; i < arrayPalom.length; i++) {
            for (int j = i+1; j < arrayPalom.length; j++) {
                // Comparamos todos los valores entre si acortando
                // y en el momento que se encuentre el primer repetido 
                // lo devolvemos
                if(arrayPalom[i]==arrayPalom[j]) return arrayPalom[i];
            }
        }
        return 0;//Para que no de error el ejercicio aunque nunca se dara
    }

    

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {

        EjerciciosJavaNIvel01 ejercicio = new EjerciciosJavaNIvel01();

//        System.out.println("Maximos");
//        System.out.println(Arrays.toString(ejercicio.maximos(ejercicio.listaMax)));
//        //Palindromo
//        System.out.println();
//        System.out.println("Isograma");
//        if ((ejercicio.Palindromo("aaa"))) {
//            System.out.println("Es palindromo");
//        } else {
//            System.out.println("No es palindromo");
//        }
//        System.out.println();
//
//        System.out.println("Isograma");
//        if (ejercicio.Isograma("asdfa")) {
//            System.out.println("Es isograma");
//        } else {
//            System.out.println("No es isograma");
//        }
//
//        System.out.println();
//        System.out.println("Calendario");
//        ejercicio.imprimeMes(8);
//        System.out.println();
//        System.out.println();
//
//        System.out.println("Anagrama");
//        System.out.println(ejercicio.anagrama("roma", "amor"));
//        System.out.println(ejercicio.acronimo("tecnologia de la informacion y de las comunicaciones"));

        System.out.println(ejercicio.sudoku(ejercicio.arrayDoble));
        
        System.out.println(ejercicio.palomero(ejercicio.arrayPalomero));
    }

}
