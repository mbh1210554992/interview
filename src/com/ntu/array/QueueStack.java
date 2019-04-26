package com.ntu.array;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 利用两个队列来模拟实现栈
 * 添加元素向q1添加，删除的话，把q1元素按顺序出队到q2，最后q1剩下一个元素，就是要出栈的元素
 * 再添加元素的话，就向非空的队列添加元素
 * @author Lenovo
 *
 */
public class QueueStack {
	//LinkedList实现了Queue接口
	private Queue<Integer> queue1=new LinkedList<Integer>();
	private Queue<Integer> queue2=new LinkedList<Integer>();
	public  void append(Integer data){
		if(!queue1.isEmpty()){
			queue1.offer(data);
		}else{
			queue2.offer(data);
		}
		System.out.println("向模拟栈中添加的数据为："+data);
		System.out.println("queue1:"+queue1.toString());
		System.out.println("queue2:"+queue2.toString());
	}
	public void delete(){
		Queue<Integer> emptyQueue=queue1;
		Queue<Integer> notEmptyQueue=queue2;
		if(!queue1.isEmpty()){
			emptyQueue=queue2;
			notEmptyQueue=queue1;
		}
		while(notEmptyQueue.size()!=1){
			emptyQueue.offer(notEmptyQueue.poll());
		}
		int temp=notEmptyQueue.poll();
		System.out.println("从模拟栈中删除的数为："+temp);
		System.out.println("queue1:"+queue1.toString());
		System.out.println("queue2:"+queue2.toString());
	}
	public static void main(String[] args) {
		QueueStack qs=new QueueStack();
		qs.append(1);
		qs.append(2);
		qs.append(3);
		qs.append(4);
		qs.append(5);
		qs.delete();
		qs.delete();
		qs.delete();
	}
}
