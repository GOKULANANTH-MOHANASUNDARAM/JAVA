package exercise5;

import java.util.HashMap;
import java.util.Map;

/**
 * Defines the method signature for displaying a tree at a given position.
 * @author gokulananth
 */
interface Tree {
    void display(int x, int y);
}

/**
 * A concrete implementation of the Tree interface that represents a pine tree.
 * @author gokulananth
 */
class PineTree implements Tree {
    private final String color;
    private final String texture;

    public PineTree(String color, String texture) {
        this.color = color;
        this.texture = texture;
        System.out.println("Creating PineTree with color " + color + " and texture " + texture);
    }

    @Override
    public void display(int x, int y) {
        System.out.println("Displaying PineTree at position (" + x + ", " + y + ") with color " + color + " and texture " + texture);
    }
}

/**
 * A factory class that manages a pool of tree objects using a hashmap. 
 * It provides a method for getting a tree object with a given color and texture, and a method for getting the total number of tree objects in the pool.
 * @author gokulananth
 */
class TreeFactory {
    private static Map<String, Tree> treePool = new HashMap<>();

    public static Tree getTree(String color, String texture) {
        String key = color + texture;
        if (!treePool.containsKey(key)) {
            treePool.put(key, new PineTree(color, texture));
        }
        return treePool.get(key);
    }

    public static int getTreeCount() {
        return treePool.size();
    }
}

/**
 * The main class that creates and displays multiple pine trees using the TreeFactory. 
 * The Flyweight pattern is used to reduce the number of objects created and to reuse existing objects when possible.
 * @author gokulananth
 */
class FlyweightPattern {
    public static void main(String[] args) {
        for (int i = 0; i < 10; i++) {
            Tree tree = TreeFactory.getTree("green", "pine");
            tree.display(i * 10, i * 10);
        }
        System.out.println("Total number of trees: " + TreeFactory.getTreeCount());
    }
}

