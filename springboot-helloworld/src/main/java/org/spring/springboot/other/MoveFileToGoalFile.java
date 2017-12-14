package org.spring.springboot.other;

import java.io.File;

/**
 * 	将文件移动到另外一个文件
 *  @author yigang.wu
 *	@date 2017年10月13日 下午2:34:21
 *
 */
public class MoveFileToGoalFile {
	public static void main(String[] args) {
		
		String filepath = "E:\\\\wyg\\\\手机图片视频\\\\picandvideo2";
		 File file = new File(filepath);
         if (!file.isDirectory()) {
                 System.out.println("文件");
                 System.out.println("path=" + file.getPath());
                 System.out.println("absolutepath=" + file.getAbsolutePath());
                 System.out.println("name=" + file.getName());

         } else if (file.isDirectory()) {
                 System.out.println("文件夹");
                 String[] filelist = file.list();
                 if(filelist != null) {
                	 for (int i = 0; i < filelist.length; i++) {
                         File readfile = new File(filepath + "\\" + filelist[i]);
                         if (!readfile.isDirectory()) {
                                 System.out.println("absolutepath="+ readfile.getAbsolutePath());
                                 String absolutePath = readfile.getAbsolutePath();
                                 if(absolutePath.endsWith(".MOV")||absolutePath.endsWith(".mp4")) {
                                	 File goalFile = new File(absolutePath);
                                	 String fileName = readfile.getName();
                                	 if(goalFile.renameTo(new File("E:\\wyg\\手机图片视频\\video\\"+fileName))) {
                                		 System.out.println("文件移动成功");
                                	 }else {
                                		 System.out.println("文件移动失败");
                                	 }
                                 }

                         }
                 }
                 }
         }
		
		/*String startPath = "E:\\wyg\\手机图片视频\\picandvideo1";
	    String endPath = "E:\\wyg\\手机图片视频\\video";
	    try {
	        File startFile = new File(startPath);
	        File tmpFile = new File(endPath);//获取文件夹路径
	        if(!tmpFile.exists()){//判断文件夹是否创建，没有创建则创建新文件夹
	            tmpFile.mkdirs();
	        }
	        System.out.println(endPath + startFile.getName());
	        if (startFile.renameTo(new File(endPath + startFile.getName()))) {
	            System.out.println("File is moved successful!");
	        } else {
	            System.out.println("File is failed to move!");
	        }
	    } catch (Exception e) {
	    	e.printStackTrace();
	    }*/
	}
}
