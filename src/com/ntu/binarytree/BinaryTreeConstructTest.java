package com.ntu.binarytree;

import java.util.Arrays;

/**
 * 重建二叉树
 * 输入二叉树的前序遍历和中序遍历结果，重建二叉树
 * 例：输入的前序和中序不含重复的数，前序：12473568，中序：47215386，输出后序遍历结果
 * 思路：前序的第一个数一定是根结点，根结点在中序里是在中间的位置，其左边是左子树，右边是右子树
 * 假设中序的根结点左边有3个数，即根结点的左子树有3个节点，这三个数的顺序是左子树的中序
 * 那么前序的第一个数的后面三个肯定是左子树的前序遍历	·
 * @author Lenovo
 *
 */
public class BinaryTreeConstructTest {
	/**
	 * 重建二叉树
	 * @param preorder 前序遍历
	 * @param inorder  中序遍历
	 * @return
	 */
	static BinaryTreeNode rebuild(int[] preorder,int[] inorder){
		BinaryTreeNode root=
				rebuild(preorder,0,preorder.length-1,inorder,0,inorder.length-1);
		return root;
	}
	/**
	 * 
	 * @param preorder 前序遍历
	 * @param startPre 前序遍历开始的位置
	 * @param endPre   前序遍历结束的位置
	 * @param inorder  中序........
	 * @param startIn
	 * @param endIn
	 * @return
	 */
	static BinaryTreeNode rebuild(int[] preorder,int startPre,int endPre,int[] inorder,int startIn,int endIn){
		if(startIn>endIn||startPre>endPre||preorder.length!=inorder.length ){
			return null;
		}
		boolean haveRoot=false;
		//前序第一个数为根结点
		BinaryTreeNode root=new BinaryTreeNode();
		for(int i=startIn;i<inorder.length;i++){
			//找到中序遍历的根结点
			if(preorder[startPre]==inorder[i]){
				haveRoot=true;
				root.data=preorder[startPre];
				//根结点左子树（在左子树中找到其根结点和左右子树）
				root.leftNode=
						rebuild(Arrays.copyOfRange(preorder, 1,i+1),Arrays.copyOfRange(inorder, 0,i));
				//根结点的右子树（在右子树中找到其根结点和左右子树）
				root.rightNode=
						rebuild(Arrays.copyOfRange(preorder, i+1, preorder.length),Arrays.copyOfRange(inorder, i+1, inorder.length));
			}
		}
		if(!haveRoot){
			System.out.println("没有找到根节点");
			return null;
		}
		return root;
	}
	
	static void postorder(BinaryTreeNode root){
		if(root==null){
			System.out.println("根节点为空");
		}
		if(root.leftNode!=null){
			postorder(root.leftNode);
		}
		if(root.rightNode!=null){
			postorder(root.rightNode);
		}
		System.out.println(root.data);
	}
	
	//测试
	public static void main(String[] args) {
		int[] preorder={1,2,4,7,3,5,6};
		int[] inorder={4,7,2,1,5,3,6};
		postorder(rebuild(preorder,inorder));
	}
		
				
}

/**
 * 二叉树结点
 * @author Lenovo
 *
 */
class BinaryTreeNode{
	int data;
	BinaryTreeNode leftNode;
	BinaryTreeNode rightNode;
}
