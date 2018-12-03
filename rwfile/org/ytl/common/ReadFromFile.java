package org.ytl.common;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.RandomAccessFile;
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
	 *            read by char. eg. note, text;
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
							System.out.println((char) tempchar);
						num++;
					}
				}

				reader.close();
			} catch (Exception e) {
				// TODO: handle exception
			}
		} while (false);
	}
    /** 
     * 以行为单位读取文件，常用于读面向行的格式化文件 
     */  
    public static void readFileByLines(String fileName) {  
        File file = new File(fileName);  
        BufferedReader reader = null;  
        try {  
            System.out.println("以行为单位读取文件内容，一次读一整行：");  
            reader = new BufferedReader(new FileReader(file));  
            String tempString = null;  
            int line = 1;  
            // 一次读入一行，直到读入null为文件结束  
            while ((tempString = reader.readLine()) != null) {  
                // 显示行号  
                System.out.println("line " + line + ": " + tempString);  
                line++;  
            }  
            reader.close();  
        } catch (IOException e) {  
            e.printStackTrace();  
        } finally {  
            if (reader != null) {  
                try {  
                    reader.close();  
                } catch (IOException e1) {  
                }  
            }  
        }  
    }  
  
    /** 
     * 随机读取文件内容 
     */  
    public static void readFileByRandomAccess(String fileName) {  
        RandomAccessFile randomFile = null;  
        try {  
            System.out.println("随机读取一段文件内容：");  
            // 打开一个随机访问文件流，按只读方式  
            randomFile = new RandomAccessFile(fileName, "r");  
            // 文件长度，字节数  
            long fileLength = randomFile.length();  
            // 读文件的起始位置  
            int beginIndex = (fileLength > 4) ? 4 : 0;  
            // 将读文件的开始位置移到beginIndex位置。  
            randomFile.seek(beginIndex);  
            byte[] bytes = new byte[10];  
            int byteread = 0;  
            // 一次读10个字节，如果文件内容不足10个字节，则读剩下的字节。  
            // 将一次读取的字节数赋给byteread  
            while ((byteread = randomFile.read(bytes)) != -1) {  
                System.out.write(bytes, 0, byteread);  
            }  
        } catch (IOException e) {  
            e.printStackTrace();  
        } finally {  
            if (randomFile != null) {  
                try {  
                    randomFile.close();  
                } catch (IOException e1) {  
                }  
            }  
        }  
    }  
  
    /** 
     * 显示输入流中还剩的字节数 
     */  
    private static void showAvailableBytes(InputStream in) {  
        try {  
            System.out.println("当前字节输入流中的字节数为:" + in.available());  
        } catch (IOException e) {  
            e.printStackTrace();  
        }  
    }  
  

}
