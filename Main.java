package me.vrekt.fh;

import java.io.File;
import java.util.Scanner;

import me.vrekt.fh.convert.Converter;
import me.vrekt.fh.hash.Hash;

public class Main {

	public static void main(String[] args) {
		System.out.println("Welcome to FileHasher. Please select an option below.");

		System.out.println("[1] SHA1");
		System.out.println("[2] MD5");

		Scanner input = new Scanner(System.in);
		String action = input.nextLine();

		switch (action.toLowerCase()) {
		case "sha1":
		case "1":
			System.out.println("Enter the path to the file.");
			String path = input.nextLine();
			input.close();

			File file = new File(path);
			if (!file.exists()) {
				System.out.println("File not found.");
				return;
			}

			new Converter(file, Hash.SHA1);
		case "md5":
		case "2":
			System.out.println("Enter the path to the file.");
			String p = input.nextLine();
			input.close();

			File f = new File(p);
			if (!f.exists()) {
				System.out.println("File not found.");
				return;
			}

			new Converter(f, Hash.MD5);

		}

	}

}
