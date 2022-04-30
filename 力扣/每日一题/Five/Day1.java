package 力扣.每日一题.Five;

import 力扣.知识点.二叉树.TreeNode;

import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

public class Day1 {
    /*
        暴力法
     */
    List<Integer> res = new LinkedList<>();

    public List<Integer> getAllElements(TreeNode root1, TreeNode root2) {
        sumTree(root1);
        sumTree(root2);
        Collections.sort(res);//直接排序
        return res;
    }

    public void sumTree(TreeNode root) {
        if (root == null) {
            return;
        }
        res.add(root.val);
        sumTree(root.left);
        sumTree(root.right);
    }

    /*
        中序遍历+归并排序
        归并是因为中序遍历之后,得到两个有序的列表,合并两个有序列表称为  "归并"
     */
    public List<Integer> getAllElements2(TreeNode root1, TreeNode root2) {
        List<Integer> list1 = new LinkedList<>();
        List<Integer> list2 = new LinkedList<>();
        inorder(list1, root1);
        inorder(list2, root2);
        //合并这两个列表
        int i = 0, j = 0;
        while (i < list1.size() || j < list2.size()) {
            //某一个到达尽头,直接取出所有
            if (i == list1.size()) {
                res.addAll(list2.subList(j, list2.size()));
                break;
            }
            if (j == list2.size()) {
                res.addAll(list1.subList(i, list1.size()));
                break;
            }
            //正常归并
            if (list1.get(i) < list2.get(j)) {
                res.add(list1.get(i++));
            } else {
                res.add(list2.get(j++));
            }
        }
        return res;
    }

    /*
        中序遍历
     */
    private void inorder(List<Integer> list, TreeNode root) {
        if (root == null) {
            return;
        }
        inorder(list, root.left);
        list.add(root.val);
        inorder(list, root.right);
    }
}
