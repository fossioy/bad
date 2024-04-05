/*
 * Copyright (c) Huawei Technologies Co., Ltd. 2021-2021. All rights reserved.
 */

package com.huawei.long_function.storage.helpers;

import java.io.Closeable;
import java.io.IOException;
import java.io.InputStream;

/**
 * @version 1.0
 * @description
 * @since 2021/9/7
 */
public class SftpConnection implements Closeable {

    public SftpConnection(String destination) {
        throw new NotImplementedException();
    }

    public long upload(InputStream stream) {
        throw new NotImplementedException();
    }

    @Override
    public void close() throws IOException {
        throw new NotImplementedException();
    }
}
