/*
 * Copyright (c) Huawei Technologies Co., Ltd. 2021-2021. All rights reserved.
 */

package storage;

import storage.helpers.*;

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
                return saveToLocal(stream, destination);
            case SFTP:
                return saveToSftp(stream, destination);
            case EMAIL:
                return saveToEmail(stream, destination);
            case HUAWEI_CLOUD:
                return saveToHuaweiCloud(stream, destination);
            case BAIDU_CLOUD:
                return saveToBaiduCloud(stream, destination);
            default:
                throw new NotImplementedException();
        }
    }

    private long saveToBaiduCloud(InputStream stream, String destination) {
        // pseudocode
        BaiduCloudClient baiduCloudClient = new BaiduCloudClient();
        long uploadedTotal = baiduCloudClient.upload(destination, stream);
        return uploadedTotal;
    }

    private long saveToHuaweiCloud(InputStream stream, String destination) throws IOException {
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
    }

    private long saveToEmail(InputStream stream, String destination) {
        // pseudocode
        EmailDraft emailDraft = new EmailDraft();
        emailDraft.setRecipient(destination);
        long size = emailDraft.attach("filename", stream);
        EmailSender.send(emailDraft);
        return size;
    }

    private long saveToSftp(InputStream stream, String destination) throws IOException {
        // pseudocode
        try (SftpConnection sftpConnection = new SftpConnection(destination)) {
            return sftpConnection.upload(stream);
        }
    }

    private long saveToLocal(InputStream stream, String destination) throws IOException {
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
    }
}
