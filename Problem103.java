package leetcode;

import java.util.ArrayList;
import java.util.List;

public class Problem103 {
    public static void main(String[] args) {
        Problem103 problem101 = new Problem103();
        problem101.solve();
    }
    public void solve(){
        TreeNode p = new TreeNode(3);
        p.left = new TreeNode(9);
        TreeNode p_right =  new TreeNode(20);
        p_right.left = new TreeNode(15);
        p_right.right = new TreeNode (7);
        p.right = p_right;
        List<List<Integer>> list = levelOrder(p);
        for(List i: list) {
            for(int j = 0; j < i.size(); j++) {
                System.out.print(i.get(j) + " ");
            }
            System.out.println();
        }
    }

    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> list = new ArrayList<>();
        getLevel(root, list, 0);
        List<List<Integer>> returnList = new ArrayList<>();
        for(int i=0; i < list.size(); i++) {
            if(returnList.size() == i)returnList.add(i, new ArrayList<>());
            if(i%2 == 0) {
                for (int j = 0; j < list.get(i).size(); j++) {
                    returnList.get(i).add(list.get(i).get(j));
                }
            } else {
                for (int j = list.get(i).size() - 1; j >=0 ; j--) {
                    returnList.get(i).add(list.get(i).get(j));
                }
            }

        }
        return returnList;
    }
    private void getLevel(TreeNode node, List<List<Integer>> list, int level) {
        if(node == null) return;
        if(list.size() <= level)list.add(level, new ArrayList<>());
        list.get(level).add(node.val);
        getLevel(node.left, list, level + 1);
        getLevel(node.right, list, level + 1);
    }

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }
}
