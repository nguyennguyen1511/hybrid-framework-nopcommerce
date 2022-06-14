package javaBasic;

import org.testng.annotations.Test;

public class Topic_11_Array {
	int number[] = {5,8,12,60,70};
	
	@Test
	public void TC_01_Find_Max_Number() {
		int x =0;
		for (int i=0; i<number.length; i++) {
			if (x <number[i]) {
				x=number[i];
			}
		}
		System.out.println("Max = " + x);
	}
	@Test
	public void TC_02_Sum_First_And_Last() {
		
		int x = number[0] + number[number.length-1];
		System.out.println("Sum = " + x);
	}
	@Test
	public void TC_03_Find_Even_Number() {
		int x =0;
		for (int i=0; i<number.length; i++) {
			if (number[i] % 2 == 0) {
				System.out.println("Event number = " + number[i]);
			}
		}
	}
	@Test
	public void TC_04_Find_Number() {
			int x =0;
			for (int i=0; i<number.length; i++) {
				if (number[i] >= 0 && number[i] <= 10) {
					System.out.println("0 <= Number <= 10: " + number[i]);
				}
			}
	}
	@Test
	public void TC_05_Sum_Number() {
			int sum = 0;
			for (int i=0; i<number.length; i++) {
				sum += number[i];
				
				}
			System.out.println("Sum all number =" + sum);
			float average = sum/number.length;
			System.out.println("Average all number = " + average);
			}
	}
