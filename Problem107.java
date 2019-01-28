import java.util.ArrayList;
import java.util.List;

public class Problem107 {
    public List<List<Integer>> levelOrderBottom(TreeNode root) {
        List<List<Integer>> tmpResult =  new ArrayList<List<Integer>>();
        List<List<Integer>> result =  new ArrayList<List<Integer>>();
        int level = 0;
        traverse(root, level, tmpResult );
        for(int i = tmpResult.size()-1; i >= 0; i--) {
            result.add(tmpResult.get(i));
        }
        return result;
    }

    private void traverse(TreeNode root, int level, List<List<Integer>> result) {
        if(root == null) return;
        if(result.size() == level) {
            result.add(new ArrayList<Integer>());
        }
        result.get(level).add(root.val);
        traverse(root.left, level+1, result);
        traverse(root.right, level+1, result);
    }
}
