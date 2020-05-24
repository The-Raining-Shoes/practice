package com.example.item.tools.ftpConnect;

import lombok.Data;

import java.io.InputStream;

/**
 * @author HXM
 * @date 2020年05月15日 11:05
 */
@Data
public class FtpBean {
    //FTP服务器地址
    private String address;
    //FTP服务器端口号
    private String port;
    //FTP服务器用户名
    private String username;
    //FTP服务器密码
    private String password;
    //上传文件名称
    private String fileName;
    //基本路径
    private String basepath;
    //文件输入流
    private InputStream inputStream;
    //保存文件方式  默认：1-覆盖；2-文件名称后面+(递增数据)
    private Integer saveFileType;

}


