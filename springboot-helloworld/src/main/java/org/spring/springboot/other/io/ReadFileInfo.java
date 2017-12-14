package org.spring.springboot.other.io;

import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class ReadFileInfo {
	public static void main(String[] args) throws IOException {
        BufferedReader input=new BufferedReader(new InputStreamReader(new BufferedInputStream(new FileInputStream (new File("D:\\\\PLAN_cy5jvkfz4gk8p.txt"))),"utf-8"));
        //每个块建立一个输出  
        BufferedWriter output = new BufferedWriter( new OutputStreamWriter( new FileOutputStream( new File("D:\\abc.txt")),"utf-8"));
        //设置你需要读到第几行
        long perSplitLines=70;
        String line = null;  
        //逐行读取，逐行输出   
        for (long lineCounter = 27; lineCounter < perSplitLines && (line = input.readLine()) != null; ++lineCounter)  
        {  
            System.out.println(line);
            output.append(line + "\r\n");  
        }  
        output.close();
        input.close();
    }

}
