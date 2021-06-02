package edu.escuelaing.arsw.linecounter;

/**
 * Clase que lee únicamente líneas de código de un archivo excluyendo comentarios y lineas en blanco.
 */

public class LOCLineCounter implements LineCounter{
    private int contador = 0;
    public LOCLineCounter(){
    }

    private void increment(){
        contador++;
    }

    private boolean isAComment(String linea){
        boolean band = false;
        if (linea.length() > 1){
            if (linea.substring(0, 2).equals("/*")){
                band = true;
            }
            else if(linea.substring(0,2).equals("//")){
                band = true;
            }
        }
        else {
            if (linea.charAt(0) != '*') {
                band = true;
            }
        }
        return band;
    }

    @Override
    public void count(String linea) {
        linea = linea.trim();
        if (linea.length() > 0) {
            if (!isAComment(linea)) {
                increment();
            }
        }

    }

    @Override
    public int getCount() {
        return contador;
    }
}
