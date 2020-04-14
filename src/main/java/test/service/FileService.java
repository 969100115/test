package test.service;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;

public interface FileService {
    File uploadFile (byte[] contentInBytes,String uuid,String type) throws IOException;
}
