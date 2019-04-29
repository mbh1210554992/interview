package com.ntu.link;
/**
 * 在O(1)时间删除链表节点
 * 一般是从头开始遍历，这样的复杂度为O（n）
 * 
 * @author Lenovo
 *
 */


public class DeleteNode {
	/**
	 * 三种情况
	 * 要删除的节点不是尾节点：应把该节点的值设为该节点下一个节点的值，然后让该节点指向下下一个结点
	 * 只有一个节点；O（1）
	 * 删除的是尾节点：O（n）
	 * 三种情况平均下来复杂度为O（1）
	 * @param headNode
	 * @param deleteNode
	 */
	static void delete(LinkedNode headNode,LinkedNode deleteNode){
		if(headNode==null||deleteNode==null){
			System.out.println("都是null");
			return;
		}
		//要删除的结点不是尾节点
		if(deleteNode.next!=null){
			deleteNode.data=deleteNode.next.data;
			deleteNode.next=deleteNode.next.next;
		}else if(headNode.next==deleteNode){ //链表中只有一个节点
			headNode.next=null;
		}else {//要删除的节点为尾节点
			while(headNode.next.next!=null){
				headNode=headNode.next;
			}
			headNode.next=null;
		}
	}
	
	public static void main(String[] args) {
		LinkedNode headNode=new LinkedNode(0);
		LinkedNode one=new LinkedNode(0);
		LinkedNode two=new LinkedNode(1);
		LinkedNode three=new LinkedNode(2);
		LinkedNode four=new LinkedNode(3);
		headNode.next=one;
		one.next=two;
		two.next=three;
		three.next=four;
		LinkedNode p=headNode;
		delete(headNode, four);
		while(p.next!=null){
			System.out.print(p.next.data+" ");
			p=p.next;
		}
	}
}
