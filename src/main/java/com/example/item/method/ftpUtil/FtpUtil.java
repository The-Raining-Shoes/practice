package com.example.item.method.ftpUtil;

import com.example.item.utils.CheckUtil;
import com.example.item.utils.StringUtils;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.net.ftp.FTPClient;
import org.apache.commons.net.ftp.FTPClientConfig;
import org.apache.commons.net.ftp.FTPReply;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;
import org.springframework.core.io.support.PropertiesLoaderUtils;

import javax.validation.constraints.NotNull;
import java.io.BufferedInputStream;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Properties;

/**
 * FTP工具类
 *
 * @author MaoHao
 * @date 2020年05月18日 9:22
 */
@Slf4j
public class FtpUtil {

    public String HOST_IP;
    public String PORT;
    public String USER_NAME;
    public String PASSWORD;
    public String LOCAL_PATH;
    public String REMOTE_PATH;

    private final FTPClient ftpClient;
    private BufferedWriter writer;
    private String LOCAL_FILE_NAME;


    public FtpUtil(@NotNull String tableName) {
        readPropertiesFile("application.properties");
        LOCAL_FILE_NAME = dealFileNameWithTable(tableName);
        ftpClient = new FTPClient();
    }

    public boolean upload() {
        boolean s = false;
        if (writer == null) {
            throw new RuntimeException("请先写入文件流数据！");
        }
        try {
            writer.flush();
        } catch (IOException e) {
            FtpUtil.log.error("写入失败！", e);
            throw new RuntimeException("写入失败！", e);
        }
        try {
            s = upload(LOCAL_FILE_NAME);
        } catch (Exception e) {
            FtpUtil.log.warn("文件上传失败1次,即将重新上传", e);
            try {
                s = upload(LOCAL_FILE_NAME);
            } catch (Exception ex) {
                FtpUtil.log.warn("文件上传失败2次,上传文件失败{}", LOCAL_FILE_NAME);
                ex.printStackTrace();
            }
            e.printStackTrace();
        }
        return s;
    }

    public boolean upload(String localFileName) throws Exception {
        return putFile(localFileName, localFileName);
    }

    public boolean putFile(String localFileName, String remoteFileName) throws Exception {
        boolean ifPut = false;
        boolean ifRename = false;
        connect();
        if (CheckUtil.isNotBlank(REMOTE_PATH)) {
            // 切换FTP上传路径
            changeWorkingDirectory(REMOTE_PATH);
            // 上传中文件名
            String remoteFileNameIng = remoteFileName.concat(".tmp");
            ifPut = put(localFileName, remoteFileNameIng);
            ifRename = rename(remoteFileNameIng, remoteFileName);
        }
        return ifPut && ifRename;
    }

