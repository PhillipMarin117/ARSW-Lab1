package edu.escuelaing.arsw.linecounter;
/**
 * Clase encargada de leer todas las líneas de un archivo.
 */
public class PhysicalLineCounter implements LineCounter{

    private int contador=0;

    @Override
    public void count(String linea){
        contador++;
    }

    @Override
    public int getCount(){
        return contador;
    }


}