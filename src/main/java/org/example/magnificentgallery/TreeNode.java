package org.example.magnificentgallery;

import org.example.magnificentgallery.Entity.Painting;

import java.util.ArrayList;

public class TreeNode {
    private Painting painting;
    private ArrayList<TreeNode> children;

    public TreeNode(Painting painting, ArrayList<TreeNode> children) {
        this.painting = painting;
        this.children = children;
    }

    // Getters and setters for painting and children

    public Painting getPainting() {
        return painting;
    }

    public TreeNode getPaintingById(int id) {
        var painting = getAllChilds().stream().filter(item -> item.getPainting().getId() == id).findFirst().orElse(null);
        return painting;
    }

    public void setPainting(Painting painting) {
        this.painting = painting;
    }

    public ArrayList<TreeNode> getChildren() {
        return children;
    }

    public void setChildren(ArrayList<TreeNode> children) {
        this.children = children;
    }

    public void addChildren(int id, TreeNode child) {
        var painting = getAllChilds().stream().filter(item -> item.getPainting().getId() == id).findFirst().orElse(null);

        if (painting != null) {
            ArrayList<TreeNode> currentChildren = painting.getChildren();

            currentChildren.add(child);

            painting.setChildren(currentChildren);
        }
    }

    public ArrayList<TreeNode> getAllChilds() {
        ArrayList<TreeNode> treeNodeList = new ArrayList<TreeNode>();

        treeNodeList.add(this);

        if (this.getChildren() != null && !this.getChildren().isEmpty()) {
            for (TreeNode child : this.getChildren()) {
                treeNodeList.addAll(child.getAllChilds());
            }
        }

        return treeNodeList;
    }
}
