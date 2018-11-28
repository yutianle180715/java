package org.ytl.common;

public class Test {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String filepath = "./rwfile/pin_list.bin";
		int bytenum = 1;
		ReadFromFile.readFileByBytes(filepath, bytenum);
//		ReadFromFile.readFileByChars(filepath);
	}

}
