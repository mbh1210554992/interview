package com.ntu.array;
/**
 * 旋转数组的最小数字
 * 把一个数组最开始的几个元素搬到数组末尾，称之为数组的旋转
 * 输入一个递增的数组旋转，输出他的最小元素。如{34512}为{12345}的一个旋转，输出1
 * @author Lenovo
 *
 */
public class ArrayRotateTest {
	public static void main(String[] args) {
		int[] test={3,4,5,1,2};
		System.out.println(PrintMin(test));
	}
	//最简单的二分法
	public static Integer PrintMin(int array[]){
		int low=0;
		int high=array.length-1;
		if(array.length==0)return null;
		while(low<high){
			int mid=(low+high)>>1;
			if(array[mid]>array[high]){
				low=mid+1;
			}else if(array[mid]==array[high]){
				high=high-1;
			}else{
				high=mid;
			}
		}
		return array[low];
	}
}
