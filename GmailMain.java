package com.te.mock.java;

import java.util.Scanner;

public class GmailMain {

	public static void main(String[] args) {

		Scanner scanner  = new Scanner(System.in);
		GmailRegister data = new GmailRegister();
		for (;;) {
			System.out.println("Press Register : 1 / Login : 2 / Exit : 3 ");
			int no = scanner.nextInt();
			if (no == 1) {
				data.register();
			}
			else if (no == 2) {
				data.login();
			}
			else if (no == 3) {
				System.out.println(".................Exit..............");
				break;
			}	
		}
		
		
	}

}