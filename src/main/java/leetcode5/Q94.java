package leetcode5;

import java.util.LinkedList;
import java.util.List;

/**
 * 给定一个二叉树，返回它的中序遍历。
 示例
 输入: [1,null,2,3]
 1
 \
 2
 /
 3
 输出: [1,3,2]

 */
public class Q94 {
    // 此处不能加static，多次执行的时候 多个实例会用同一份result
    public /**static*/ List<Integer> result = new LinkedList<>();
    /**
     * 前序遍历：根左右
     * 中序遍历：左根右
     * 后续遍历：左右根
     * @param root
     * @return
     */
    public List<Integer> inorderTraversal(TreeNode root) {
        if(root!=null){
            if(root.left!=null){
                inorderTraversal(root.left);
            }
            result.add(root.val);
            if(root.right!=null){
                inorderTraversal(root.right);
            }
        }

        return result;
    }
    static class TreeNode {
      int val;
      TreeNode left;
      TreeNode right;
      TreeNode(int x) { val = x; }
    }
}
