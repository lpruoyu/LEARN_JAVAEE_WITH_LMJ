package programmer.lp.view;

import org.springframework.web.servlet.view.InternalResourceView;

import java.io.File;
import java.util.Locale;

public class MyView extends InternalResourceView {
    // 根据实际情况来返回
    // 存在：返回true
    // 不存在：返回false
    @Override
    public boolean checkResource(Locale locale) throws Exception {
        // 拿到打包部署项目之后的真实路径
        String path = getServletContext().getRealPath(getUrl());
//        String path = getServletContext().getRealPath("/") + getUrl();
        File file = new File(path);
        return file.exists();
    }
}
