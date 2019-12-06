package com.lyb.gmall.manage.util;

import org.csource.common.MyException;
import org.csource.fastdfs.ClientGlobal;
import org.csource.fastdfs.StorageClient;
import org.csource.fastdfs.TrackerClient;
import org.csource.fastdfs.TrackerServer;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

public class PmsUploadUtil {

    public static String uploadImage(MultipartFile multipartFile) {
        String imgUrl="http://192.168.10.99";;
        //上传图片的到服务器
        //配置fdfs的全局链接地址
        String tracker = PmsUploadUtil.class.getResource("/tracker.conf").getPath();//获取配置文件的路径
        try {
            ClientGlobal.init(tracker);
        } catch (Exception e) {
            e.printStackTrace();
        }
        TrackerClient trackerClient = new TrackerClient();
        //获得一个trackerServer实例
        TrackerServer trackerServer = null;
        try {
            trackerServer = trackerClient.getConnection();
        } catch (IOException e) {
            e.printStackTrace();
        }
        //通过tracker获得一个Storage链接客户端
        StorageClient storageClient=new StorageClient(trackerServer,null);

        try {
            byte[] bytes = multipartFile.getBytes();//获得上传的二进制对象
            String originalFilename = multipartFile.getOriginalFilename();//a.jpg文件全名
            int i=originalFilename.lastIndexOf(".");//获得最后一个点的位置
            String extName = originalFilename.substring(i+1);//最后一个点 后面的就是文件类型了

            String[] uploadInfos = storageClient.upload_file(bytes,extName,null);
            //(文件对象,后缀名(文件类型),null);
            for (String uploadInfo:uploadInfos){
                imgUrl+="/"+uploadInfo;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return imgUrl;
    }
}
