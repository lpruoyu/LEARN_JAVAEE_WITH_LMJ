package programmer.lp.configuration;

import org.springframework.web.filter.CharacterEncodingFilter;
import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

import javax.servlet.FilterRegistration;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;

public class WebAppInitializer extends AbstractAnnotationConfigDispatcherServletInitializer {
    /**
     * 父容器的配置类
     */
    @Override
    protected Class<?>[] getRootConfigClasses() {
        return new Class[]{SpringConfiguration.class};
    }

    /**
     * 子容器的配置类(SpringMVC的配置类)
     */
    @Override
    protected Class<?>[] getServletConfigClasses() {
        return new Class[]{SpringMVCConfiguration.class};
    }

    /**
     * 配置DispatcherServlet的 url-pattern
     */
    @Override
    protected String[] getServletMappings() {
        return new String[]{"/"};
    }

    @Override
    public void onStartup(ServletContext servletContext) throws ServletException {
        super.onStartup(servletContext);
        // 添加Filter
        // 方式一：
        // FilterRegistration.Dynamic encodingFilter =
        //         servletContext.addFilter("CharacterEncodingFilter", new CharacterEncodingFilter("UTF-8"));
        // encodingFilter.addMappingForUrlPatterns(null, false, "/*");
        // 方式二：
        FilterRegistration.Dynamic encodingFilter =
                servletContext.addFilter("CharacterEncodingFilter", CharacterEncodingFilter.class);
        encodingFilter.setInitParameter("encoding", "UTF-8");
        encodingFilter.addMappingForUrlPatterns(null, false, "/*");
    }

}
