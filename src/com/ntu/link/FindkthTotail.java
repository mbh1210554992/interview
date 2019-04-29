package com.ntu.link;

import java.util.Scanner;

/**
 * 打印链表中倒数第k个数（方法一）
 * 利用头结点来存储链表的长度（头结点的下一个节点是链表的第一个节点）
 * 倒数第k个数就是第n-k+1个数（n为链表的长度）
 * @author Lenovo
 *
 */

class LinkNode2{
	int data;
	LinkNode2 next;
	public LinkNode2(int data){
		this.data=data;
	}
	
	
}


public class FindkthTotail {
	LinkNode2 p;//永远指向最后一个节点（用来进行尾插法）
	int size; //链表的长度
	LinkNode2 headNode=new LinkNode2(size); //头结点，用来存储链表的长度（头结点不算在链表长度中）
	
	//构建链表
	public void buildLink(){
		Scanner sc=new Scanner(System.in);
		System.out.println("输入链表的值，以0为结束标志");
		int data=sc.nextInt();
		
		while(true){
			if(headNode.next==null){
				LinkNode2 newNode=new LinkNode2(data);
				headNode.next=newNode;
				p=newNode;
				
				
			}else{
				LinkNode2 newNode=new LinkNode2(data);
				p.next=newNode;
				p=newNode;
			
				data=sc.nextInt();
				
			}
			if(data==0){
				break;
			}
			size++;
		}
		headNode.data=size;
	}
	/**
	 * 倒数第k个数：
	 * size为链表长度，要查询的结点为第size-k+1个结点
	 * @param k
	 * @return
	 */
	public LinkNode2 find(int k){
		if(k>size||k<=0){
			System.out.println("k值为空或有误");
			return null;
		}
		LinkNode2 q=headNode;
		for(int i=0;i<=size-k+1;i++){
			q=q.next;
		}
		return q;
	}
	
	public static void main(String[] args) {
		FindkthTotail test=new FindkthTotail();
		test.buildLink();
		Scanner sc=new Scanner(System.in);
		System.out.println("请输入要查询倒数第几个数：");
		int k=sc.nextInt();
		LinkNode2 node=test.find(k);
		System.out.println("链表的长度为："+test.headNode.data);
		System.out.println("倒数第 "+k+" 个数为："+node.data);
		
	}
}
