package edu.escuelaing.arsw.linecounter;
/**
 * Interface que maneja el conteo de líneas de codigo.
 */

public interface LineCounter {
    public void count(String linea);
    public int getCount();
}