package be.technifutur.demineurApp;

import java.util.HashSet;
import java.util.Random;
import java.util.Set;

public class Grille {
    private final int WIDTH = 10;
    private final int HEIGHT = 8;
    private final int BOMB = 15;
    private Cell[][] grille = new Cell[HEIGHT][WIDTH];

    public Grille() {
        makeBomb();
    }
    public int getWIDTH() {
        return WIDTH;
    }

    public int getHEIGHT() {
        return HEIGHT;
    }

    public int getBOMB() {
        return BOMB;
    }

    public Cell getCell(int i, int j) {
        return grille[i][j];
    }

    public Cell[][] getGrille() {
        return grille;
    }

    public void makeBomb() {
        Random rand = new Random();
        int numb= 0;
        int bombRestante = 15;
        int cellLeft = WIDTH * HEIGHT;
        for (int i = 0; i < HEIGHT; i++) {
            for (int j = 0; j < WIDTH; j++) {
                numb = rand.nextInt(cellLeft) + 1;
                grille[i][j] = new Cell();
                if (numb <= bombRestante) {
                    grille[i][j].isBomb = true;
                    System.out.print("\tX");
                    bombRestante--;
                } else {
                    System.out.print("\t-");
                }
                cellLeft--;
            }
            System.out.println();
        }
    }

    public Set<Cell> getVoisin(int i, int j) {
        if (isPositionValid(i, j)) {
            Set<Cell> voisin = new HashSet<>();
            if (i > 0) {
                voisin.add(getCell(i - 1, j));
                if (j > 0) {
                    voisin.add(getCell(i - 1, j - 1));
                }
                if (j < 9) {
                    voisin.add(getCell(i - 1, j + 1));
                }
            }
            if (j > 0) {
                voisin.add(getCell(i, j - 1));
            }
            if (j < 7) {
                voisin.add(getCell(i, j + 1));
            }
            if (i < 7) {
                voisin.add(getCell(i + 1, j));
                if (j > 0) {
                    voisin.add(getCell(i + 1, j - 1));
                }
                if (j < 9) {
                    voisin.add(getCell(i + 1, j + 1));
                }
            }
            return voisin;
        }
        return null;

    }

    private boolean isPositionValid(int i, int j) {
        return ((i < HEIGHT && i >= 0) && (j < WIDTH && j >= 0));
    }
}
