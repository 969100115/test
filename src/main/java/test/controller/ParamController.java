package test.controller;


import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.pdf.*;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.Data;
import lombok.extern.slf4j.Slf4j;
import org.apache.tomcat.util.http.fileupload.ByteArrayOutputStream;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import test.bean.Order;
import test.bean.ProjectParam;
import test.common.ResultBean;
import test.common.ResultEnum;
import test.dao.ProjectParamMapper;
import test.dto.ProjectDTO;
import test.service.ContentService;
import test.service.OrderService;
import test.service.ProjectParamService;
import test.service.ProjectService;

import org.apache.commons.lang3.StringUtils;
import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.*;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.net.URLEncoder;
import java.util.*;

@RestController
@RequestMapping("" +
        "param/")
@Slf4j
@Api(value = "参数与结论")
public class ParamController {

    @Autowired
    OrderService orderService;

    @Autowired
    ProjectParamService projectParamService;

    @Autowired
    ContentService contentService;

    @Resource
    ProjectParamMapper projectParamMapper;

    @Autowired
    ProjectService projectService;

    @ApiOperation(value = "上传测试结果", httpMethod = "POST")
    @RequestMapping(value = "UploadTestResults", method = RequestMethod.POST)
    public ResultBean WriteParams(@RequestBody JSONObject word) {

        String status = projectParamMapper.getStatusdownload(Integer.valueOf(word.get("orderId").toString()));
        if("1".equals(status)){return new ResultBean("已操作",ResultEnum.ERROR);}
        //写入数据库
        if(null!=word.get("parameters")){
            JSONArray jsonArray=word.getJSONArray("parameters");
                for(int i=0;i<jsonArray.size();i++){
                    JSONObject jsonObject=jsonArray.getJSONObject(i);
                    projectParamMapper.insertvalue(Integer.valueOf(word.getString("orderId")),
                            jsonObject.getString("param"),jsonObject.getString("value"));
                }
        }
        // 模板路径
        Date now = new Date();
//        String templatePath = "/Users/suxinhaixp/Desktop/测试模板result.pdf";
        String templatePath = "/opt/java/earn/file/测试模板result.pdf";
        // 生成的新文件路径
        String random = now.toString();
//        String newPDFPath = "/Users/suxinhaixp/Desktop/测试结果" + random + ".pdf";
        String newPDFPath = "/opt/java/earn/file/测试结果" + random + ".pdf";
        Order order = orderService.selectOrderById(Integer.valueOf(word.getString("orderId")));
        List<ProjectParam> projectParams = projectParamService.listProjectParam(Integer.valueOf(word.getString("orderId")));
        ProjectDTO projectDTO=projectService.selectProjectById(order.getProjectId());

        int num=projectParamMapper.insertway(Integer.valueOf(word.get("orderId").toString()),random,"1");
        PdfReader reader;
        FileOutputStream out;
        ByteArrayOutputStream bos;
        PdfStamper stamper;
        try {
            out = new FileOutputStream(newPDFPath);
            reader = new PdfReader(templatePath);
            bos = new ByteArrayOutputStream();
            stamper = new PdfStamper(reader, bos);
            AcroFields form = stamper.getAcroFields();
            Map<String, String> map = new HashMap<>();
            Integer n = 1;
            final double d = Math.random();
            final int no = (int)(d*1000);
            map.put("TestNo",String.valueOf(no));
            map.put("TestUnitName","上海国家测试单位");
            map.put("TestName",projectDTO.getName());
            map.put("TestPlace","上海国家测试单位");
            map.put("TestType",projectDTO.getType());
            map.put("TestTime",null==order.getTestPredictTime()? "":order.getTestPredictTime().toString());
            map.put("TestFinshTime",null==order.getTestCompleteTime()? "":order.getTestCompleteTime().toString());
            map.put("TestSite","上海国家测试单位");
            map.put("TestEnvir","室外");
            map.put("TestText",projectDTO.getName());
            map.put("TestDifficulty",projectDTO.getDuration().toString());
            map.put("TestFun",projectDTO.getDescription());
            for (ProjectParam projectParam : projectParams) {
                if(!"结论".equals(projectParam.getParam())){
                    map.put("Name" + n.toString(), projectParam.getParam());
                    map.put("Param" + n.toString(), projectParam.getValue());
                    n++;
                }else {
                    map.put("Result", projectParam.getValue());
                }

            }

            int i = 0;
            java.util.Iterator<String> it = form.getFields().keySet().iterator();
            while (it.hasNext()) {
                String name = it.next();
                form.setField(name, map.get(name));
            }
            //true代表生成的PDF文件不可编辑
            stamper.setFormFlattening(true);
            stamper.close();
            Document doc = new Document();
            PdfCopy copy = new PdfCopy(doc, out);
            doc.open();
            PdfImportedPage importPage1 = copy.getImportedPage(new PdfReader(bos.toByteArray()), 1);
            PdfImportedPage importPage2 = copy.getImportedPage(new PdfReader(bos.toByteArray()), 2);
            PdfImportedPage importPage3 = copy.getImportedPage(new PdfReader(bos.toByteArray()), 3);
            copy.addPage(importPage1);
            copy.addPage(importPage2);
            copy.addPage(importPage3);
            doc.close();

        } catch (IOException e) {
            e.printStackTrace();
        } catch (DocumentException e) {
            e.printStackTrace();
        }
        order.setStatus("3");
        order.setTestPredictTime(now);
        orderService.updateOrder(order);
        return new ResultBean("ok",ResultEnum.SUCCESS);
    }


