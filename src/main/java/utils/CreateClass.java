package utils;

import java.util.List;

/**
 * @author Wenbo
 * @date 2020/2/4 19:03
 * @Email 969****15@qq.com
 * @phone 176****7037
 */
public class CreateClass extends JavaFactory {
    @Override
    public void classTitleCreate(String className, List<String> annotationList, String implementsClassName, String... baseClassName) {
        for (String annotation : annotationList) {
            javaString.append(annotation + "\n");
        }
        javaString.append("public class " + className);
        if (null != baseClassName && baseClassName.length>0) {
            javaString.append(" extends " + baseClassName);
        }
        if (null != implementsClassName && !"".equals(implementsClassName)) {
            javaString.append(" implements " + implementsClassName);
        }
        javaString.append(" {\n");
    }
}
