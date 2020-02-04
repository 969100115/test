import org.dom4j.Document;
import org.dom4j.DocumentException;
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
 * @date 2020/2/4 13:03
 * @Email 969****15@qq.com
 * @phone 176****7037
 */
public class PomFileFactory {
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
        PomFileFactory.addDependency(dependencies, "tk.mybatis", "mapper", "4.1.5");
        PomFileFactory.addDependency(dependencies, "org.springframework.boot", "spring-boot-starter-jdbc", null);
        PomFileFactory.addDependency(dependencies, "org.springframework.boot", "spring-boot-starter-web", null);
        PomFileFactory.addDependency(dependencies, "org.mybatis.spring.boot", "mybatis-spring-boot-starter", "1.3.2");
        PomFileFactory.addDependencyWithScope(dependencies, "org.springframework.boot", "spring-boot-devtools", "runtime");
        PomFileFactory.addDependency(dependencies, "mysql", "mysql-connector-java", null);
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
