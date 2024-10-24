package com.example.sbdb;

import java.util.Stack;

public class stackRev {
	
	public static String revString(String str) {
		
		char[] revStr = new char[str.length()];
		
		Stack<Character> revS = new Stack<Character>();
		
		for (int i = 0 ; i< str.length()-1 ;i ++) {
			revS.add(str.charAt(i));
			System.out.println(str.charAt(i));
		}
		
		System.out.println("");
		int i = 0;
		while (!revS.empty()) {
			
			if(!Character.isLetter(str.charAt(i))) {
					System.out.println(str.charAt(i++));
			}else {
				i++;
			}
			
			//System.out.println(revS.pop());
		}
		
	
		
		return str;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		String str = "Sad@nan$d";
		revString(str);

	}

}
