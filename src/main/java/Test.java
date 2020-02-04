import java.io.*;
import java.util.ArrayList;
import java.util.List;

import org.dom4j.*;
import org.dom4j.io.OutputFormat;
import org.dom4j.io.SAXReader;
import org.dom4j.io.XMLWriter;

/**
 * @author Wenbo
 * @date 2020/1/31 18:51
 * @Email 969****15@qq.com
 * @phone 176****7037
 */
public class Test {

    public static final String PATH = ".\\src\\main\\java\\";
    public static final String PACK = "test";
    public static final String Application = "MyApplication";
    public static final ArrayList<String> beanName = new ArrayList<>();

    public static void main(String[] args) throws IOException, DocumentException {
                Test test = new Test();
        test.readBean();
        ApplicationFactory.createApplication();
        MapperFactory.createDAO();
//        Test test = new Test();
//        test.createApplication();
//        test.readBean();
//        test.createDAO();
//        test.createMybatisXML();
//        test.addApplication();
//        test.createService();
        System.out.println();

    }

    private void readBean() {
        File file = new File(PATH + "test/bean");
        File[] beans = file.listFiles();
        for (File bean : beans) {
            String name = bean.getName().replace(".java", "");
            Test.beanName.add(name);
        }
    }

    private void createMybatisXML() throws IOException {
        String path = PATH + "..\\resources\\" + "\\mapper\\";
        File file = new File(path);
        if (!file.exists()) {
            file.mkdirs();
        }
        for (String bean : beanName) {
            File beanXML = new File(path + bean + "Mapper.xml");
            if (!beanXML.exists()) {
                beanXML.createNewFile();
            }
            Document document = DocumentHelper.createDocument();
            document.addDocType("mapper", "-//mybatis.org//DTD Mapper 3.0//EN", "http://mybatis.org/dtd/mybatis-3-mapper.dtd");
            Element mapper = document.addElement("mapper");
            mapper.addAttribute("namespace", PACK + ".dao." + beanName + "Mapper");
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

    private void createService() throws IOException {
        String path = PATH + PACK + "\\service\\";
        String serviceImplPath = path + "\\impl\\";

        File serviceFile = new File(path);
        File serviceImplFile = new File(serviceImplPath);
        if (!serviceFile.exists()) {
            serviceFile.mkdirs();
            serviceImplFile.mkdirs();
        }

        for (String bean : beanName) {
            File service = new File(path + bean + "Service.java");

            String packageContent = "package " + PACK + ".service;\n";
            StringBuffer importContent = new StringBuffer();

            importContent.append("import " + PACK + ".bean.*;\n");
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

        for (String bean : beanName) {
            File service = new File(serviceImplPath + bean + "ServiceImpl.java");

            String packageContent = "package " + PACK + ".service.impl;\n";
            StringBuffer importContent = new StringBuffer();
            importContent.append("import " + PACK + ".bean.*;\n")
                    .append("import " + PACK + ".service.*;\n")
                    .append("import " + PACK + ".dao.*;\n")
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

    private void createDAO() throws IOException {
        String path = PATH + PACK + "\\dao\\";
        String packageContent = "package " + PACK + ".dao;\n";
        File file = new File(path);
        if (!file.exists()) {
            file.mkdirs();
        }

        //创建BaseMapper文件
        File baseMapper = new File(path + "BaseMapper.java");
        StringBuffer baseImportContent = new StringBuffer();
        baseImportContent.append("import tk.mybatis.mapper.common.Mapper;\n")
                .append("import tk.mybatis.mapper.common.MySqlMapper;\n");
        StringBuffer baseContent = new StringBuffer();
        baseContent.append("public interface BaseMapper<T> extends Mapper<T>, MySqlMapper<T> {\n")
                .append("}");
        FileWriter baseFileWritter = new FileWriter(baseMapper.getAbsoluteFile());
        BufferedWriter bw = new BufferedWriter(baseFileWritter);
        bw.write(packageContent);
        bw.write(baseImportContent.toString());
        bw.write(baseContent.toString());
        bw.close();

        //创建Bean对应的DAO层Mapper文件
        for (String bean : beanName) {
            File beanXML = new File(path + bean + "Mapper.java");
            if (!beanXML.exists()) {
                beanXML.createNewFile();
            }


            StringBuffer importContent = new StringBuffer();
            importContent.append("import " + PACK + ".dao.BaseMapper;\n")
                    .append("import org.springframework.stereotype.Repository;\n")
                    .append("import " + "test.bean." + bean + ";\n");
            StringBuffer content = new StringBuffer();
            content.append("@Repository\n")
                    .append("public interface " + bean + "Mapper extends BaseMapper<" + bean + "> {\n")
                    .append(" int insertBean(" + bean + " bean);\n")
                    .append(bean + " update(" + bean + " bean);\n")
                    .append(bean + " select(String id);\n")
                    .append(" int deleteBean(String id);\n")
                    .append("}");

            FileWriter fileWritter = new FileWriter(beanXML.getAbsoluteFile());
            BufferedWriter bufferedWriter = new BufferedWriter(fileWritter);
            bufferedWriter.write(packageContent);
            bufferedWriter.write(importContent.toString());
            bufferedWriter.write(content.toString());
            bufferedWriter.close();
        }


    }

    private void createController() {

    }

    /**
     * 创建启动类
     *
     * @throws IOException
     */
    private void createApplication() throws IOException {
        File file = new File(PATH + PACK + "\\" + Application + ".java");
        String packageContent = "package " + PACK + ";\n";
        StringBuffer importContent = new StringBuffer();
        importContent.append("import org.springframework.boot.SpringApplication;\n")
                .append("import org.springframework.boot.autoconfigure.SpringBootApplication;\n");

        StringBuffer content = new StringBuffer();
        content.append("@SpringBootApplication\n")
                .append("public class " + Application + "{\n")
                .append("public static void main(String[] args) {\n")
                .append("SpringApplication.run(" + Application + ".class, args);\n")
                .append("}\n")
                .append("}\n");
        if (!file.exists()) {
            file.createNewFile();
        }


        FileWriter fileWritter = new FileWriter(file.getAbsoluteFile());
        BufferedWriter bw = new BufferedWriter(fileWritter);
        bw.write(packageContent);
        bw.write(importContent.toString());
        bw.write(content.toString());
        bw.close();
    }

    void writePomFile() throws IOException, DocumentException {
        File file = new File(".\\" + "pom.xml");
        SAXReader saxReader = new SAXReader();
        Document document = saxReader.read(file);
        Element rootElement = document.getRootElement();

        Element dependency = rootElement.addElement("parent");
        Element groupIdElement = dependency.addElement("groupId");
        groupIdElement.setText("org.springframework.boot");
        Element artifactIdElement = dependency.addElement("artifactId");
        artifactIdElement.setText("spring-boot-starter-parent");
        Element versionElement = dependency.addElement("version");
        versionElement.setText("2.0.2.RELEASE");
        Element dependencies = rootElement.element("dependencies");
        List<Element> dependencyList = dependencies.elements("dependency");
        Test.addDependency(dependencies, "tk.mybatis", "mapper", "4.1.5");
        Test.addDependency(dependencies, "org.springframework.boot", "spring-boot-starter-jdbc", null);
        Test.addDependency(dependencies, "org.springframework.boot", "spring-boot-starter-web", null);
        Test.addDependency(dependencies, "org.mybatis.spring.boot", "mybatis-spring-boot-starter", "1.3.2");
        Test.addDependencyWithScope(dependencies, "org.springframework.boot", "spring-boot-devtools", "runtime");
        Test.addDependency(dependencies, "mysql", "mysql-connector-java", null);
        try {
            // 创建格式化类
            OutputFormat format = OutputFormat.createPrettyPrint();
            // 设置编码格式，默认UTF-8
            format.setEncoding("UTF-8");
            // 创建输出流，此处要使用Writer，需要指定输入编码格式，使用OutputStream则不用
            FileOutputStream fos = new FileOutputStream(file);
            // 创建xml输出流
            XMLWriter writer = new XMLWriter(fos, format);
            // 生成xml文件
            writer.write(document);
            writer.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void addApplication() throws IOException {
        File file = new File(PATH + "..\\resources\\application.yml");

        StringBuffer content = new StringBuffer();
        content.append("spring:\n")
                .append("\tprofiles:\n")
                .append("\t\tactive: dev");
        FileWriter baseFileWritter = new FileWriter(file.getAbsoluteFile());
        BufferedWriter bw = new BufferedWriter(baseFileWritter);
        bw.write(content.toString());
        bw.close();
    }


    private static void addDependency(Element element, String groupId, String artifactId, String version) {
        Element dependency = element.addElement("dependency");
        Element groupIdElement = dependency.addElement("groupId");
        groupIdElement.setText(groupId);
        Element artifactIdElement = dependency.addElement("artifactId");
        artifactIdElement.setText(artifactId);
        if (null != version) {
            Element versionElement = dependency.addElement("version");
            versionElement.setText(version);
        }


    }

    private static void addDependencyWithScope(Element element, String groupId, String artifactId, String scope) {
        Element dependency = element.addElement("dependency");
        Element groupIdElement = dependency.addElement("groupId");
        groupIdElement.setText(groupId);
        Element artifactIdElement = dependency.addElement("artifactId");
        artifactIdElement.setText(artifactId);
        if (null != scope) {
            Element scopeElement = dependency.addElement("scope");
            scopeElement.setText(scope);
        }
    }


}
