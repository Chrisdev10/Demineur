package be.technifutur.demineurApp;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class GrilleTest {

    @Test
    public void testgetStartGrilleNotNull() {
        DemineurApp app = new DemineurApp();
        Grille grille = app.getGrille();
        assertNotNull(grille);
    }
    @Test
    public void testGrilleDefaultSize() {
        Grille grille = new Grille();
        assertEquals(10,grille.getWidth());
        assertEquals(8,grille.getHeight());
    }
    @Test
    public void testGrilleDefaultBomb() {
        Grille grille = new Grille();
        assertEquals(15,grille.getBomb());
    }

}