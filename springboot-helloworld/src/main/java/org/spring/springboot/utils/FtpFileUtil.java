package org.spring.springboot.utils;

import com.google.common.base.Objects;
import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.net.ftp.FTPClient;
import org.apache.commons.net.ftp.FTPFile;
import org.apache.commons.net.ftp.FTPReply;

import java.io.*;
import java.util.List;

/**
 * 接收请求报价消息的测试类
 *
 * @author yigang.wu
 * @date created in $time $date
 */
public class FtpFileUtil {

    /**
     * ftp上传指定文件
     *
     * @param file
     *            上传的文件
     * @param path   例子  /home/loan/wangdai/
     *            上传到ftp服务器哪个路径下，请尽量使用绝对路径
     * @param addr
     *            地址
     * @param port
     *            端口号
     * @param username
     *            用户名
     * @param password
     *            密码，加密之后的密码，别乱传，使用产品加密算法，加密请参考——RsaKeyFactory这个类
     * @return
     * @throws Exception
     */
    public static boolean fileUploan(File file, String path, String addr,
                                     int port, String username, String password) throws Exception {
        boolean flag = false;
        FTPClient ftpClient = connect(path, addr, port, username, password);
        FileInputStream input = null;
        if (!Objects.equal(null, ftpClient) && file.exists()) {
            try {
                input = new FileInputStream(file);
                flag = ftpClient.storeFile(file.getName(), input);
                System.out.println("==============安硕" + file.getName() + "文件上传是否成功===============" + flag);
            } finally {
                if (!Objects.equal(null, input)) {
                    input.close();
                }
                if (!Objects.equal(null, ftpClient)) {
                    ftpClient.disconnect();
                }
            }
        }
        return flag;
    }

    /**
     * 千万别改这段工具的使用，这段代码只有两个人可以改，一个上帝，一个是我
     *
     * @param path 上传到ftp服务器哪个路径下
     * @param addr 地址
     * @param port 端口号
     * @param username 用户名
     * @param password 密码
     * @return
     * @throws Exception
     */
    private static FTPClient connect(String path,String addr,int port,String username,String password) throws Exception {
        FTPClient ftp = new FTPClient();
        int reply;
        ftp.connect(addr,port);
        String realPassword = password;
        ftp.login(username,realPassword);
        // 使用FTPClinet被动模式，因为服务器（Linux或Unix安全隔离级别有差异）所以需要切换为被动模式
        ftp.enterLocalPassiveMode();
        reply = ftp.getReplyCode();
        if (!FTPReply.isPositiveCompletion(reply)) {
            ftp.disconnect();
            return null;
        }
        System.out.println("==============安硕上传文件工作空间================" + path);
        boolean flag = ftp.changeWorkingDirectory(path);
        System.out.println("==============安硕上传文件改变工作空间================" + flag);
        ftp.setBufferSize(1024);
        ftp.setControlEncoding("gbk");
        ftp.setFileType(FTPClient.BINARY_FILE_TYPE);
        ftp.setFileTransferMode(FTPClient.BINARY_FILE_TYPE);
        return ftp;
    }

    /**
     * 根据自定对象生成文件对象
     *
     * @param info——所有需要上传AbstractFileUploanDto具体子类
     * @param filePath——请使用绝对路径，比如/home/loan/MtFile/
     * @return
     */
    public static File createFile(List infos, String filePath) {
        File file = new File(filePath);
        OutputStreamWriter outputStreamWriter = null;
        BufferedWriter bufferedWriter = null;
        try {
            if (file.exists()) {
                file.delete();
            }
            file.createNewFile();
            outputStreamWriter = new OutputStreamWriter(new FileOutputStream(filePath),"GBK");//确认流的输
            bufferedWriter = new BufferedWriter(outputStreamWriter);
            if (CollectionUtils.isNotEmpty(infos)) {
                for(int i = 1; i < infos.size(); i ++) {
                    List info = (List) infos.get(i);
                    // 对普通的bean进行处理
//					FileBeanUtil.handleBean(info.getClass(), info);
                    bufferedWriter.write(info.toString());
                    // 最后一行不换行
                    if (i != infos.size() - 1) {
                        bufferedWriter.newLine();
                        bufferedWriter.flush();
                    }
                }
                // 为了保证文件为空，必须写一行空行
                bufferedWriter.newLine();
                bufferedWriter.flush();
            }
        } catch (Exception e) {
            System.out.println("=================根据自定对象生成文件对象==================="+e);
        } finally {
            try {
                if (!Objects.equal(null, bufferedWriter)) {
                    bufferedWriter.close();
                }
                if (!Objects.equal(null, outputStreamWriter)) {
                    outputStreamWriter.close();
                }
            } catch (Exception e) {
                System.out.println("=================根据自定对象生成文件对象==================="+e);
            }
        }
        return file;
    }