    public boolean put(String localFileName, String remoteFileName) {
        File file = new File(LOCAL_PATH, localFileName);
        boolean s = false;
        try {
            BufferedInputStream in = new BufferedInputStream(new FileInputStream(file));
            s = ftpClient.storeFile(remoteFileName, in);
            FtpUtil.log.info("{}上传文件FTP目录{}{}", localFileName, remoteFileName, s);
            return s;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return s;
    }

    public boolean rename(String remoteFileNameIng, String remoteFileName) throws IOException {
        boolean s = ftpClient.rename(remoteFileNameIng, remoteFileName);
        FtpUtil.log.info("修改临时文件名{}->{}{}", remoteFileNameIng, remoteFileName, s);
        return s;
    }

    public void changeWorkingDirectory(String remotePath) throws Exception {
        // 切换ftp目录
        if (ftpClient == null || !ftpClient.isConnected()) {
            connect();
        }
        assert ftpClient != null;
        boolean s = ftpClient.changeWorkingDirectory(remotePath);// 转移到FTP服务器目录
        FtpUtil.log.info("切换文件路径{},{}", remotePath, s);
    }

    /**
     * 连接FTP 设置编码
     */
    public void connect() throws Exception {
        FtpUtil.log.info("connect [{}:{}]", HOST_IP, PORT);
        if (!ftpClient.isConnected()) {
            ftpClient.connect(HOST_IP, Integer.parseInt(PORT));
            ftpClient.login(USER_NAME, PASSWORD);
        }
        if (!FTPReply.isPositiveCompletion(ftpClient.getReplyCode())) {
            FtpUtil.log.error("ftp认证失败：{} {} {}", HOST_IP, PORT, USER_NAME);
            throw new Exception("ftp认证失败！");
        } else {
            //ftp中文编码设置
            ftpClient.setControlEncoding("GBK");
            FTPClientConfig conf = new FTPClientConfig(FTPClientConfig.SYST_UNIX);
            conf.setServerLanguageCode("zh");
            ftpClient.configure(conf);
        }
    }

    /**
     * 登出FTP 清理资源
     */
    public void logout(String useMethod) {
        FtpUtil.log.info("登出FTP {}", useMethod);
        if (ftpClient.isConnected()) {
            try {
                ftpClient.logout();
            } catch (IOException e) {
                FtpUtil.log.error("logout fail", e);
            }
            try {
                ftpClient.disconnect();
            } catch (IOException e) {
                FtpUtil.log.error("disconnect fail", e);
            }
        }

        if (writer != null) {
            try {
                writer.close();
            } catch (IOException e) {
                FtpUtil.log.error("writer close fail", e);
            }
        }
    }

    public void writeLine(CharSequence line) {
        write(line, true);
    }

    // 写入数据
    public void write(CharSequence line) {
        try {
            if (writer == null) {
                synchronized (ftpClient) {
                    if (writer == null) {
                        newWriter();
                    }
                }
            }
            writer.append(line);
        } catch (IOException e) {
            FtpUtil.log.error("写入失败：{}", line, e);
        }
    }

    public void write(CharSequence line, boolean newLine) {
        try {
            if (writer == null) {
                synchronized (ftpClient) {
                    if (writer == null) {
                        newWriter();
                    }
                }
            }
            writer.append(line);
            if (newLine) {
                writer.newLine();
            }
        } catch (IOException e) {
            FtpUtil.log.error("写入失败：{}", line, e);
        }
    }

    void newWriter() {
        File localPathFile = new File(LOCAL_PATH);
        if (!localPathFile.exists()) {
            boolean s = localPathFile.mkdirs();
            FtpUtil.log.error("创建本地文件夹：{}{}", LOCAL_PATH, s);
        }
        Path path = Paths.get(LOCAL_PATH, LOCAL_FILE_NAME);
        try {
            writer = new BufferedWriter(new OutputStreamWriter(Files.newOutputStream(path), "gbk"));
        } catch (IOException e) {
            throw new RuntimeException("创建本地文件失败！");
        }
    }

    // 文件名规范"n00_{系统英文缩写}_{周期类型缩写}_{Table名称}_{帐期时间}[_{01}].dat"
    private String dealFileNameWithTable(String table) {
        StringBuilder fileName = new StringBuilder();
        if (CheckUtil.isNotBlank(table)) {
            fileName.append("n00")
                    .append("_qywx")
                    .append("_id")
                    .append("_").append(table)
                    .append("_").append(getYesterdayStr())
                    .append("_01")
                    .append(".dat");
        }
        return fileName.toString();
    }

    // 添加附加文件
    public void extra(int dataSize) {
        String fileName = LOCAL_FILE_NAME;
        int fileSize = getFileSize();
        if (fileName.lastIndexOf(".") > -1) {
            LOCAL_FILE_NAME = fileName.substring(0, fileName.lastIndexOf(".")) + "." + getVerifyFileNameSuffix();
            newWriter();
            String sb = StringUtils.joinWithoutNull(new Object[]{fileName, fileSize,
                    dataSize, getYesterdayStr()}, Constants.FILE_ODS_SPLIT_CHAR5);
            writeLine(sb);
            upload();
        }
    }

    public int getFileSize() {
        Path path = Paths.get(LOCAL_PATH, LOCAL_FILE_NAME);
        try {
            byte[] bytes = Files.readAllBytes(path);
            return bytes.length;
        } catch (IOException e) {
            e.printStackTrace();
        }
        return 0;
    }

    String getYesterdayStr() {
        SimpleDateFormat df = new SimpleDateFormat("yyyyMMdd");
        Calendar calendar = Calendar.getInstance();
        calendar.add(Calendar.DAY_OF_MONTH, -1);
        return df.format(calendar.getTime());
    }

    String getVerifyFileNameSuffix() {
        return Constants.DEFAULT_VERIFY_FILE_NAME_SUFFIX;
    }

    /**
     * 通过配置文件名读取内容
     */
    public void readPropertiesFile(String fileName) {
        try {
            Resource resource = new ClassPathResource(fileName);
            Properties properties = PropertiesLoaderUtils.loadProperties(resource);
            HOST_IP = properties.getProperty("ods.ftp.hostIp");
            PORT = properties.getProperty("ods.ftp.port");
            USER_NAME = properties.getProperty("ods.ftp.userName");
            PASSWORD = properties.getProperty("ods.ftp.password");
            LOCAL_PATH = properties.getProperty("ods.ftp.localPath");
            REMOTE_PATH = properties.getProperty("ods.ftp.remotePath");
        } catch (Exception e) {
            System.out.println("————读取配置文件：" + fileName + "出现异常，读取失败————");
            e.printStackTrace();
        }
    }
}
