package test.service.impl;

import org.springframework.stereotype.Service;
import test.service.FileService;

import java.io.*;

@Service
public class FileServiceImpl implements FileService {
    private String path = "/usr/local/webserver/nginx/html/photo";

    @Override
    public File uploadFile(byte[] contentInBytes ,String uuid,String type) throws IOException {
        File file = new File(path+"/"+uuid+"."+type);
        if (!file.exists()) {
            file.createNewFile();
        }
        FileOutputStream fileOutputStream = new FileOutputStream(file);
        fileOutputStream.write(contentInBytes);
        fileOutputStream.flush();
        fileOutputStream.close();
        return file;
    }
}
