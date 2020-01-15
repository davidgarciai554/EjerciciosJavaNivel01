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

    private boolean anagrama(String palabraA, String palabraB) {
        //pasamos a mayúsculas todas las letras
        palabraA = palabraA.toUpperCase();
        palabraB = palabraB.toUpperCase();
        palabraA = quita(palabraA);
        palabraB = quita(palabraB);

        boolean anagr = false;
        if (palabraA.length() == palabraB.length()) {
            for (int i = 0; i < palabraA.length(); i++) {
                int a = 0;
                while (a < palabraB.length() && palabraA.charAt(i) != palabraB.charAt(a)) {
                    a++;
                }
                if (a == palabraB.length()) {//la letra no estaba, retorno falso
                    return false;
                } else {  //la letra sí que está en B, la voy a eliminar
                    palabraB = palabraB.substring(0, a) + palabraB.substring(a + 1);
                }
            }
            if (palabraB.length() == 0) {
                return true;
            }
        }
        return anagr;
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

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {

        EjerciciosJavaNIvel01 ejercicio = new EjerciciosJavaNIvel01();

        System.out.println("Maximos");
        System.out.println(Arrays.toString(ejercicio.maximos(ejercicio.listaMax)));
        //Palindromo
        System.out.println();
        System.out.println("Isograma");
        if ((ejercicio.Palindromo("aaa"))) {
            System.out.println("Es palindromo");
        } else {
            System.out.println("No es palindromo");
        }
        System.out.println();

        System.out.println("Isograma");
        if (ejercicio.Isograma("asdfa")) {
            System.out.println("Es isograma");
        } else {
            System.out.println("No es isograma");
        }

        System.out.println();
        System.out.println("Calendario");
        ejercicio.imprimeMes(8);
        System.out.println();
        System.out.println();

        System.out.println("Anagrama");
        System.out.println(ejercicio.anagrama("rkma", "amor"));
    }

}