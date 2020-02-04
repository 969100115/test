package utils;


import java.util.ArrayList;
import java.util.List;

/**
 * @author Wenbo
 * @date 2020/2/4 13:21
 * @Email 969****15@qq.com
 * @phone 176****7037
 */
public abstract class FunctionFactory {
    String name;
    List<String> annotation = new ArrayList<>();
    String returnType;
    List<String> paramTypes = new ArrayList<>();
    StringBuffer content = new StringBuffer();

    public abstract String getClassTitle();


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<String> getAnnotation() {
        return annotation;
    }

    public void setAnnotation(List<String> annotation) {
        this.annotation = annotation;
    }

    public String getReturnType() {
        return returnType;
    }

    public void setReturnType(String returnType) {
        this.returnType = returnType;
    }

    public List<String> getParamTypes() {
        return paramTypes;
    }

    public void setParamTypes(List<String> paramTypes) {
        this.paramTypes = paramTypes;
    }

    public StringBuffer getContent() {
        return content;
    }

    public void setContent(StringBuffer content) {
        this.content = content;
    }
}
