package com.huawei.long_function;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import storage.StorageType;
import storage.StreamSaver;
import storage.helpers.NotImplementedException;

import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;

public class StreamSaverTest {
    @Test
    void StreamSaver_should_ret_content_Length_with_local_save() throws IOException {
        String content = "i am test data";
        int contentLen = content.length();
        InputStream stream = new ByteArrayInputStream(content.getBytes());
        String destination = System.getProperty("user.dir") + File.separator + "localFile.txt";
        StreamSaver streamSaver = new StreamSaver();
        long size =  streamSaver.save(stream, destination, StorageType.LOCAL);
        Assertions.assertEquals(contentLen, size);
    }

    @Test
    void StreamSaver_should_ret_NotImplementedException_with_sftp_save() {
        String content = "i am test data";
        InputStream stream = new ByteArrayInputStream(content.getBytes());
        String destination = "sftp tecmint@192.168.56.10";
        StreamSaver streamSaver = new StreamSaver();
        Assertions.assertThrows(NotImplementedException.class, ()->{
            streamSaver.save(stream, destination, StorageType.SFTP);
        });
    }

    @Test
    void StreamSaver_should_ret_NotImplementedException_with_Email_save() {
        String content = "i am test data";
        InputStream stream = new ByteArrayInputStream(content.getBytes());
        String destination = "zs12345678@huawei.com";
        StreamSaver streamSaver = new StreamSaver();
        Assertions.assertThrows(NotImplementedException.class, ()->{
            streamSaver.save(stream, destination, StorageType.EMAIL);
        });
    }

    @Test
    void StreamSaver_should_ret_NotImplementedException_with_HuaWeiCloud_save() {
        String content = "i am test data";
        InputStream stream = new ByteArrayInputStream(content.getBytes());
        String destination = "192.168.xxx.xxx";
        StreamSaver streamSaver = new StreamSaver();
        Assertions.assertThrows(NotImplementedException.class, ()->{
            streamSaver.save(stream, destination, StorageType.HUAWEI_CLOUD);
        });
    }

    @Test
    void StreamSaver_should_ret_content_Length () {
        String content = "i am test data";
        InputStream stream = new ByteArrayInputStream(content.getBytes());
        String destination = "192.168.xxx.xxx";
        StreamSaver streamSaver = new StreamSaver();
        Assertions.assertThrows(NotImplementedException.class, ()->{
            streamSaver.save(stream, destination, StorageType.BAIDU_CLOUD);
        });
    }
}
