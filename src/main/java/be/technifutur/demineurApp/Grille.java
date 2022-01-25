package be.technifutur.demineurApp;

public class Grille {
    private int width = 10;
    private int height = 8;
    private int bomb = 15;

    public int getWidth() {
        return width;
    }

    public void setWidth(int width) {
        this.width = width;
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public int getBomb() {
        return bomb;
    }

    public void setBomb(int bomb) {
        this.bomb = bomb;
    }
}
