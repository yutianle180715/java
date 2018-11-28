package org.ytl.common;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;

public class ReadFromFile {
	/**
	 * @param filename
	 *            read file by byte, eg. image, sound or video ect
	 */
	public static void readFileByBytes(String filename, int bytenum) {
		File file = new File(filename);
		InputStream in = null;
		do {
			if (!file.exists()) {
				System.out.printf("can't find the file: %s \n", filename);
				break;
			}
			try {
				System.out.printf("%d byte one time:", bytenum);
				// one byte
				in = new FileInputStream(file);
				byte[] tempbytes = new byte[bytenum];
				int tempbyte = 0;
				int num = 0;
				while ((tempbyte = in.read()) != -1) {// read() default read one
														// Byte.
					// System.out.write(tempbytes, 0, tempbyte);
					if (num < 10)
						System.out.println(tempbyte);
					num++;
					// System.out.write(tempbyte);
				}
				in.close();
			} catch (IOException e) {
				// TODO: handle exception
				e.printStackTrace();
				return;
			} finally {
				if (in != null) {
					try {
						in.close();
					} catch (IOException e) {
						// TODO: handle exception
					}
				}
			}
		} while (false);
	}

	/**
	 * @param fileName
	 *            read by char
	 */
	public static void readFileByChars(String fileName) {
		File file = new File(fileName);
		Reader reader = null;
		do {
			if (!file.exists()) {
				System.out.printf("can't find the file: %s", fileName);
				break;
			}
			try {
				System.out.println("read by char");
				reader = new InputStreamReader(new FileInputStream(file));
				int tempchar;
				int num = 0;
				while ((tempchar = reader.read()) != -1) {
					if (((char) tempchar) != '\r') {
//						System.out.print((char) tempchar);
						if (num < 10)
							System.out.println(tempchar);
						num++;
					}
				}

				reader.close();
			} catch (Exception e) {
				// TODO: handle exception
			}
		} while (false);
	}
}
