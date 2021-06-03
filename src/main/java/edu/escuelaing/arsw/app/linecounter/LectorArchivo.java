package edu.escuelaing.arsw.app.linecounter;
import java.io.BufferedReader;
import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
/**
 * Clase encargada de comunicarse con la interfaz para que realice el conteo correspondiente
 */
public class LectorArchivo {
    public LectorArchivo(){
    }

    /**
     * Metodo encargado de realizar la lectura línea por línea del archivo que se le envia como parametro
     * @param ruta es la ruta del archivo que se esta leyendo
     * @param lineC es la interfaz con la que se comunicará para realizar el conteo correspondiente
     * @throws java.io.IOException Por si no se encuentra el arhivo indicado
     */
    public void leerArchivo(String ruta, LineCounter lineC)throws IOException{
        Charset charset = Charset.forName("UTF-8");
        Path archivo = Paths.get(ruta);
        try(BufferedReader lector = Files.newBufferedReader(archivo, charset)){
            String linea;
            while ((linea = lector.readLine()) != null) {
                lineC.count(linea);
            }
            System.out.println("La cantidad de lineas que contiene el achivo es: "+lineC.getCount());
        }catch(IOException e){
            throw new IOException("El archivo no exite",e);
        }
    }

}