package org.example.magnificentgallery;

import org.example.magnificentgallery.Entity.Painting;

import java.util.ArrayList;

public class LinkedListNode {
    private Painting painting;
    private LinkedListNode link;

    public LinkedListNode() {
        link = null;
        painting = null;
    }

    public LinkedListNode(Painting painting, LinkedListNode link) {
        link = link;
        painting = painting;
    }

    public Painting getPainting() {
        return painting;
    }

    public void setPainting(Painting painting) {
        this.painting = painting;
    }

    public LinkedListNode getLink() {
        return link;
    }

    public void setLink(LinkedListNode link) {
        this.link = link;
    }

    public LinkedListNode addPainting(Painting painting) {
        if (this.getPainting() == null) {
            this.painting = painting;
        } else {
            LinkedListNode current = this;
            while (current.getLink() != null) {
                current = current.getLink();
            }
            current.setLink(new LinkedListNode(painting, null));
            current.getLink().setPainting(painting);
        }
        return this;
    }

    public void deleteNodesFromLinkedList() {
        if (this.getLink() == null) {
            this.setPainting(null);
        } else {
            this.setPainting(null);
            this.setLink(null);
        }
    }

    public ArrayList<Painting> getAllNodes() {
        var arrayList = new ArrayList<Painting>();

        if (this.getLink() == null && this.getPainting() == null) {
            return arrayList;
        } else if (this.getLink() == null && this.getPainting() != null) {
            arrayList.add(this.getPainting());
            return arrayList;
        } else {
            LinkedListNode current = this;
            arrayList.add(current.getPainting());
            while (current.getLink() != null) {
                current = current.getLink();

                arrayList.add(current.getPainting());
            }
            return arrayList;
        }
    }
}
