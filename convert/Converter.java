package me.vrekt.fh.convert;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

import me.vrekt.fh.hash.Hash;
import me.vrekt.fh.hash.HashHelper;

public class Converter implements Runnable {

	private File file;
	private File out;
	private Hash hash;

	private FileWriter writer;
	private BufferedReader reader;

	public Converter(File file, Hash hash) {
		this.file = file;
		this.hash = hash;

		this.out = new File("hashed-output.txt");

		try {
			writer = new FileWriter(out, true);
		} catch (IOException e) {
			e.printStackTrace();
		}

		new Thread(this).start();

	}

	@Override
	public void run() {

		long now = System.currentTimeMillis();
		System.out.println("Converting file to " + hash.toString());

		try {
			reader = new BufferedReader(new FileReader(file));

			String line;
			while ((line = reader.readLine()) != null) {
				write(line, hash);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		try {
			reader.close();
			writer.close();
		} catch (IOException e) {
			System.out.println("Could not close reader or writer.");
			e.printStackTrace();
		}
		long time = System.currentTimeMillis() - now;
		System.out.println("Finished, output: hashed-output, took: " + time + "ms");

	}

	private void write(String line, Hash hash) {
		try {
			switch (hash) {
			case SHA1:
				writer.write(HashHelper.sha1(line) + "\n");
			case MD5:
				writer.write(HashHelper.md5(line) + "\n");
			case SHA256:
				writer.write(HashHelper.sha256(line) + "\n");
			default:
				break;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
