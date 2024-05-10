package org.example.magnificentgallery;

import org.example.magnificentgallery.Entity.Customer;
import org.example.magnificentgallery.Entity.Painting;

import java.util.*;
import java.util.stream.Collectors;

public class Service {
    public String[] getPaintingUrlList() {
        var tree = getPaintingTree();
        var paintings = tree.getAllChilds();
        String[] urlList = paintings.stream()
                .map(item -> item.getPainting().getUrl())
                .toArray(String[]::new);
        return urlList;
    }

    public TreeNode getPaintingTree() {
        var paintings = new Painting().getPaintings();
        TreeNode tree = null;

        if (!paintings.isEmpty()) {
            // root node
            tree = new TreeNode(paintings.get(0), new ArrayList<>());

            paintings.sort(Comparator.comparingInt(Painting::getId));
            //  children nodes
            for (Painting painting : paintings) {
                var node = tree.getPaintingById(painting.getParentId());
                if (node != null) {
                    node.addChildren(painting.getParentId(), new TreeNode(painting, new ArrayList<>()));
                }
            }
        }

        return tree;
    }

    public Customer GetCustomer(String email) {
        var customers = new Customer().getCustomers();
        var customer = customers.stream().filter(x -> x.getEmail().equals(email)).findFirst();

        return customer.orElse(null);
    }

    public double GetTotalPrice(ArrayList<Painting> paintings) {
        Map<Integer, List<Painting>> totalPriceByPaintingId = paintings.stream()
                .collect(Collectors.groupingBy(Painting::getId));

        double totalAmount = 0.0;
        for (List<Painting> group : totalPriceByPaintingId.values()) {
            for (Painting painting : group) {
                totalAmount += painting.getPrice();
            }
        }

        return totalAmount;
    }
}
