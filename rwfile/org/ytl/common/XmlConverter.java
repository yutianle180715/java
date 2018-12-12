package org.ytl.common;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.UnsupportedEncodingException;

import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.io.OutputFormat;
import org.dom4j.io.SAXReader;
import org.dom4j.io.XMLWriter;

/**
 * @author daemon.yu
 *
 */
public abstract class XmlConverter {
	private String input = null;
	private String output = null;
	private SAXReader reader = null;
	/**
	 * @param input
	 * @param output
	 */
	public XmlConverter(String input, String output) {
		super();
		this.input = input;
		this.output = output;
		reader = new SAXReader();
	}

	private Document getDomument(File input) {
		Document doc = null;
		if (input.exists()&&input.isFile()) {
			try {
				doc = reader.read(input);
			} catch (DocumentException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				doc = null;
			}
		}
		return doc;
	}
	
	abstract Document convert(Document doc);
	
	abstract OutputFormat myFormat();
	
	public boolean writeToFile() {
		boolean result = false;
		Document temp = convert(getDomument(new File(input)));
		
		if (temp != null) {
			File f = new File(output);
			if (f == null || !f.exists()) {
				result = f.mkdir();
				if (!result) {
					System.out.println("can't mkdir the file.");
					return result;
				}
			}
			try {
				XMLWriter writer = new XMLWriter(new FileOutputStream(output), myFormat());
				writer.write(temp);
				
			} catch (UnsupportedEncodingException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (FileNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} 
		}
		
		
		return result;
	}
 
}
