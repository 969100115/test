import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

/**
 * @author Wenbo
 * @date 2020/2/4 13:05
 * @Email 969****15@qq.com
 * @phone 176****7037
 */
public class ServiceFactory {
    private void createService() throws IOException {
        String path = Test.PATH + Test.PACK + "\\service\\";
        String serviceImplPath = path + "\\impl\\";

        File serviceFile = new File(path);
        File serviceImplFile = new File(serviceImplPath);
        if (!serviceFile.exists()) {
            serviceFile.mkdirs();
            serviceImplFile.mkdirs();
        }

        for (String bean : Test.beanName) {
            File service = new File(path + bean + "Service.java");

            String packageContent = "package " + Test.PACK + ".service;\n";
            StringBuffer importContent = new StringBuffer();

            importContent.append("import " + Test.PACK + ".bean.*;\n");
            StringBuffer content = new StringBuffer();
            content.append("public interface " + bean + "Service{\n")
                    .append("int insert"+bean+" ( " + bean +" bean );\n")
                    .append("int update"+bean+" ( " + bean +" bean );\n")
                    .append("int delete"+bean+"ById ( int id);\n")
                    .append("public "+bean+" select"+bean+"ById ( int id);\n")
                    .append("}");
            FileWriter baseFileWritter = new FileWriter(service.getAbsoluteFile());
            BufferedWriter bw = new BufferedWriter(baseFileWritter);
            bw.write(packageContent);
            bw.write(importContent.toString());
            bw.write(content.toString());
            bw.close();

        }

        for (String bean : Test.beanName) {
            File service = new File(serviceImplPath + bean + "ServiceImpl.java");

            String packageContent = "package " + Test.PACK + ".service.impl;\n";
            StringBuffer importContent = new StringBuffer();
            importContent.append("import " + Test.PACK + ".bean.*;\n")
                    .append("import " + Test.PACK + ".service.*;\n")
                    .append("import " + Test.PACK + ".dao.*;\n")
                    .append("import org.springframework.stereotype.Service;\n")
                    .append("import org.springframework.transaction.annotation.Transactional;\n")
                    .append("import javax.annotation.Resource;\n");
            StringBuffer content = new StringBuffer();
            String beanMapper = bean.replaceFirst(String.valueOf(bean.charAt(0)),
                    String.valueOf(bean.charAt(0)).toLowerCase()) + "Mapper";
            content.append("@Service\n")
                    .append("public class " + bean + "ServiceImpl implements " + bean + "Service{\n")
                    .append("@Resource\n")
                    .append(bean + "Mapper " + beanMapper+ ";\n" )
                    .append("@Override\n")
                    .append("public int insert"+bean+" ( " + bean +" bean ){\n")
                    .append("return "+beanMapper+ ".insert(bean);\n")
                    .append("    }\n")
                    .append("@Override\n")
                    .append("public int update"+bean+" ( " + bean +" bean ){\n")
                    .append("return "+beanMapper+ ".updateByPrimaryKey(bean);\n")
                    .append("    }\n")
                    .append("@Override\n")
                    .append("public int delete"+bean+"ById ( int id){\n")
                    .append("return "+beanMapper+ ".deleteByPrimaryKey(id);\n")
                    .append("    }\n")
                    .append("@Override\n")
                    .append("public "+bean+" select"+bean+"ById ( int id){\n")
                    .append("return "+beanMapper+ ".selectByPrimaryKey(id);\n")
                    .append("    }\n")
                    .append("}");
            FileWriter baseFileWritter = new FileWriter(service.getAbsoluteFile());
            BufferedWriter bw = new BufferedWriter(baseFileWritter);
            bw.write(packageContent);
            bw.write(importContent.toString());
            bw.write(content.toString());
            bw.close();
        }


    }
}
