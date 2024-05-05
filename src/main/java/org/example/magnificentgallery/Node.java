package org.example.magnificentgallery;

import java.util.ArrayList;

public class Node {
    private int paintingId;
    private int level;
    private ArrayList<Node> childList;

    public  Node(int paintingId){
        this.paintingId = paintingId;
        this.level = 0;
        this.childList = new ArrayList<Node>();
    }

    public int getPaintingId() {
        return paintingId;
    }

    public void setPaintingId(int paintingId) {
        this.paintingId = paintingId;
    }

    public int getLevel(){
        return level;
    }

    public ArrayList<Node> getChildList() {
        return childList;
    }

    public void setChildList(ArrayList<Node> childList) {
        this.childList = childList;
    }

    public void addChild(Node child) {
        this.childList.add(child);
    }

    public void deleteChild(Node child) {
        this.childList.remove(child);
    }

    public void deleteChildByPaintingId(int paintingId) {
        this.childList.removeIf(child -> child.getPaintingId() == paintingId);
    }
}
