package utils;


import java.util.List;

/**
 * @author Wenbo
 * @date 2020/2/4 19:07
 * @Email 969****15@qq.com
 * @phone 176****7037
 */
public class CreateInterface extends JavaFactory {
    @Override
    public void classTitleCreate(String className, List<String> annotationList, String implementsClassName, String... baseClassName) {
       if(null!=annotationList&&annotationList.size()>0){
           for (String annotation : annotationList) {
               javaString.append(annotation + "\n");
           }
       }
        javaString.append("public interface " + className);
        if (null != baseClassName && baseClassName.length>0) {
            javaString.append(" extends ");
            for (int i = 0;i<baseClassName.length;i++) {
                javaString.append(baseClassName[i]);
                if(i<baseClassName.length-1){
                    javaString.append(",");
                }
            }
        }
        if (null != implementsClassName && !"".equals(implementsClassName)) {
            javaString.append(" implements " + implementsClassName);
        }
        javaString.append(" {\n");
    }
}
