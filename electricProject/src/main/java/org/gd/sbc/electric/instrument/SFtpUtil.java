package org.gd.sbc.electric.instrument;

import com.jcraft.jsch.*;
import com.sun.deploy.util.StringUtils;
import org.gd.sbc.electric.constants.SftpConstant;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.HashMap;
import java.util.Map;
import java.util.Properties;
import java.util.Vector;

/**
 * sftp的工具类
 * @author yigang.wu
 * @date created in $time $date
 */
public class SFtpUtil {
    Session session = null;
    Channel channel = null;

    private static Logger logger = LoggerFactory.getLogger(SFtpUtil.class);

    public ChannelSftp getChannelSftp(Map<String,String> maps,int timeout) throws Exception {
        String ftpHost = maps.get(SftpConstant.SFTP_REQ_HOST);
        String port = maps.get(SftpConstant.SFTP_REQ_PORT);
        String ftpUserName = maps.get(SftpConstant.SFTP_REQ_USERNAME);
        String ftpPassword = maps.get(SftpConstant.SFTP_REQ_PASSWORD);

        int ftpPort = SftpConstant.SFTP_DEFAULT_PORT;

        if(port != null && !"".equals(port)){
            ftpPort = Integer.valueOf(port);
        }

        JSch jSch = new JSch();
        session = jSch.getSession(ftpUserName,ftpHost,ftpPort);
        logger.info("Session is created");
        if(ftpPassword != null && !"".equals(ftpPassword)){
            session.setPassword(ftpPassword);
        }

        Properties properties = new Properties();
        properties.put("StrictHostKeyChecking", "no");
        session.setConfig(properties);
        session.setTimeout(timeout);
        session.connect();
        logger.info("session is connect");

        logger.info("open channel");
        channel = session.openChannel("sftp");
        channel.connect();
        logger.info("Connected successfully to ftpHost = " + ftpHost + ",as ftpUserName = " + ftpUserName
                + ", returning: " + channel);
        return  (ChannelSftp)channel;
    }

    public void close(){
        if(channel != null){
            channel.disconnect();
        }

        if(session != null){
            session.disconnect();
        }
    }
}
