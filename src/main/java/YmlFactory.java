import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

/**
 * @author Wenbo
 * @date 2020/2/4 13:09
 * @Email 969****15@qq.com
 * @phone 176****7037
 */
public class YmlFactory {
    private void addApplication() throws IOException {
        File file = new File(Test.PATH + "..\\resources\\application.yml");

        StringBuffer content = new StringBuffer();
        content.append("spring:\n")
                .append("\tprofiles:\n")
                .append("\t\tactive: dev");
        FileWriter baseFileWritter = new FileWriter(file.getAbsoluteFile());
        BufferedWriter bw = new BufferedWriter(baseFileWritter);
        bw.write(content.toString());
        bw.close();
    }
}
