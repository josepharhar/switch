package gui;

import java.util.ArrayList;
import java.util.List;

public class Grid<E> {
    
    private int width;
    private int height;
    
    private Object[][] array;
    
    public Grid(int width, int height) {
        this.width = width;
        this.height = height;
        array = new Object[width][height];
    }
    
    // Object manipulation
    
    public void swap(int x1, int y1, int x2, int y2) {
        E temp = get(x1, y1);
        put(x1, y1, get(x2, y2));
        put(x2, y2, temp);
    }
    
    public E get(int x, int y) {
        return (E) array[x][y];
    }
    
    public E put(int x, int y, E obj) {
        array[x][y] = obj;
        return obj;
    }
    
    public E remove(int x, int y) {
        E obj = get(x, y);
        array[x][y] = null;
        return obj;
    }
    
    
    public int getWidth() {
        return width;
    }
    
    public int getHeight() {
        return height;
    }
    
    
    
    
    //Returns the objects up, down, left, and right of the specified location
    public List<E> getAdjacent(int x, int y) {
        List<E> output = new ArrayList<E>(4);
        
        if (isValid(x + 1, y)) {
            //Right
            output.add(get(x + 1, y));
        }
        if (isValid(x - 1, y)) {
            //Left
            output.add(get(x - 1, y));
        }
        if (isValid(x, y + 1)) {
            //Down
            output.add(get(x, y + 1));
        }
        if (isValid(x, y - 1)) {
            //Up
            output.add(get(x, y - 1));
        }
        
        return output;
    }
    
    public boolean isValid(int x, int y) {
        return x >= 0 && x < width && y >= 0 && y < height;
    }
}
