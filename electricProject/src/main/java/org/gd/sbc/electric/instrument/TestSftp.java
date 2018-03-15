package org.gd.sbc.electric.instrument;

import com.jcraft.jsch.ChannelSftp;
import org.gd.sbc.electric.constants.SftpConstant;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Vector;

/**
 * 测试类
 * @author yigang.wu
 * @date created in $time $date
 */
public class TestSftp {
    public static void main(String[] args) throws Exception{
        SFtpUtil util = new SFtpUtil();
        Map<String,String> map = new HashMap<String, String>();
        map.put(SftpConstant.SFTP_REQ_HOST,"39.106.189.211");
        map.put(SftpConstant.SFTP_REQ_PASSWORD,"test");
        map.put(SftpConstant.SFTP_REQ_USERNAME,"test");
        ChannelSftp channelSftp = util.getChannelSftp(map,6000);

        FileDownAndUploadUtil fileDownAndUploadUtil = new FileDownAndUploadUtil();
        String src = "D:\\\\xqaunt\\\\";
        String dst = "/home/test/wyg/";
//        fileDownAndUploadUtil.uploadSingFile(src,dst,channelSftp);
        /*Vector vectors = fileDownAndUploadUtil.getFileList(dst,channelSftp);
        for(Object object:vectors){
            System.out.println("目录结构是："+object);
        }*/

       /* List<String> fileNames = fileDownAndUploadUtil.downFileBatch(dst,src,channelSftp,true);
        for(String str:fileNames){
            System.out.println(str);
        }//批量下载 并且下载完成之后删掉远程服务器上面的文件*/

       /*List<String> fileNames = fileDownAndUploadUtil.uploadFileBatch(src,dst,channelSftp,true);
       for (String fileName : fileNames){
           System.out.println("filename is "+fileName);
       }//批量上传 上传完成之后删除本地的文件*/
        channelSftp.quit();
        util.close();
    }
}
