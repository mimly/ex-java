package composite.v1;

import java.io.IOException;

import java.nio.file.Files;
import java.nio.file.Path;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

import javax.swing.JFrame;
import javax.swing.JTree;
import javax.swing.SwingUtilities;
import javax.swing.tree.DefaultMutableTreeNode;

public class Composite1 {

    public static void main (String[] args) {
        SwingUtilities.invokeLater(() -> {
            JFrame frame = new JFrame();
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frame.setSize(320, 240);
            frame.setVisible(true);

            VirtualDirectory root = new VirtualDirectory(Path.of("."), ".");

            Queue<Viewable> queue = new LinkedList<>();
            queue.offer(root);
            while (!queue.isEmpty()) {
                VirtualDirectory d1 = (VirtualDirectory) queue.poll();
                Path path = d1.getPath();
                try {
                    Files.list(path).map(Path::toFile).forEach(file -> {
                        if (file.isFile()) {
                            VirtualFile f1 = new VirtualFile(file.getName());
                            d1.add(f1);
                        } else if (file.isHidden()) {
                            VirtualHiddenFile f1 = new VirtualHiddenFile(file.getName());
                            d1.add(f1);
                        } else {
                            VirtualDirectory d2 = new VirtualDirectory(path, file.getName());
                            d1.add(d2);
                            queue.offer(d2);
                        }
                    });
                } catch(IOException e) {
                    e.printStackTrace();
                }
            }

            // VirtualDirectory d1 = new VirtualDirectory("A");
            // VirtualDirectory d2 = new VirtualDirectory("B");
            // root.add(d1);
            // root.add(d2);
            // root.add(new VirtualFile("C"));
            // d1.add(new VirtualFile("D"));
            // d2.add(new VirtualFile("E"));
            // d2.add(new VirtualFile("F"));

            JTree tree = new JTree(root.view());
            frame.add(tree);
        });
    }
}

/**
 * Composite design pattern - useful only when dealing with a tree data model.
 */
interface Viewable {
    DefaultMutableTreeNode view();
}

class VirtualFile implements Viewable {
    private final String name;

    public VirtualFile(String name) {
        this.name = name;
    }

    public String getName() {
        return this.name;
    }

    @Override
    public DefaultMutableTreeNode view() {
        return new DefaultMutableTreeNode(this.name);
    }
}

class VirtualHiddenFile implements Viewable {
    private final String name;

    public VirtualHiddenFile(String name) {
        this.name = name;
    }

    public String getName() {
        return this.name;
    }

    @Override
    public DefaultMutableTreeNode view() {
        return new DefaultMutableTreeNode(this.name);
    }
}

/**
 * Composite does not know anything about the objects it contains
 * and communicates with them only by a well-defined interface.
 */
class VirtualDirectory implements Viewable {
    private final String name;
    private final Path path;
    private final List<Viewable> viewables;

    public VirtualDirectory(String name) {
        this.name = name;
        this.path = null;
        this.viewables = new LinkedList<>();
    }

    public VirtualDirectory(Path path, String name) {
        this.name = name;
        this.path = path.resolve(name).normalize();
        this.viewables = new LinkedList<>();
    }

    public String getName() {
        return this.name;
    }

    public Path getPath() {
        return this.path;
    }

    /**
     * These methods could be also defined in the interface, violating ISP
     * (the interface-segregation principle) due to some dummy implementations
     * in the non-composite classes. On the other hand, if the methods were implemented
     * in the interface, all objects could be treated equally. @see Composite2.java
     */
    public void add(Viewable viewable) {
        this.viewables.add(viewable);
    }

    // ...

    @Override
    public DefaultMutableTreeNode view() {
        DefaultMutableTreeNode directory = new DefaultMutableTreeNode(this.name);
        for (Viewable viewable : viewables) {
            directory.add(viewable.view());
        }
        return directory;
    }
}
