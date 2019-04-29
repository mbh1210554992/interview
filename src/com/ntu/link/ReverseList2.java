package com.ntu.link;
/**
 * 反转链表（递归和非递归）
 * 输入一个链表的头结点，反转该链表并输出反转后链表的头结点
 * 需要定义三个指针：
 * 1.当前结点的下一个节点（先将下一个结点保存）
 * 2.当前遍历到的结点
 * 3.当前结点的上一个结点（使当前结点的next指向此节点）
 * 
 * @author Lenovo
 *
 */
public class ReverseList2 {
	/**
	 * 需要定义三个指针：
	 * 1.当前结点的下一个节点（先将下一个结点保存）
	 * 2.当前遍历到的结点
	 * 3.当前结点的上一个结点（使当前结点的next指向此节点）
	 * @param headNode
	 * @return
	 */
	private LinkedNode reverseList(LinkedNode headNode){
		if(headNode==null){
			System.out.println("头结点为空！");
			return null;
		}
		LinkedNode nowNode=headNode;  //当前结点
		LinkedNode preNode=null; //上一个节点
		LinkedNode nextNode=null; //下一个节点
		LinkedNode revHead=null; //反转后的头结点
		while(nowNode!=null){
			if(nowNode.next==null){
				revHead=nowNode;
			}
			nextNode=nowNode.next;
			nowNode.next=preNode;
			preNode=nowNode;
			nowNode=nextNode;
		}
		return revHead;
	}
	
	public void print(LinkedNode headNode){
		if(headNode==null){
			System.out.println("链表为空！");
			return ;
		}
		while(headNode!=null){
			System.out.print(headNode.data+" ");
			headNode=headNode.next;
		}
	}
	
	public static void main(String[] args) {
		LinkedNode one=new LinkedNode(1);
		LinkedNode two=new LinkedNode(2);
		LinkedNode three=new LinkedNode(3);
		LinkedNode four=new LinkedNode(4);
		LinkedNode five=new LinkedNode(5);
		one.next=two;
		two.next=three;
		three.next=four;
		four.next=five;
		ReverseList2 test=new ReverseList2();
		System.out.print("反转前的链表为：");
		test.print(one);
		System.out.println();
		
		System.out.print("反转后的链表为：");
		test.print(test.reverseList(one));
	}
}
