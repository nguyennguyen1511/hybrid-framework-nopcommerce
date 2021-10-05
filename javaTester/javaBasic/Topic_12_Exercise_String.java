package javaBasic;

import java.util.Collections;

import org.testng.annotations.Test;

public class Topic_12_Exercise_String {

	String courseName = "Automation Testing Advance 21";
	String courseName2 = "Automation Testing 345 Tutorials Online 789";
	
	@Test
	public void TC_01() {
		char courseNameArr[] = courseName.toCharArray();
		int countUper = 0;
		int countLower = 0;
		int countNumber = 0;
		for (char c : courseNameArr) {
			if(c <= 'Z' && c >='A')
				countUper++;	
		}
		for (char c : courseNameArr) {
			if(c <= 'z' && c >='A')
				countLower++;	
		}
		for (char c : courseNameArr) {
			if(c <= '9' && c >='0')
				countNumber++;	
		}
		System.out.println("Uper Character = " + countUper);
		System.out.println("Lower Character = " + countLower);
		System.out.println("Number Character = " + countNumber);
	}
	@Test
	public void TC_02() {

		char courseName2Arr[] = courseName2.toCharArray();		
		int counta = 0;
		for (char c : courseName2Arr) {
			if(c == 'a') {
				counta++;
			}
		}
		System.out.println("Ki tu a trong chuoi: " + counta);
		System.out.println("Chuoi co chua Testing: " + courseName2.contains("Testing"));
		System.out.println("Chuoi co bat dau Automation: " + courseName2.startsWith("Automation"));
		System.out.println("Chuoi co ket thuc Online: " + courseName2.endsWith("Online"));
		System.out.println("Vị trí cua Tutorials: " + courseName2.indexOf("Tutorials"));
		
		courseName2 = courseName2.replace("Online", "Offline");
		System.out.println("Chuoi thay the: " + courseName2);
		
		int countNumber = 0;
		for (char c : courseName2Arr) {
			if(c <= '9' && c >='0')
				countNumber++;	
		}
		System.out.println("Number Character = " + countNumber);
		
	}
	@Test
	public void TC_03() {
		char courseNameArr[] = courseName.toCharArray();
		String chuoiNguoc = "";
		for(int i= courseNameArr.length-1; i>=0; i--) {
			chuoiNguoc += courseNameArr[i];
			
		}
		System.out.println("Chuoi nguoc: " + chuoiNguoc);
		
	}
}
