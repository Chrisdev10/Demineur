package be.technifutur.demineurApp;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.Set;
import java.util.stream.Stream;

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
        assertAll(
                () -> assertEquals(10,grille.getWIDTH()),
                () -> assertEquals(8,grille.getHEIGHT())
        );
    }
    @Test
    public void testGrilleDefaultBomb() {
        Grille grille = new Grille();
        assertEquals(15,grille.getBOMB());
    }

    @Test
    public void grilleCellNotNull() {
        Grille grille = new Grille();
        for (int i = 0; i < grille.getHEIGHT(); i++) {
            for (int j = 0; j < grille.getWIDTH(); j++) {
                assertNotNull(grille.getCell(i, j));

            }
        }
    }
    @Test
    public void grilleCellSameCheck() {
        Grille grille = new Grille();

        assertNotSame(grille.getCell(1, 1), grille.getCell(2,2));
    }

    @Test
    public void bombCountTest() {
        Grille grille = new Grille();

        int bomb = (int) Arrays
                .stream(grille.getGrille())
                .flatMap(Arrays::stream)
                .filter(x -> x.isBomb)
                .count();
        assertEquals(grille.getBOMB(), bomb);
    }

    @Test
    public void testVoisin2_2() {
        Grille grille = new Grille();
        Set<Cell> voisin = grille.getVoisin(2, 2);
        assertEquals(8, voisin.size());
        assertAll(
                () -> assertTrue(voisin.contains(grille.getCell(1, 2))),
                () -> assertTrue(voisin.contains(grille.getCell(1, 1))),
                () -> assertTrue(voisin.contains(grille.getCell(2, 1))),
                () -> assertTrue(voisin.contains(grille.getCell(2, 3))),
                () -> assertTrue(voisin.contains(grille.getCell(3, 2))),
                () -> assertTrue(voisin.contains(grille.getCell(3, 1))),
                () -> assertTrue(voisin.contains(grille.getCell(3, 3)))
                );

    }
    @Test
    public void testVoisin0_4() {
        Grille grille = new Grille();
        Set<Cell> voisin = grille.getVoisin(0, 4);
        assertEquals(5, voisin.size());
        assertAll(
                () -> assertTrue(voisin.contains(grille.getCell(0, 3))),
                () -> assertTrue(voisin.contains(grille.getCell(0, 5))),
                () -> assertTrue(voisin.contains(grille.getCell(1, 4))),
                () -> assertTrue(voisin.contains(grille.getCell(1, 3))),
                () -> assertTrue(voisin.contains(grille.getCell(1, 5)))

        );

    }
    @Test
    public void testVoisin0_0() {
        Grille grille = new Grille();
        Set<Cell> voisin = grille.getVoisin(0, 0);
        assertEquals(3, voisin.size());
        assertAll(
                () -> assertTrue(voisin.contains(grille.getCell(0, 1))),
                () -> assertTrue(voisin.contains(grille.getCell(1, 1))),
                () -> assertTrue(voisin.contains(grille.getCell(1, 0)))
        );

    }
    @Test
    public void testVoisin7_4() {
        Grille grille = new Grille();
        Set<Cell> voisin = grille.getVoisin(7, 4);
        assertEquals(5, voisin.size());
        assertAll(
                () -> assertTrue(voisin.contains(grille.getCell(7, 3))),
                () -> assertTrue(voisin.contains(grille.getCell(7, 5))),
                () -> assertTrue(voisin.contains(grille.getCell(6, 3))),
                () -> assertTrue(voisin.contains(grille.getCell(6, 4))),
                () -> assertTrue(voisin.contains(grille.getCell(6, 5)))
        );

    }
}