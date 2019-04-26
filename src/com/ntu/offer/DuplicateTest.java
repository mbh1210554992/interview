package com.ntu.offer;
/**
 * 找出数组中重复的数
 * 在一个长度为n的数组中，所有数字都在0-n-1范围内。找出数组中任意一个重复的数
 * @author Lenovo
 *
 */
public class DuplicateTest {
	public static void main(String[] args) {
		int[] a={1,3,0,2,2};
		System.out.println(duplicate01(a));
		
	}
	/**
	 * 数组在内存中占据连续的空间，可以根据下标定位对应的元素
	 * 扫描到下标为i的数字m时，若m与i相等，则位置不变。若不相等，则m与下标为m的数
	 * 进行比较，如果相等，就是重复的数，若不相等，就将他们交换
	 * @return
	 */
	public static boolean duplicate01(int[] array){
		if(array==null||array.length<=0){
			return false;
		}
		for(int i=0;i<array.length;i++){
			//判断是否有0-n-1之外的数
			if(array[i]<0||array[i]>array.length-1){
				return false;
			}
		}
		for(int i=0;i<array.length;i++){
			while(array[i]!=i){
				if(array[i]==array[array[i]]){
					System.out.println("找到一个重复的数："+array[i]);
					return true;
				}
				int temp=array[array[i]];
				array[array[i]]=array[i];
				array[i]=temp;
			}
			
		}
		return false;
		
	}
}
