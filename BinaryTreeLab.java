/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package lab_dsa_7_8;

import java.util.LinkedList;
import java.util.Queue;

/**
 *
 * @author N TECH
 */

    /**
     * @param args the command line arguments
     */
 
// Node class representing a tree node
class Node {
    int value;
    Node left, right;

    // Constructor
    public Node(int value) {
        this.value = value;
        left = right = null;
    }
}

// BinaryTree class
class BinaryTree {
    private Node root;
    private int nodeCount; // Keeps track of the number of nodes

    // Constructor
    public BinaryTree() {
        root = null;
        nodeCount = 0;
    }

    // Method to insert a node into the binary tree
    public void insert(int value) {
        root = insertRec(root, value);
        nodeCount++;
    }

    // Recursive helper for insertion
    private Node insertRec(Node root, int value) {
        if (root == null) {
            return new Node(value);
        }
        if (value < root.value) {
            root.left = insertRec(root.left, value);
        } else {
            root.right = insertRec(root.right, value);
        }
        return root;
    }

    // Method to count the total nodes in the tree
    public int getNodeCount() {
        return nodeCount;
    }

    // Level-order Traversal
    public void levelOrderTraversal() {
        if (root == null) {
            System.out.println("Tree is empty");
            return;
        }
        Queue<Node> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            Node current = queue.poll();
            System.out.print(current.value + " ");
            if (current.left != null) queue.add(current.left);
            if (current.right != null) queue.add(current.right);
        }
        System.out.println();
    }

    // Pre-order Traversal (Root -> Left -> Right)
    public void preOrderTraversal() {
        preOrderTraversalRec(root);
        System.out.println();
    }

    private void preOrderTraversalRec(Node root) {
        if (root != null) {
            System.out.print(root.value + " ");
            preOrderTraversalRec(root.left);
            preOrderTraversalRec(root.right);
        }
    }

    // In-order Traversal (Left -> Root -> Right)
    public void inOrderTraversal() {
        inOrderTraversalRec(root);
        System.out.println();
    }

    private void inOrderTraversalRec(Node root) {
        if (root != null) {
            inOrderTraversalRec(root.left);
            System.out.print(root.value + " ");
            inOrderTraversalRec(root.right);
        }
    }

    // Post-order Traversal (Left -> Right -> Root)
    public void postOrderTraversal() {
        postOrderTraversalRec(root);
        System.out.println();
    }

    private void postOrderTraversalRec(Node root) {
        if (root != null) {
            postOrderTraversalRec(root.left);
            postOrderTraversalRec(root.right);
            System.out.print(root.value + " ");
        }
    }
}

// Main class to test the BinaryTree
public class BinaryTreeLab {
    public static void main(String[] args) {
        BinaryTree tree = new BinaryTree();

        // Part 3: Testing the Binary Tree
        int[] elements = {50, 30, 20, 40, 70, 60, 80}; // Elements to insert
        System.out.println("Insertion Test:");
        for (int value : elements) {
            tree.insert(value);
            System.out.println("Inserted: " + value + ", Total Nodes: " + tree.getNodeCount());
        }

        // Perform Traversal Tests
        System.out.println("\nTraversal Tests:");
        System.out.print("Level-order Traversal: ");
        tree.levelOrderTraversal();

        System.out.print("Pre-order Traversal: ");
        tree.preOrderTraversal();

        System.out.print("In-order Traversal: ");
        tree.inOrderTraversal();

        System.out.print("Post-order Traversal: ");
        tree.postOrderTraversal();
    }
}
