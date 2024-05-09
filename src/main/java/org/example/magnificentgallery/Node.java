package org.example.magnificentgallery;

import org.example.magnificentgallery.Entity.Painting;

import java.util.ArrayList;

public class Node {
    private Painting painting;
    private ArrayList<Node> children;

    public Node(Painting painting, ArrayList<Node> children) {
        this.painting = painting;
        this.children = children;
    }

    // Getters and setters for painting and children

    public Painting getPainting() {
        return painting;
    }

    public Node getPaintingById(int id) {
        var painting = getAllChilds().stream().filter(item->item.getPainting().getId() == id).findFirst().orElse(null);
        return painting;
    }

    public void setPainting(Painting painting) {
        this.painting = painting;
    }

    public ArrayList<Node> getChildren() {
        return children;
    }

    public void setChildren(ArrayList<Node> children) {
        this.children = children;
    }

    public void addChildren(int id, Node child) {
        var painting = getAllChilds().stream().filter(item->item.getPainting().getId() == id).findFirst().orElse(null);

        if (painting != null) {
            ArrayList<Node> currentChildren = painting.getChildren();

            currentChildren.add(child);

            painting.setChildren(currentChildren);
        }
    }

    public ArrayList<Node> getAllChilds() {
        ArrayList<Node> nodeList = new ArrayList<Node>();

        nodeList.add(this);

        if (this.getChildren()!= null && !this.getChildren().isEmpty()) {
            for (Node child : this.getChildren()) {
                nodeList.addAll(child.getAllChilds());
            }
        }

        return nodeList;
    }
}
