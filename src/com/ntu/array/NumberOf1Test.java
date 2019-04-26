package com.ntu.array;

import java.util.Scanner;

/**
 * 二进制中1的个数
 * 输入一个整数，输出该数二进制表示中1的个数
 * @author Lenovo
 *
 */
public class NumberOf1Test {
	public static void main(String[] args) {
		Scanner scanner=new Scanner(System.in);
		System.out.println("请输入一个整数：");
		int n=scanner.nextInt();
		System.out.println(numberOf1_02(n));
		System.out.println(Integer.toBinaryString(n));
	}
	/**
	 * 解法一
	 * 先判断而二进制最右边的1位是不是1，把整数和1做与运算即可，然后右移一位，继续判断
	 * 当输入为负数时，右移时，最左边自动补1，可能会陷入死循环
	 * @param n
	 * @return
	 */
	static int numberOf1(int n){
		int count=0;
		int flag=1;
		while(n!=0){
			if((flag&n)==1)count++;
			n=n>>1;
		}
		return count;
	}
	/**
	 * 解法二
	 * 把一个整数减去1，在和原来的整数做与运算，会把整数最右边的1变成0
	 * 例如：当最后一位不是1时：1100，减去1时变成1011，跟1100与运算之后变成1000；最后一位是1时，更好推算
	 * 则一个整数的二进制表示中有多少个1，就可以进行多少次这样的操作；
	 * @return
	 */
	static int numberOf1_02(int n){
		int count=0;
		while(n!=0){
			n=(n-1)&n;
			count++;
		}
		return count;
	}
}
