package fiftyquestions;

public class BinaryTreeToDoublyLinkedList {

    private class TreeNode {
        private TreeNode left;
        private TreeNode right;
        private int value;
    }
    private TreeNode root;
    TreeNode doublyLinkedListNode = null;
    TreeNode prev = null;

    public TreeNode convertToDoublyLinkedList(){
        if(root == null) return null;
        convertToLinkedList(root, doublyLinkedListNode, prev);
        return doublyLinkedListNode;
    }

    private void convertToLinkedList(TreeNode node, TreeNode listHead, TreeNode prev){
        if(node == null) return;
        convertToLinkedList(node.left, listHead, prev);
        if(listHead == null){
            listHead = node;
        } else {
            prev.right = node;
            node.left = prev;
        }
        prev = node;
        convertToLinkedList(node.right, listHead, prev);
    }
}
