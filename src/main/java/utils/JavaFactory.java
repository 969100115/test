package utils;

import org.springframework.util.StringUtils;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

/**
 * @author Wenbo
 * @date 2020/2/4 13:16
 * @Email 969****15@qq.com
 * @phone 176****7037
 */
public abstract class JavaFactory {
    static StringBuffer javaString;

    private static void packageCreate(String pack) {
        String packageContent = pack + "\n\n";
        javaString.append(packageContent);
    }

    private static void importCreate(List<String> importList) {
        for (String importString : importList) {
            javaString.append("import " + importString + ";\n");
        }
        javaString.append("\n\n");
    }

    public abstract void classTitleCreate(String className, List<String> annotationList, String implementsClassName, String... baseClassName);


    public File classFactory(File file, String pack, List<String> importList, String className
            , List<String> annotationList, List<FunctionFactory> functions, String implementsClassName, String... baseClassName) throws IOException {
        JavaFactory.javaString = new StringBuffer();

        JavaFactory.packageCreate(pack);
        JavaFactory.importCreate(importList);
        classTitleCreate(className, annotationList, implementsClassName,baseClassName);


        if (null != functions && functions.size()>0) {
            for (FunctionFactory function : functions) {
                JavaFactory.createFunction(function);
            }
        }
        javaString.append("}");

        FileWriter baseFileWriter = new FileWriter(file.getAbsoluteFile());
        BufferedWriter bw = new BufferedWriter(baseFileWriter);
        bw.write(javaString.toString());
        bw.close();
        return file;
    }

    public static void createFunction(FunctionFactory functionFactory) {
        if (functionFactory.annotation.size() > 0) {
            for (String annotation : functionFactory.annotation) {
                javaString.append(annotation + "\n");
            }
        }
        javaString.append(functionFactory.getClassTitle())
                .append(functionFactory.content + "\n")
                .append("    }\n");
    }
}
