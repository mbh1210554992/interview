package com.ntu.offer;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/**
 * 找出数组中重复元素最多的数
 * 利用Map映射表，每个关键词只能在map中出现一次，用Value的值来存储出现的次数
 * @author Lenovo
 *
 */
public class FrequentArrayTest {
	public static void main(String[] args) {
		int a[]={1,2,3,4,5,6,6,6,6,7,7,7,7,7};
		System.out.println("数组中出现次数最多的数为："+frequentArray(a));
	}
	
	static int frequentArray(int[] target){
		int result=0;
		if(target.length==0){
			return Integer.MAX_VALUE;
		}
		//记录每个元素出现的次数
		Map<Integer,Integer> map=new HashMap();
		for(int i=0;i<target.length;i++){
			if(map.containsKey(target[i])){
				map.put(target[i], map.get(target[i])+1);
			}else{
				map.put(target[i], 1);
			}
		}
		
		//找出出现次数最多的元素
		int most=0;
		Iterator iter=map.keySet().iterator();
		while(iter.hasNext()){
			int key=(Integer) iter.next();
			int value=map.get(key);
			if(value>most){
				result=key;
				most=value;
			}
		}
		return result;
	}
	
}
