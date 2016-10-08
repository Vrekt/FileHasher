package me.vrekt.fh;

import java.io.File;
import java.util.Scanner;

import me.vrekt.fh.convert.Converter;
import me.vrekt.fh.hash.Hash;

public class Main {

	public static void main(String[] args) {
		System.out.println("Welcome to FileHasher. Please select an option below.");

		System.out.println("SHA1");
		System.out.println("MD5");
		System.out.println("SHA256");

		Scanner input = new Scanner(System.in);
		String action = input.nextLine();

		if (action.equalsIgnoreCase("sha1")) {
			System.out.println("Enter the path to the file.");
			String path = input.nextLine();
			input.close();

			File file = new File(path);
			if (!file.exists()) {
				System.out.println("File not found.");
				return;
			}

			new Converter(file, Hash.SHA1);
			return;
		}

		if (action.equalsIgnoreCase("md5")) {

			System.out.println("Enter the path to the file.");
			String path = input.nextLine();
			input.close();

			File file = new File(path);
			if (!file.exists()) {
				System.out.println("File not found.");
				return;
			}

			new Converter(file, Hash.MD5);
			return;
		}

		if (action.equalsIgnoreCase("sha256")) {

			System.out.println("Enter the path to the file.");
			String path = input.nextLine();
			input.close();

			File file = new File(path);
			if (!file.exists()) {
				System.out.println("File not found.");
				return;
			}

			new Converter(file, Hash.SHA256);
			return;

		}

		System.out.println("Invalid option.");
		input.close();
	}

}
