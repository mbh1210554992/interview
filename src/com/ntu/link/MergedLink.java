package com.ntu.link;
/**
 * 合并两个排序的链表
 * 新链表仍然是递增排序
 * @author Lenovo
 *
 */
public class MergedLink {
	/**
	 * 利用递归来实现
	 * 比较两个链表的头结点
	 * 将小的那一个作为合并链表的头结点
	 * 然后将它的next继续做递归操作
	 * @param headNode1
	 * @param headNode2
	 * @return
	 */
	public LinkedNode merge(LinkedNode headNode1,LinkedNode headNode2){
		if(headNode1==null){
			return headNode2;
		}
		if(headNode2==null){
			return headNode1;
		}
		LinkedNode mergeHeadNode=null;
		if(headNode1.data<headNode2.data){
			mergeHeadNode=headNode1;
			mergeHeadNode.next=merge(headNode1.next,headNode2);
		}else{
			mergeHeadNode=headNode2;
			mergeHeadNode.next=merge(headNode1,headNode2.next);
		}
		return mergeHeadNode;
	}
	/**
	 * 利用尾插法构建链表
	 * @param a
	 * @return
	 */
	public LinkedNode build(int[] a){
		if(a.length<=0){
			System.out.println("输入的数组为空！");
			return null;
		}
		LinkedNode headNode=new LinkedNode(a[0]);
		LinkedNode p=headNode;
		for(int i=1;i<a.length;i++){
			LinkedNode q=new LinkedNode(a[i]);
			p.next=q;
			p=q;
		}
		return headNode;
	}
	/**
	 * 输出链表
	 * @param headNode
	 */
	public void print(LinkedNode headNode){
		if(headNode==null){
			System.out.println("链表为空！");
			return;
		}
		while(headNode!=null){
			System.out.print(headNode.data+" ");
			headNode=headNode.next;
		}
		System.out.println();
	}
	
	public static void main(String[] args) {
		int[] a={2,4,6,7,9};
		int []b={1,3,5,6,7,8};
		MergedLink test=new MergedLink();
		LinkedNode headNode1=test.build(a);
		LinkedNode headNode2=test.build(b);
		System.out.print("链表一：");
		test.print(headNode1);
		System.out.print("链表二：");
		test.print(headNode2);
		LinkedNode mergeHeadNode=test.merge(headNode1, headNode2);
		
		System.out.println("合并后的链表为：");
		test.print(mergeHeadNode);
	}
}
