package exercise5;

import java.util.HashMap;
import java.util.Map;

interface Tree {
    void display(int x, int y);
}

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

class FlyweightPattern {
    public static void main(String[] args) {
        for (int i = 0; i < 10; i++) {
            Tree tree = TreeFactory.getTree("green", "pine");
            tree.display(i * 10, i * 10);
        }
        System.out.println("Total number of trees: " + TreeFactory.getTreeCount());
    }
}