    @ApiOperation(value = "下载文件", httpMethod = "POST")
    @RequestMapping(value = "download", method = RequestMethod.POST)
    public ResultBean downloadFile(@RequestBody Map word,HttpServletRequest request,HttpServletResponse response) throws IOException {
        String way = projectParamMapper.getWaydownload(Integer.valueOf(word.get("orderId").toString()));
        //文件所在目录路径
        if(null==way||"".equals(way)){
            return  new ResultBean("未生成数据",ResultEnum.ERROR);
        }
            String filename="测试结果"+way+".pdf";
            String filePath = "/opt/java/earn/file/"+filename;
//             String filePath = "/Users/suxinhaixp/Desktop/"+filename;

            System.out.println("文件路径：" + filePath);

            //得到该文件
            File file = new File(filePath);
            if(!file.exists()){
                System.out.println("Have no such file!");
                return new ResultBean("文件不存在",ResultEnum.ERROR);//文件不存在就退出方法
            }

            FileInputStream fileInputStream = new FileInputStream(file);
            //设置Http响应头告诉浏览器下载这个附件,下载的文件名也是在这里设置的
        String userAgent = request.getHeader("USER-AGENT");

        if(StringUtils.contains(userAgent, "MSIE")){//IE浏览器
            filename = URLEncoder.encode(filename,"UTF8");
        }else if(StringUtils.contains(userAgent, "Mozilla")){//google,火狐浏览器
            filename = new String(filename.getBytes(), "ISO8859-1");
        }else{
            filename = URLEncoder.encode(filename,"UTF8");//其他浏览器
        }
        response.setHeader("Content-Disposition", "attachment; filename=\"" + filename + "\"");
        response.setContentType("multipart/form-data");
        OutputStream outputStream = response.getOutputStream();
            byte[] bytes = new byte[2048];
            int len = 0;
            while ((len = fileInputStream.read(bytes))>0){
                outputStream.write(bytes,0,len);
            }
            fileInputStream.close();
            outputStream.close();
        Order order = orderService.selectOrderById(Integer.valueOf(word.get("orderId").toString()));
        order.setStatus("4");
        if(!"".equals(order.getTestCompleteTime())) {
            order.setTestCompleteTime(new Date());
        }
        orderService.updateOrder(order);
        return new ResultBean("ok",ResultEnum.SUCCESS);
    }

    @ApiOperation(value = "清楚参数", httpMethod = "POST")
    @RequestMapping(value = "CleanParams", method = RequestMethod.POST)
    public ResultBean downloadFile(@RequestBody Map map ) {
        if(null!=map.get("orderId")){
            projectParamMapper.deleteParams(Integer.valueOf(map.get("orderId").toString()));
            projectParamMapper.deleteway(Integer.valueOf(map.get("orderId").toString()));
            return new ResultBean("ok",ResultEnum.SUCCESS);
        }else {
            return new ResultBean("没有这条记录",ResultEnum.ERROR);
        }

    }

}
