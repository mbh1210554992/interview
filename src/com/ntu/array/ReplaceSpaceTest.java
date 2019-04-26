package com.ntu.array;
/**
 * 将字符串中的空格替换为%20
 * @author Lenovo
 *
 */
public class ReplaceSpaceTest {
	public static void main(String[] args) {
		String str="mbh is good";
		str=repalceSpace02(str);
		System.out.println(str);
	}
	
	/**
	 * 方法一：直接用replaceAll（）；方法替换
	 * @param str
	 * @return
	 */
	public static String replaceSpace01(String str){
		str=str.toString().replaceAll(" ", "%20");
		return str;
	}
	/**
	 * 方法二：新建一个字符串，将原字符串复制到新字符串中（逐个字符替换），将空格替换
	 * @param input
	 * @return
	 */
	public static String repalceSpace02(String input){
		StringBuffer output=new StringBuffer();
		for(int i=0;i<input.length();i++){
			if(input.charAt(i)==' '){
				output.append("%20");
			}else{
				output.append(input.charAt(i));
			}
		}
		
		return new String(output);
	}
}



