package com.ntu.binarytree;
/**
 * 判断二叉树B是不是二叉树A的子树
 * @author Lenovo
 *
 */
public class HasSubTree {
	public boolean hasSubTree(BinaryTreeNode headNode1,BinaryTreeNode headNode2){
		boolean flag=false;
		if(headNode1!=null&&headNode2!=null){
			if(headNode1.data==headNode2.data)
				flag=tree1HaveTree2(headNode1,headNode2);
			if(!flag)
				flag=hasSubTree(headNode1.leftNode, headNode2);
			if(!flag)
				flag=hasSubTree(headNode1.rightNode, headNode2);
		}
		return flag;
	}
	
	public boolean tree1HaveTree2(BinaryTreeNode headNode1,BinaryTreeNode headNode2){
		if(headNode2==null)
			return true;
		if(headNode1==null)
			return false;
		if(headNode1.data!=headNode2.data)
			return false;
		return tree1HaveTree2(headNode1.leftNode,headNode2.leftNode)
				&&tree1HaveTree2(headNode1.rightNode,headNode2.rightNode);
	}
}
