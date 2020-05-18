package test.controller;


import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import test.bean.Content;
import test.common.ResultBean;
import test.common.ResultEnum;
import test.params.ContentParams;
import test.service.FileService;
import test.vo.ContentVO;

import java.io.*;
import java.util.UUID;

@RestController
@RequestMapping("common/")
@Slf4j
@Api(value = "公共服务")
public class CommonController {

    @Autowired
    FileService fileService;

    @ApiOperation(value = "上传文件",httpMethod = "POST")
    @RequestMapping(value = "uploadFile",method = RequestMethod.POST)
    public ResultBean uploadFile (@RequestParam("file") MultipartFile file) throws IOException {

        String[] type = file.getOriginalFilename().split("\\.");
        byte[] fileByte = file.getBytes();
        File file1 = fileService.uploadFile(fileByte, UUID.randomUUID().toString(),type[1]);
        String filePath = "120.26.88.248" + file1.getAbsolutePath().split("html")[1];
        return new ResultBean(filePath,ResultEnum.SUCCESS);
    }

}
