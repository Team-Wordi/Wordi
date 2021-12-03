package com.pm.wordi.commons.utils.file;

import java.util.UUID;

public class FileNameUtils {

    public static String fileNameConvert(String fileName) {
        StringBuilder builder = new StringBuilder();
        UUID uuid = UUID.randomUUID();
        String extension = getExtension(fileName);

        builder.append(uuid).append(".").append(extension);

        return builder.toString();
    }

    // 확장자 추출
    private static String getExtension(String fileName) {
        int pos = fileName.lastIndexOf(".");

        return fileName.substring(pos + 1);
    }

    public static String getFileName(String path) {
        int idx = path.lastIndexOf("/");

        return path.substring(idx + 1);
    }

}
