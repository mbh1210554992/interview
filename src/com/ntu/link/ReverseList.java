package com.ntu.link;

import java.util.Scanner;
import java.util.Stack;

/**
 * 反向打印链表
 * 利用STACK来实现，先进后出
 * @author Lenovo
 *
 */
public class ReverseList {
	public static void main(String[] args) {
		LinkNode headNode=new LinkNode();
		LinkNode test=createLink(headNode);
		System.out.println("反向打印链表:");
		printLinkReverse(test);
	}
	
	
	/**
	 * 尾插法建立链表
	 * @param headNode:头结点，本身没有值
	 * @return
	 */
	public static LinkNode createLink(LinkNode headNode){
		LinkNode p=headNode;
		if(p==null){
			System.out.println("输入头节点为空，请检查");
			return null;
		}else{
			Scanner sc=new Scanner(System.in);
			System.out.println("输入链表的值：  以0为结束标志");
			int data=sc.nextInt();
			while(data!=0){
				//q为要插入的结点
				LinkNode q=new LinkNode();
				q.data=data;
				q.next=null;
				p.next=q;
				//p始终只想最后一个结点
				p=q;
				data=sc.nextInt();
			}
		}
		return headNode;
	}
	
	
	/**
	 * 从尾到头打印，利用栈
	 * @param headNode
	 */
	public static void printLinkReverse(LinkNode headNode){
		Stack<LinkNode> stack=new Stack<>();
		LinkNode p=headNode;
		while(p!=null&&p.next!=null){
			stack.push(p.next);
			p=p.next;
		}
		while(!stack.isEmpty()){
			
			System.out.print(stack.pop().data+" ");//pop():删除栈顶部的对象，并返回它
		}
	}

}

//链表的结点
class LinkNode{
	int data;
	LinkNode next=null;
}
