package programmer.lp.resume;

import org.apache.commons.io.FileUtils;
import programmer.lp.resume.bean.Company;

import java.io.File;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class Main {

    private static final String baseDir = "D:\\code_space\\LearnJava\\IntellijIdea\\LearnJavaEEWithXMGLMJ\\StepTWO\\lp_resume\\src\\main\\java\\programmer\\lp\\resume\\";
    private static final String replacement = "#name#";

    private static final Class[] classes = {
            Company.class
    };

    private static final Map<String, String> maps = new HashMap<>();

    static {
        maps.put("Dao", "dao");
        maps.put("DaoImpl", "dao/impl");
        maps.put("Service", "service");
        maps.put("ServiceImpl", "service/impl");
        maps.put("Servlet", "servlet");
    }

    public static void main(String[] args) {
        try {
            for (Class aClass : classes) {
                final Set<Map.Entry<String, String>> entries = maps.entrySet();
                for (Map.Entry<String, String> entry : entries) {
                    final String key = entry.getKey();
                    final String value = entry.getValue();
                    final String classSimpleName = aClass.getSimpleName();
                    final String tplPath = Main.class.getClassLoader().getResource("tpl/" + key + ".tpl").getFile();
                    final String tplSourceStr = FileUtils.readFileToString(new File(tplPath), "UTF-8");
                    final String tplNewStr = tplSourceStr.replace(replacement, classSimpleName);
                    final String outFileName = classSimpleName + key + ".java";
                    final String outFileDir = baseDir + value;
                    final File finalFile = new File(outFileDir, outFileName);
                    if (!finalFile.exists()) {
                        FileUtils.write(finalFile, tplNewStr);
                    } else {
                        System.out.println(finalFile.getName() + "文件已经存在");
                    }
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}