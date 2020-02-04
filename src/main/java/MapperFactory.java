import utils.CreateInterface;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * @author Wenbo
 * @date 2020/2/4 13:06
 * @Email 969****15@qq.com
 * @phone 176****7037
 */
public class MapperFactory {
    public static void createDAO() throws IOException {
        String path = Test.PATH + Test.PACK + "\\dao\\";
        String packageContent = "package " + Test.PACK + ".dao;\n";
        File file = new File(path);
        if (!file.exists()) {
            file.mkdirs();
        }

        //创建BaseMapper文件
        File baseMapper = new File(path + "BaseMapper.java");
        String name = "BaseMapper<T>";
        String[] extendString = {"Mapper<T>", "MySqlMapper<T>"};
        List<String> importList = new ArrayList<>();
        importList.add("tk.mybatis.mapper.common.Mapper");
        importList.add("tk.mybatis.mapper.common.MySqlMapper");

        CreateInterface createInterface = new CreateInterface();
        createInterface.classFactory(baseMapper, packageContent, importList, name, null, null, null, extendString);


        //创建Bean对应的DAO层Mapper文件
        for (String bean : Test.beanName) {
            File beanXML = new File(path + bean + "Mapper.java");
            if (!beanXML.exists()) {
                beanXML.createNewFile();
            }

            String mapperName = bean + "Mapper";
            String[] mapperExtendString = {"BaseMapper<"+ bean + ">"};

            List<String> mapperImportList = new ArrayList<>();
            importList.add("org.springframework.stereotype.Repository");
            importList.add(Test.PACK + ".dao.BaseMapper");
            importList.add("test.bean." + bean);

            List<String> annoatationList = new ArrayList<>();
            annoatationList.add("@Repository");

            CreateInterface createMapperInterface = new CreateInterface();

            createInterface.classFactory(beanXML,packageContent,importList,mapperName,annoatationList,null,null,mapperExtendString);

//
//
////            StringBuffer importContent = new StringBuffer();
////            importContent.append("import " + Test.PACK + ".dao.BaseMapper;\n")
////                    .append("import org.springframework.stereotype.Repository;\n")
////                    .append("import " + "test.bean." + bean + ";\n");
//            StringBuffer content = new StringBuffer();
//            content.append("@Repository\n")
//                    .append("public interface " + bean + "Mapper extends BaseMapper<" + bean + "> {\n")
//                    .append(" int insertBean(" + bean + " bean);\n")
//                    .append(bean + " update(" + bean + " bean);\n")
//                    .append(bean + " select(String id);\n")
//                    .append(" int deleteBean(String id);\n")
//                    .append("}");
//
//            FileWriter fileWritter = new FileWriter(beanXML.getAbsoluteFile());
//            BufferedWriter bufferedWriter = new BufferedWriter(fileWritter);
//            bufferedWriter.write(packageContent);
//            bufferedWriter.write(importContent.toString());
//            bufferedWriter.write(content.toString());
//            bufferedWriter.close();
        }


    }
}
