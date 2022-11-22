package com.demo.moudleOne.todo.java;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import javax.servlet.http.HttpServletResponse;
import org.apache.commons.io.FileUtils;
import org.apache.commons.io.IOUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;

public final class FileKit {
    private static final Logger log = LoggerFactory.getLogger(FileKit.class);

    private FileKit() {
    }

    public static ResponseEntity<byte[]> toResponseEntity(String path) {
        File file = new File(path);
        HttpHeaders headers = new HttpHeaders();
        headers.set("Content-Disposition", wrap(file.getName()));
        headers.setContentType(MediaType.APPLICATION_OCTET_STREAM);

        try {
            return new ResponseEntity(FileUtils.readFileToByteArray(file), headers, HttpStatus.OK);
        } catch (IOException e) {
            throw new RuntimeException("无法读取文件字节流:" + path, e);
        }
    }



    private static String wrap(String filename) {
        StringBuilder value = new StringBuilder("attachment;");
        String encodedName = encodeURIComponent(filename);
        value.append(" filename=\"").append(encodedName).append("\";").append(" filename*=utf-8''").append(encodedName);
        return value.toString();
    }

    private static String encodeURIComponent(String fileName) {
        try {
            return URLEncoder.encode(fileName, "UTF-8").replaceAll("\\+", "%20");
        } catch (UnsupportedEncodingException e) {
            log.error("不支持的编码格式", e);
            return null;
        }
    }

    public static boolean isFileExists(String filePath) {
        return (new File(filePath)).exists();
    }

    public static File toFile(String filePath) {
        return new File(filePath);
    }


    public static void download(InputStream is, String name, HttpServletResponse response) {
        try {
            byte[] data = IOUtils.toByteArray(is);
            download(data, name, response);
        } catch (IOException e) {
            log.error("InputStream转byte[]异常", e);
        }

    }

    public static void download(byte[] data, String name, HttpServletResponse response) {
        response.setHeader("Content-Disposition", wrap(name));
        response.setContentType("application/octet-stream");
        response.setContentLength(data.length);

        try {
            OutputStream out = response.getOutputStream();
            out.write(data);
            out.flush();
        } catch (IOException e) {
            throw new RuntimeException("无法读取文件字节流:" + name, e);
        }
    }

    public static void download(String path, HttpServletResponse response) {
        File file = new File(path);
        response.setHeader("Content-Disposition", wrap(file.getName()));
        response.setContentType("application/octet-stream");

        try {
            response.getOutputStream().write(FileUtils.readFileToByteArray(file));
        } catch (IOException e) {
            throw new RuntimeException("无法读取文件字节流:" + path, e);
        }
    }


    public static FileInputStream toFileInputStream(String filePath) throws FileNotFoundException {
        return new FileInputStream(filePath);
    }

    public static FileInputStream toFileInputStream(File file) throws FileNotFoundException {
        return new FileInputStream(file);
    }


}
