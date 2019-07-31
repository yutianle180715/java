package org.ytl.common;

import java.io.File;

import org.dom4j.Document;
import org.dom4j.io.OutputFormat;

public class Test {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		/*test okhttp*/
		
		
		
		/****** test read binary file start ******/
		 /*String filepath = "./rwfile/pin_list.bin";
		 int bytenum = 1;
		 ReadFromFile.readFileByBytes(filepath, bytenum);

		// read text file
		String filepath = "./rwfile/testfornote.txt";

		ReadFromFile.readFileByChars(filepath); */
		/****** test read binary file end ******/
		
		/****** test read xml file start ******/
		/*String a = "./rwfile/preferences.xml";
		String b = "./rwfile/test.xml";
		File input = new File(a);
		File output = new File(b);
		
		XmlConverter xc = new XmlConverter(a, b) {
			
			@Override
			Document convert(Document doc) {
				// TODO Auto-generated method stub
				return doc;
			}

			@Override
			OutputFormat myFormat() {
				// TODO Auto-generated method stub
				OutputFormat format = OutputFormat.createCompactFormat();
//				format.setIndent(true);
				format.setNewlines(true);
				format.setIndentSize(4);//tab
				format.setEncoding("UTF-8");
				return format;
			}
		};
		xc.writeToFile();*/
		/****** test read xml file end ******/
	}

}
