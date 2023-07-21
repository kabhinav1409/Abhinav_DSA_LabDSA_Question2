package com.binarySerachTree;

public class BSTPairSumFinder {

    // Function to find a pair with the given sum in the BST
    public static void findPairWithSum(Node root, int targetSum) {
        if (root == null) {
            System.out.println("Nodes are not found.");
            return;
        }

        Node left = getSmallest(root);
        Node right = getLargest(root);

        while (left != right) {
            int sum = left.data + right.data;

            if (sum == targetSum) {
                System.out.println("Pair is (" + left.data + ", " + right.data + ")");
                return;
            } else if (sum < targetSum) {
                left = getInorderSuccessor(root, left);
            } else {
                right = getInorderPredecessor(root, right);
            }
        }

        System.out.println("Nodes are not found.");
    }

    // Helper function to get the smallest node in the BST
    private static Node getSmallest(Node node) {
        while (node.left != null) {
            node = node.left;
        }
        return node;
    }

    // Helper function to get the largest node in the BST
    private static Node getLargest(Node node) {
        while (node.right != null) {
            node = node.right;
        }
        return node;
    }

    // Helper function to find the in-order successor of a node in the BST
    private static Node getInorderSuccessor(Node root, Node node) {
        if (node.right != null) {
            return getSmallest(node.right);
        }

        Node successor = null;
        while (root != null) {
            if (node.data < root.data) {
                successor = root;
                root = root.left;
            } else if (node.data > root.data) {
                root = root.right;
            } else {
                break;
            }
        }

        return successor;
    }

    // Helper function to find the in-order predecessor of a node in the BST
    private static Node getInorderPredecessor(Node root, Node node) {
        if (node.left != null) {
            return getLargest(node.left);
        }

        Node predecessor = null;
        while (root != null) {
            if (node.data > root.data) {
                predecessor = root;
                root = root.right;
            } else if (node.data < root.data) {
                root = root.left;
            } else {
                break;
            }
        }

        return predecessor;
    }

    // Sample Binary Search Tree creation for testing
    public static Node createBST() {
        Node root = new Node(10);
        root.left = new Node(20);
        root.right = new Node(30);
        root.left.left = new Node(40);
        root.left.right = new Node(50);
        root.right.left = new Node(60);
        root.right.right = new Node(70);
        return root;
    }

    public static void main(String[] args) {
        int targetSum = 130;
        Node root = createBST();
        findPairWithSum(root, targetSum);
    }
}
