package com.ntu.offer;

import java.util.Stack;

/**
 * 用两个栈实现队列
 * 完成两个方法append Tail和deletedHead,分别是在队列尾部插入结点和在队列头部删除结点的功能
 * 
 * 思路：添加元素，即压入一个栈s1，删除元素的话，把s1中的元素按顺序先弹出再压入栈s2，这时
 * 弹出栈s2的元素就能实现先进先出
 * @author Lenovo
 *
 */
public class StackQueue {
	private Stack<Integer> stack1=new Stack();
	private Stack<Integer> stack2=new Stack();
	
	/**
	 * 添加元素就直接向stack1中添加
	 * @param elem
	 */
	public void appendTail(int elem){
		stack1.push(elem);
		System.out.print("向模拟队列中添加的数为："+elem);
		System.out.println(" stack1:"+stack1.toString());
	}
	
	/**
	 * 删除分三种情况
	 * 1.stack2不空，直接从它里头弹出
	 * 2.stack2空，stack1不空，ba1中先弹再压到2，再从2弹出
	 * 3.两都空
	 */
	public void deleteHead(){
		if(!stack2.isEmpty()){
			System.out.println("从模拟队列中删除的数位："+stack2.pop());
		}else if(!stack1.isEmpty()){
			while(!stack1.isEmpty()){
				stack2.push(stack1.pop());
			}
			System.out.println("从模拟队列中删除的数位："+stack2.pop());
		}else{
			System.out.println("两个栈都空了");
		}
		System.out.println("stack1:"+stack1);
		System.out.println("stack2:"+stack2.toString());
	}
	
	
	
	
	public static void main(String[] args) {
		StackQueue test=new StackQueue();
		test.appendTail(2);
		test.appendTail(4);
		test.appendTail(6);
		test.deleteHead();
		test.appendTail(100);
		test.deleteHead();
		test.deleteHead();
		test.deleteHead();
	}
}
