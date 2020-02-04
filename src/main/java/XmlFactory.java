import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.DocumentHelper;
import org.dom4j.Element;
import org.dom4j.io.OutputFormat;
import org.dom4j.io.SAXReader;
import org.dom4j.io.XMLWriter;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.List;

/**
 * @author Wenbo
 * @date 2020/2/4 13:02
 * @Email 969****15@qq.com
 * @phone 176****7037
 */
public class XmlFactory {
    private void createMybatisXML() throws IOException {
        String path = Test.PATH + "..\\resources\\" + "\\mapper\\";
        File file = new File(path);
        if (!file.exists()) {
            file.mkdirs();
        }
        for (String bean : Test.beanName) {
            File beanXML = new File(path + bean + "Mapper.xml");
            if (!beanXML.exists()) {
                beanXML.createNewFile();
            }
            Document document = DocumentHelper.createDocument();
            document.addDocType("mapper", "-//mybatis.org//DTD Mapper 3.0//EN", "http://mybatis.org/dtd/mybatis-3-mapper.dtd");
            Element mapper = document.addElement("mapper");
            mapper.addAttribute("namespace", Test.PACK + ".dao." + Test.beanName + "Mapper");
//                Element sql = mapper.addElement("insert");
//                sql.addAttribute("id","insertBean").addAttribute("parameterType",PACK+".test.test.bean."+beanName);
//                sql.setText("insert test.bean into " +beanName+ "");
//                Element info2 = sql.addElement("include");
            try {
                // 创建格式化类
                OutputFormat format = OutputFormat.createPrettyPrint();
                // 设置编码格式，默认UTF-8
                format.setEncoding("UTF-8");
                // 创建输出流，此处要使用Writer，需要指定输入编码格式，使用OutputStream则不用
                FileOutputStream fos = new FileOutputStream(beanXML);
                // 创建xml输出流
                XMLWriter writer = new XMLWriter(fos, format);
                // 生成xml文件
                writer.write(document);
                writer.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

    }


}
