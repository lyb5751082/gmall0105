package com.lyb.gmall.manage;

import org.csource.common.MyException;
import org.csource.fastdfs.ClientGlobal;
import org.csource.fastdfs.StorageClient;
import org.csource.fastdfs.TrackerClient;
import org.csource.fastdfs.TrackerServer;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import java.io.IOException;

@RunWith(SpringRunner.class)
@SpringBootTest
public class GmallManageWebApplicationTests {

    @Test
    public void contextLoads() throws IOException, MyException {
       /* //配置fdfs的全局链接地址
        String tracker = GmallManageWebApplicationTests.class.getResource("/tracker.conf").getPath();//获取配置文件的路径
        ClientGlobal.init(tracker);
        TrackerClient trackerClient = new TrackerClient();
        //获得一个trackerServer实例
        TrackerServer trackerServer = trackerClient.getConnection();
        //通过tracker获得一个Storage链接客户端
        StorageClient storageClient=new StorageClient(trackerServer,null);

        String[]uploadInfos=storageClient.upload_file("f:/a.jpeg","jpeg",null);
        String url="http://192.168.10.99";
        for (String upinfo:uploadInfos){
             url+=upinfo;
         }
        System.out.println(url);*/
    }

}
