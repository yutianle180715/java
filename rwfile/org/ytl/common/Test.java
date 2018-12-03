package org.ytl.common;

public class Test {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		// read binary file
		// String filepath = "./rwfile/pin_list.bin";
		// int bytenum = 1;
		// ReadFromFile.readFileByBytes(filepath, bytenum);

		// read text file
		String filepath = "./rwfile/testfornote.txt";

		ReadFromFile.readFileByChars(filepath);
	}

}
