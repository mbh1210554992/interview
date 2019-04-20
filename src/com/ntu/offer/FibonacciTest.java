package com.ntu.offer;
/**
 * 斐波那契数列
 * 利用递归来计算的时候，会出现很多重复的计算，影响效率
 * 题目二：青蛙跳台阶问题
 * 一只青蛙一次可以跳上1级或2级台阶，求该青蛙跳上一个n级台阶共有多少种跳法
 * 设n级台阶共有f(n)种跳法
 * 当n>2时，2种情况：1：第一次跳1个台阶，则后面有f(n-1)种跳法。2：第一次跳2个，则后面f(n-2)
 * 所以此问题可以转换成斐波那契数列；
 * @author Lenovo
 *
 */
public class FibonacciTest {
	public static void main(String[] args) {
		System.out.println(Fibonacci(12));
	}
	/**
	 * 从0开始往上算，以此类推。时间复杂度为：O（n）
	 * @param n
	 * @return
	 */
	static long Fibonacci(int n){
		int[] result={0,1};
		if(n<2){
			return result[n];
		}
		long fibOne=0; //f(0)
		long fibTwo=1;//f(1)
		long fibN=0;//f(n)
		for(int i=0;i<=n;i++){
			fibN=fibOne+fibTwo;
			fibOne=fibTwo;
			fibTwo=fibN;
		}
		return fibN;
	}
}
