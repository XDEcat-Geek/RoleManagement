package com.xde.utils;

import org.springframework.boot.system.ApplicationHome;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

/**
 * date: 2021/1/11 21:41
 * 说明: 处理文件的工具类
 *
 * @author: 薛定谔的猫er
 * @since: JDK 1.8
 */
public class FileUtil {
    // 获取文件的byte[]数据
    public static byte[] getFileBytes(String filePath) throws IOException {
        // 1.根据文件路径名创建文件对象
        File file = new File(filePath);
        long fileSize = file.length();
        FileInputStream fi = new FileInputStream(file);
        byte[] buffer = new byte[(int)fileSize];
        int offset = 0;
        int numRead = 0;
        while (offset < buffer.length && (numRead = fi.read(buffer,offset,buffer.length-offset))>=0){
            offset += numRead;
        }
        // 确保所有数据均被读取
        if (offset != buffer.length) {
            throw new IOException("Could not completely read file "
                    + file.getName());
        }
        fi.close();
        return buffer;
    }
    // 按文件名字进行批量删除
    public static void deleteFiles(String folder,String id){
        //1.遍历指定目录下的所有文件
        File file = new File(folder);
        File[] files = file.listFiles();
        for (File f : files){
            // 如果不是目录(文件)
            if (!f.isDirectory()){
                System.out.println(f.getName());
                String[] s = f.getName().split("_", 2);
                if (s[0].equals(id)){
                    boolean delete = f.delete();
                    System.out.println("删除:"+delete);
                }
            }
        }
    }
}
