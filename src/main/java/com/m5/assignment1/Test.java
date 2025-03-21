package com.m5.assignment1;

import com.harish.QspiderList;

public class Test {
	
	
	public static void main(String[] args) {
		
		QspiderList<String> q1 = new QspiderList<String>();
		q1.add("Harish");
		q1.add("Kartik");
		q1.add("chink");
		q1.add("abhishk");
		System.out.println(q1.get(0));
		System.out.println(q1.size());
		System.out.println("deleted element : " +q1.delete(0));
		
	}

}
