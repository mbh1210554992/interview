package com.ntu.offer;

import java.util.Scanner;

/**
 * 在一个二维数组中，每一行从左到右递增，每一列从上到下递增。
 * 输入这样一个数组，并输入一个整数，判断数组中是否有该整数
 * @author Lenovo
 *
 */
public class ArrayIndexTest {
	public static void main(String[] args) {
		int[][] array=input();
		for(int i=0;i<array.length;i++){
			System.out.print("[ ");
			for(int temp:array[i]){
				System.out.print(temp+" ");
			}
			System.out.print("]\n");
		}
		
		Scanner scanner=new Scanner(System.in);
		System.out.println("请输入要查询的整数");
		int index=scanner.nextInt();
		boolean flag=indexArray(array,index);
		if(flag){
			System.out.println(index+" 存在于此数组中");
		}else System.out.println(index+" 不3存在于此数组中");
	}
	
	/**
	 * 数组的输入
	 * @return:返回二维数组
	 */
	public static int[][] input(){
		Scanner sc=new Scanner(System.in);
		System.out.println("请输入二维数组的行数：");
		int rowNum=sc.nextInt();
		System.out.println("请输入二维数组的列数:");
		int colNum=sc.nextInt();
		int[][] array=new int[rowNum][colNum];
		if(rowNum!=0&&colNum!=0){
			for(int i=0;i<rowNum;i++){
				System.out.println("请输入第"+(i+1)+"行的 "+colNum+" 个数");
				for(int j=0;j<colNum;j++){
					array[i][j]=sc.nextInt();
				}
			}
			return array;
		}else{
			System.out.println("输入有误，数组为空");
			return null;
		}
	}
	/**
	 * 先从右上角或左下角开始比：
	 * 右上角：若找的数比这个数小，剔除这一列，比较前一列的第一个数
	 * 左下角：若找的数比这个数小，剔除这一行，比较前一行的第一个数
	 * （先从左上角或右下角是不行的）
	 * @param array
	 * @param target
	 * @return
	 */
	public static boolean indexArray(int[][] array,int target){
		//从左下角开始比
		int row=0;
		int col=array[0].length-1;
		while(col>=0&&row<array.length){
			if(target==array[row][col]){
				return true;
			}else if(target<array[row][col]){
				col--;
			}else{
				row++;
			}
		}
		return false;
	}
}
