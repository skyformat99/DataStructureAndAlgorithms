import common.Tree;
import common.TreeNode;

public class AVLTree<T extends Comparable<T>> extends Tree{
	public TreeNode<T> root;

	public AVLTree(TreeNode root) {
		super(root);
	}

	/**
	 * 插入元素
	 * @param e
	 */
	public void insert(T e){
		if(root == null){
			root = new TreeNode<T>(e);
		}else{
			boolean success = false;
			TreeNode<T> parent = root;
			while(!success){
				int compare = e.compareTo(parent.val);
				if(compare < 0){
					if(parent.left != null){
						parent = parent.left;
					}else{
						parent.left = new TreeNode<T>(e);
						success = true;
					}
				}else if(compare > 0){
					if(parent.right != null){
						parent = parent.right;
					}else{
						parent.right = new TreeNode<T>(e);
						success = true;
					}
				}else{
					System.out.println("Insert failed, Node:["+ e.toString() +"] has been existed.");
				}
			}
		}
	}
	
	/**
	 * 删除元素
	 * @param e
	 */
	public void delete(T e){
	}
	
	/**
	 * 查找元素
	 * @param e
	 */
	public TreeNode<T> search(T e){
		return null;
	}
}