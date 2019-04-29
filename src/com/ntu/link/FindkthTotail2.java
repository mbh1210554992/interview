package com.ntu.link;

import java.util.Scanner;

/**
 * 打印链表中倒数第k个数（方法二）
 * 定义两个指针
 * 第一个指针先遍历到第k-1个节点
 * 然后第二个指针再开始遍历
 * 第一个指针遍历完时，第二个指针正好还差k个节点未遍历完
 * @author Lenovo
 *
 */
public class FindkthTotail2 {
	/**
	 * 利用指针
	 * 定义两个指针
	 * 第一个指针先遍历到第k-1个节点
	 * 然后第二个指针再开始遍历
	 * 第一个指针遍历完时，第二个指针正好还差k个节点未遍历完
	 * @param headNode
	 * @param k
	 * @return
	 */
	public LinkedNode find(LinkedNode headNode,int k){
		if(headNode==null||k<=0){
			System.out.println("链表为空或输入的k值有误");
			return null;
		}
		LinkedNode p1=headNode;
		for(int i=0;i<k-1;i++){
			p1=p1.next;
			if(p1==null){
				System.out.println("k值有误");
				return null;
			}
		}
		LinkedNode p2=headNode;
		while(p1.next!=null){
			p1=p1.next;
			p2=p2.next;
		}
		return p2;
	}
	/**
	 * 构建链表，头结点不存储值
	 * @param headNode
	 * @return
	 */
	public LinkedNode buildLink(LinkedNode headNode){
		if(headNode==null){
			System.out.println("头结点为空");
			return null;
		}
		LinkedNode p=headNode;
		Scanner sc=new Scanner(System.in);
		System.out.println("请输入链表的值（以0为结束标志）：");
		int input=sc.nextInt();
		while(input!=0){
			LinkedNode q=new LinkedNode(input);
			p.next=q;
			p=q;
			input=sc.nextInt();
		}
		return headNode;
	}
	/**
	 * 打印链表
	 */
	public void print(LinkedNode headNode){
		if(headNode==null){
			System.out.println("头结点为空！");
			return;
		}
		while(headNode.next!=null){
			System.out.print(headNode.next.data+" ");
			headNode=headNode.next;
		}
	}
	
	public static void main(String[] args) {
		LinkedNode headNode=new LinkedNode();
		FindkthTotail2 test=new FindkthTotail2();
		test.buildLink(headNode);
		System.out.println();
		System.out.print("链表为：");
		test.print(headNode);
		Scanner sc=new Scanner(System.in);
		System.out.println();
		System.out.println("请输入要查询倒数第几个数：");
		int k=sc.nextInt();
		int data=test.find(headNode, k).data;
		System.out.println("倒数第 "+k+" 个数为："+data);
		
	}
}
