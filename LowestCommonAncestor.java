package fiftyquestions;

public class LowestCommonAncestor {

    class TreeNode {
        private TreeNode left;
        private TreeNode right;
        private int value;
    }
    private TreeNode root;
    public int findLowestCommonAncestor(int one, int two){
        if(root == null) throw new RuntimeException();
        return findLowestCommonAncestor(one, two, root);
    }

    private Integer findLowestCommonAncestor(int one, int two, TreeNode subTree){
        if(subTree == null) return null;
        if(subTree.value == one || subTree.value == two) return new Integer(subTree.value);

        Integer leftValue = findLowestCommonAncestor(one, two, subTree.left);
        Integer rightValue = findLowestCommonAncestor(one, two, subTree.right);

        if(leftValue != null && rightValue != null) return new Integer(subTree.value);
        if(leftValue == null && rightValue == null) return null;
        return leftValue!=null? leftValue:rightValue;
    }
}
