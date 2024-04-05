/*
 * Copyright (c) Huawei Technologies Co., Ltd. 2021-2021. All rights reserved.
 */

package com.huawei.long_function.storage;

import com.huawei.long_function.storage.helpers.BaiduCloudClient;
import com.huawei.long_function.storage.helpers.EmailDraft;
import com.huawei.long_function.storage.helpers.EmailSender;
import com.huawei.long_function.storage.helpers.HuaweiCloudClient;
import com.huawei.long_function.storage.helpers.NotImplementedException;
import com.huawei.long_function.storage.helpers.SftpConnection;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;

/**
 * @version 1.0
 * @description
 * @since 2021/9/7
 */
public class StreamSaver {
    public long save(InputStream stream, String destination, StorageType storageType)
            throws IOException {
        switch (storageType) {
            case LOCAL:
                // pseudocode
                File localFile = new File(destination);
                try (FileOutputStream fileOutputStream = new FileOutputStream(localFile)) {
                    byte[] buffer = new byte[4096];
                    long total = 0;
                    int len = 0;
                    while ((len = stream.read(buffer)) >= 0) {
                        total += len;
                        fileOutputStream.write(buffer, 0, len);
                    }
                    return total;
                }
            case SFTP:
                // pseudocode
                try (SftpConnection sftpConnection = new SftpConnection(destination)) {
                    return sftpConnection.upload(stream);
                }
            case EMAIL:
                // pseudocode
                EmailDraft emailDraft = new EmailDraft();
                emailDraft.setRecipient(destination);
                long size = emailDraft.attach("filename", stream);
                EmailSender.send(emailDraft);
                return size;
            case HUAWEI_CLOUD:
                // pseudocode
                File tempFile = File.createTempFile("prefix", "tmp");
                try (FileOutputStream fileOutputStream = new FileOutputStream(tempFile)) {
                    byte[] buffer = new byte[4096];
                    int len = 0;
                    while ((len = stream.read(buffer)) >= 0) {
                        fileOutputStream.write(buffer, 0, len);
                    }
                }
                HuaweiCloudClient huaweiCloudClient = new HuaweiCloudClient();
                long total = huaweiCloudClient.upload(destination, tempFile);
                tempFile.delete();
                return total;
            case BAIDU_CLOUD:
                // pseudocode
                BaiduCloudClient baiduCloudClient = new BaiduCloudClient();
                long uploadedTotal = baiduCloudClient.upload(destination, stream);
                return uploadedTotal;
            default:
                throw new NotImplementedException();
        }
    }
}
