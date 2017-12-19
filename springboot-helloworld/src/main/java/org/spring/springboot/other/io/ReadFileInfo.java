package org.spring.springboot.other.io;

import org.springframework.util.StringUtils;

import java.io.*;

public class ReadFileInfo {
	public static void main(String[] args) throws IOException {
        BufferedReader input=new BufferedReader(new InputStreamReader(new BufferedInputStream(new FileInputStream (new File("D:\\\\test.txt"))),"utf-8"));
        String line = null;
        StringBuffer stringBuffer = new StringBuffer();
        int i = 0;
        while((line = input.readLine()) != null) {
            //从第6行开始读取，前面几行都不读取
            if(i > 4){
                //对文本的数据的行进行解析，如果行为空的话，就换行
                if(!StringUtils.isEmpty(line)){
                    //对每一行数据进行空格分隔，然后取不为空的数据进行重新组装
                    String[] strs = line.split(" ");
                    StringBuffer sb = new StringBuffer("");
                    for(String str:strs){
                        if(!StringUtils.isEmpty(str)){
                            sb.append(str+" ");
                        }
                    }
                    stringBuffer.append(sb.toString()+" ");
                }else{
                    stringBuffer.append("\n");
                }
            }
            i++;
        }
        input.close();
        FileWriter writer = new FileWriter("D:\\abc.txt");
        BufferedWriter bw = new BufferedWriter(writer);
        bw.write(stringBuffer.toString());
        bw.close();
        writer.close();
        System.out.println(stringBuffer.toString());
    }



}
