package com.ntu.binarytree;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 二叉排序树
 * 或者是一颗空树，或者是具有以下性质的二叉树
 * 若左子树不为空，则左子树上的值均小于根结点的值
 * 若右子树不为空，则右子树上的值均大于根结点的值
 * 左右子树也分别为二叉排序树
 * @author Lenovo
 *
 */
public class BinarySortTreeTest {
	private Node root;
	
	//将data插入到二叉树中
	public void insert(int data){
		Node newNode=new Node(data);
		if(root==null){
			root=newNode;
		}else{
			Node current=root;
			Node parent;
			while(true){
				parent=current;
				if(data<current.data){
					current=current.left;
					if(current==null){
						parent.left=newNode;
						return;
					}
				}else{
					current=current.right;
					if(current==null){
						parent.right=newNode;
						return;
					}
				}
			}
		}
	}
	
	//将数值输入构建二叉树(调用insert)
	public void buildTree(int[] data){
		for(int i=0;i<data.length;i++){
			insert(data[i]);
		}
	}
	
	//中序遍历方法递归实现
	private void inOrder(Node localRoot){
		if(localRoot!=null){
			inOrder(localRoot.left);
			System.out.print(localRoot.data+" ");
			inOrder(localRoot.right);
		}
	}
	public void inOrder(){
		this.inOrder(root);
	}
	
	//先序遍历
	private void preOrder(Node localRoot){
		if(localRoot!=null){
			System.out.print(localRoot.data+" ");
			preOrder(localRoot.left);
			preOrder(localRoot.right);
		}
	}
	public void preOrder(){
		this.preOrder(root);
	}
	
	//后序遍历
	private void postOrder(Node localRoot){
		if(localRoot!=null){
			postOrder(localRoot.left);
			postOrder(localRoot.right);
			System.out.print(localRoot.data+" ");
		}
	}
	public void postOrder(){
		this.postOrder(root);
	}
	
	//层序遍历(利用队列实现)，将根结点放入到队列中，每次从队列中取出一个数并打印，若右子节点，将子结点放入队列
	public void layerTraverse(){
		if(this.root==null){
			return;
		}
		Queue q=new LinkedList();
		q.offer(this.root);
		while(!q.isEmpty()){
			Node n=(Node) q.poll();
			System.out.print(n.data+" ");
			if(n.left!=null){
				q.offer(n.left);
			}
			if(n.right!=null){
				q.offer(n.right);
			}
		}
	}
	
	
	
	public static void main(String[] args) {
		BinarySortTreeTest test=new BinarySortTreeTest();
		int[] data={2,8,7,4,9,3,1,6,7,5};
		test.buildTree(data);
		System.out.print("先序遍历：");
		test.preOrder();
		System.out.print("\n中序遍历：");
		test.inOrder();
		System.out.print("\n后序遍历: ");
		test.postOrder();
		System.out.print("\n层序遍历：");
		test.layerTraverse();
	}

}






class Node{
	int data;
	Node left;
	Node right;
	public Node(int data){
		this.data=data;
		this.left=null;
		this.right=null;
	}
}
