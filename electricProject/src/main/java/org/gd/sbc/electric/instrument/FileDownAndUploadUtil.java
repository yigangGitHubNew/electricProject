package org.gd.sbc.electric.instrument;

import com.jcraft.jsch.ChannelSftp;
import com.jcraft.jsch.SftpATTRS;
import com.jcraft.jsch.SftpException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Vector;

/**
 * 文件的上传下载
 * @author yigang.wu
 * @date created in $time $date
 */
public class FileDownAndUploadUtil {

    public static Logger logger = LoggerFactory.getLogger(FileDownAndUploadUtil.class);

    /**
     * 上传单个文件
     * @param src 源文件的路径
     * @param dst 目标路径
     * @param channelSftp 上传需要用到的通道
     */
    public boolean uploadSingFile(String src, String dst, ChannelSftp channelSftp){
        try {
            channelSftp.put(src,dst,ChannelSftp.OVERWRITE);//上传文件
            return true;
        } catch (SftpException e) {
            e.printStackTrace();
        }
        return false;
    }

    /**
     * 返回ftp服务器上的文件目录
     * @return
     */
    public Vector getFileList(String src,ChannelSftp channelSftp) throws Exception{
        Vector vector = channelSftp.ls(src);
        Vector newVectors = new Vector();
        for(Object str : vector){//channelSftp.ls(src);获取的文件目录里面有很多..,这个应该是把上一级的目录结构给你展示出来，所以对这个进行了处理
            String path = str.toString();
            String newStr = path.substring(path.length()-1,path.length());
            if(!".".equals(newStr) && !"..".equals(newStr)){
                newVectors.add(str);
            }
        }
        return newVectors;
    }

    /**
     * 批量下载文件到本地
     * @param remotePath
     * @param localPath
     * @param sftp
     * @return
     */
    public List<String> downFileBatch(String remotePath,String localPath,ChannelSftp sftp,boolean isDel) throws Exception{
        List<String> fileNames = new ArrayList<String>();
        Vector vectors = getFileList(remotePath,sftp);
        Iterator iterator = vectors.iterator();
        logger.info("文件开始下载：");
        while (iterator.hasNext()){
            ChannelSftp.LsEntry lsEntry = (ChannelSftp.LsEntry) iterator.next();
            String fileName = lsEntry.getFilename();
            SftpATTRS sftpATTRS = lsEntry.getAttrs();
            fileNames.add(fileName);
            if(!sftpATTRS.isDir()){
                String localFileName = localPath+fileName;
                String remoteFileName = remotePath+fileName;
                boolean flag = downFileSinge(remoteFileName,localFileName,sftp);
                if(isDel){
                   deleteRemoteFile(remoteFileName,sftp);
                }
            }

        }
        logger.info("下载文件结束");
        return fileNames;
    }

    /**
     * 批量上传文件到服务器
     * @param localPath 本地路径
     * @param remotePath 远程路径
     * @param sftp sftp通道
     * @return
     */
    public List<String> uploadFileBatch(String localPath,String remotePath,ChannelSftp sftp,boolean isDel){
       logger.info("开始上传");
        List<String> fileNames = new ArrayList<String>();
        File file = new File(localPath);
        File[] files = file.listFiles();
        for(File file1:files){
            String fileName = file1.getName();
            fileNames.add(fileName);
            String absouteUrl = file1.getAbsolutePath();
            uploadSingFile(absouteUrl,remotePath,sftp);
            if(isDel){
                file1.delete();
            }
        }
        logger.info("上传结束");
        return fileNames;
    }

    /**
     * 下载单个文件
     * @param remotePath 远程服务的地址
     * @param localPath 本地地址
     * @param sftp sftp的通道
     * @return
     */
    public boolean downFileSinge(String remotePath,String localPath,ChannelSftp sftp){
        FileOutputStream fileOutputStream = null;
        try {
            File file = new File(localPath);
            fileOutputStream = new FileOutputStream(file);
            sftp.get(remotePath,fileOutputStream);
            return true;
        } catch (SftpException e) {
            e.printStackTrace();
        }catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        return false;
    }

    /**
     * 删除远程服务器上面的文件
     * @param remotePath
     * @param sftp
     */
    public void deleteRemoteFile(String remotePath,ChannelSftp sftp) {
        try {
            sftp.rm(remotePath);
        } catch (SftpException e) {
            e.printStackTrace();
        }
    }
}
