import utils.CreateClass;
import utils.FunctionFactory;
import utils.JavaFactory;

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
public class ApplicationFactory {

    /**
     * 创建启动类
     *
     * @throws IOException
     */
    public static void createApplication() throws IOException {

        File file = new File(Test.PATH + Test.PACK + "\\" + Test.Application + ".java");

        String name = Test.Application;

        List<String> importList = new ArrayList<>();
        importList.add("org.springframework.boot.SpringApplication");
        importList.add("org.springframework.boot.autoconfigure.SpringBootApplication");

        String packString = "package " + Test.PACK + ";";

        List<String> annotationList = new ArrayList<>();
        annotationList.add("@SpringBootApplication");
        FunctionFactory functionFactory = new FunctionFactory() {
            @Override
            public String getClassTitle() {
                StringBuffer stringBuffer = new StringBuffer();
                stringBuffer.append("public static void main(String[] args) {\n ");
                return stringBuffer.toString();
            }
        };
        StringBuffer content = new StringBuffer();
        content.append("SpringApplication.run(" + Test.Application + ".class, args);\n");
        functionFactory.setContent(content);
        List<FunctionFactory> functionFactories = new ArrayList<>();
        functionFactories.add(functionFactory);
        CreateClass createClass = new CreateClass();
        createClass.classFactory(file,packString,importList,name,annotationList,functionFactories,null,null);
    }


}