    /**
     * 封装登录ftp
     * @param ftp
     * @param ftpUrl
     * @param ftpPort
     * @param ftpUserName
     * @param ftpPassWord
     * @param remotePath
     * @return
     */
    public static FTPFile[] connectFtp(FTPClient ftp, String ftpUrl, int ftpPort, String ftpUserName, String ftpPassWord,
                                       String remotePath){
//		Integer batchTime = DateUtil.getCNBusiDayFormat(null);
        System.out.println("开始连接ftp服务");
        int reply = 0;
        FTPFile[] fs = null;
        try {
            System.out.println("连接之前的：ftpUrl"+ftpUrl+"ftpPort"+ftpPort);
            System.out.println("连接之前的：remotePath:"+remotePath+"  remotePath:"+remotePath);
            ftp.connect(ftpUrl, ftpPort);
            System.out.println("连接之后的：ftpUrl"+ftpUrl+"ftpPort"+ftpPort);
            String password = ftpPassWord;
            System.out.println("登录之前的：ftpUserName"+ftpUserName+"ftpPassWord"+password);
            ftp.login(ftpUserName, password);//登录
            ftp.enterLocalPassiveMode();
            ftp.setControlEncoding("utf-8");
            ftp.setFileType(FTPClient.BINARY_FILE_TYPE);
            System.out.println("FTP换被动模式模式");
            System.out.println("登录之后的：ftpUserName"+ftpUserName+"ftpPassWord"+ftpPassWord);
            reply = ftp.getReplyCode();
//			System.out.println("登录之后的地址：remotePath:"+remotePath + batchTime.toString() + "/"+"  remotePath:"+remotePath + batchTime.toString() + "/");
//			boolean flag = ftp.changeWorkingDirectory(remotePath + batchTime.toString() + "/");//转移到FTP服务器目录
            boolean flag = true;
            System.out.println("改变FTP工作路径：" + flag);
            System.out.println("打印FTP指定路径下所有文件名称");
            fs = ftp.listFiles();
        } catch (IOException e) {
            System.out.println("不能登录ftp"+e);
        }finally{
            if (!FTPReply.isPositiveCompletion(reply)) {
                try {
                    ftp.disconnect();
                } catch (IOException e) {
                    System.out.println("关闭失败"+e);
                }
            }
        }
        System.out.println("连接成功");
        return fs;
    }

    public static FTPFile[] blackConnectFtp(FTPClient ftp,String ftpUrl,int ftpPort,String ftpUserName,String ftpPassWord,
                                            String remotePath){
        Integer tempDate = Integer.valueOf(20161012);
        System.out.println("开始连接ftp服务");
        int reply = 0;
        FTPFile[] fs = null;
        try {
            System.out.println("连接之前的：ftpUrl"+ftpUrl+"ftpPort"+ftpPort);
            System.out.println("连接之前的：remotePath:"+remotePath+"  remotePath:"+remotePath);
            ftp.connect(ftpUrl, ftpPort);
            System.out.println("连接之后的：ftpUrl"+ftpUrl+"ftpPort"+ftpPort);
            String password = ftpPassWord;
            System.out.println("登录之前的：ftpUserName"+ftpUserName+"ftpPassWord"+password);
            ftp.login(ftpUserName, password);//登录
            ftp.enterLocalPassiveMode();
            ftp.setControlEncoding("utf-8");
            ftp.setFileType(FTPClient.BINARY_FILE_TYPE);
            System.out.println("FTP换被动模式模式");
            System.out.println("登录之后的：ftpUserName"+ftpUserName+"ftpPassWord"+ftpPassWord);
            reply = ftp.getReplyCode();
            System.out.println("登录之后的地址：remotePath:"+remotePath + tempDate.toString() + "/"+"  remotePath:"+remotePath + tempDate.toString() + "/");
            boolean flag = ftp.changeWorkingDirectory(remotePath + tempDate.toString() + "/");//转移到FTP服务器目录
            System.out.println("改变FTP工作路径：" + flag);
            System.out.println("打印FTP指定路径下所有文件名称");
            fs = ftp.listFiles();
        } catch (IOException e) {
            System.out.println("不能登录ftp"+e);
        }finally{
            if (!FTPReply.isPositiveCompletion(reply)) {
                try {
                    ftp.disconnect();
                } catch (IOException e) {
                    System.out.println("关闭失败"+e);
                }
            }
        }
        System.out.println("连接成功");
        System.out.println("123");
        return fs;
    }
}
