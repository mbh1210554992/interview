package com.ntu.array;
/**
 * 使数组中奇数位于偶数之前
 * 前后各一个指针互相靠近如果前偶后奇，就交换位置，直到指针相遇
 * 时间复杂度O(n)
 * @author Lenovo
 *
 */
public class ReOrder {
	/**
	 * 判断是否为偶数
	 * @param num
	 * @return
	 */
	static boolean isEvenNymber(int num){
		return num%2==0?true:false;
	}
	
	static void reorder(int[] arr){
		if(arr.length==0){
			System.out.println("数组为空！");
		}
		int low=0;
		int high=arr.length-1;
		while(low<high){
			while(low<high&&!isEvenNymber(arr[low])){
				low++;
			}
			while(low<high&&isEvenNymber(arr[high])){
				high--;
			}
			int temp=arr[low];
			arr[low]=arr[high];
			arr[high]=temp;
		}
	}
	
	public static void main(String[] args) {
		int[] arr={2,4,6,1,7,9,6,11,12,13,14,15,13,15};
		reorder(arr);
		for(int temp:arr){
			System.out.print(temp+" ");
		}
	}
}
