package edu.escuelaing.arsw.app;

import edu.escuelaing.arsw.app.app.App;
import edu.escuelaing.arsw.app.linecounter.LOCLineCounter;
import edu.escuelaing.arsw.app.linecounter.LectorArchivo;
import edu.escuelaing.arsw.app.linecounter.LineCounter;
import edu.escuelaing.arsw.app.linecounter.PhysicalLineCounter;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;
import static org.junit.Assert.assertNotEquals;

import org.junit.Test;

import java.io.IOException;

public class AppTest {

    @Test
    public void deberiaCargarArchivo() {

        try {
            String[] args = {"phy", "BlogServicesImpl.java"};
            App.main(args);
            assertTrue(true);
        } catch (IOException e) {
            assertTrue(false);
        }

    }

    @Test
    public void noDeberiaCargarArchivo() {
        try {
            String[] args = {"phy", "src/main/java/edu/escuelaing/arsw/app/Apps.java"};
            App.main(args);
            assertTrue(false);
        } catch (IOException e) {
            assertTrue(true);
        }
    }

    @Test
    public void deberiaContarPHY() {

        LectorArchivo lector = new LectorArchivo();
        LineCounter lc = new PhysicalLineCounter();
        try {
            lector.leerArchivo("BlogServicesImpl.java", lc);
            assertEquals(97, lc.getCount());

        } catch (IOException ex) {
            fail();
        }
    }

    @Test
    public void noDeberiaContarPHY() {

        LectorArchivo lector = new LectorArchivo();
        LineCounter lc = new PhysicalLineCounter();
        try {
            lector.leerArchivo("BlogServicesImpl.java", lc);
            assertNotEquals(-117, lc.getCount());

        } catch (IOException ex) {
            fail();
        }
    }

    @Test
    public void deberiaContarLOC() {

        LectorArchivo lector = new LectorArchivo();
        LineCounter lc = new LOCLineCounter();
        try {
            lector.leerArchivo("BlogServicesImpl.java", lc);
            assertEquals(67, lc.getCount());

        } catch (IOException ex) {
            fail();
        }
    }

    @Test
    public void noDeberiaContarLOC() {

        LectorArchivo lector = new LectorArchivo();
        LineCounter lc = new LOCLineCounter();
        try {
            lector.leerArchivo("BlogServicesImpl.java", lc);
            if (lc.getCount() != 67) {
                assertTrue(false);
            } else {
                assertTrue(true);
            }

        } catch (IOException ex) {
            fail();
        }
    }

}