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
     * ����Ϊ��λ��ȡ�ļ��������ڶ������еĸ�ʽ���ļ� 
     */  
    public static void readFileByLines(String fileName) {  
        File file = new File(fileName);  
        BufferedReader reader = null;  
        try {  
            System.out.println("����Ϊ��λ��ȡ�ļ����ݣ�һ�ζ�һ���У�");  
            reader = new BufferedReader(new FileReader(file));  
            String tempString = null;  
            int line = 1;  
            // һ�ζ���һ�У�ֱ������nullΪ�ļ�����  
            while ((tempString = reader.readLine()) != null) {  
                // ��ʾ�к�  
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
     * �����ȡ�ļ����� 
     */  
    public static void readFileByRandomAccess(String fileName) {  
        RandomAccessFile randomFile = null;  
        try {  
            System.out.println("�����ȡһ���ļ����ݣ�");  
            // ��һ����������ļ�������ֻ����ʽ  
            randomFile = new RandomAccessFile(fileName, "r");  
            // �ļ����ȣ��ֽ���  
            long fileLength = randomFile.length();  
            // ���ļ�����ʼλ��  
            int beginIndex = (fileLength > 4) ? 4 : 0;  
            // �����ļ��Ŀ�ʼλ���Ƶ�beginIndexλ�á�  
            randomFile.seek(beginIndex);  
            byte[] bytes = new byte[10];  
            int byteread = 0;  
            // һ�ζ�10���ֽڣ�����ļ����ݲ���10���ֽڣ����ʣ�µ��ֽڡ�  
            // ��һ�ζ�ȡ���ֽ�������byteread  
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
     * ��ʾ�������л�ʣ���ֽ��� 
     */  
    private static void showAvailableBytes(InputStream in) {  
        try {  
            System.out.println("��ǰ�ֽ��������е��ֽ���Ϊ:" + in.available());  
        } catch (IOException e) {  
            e.printStackTrace();  
        }  
    }  
  

}
