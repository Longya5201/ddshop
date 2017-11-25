package com.longya.upload;

/**
 * User: Administrator
 * Date: 2017/11/22
 * Time: 19:18
 * Version:V1.0
 */
public class TestFtpUpLoad {

  /*  @Test
    public void testFtpUpLoad()throws Exception{

        FTPClient ftpClient=new FTPClient();
        //创建FTP连接
        ftpClient.connect("10.31.161.62",21);
        //登录
        ftpClient.login("ftpuser","dhc890dhc");
        //读取本地文件
        FileInputStream fileInputStream = new FileInputStream(new File("d:\\32.jpg"));
        //配置上传参数
        ftpClient.changeWorkingDirectory("/home/ftpuser/www/images");
        ftpClient.setFileType(FTP.BINARY_FILE_TYPE);
        //上传文件
        ftpClient.storeFile("hello.jpg",fileInputStream);
        //关闭连接
        fileInputStream.close();
        ftpClient.logout();
    }


    @Test
    public void testFtpUpLoad1()throws Exception{
        //读取本地文件
        FileInputStream fileInputStream =new FileInputStream(new File("D:\\32.jpg"));

        // 下面代码中文件上传的位置是basePath+filePath
        FtpUtil.uploadFile("10.31.161.62",21,"ftpuser","dhc890dhc",
                "/home/ftpuser/www/images","/","hell01.jpg",fileInputStream);
        //关闭输入流
        fileInputStream.close();
    }*/
}
