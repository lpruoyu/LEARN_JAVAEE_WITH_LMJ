package programmer.lp.fm;

import freemarker.template.Configuration;
import freemarker.template.Template;

import java.io.File;
import java.io.FileWriter;
import java.util.HashMap;
import java.util.Map;

public class Main {
    public static void main(String[] args) throws Exception {
        final String basePath = "D:/code_space/LearnJava/IntellijIdea/LearnJavaEEWithXMGLMJ/StepTHREE/SpringBoot-Freemarker/";
        Configuration cfg = new Configuration(Configuration.VERSION_2_3_23);
        cfg.setDefaultEncoding("UTF-8");
        cfg.setDirectoryForTemplateLoading(new File(basePath + "templates"));
        Template tpl = cfg.getTemplate("mapper.ftl");
        Map<String, Object> data = new HashMap<>();
        data.put("name", "lp");
        data.put("age", 10);
        try (FileWriter out = new FileWriter(new File(basePath + "src/main/resources/static/index.html"))) {
            tpl.process(data, out);
        }
    }

    public static void mainMapper(String[] args) throws Exception {
        final String basePath = "D:/code_space/LearnJava/IntellijIdea/LearnJavaEEWithXMGLMJ/StepTHREE/SpringBoot-Freemarker/";

        Configuration cfg = new Configuration(Configuration.VERSION_2_3_23);
        // 设置编码
        cfg.setDefaultEncoding("UTF-8");
        // 模板文件的存放目录
        cfg.setDirectoryForTemplateLoading(new File(basePath + "templates"));

        // 获取模板文件
        Template tpl = cfg.getTemplate("mapper.ftl");

        // 数据
        Map<String, Object> data = new HashMap<>();
        final String className = "DictItem";
        data.put("type", className);

        try (FileWriter out = new FileWriter(new File(basePath + "src/main/java/programmer/lp/fm/mapper/" + className + "Mapper.java"))) {
            tpl.process(data, out);
        }
    }
}
