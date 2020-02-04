package utils;

/**
 * @author Wenbo
 * @date 2020/2/4 18:38
 * @Email 969****15@qq.com
 * @phone 176****7037
 */
public class SimpleFunction extends FunctionFactory {
    @Override
    public String getClassTitle() {
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append("public ")
                .append(returnType + " ")
                .append("( ");
        for (int i = 0;i<paramTypes.size();i++) {
            stringBuffer.append(paramTypes + " " + paramTypes );
            if(i<paramTypes.size()-1){
                stringBuffer.append(" , ");
            }
        }
        stringBuffer.append("){");
        return stringBuffer.toString();
    }
}
