package programmer.lp.initializer;

import org.springframework.web.filter.CharacterEncodingFilter;
import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;
import programmer.lp.configuration.DaoConfiguration;
import programmer.lp.configuration.ServiceConfiguration;
import programmer.lp.configuration.WebConfiguration;

import javax.servlet.FilterRegistration;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;

public class ApplicationInitializer extends AbstractAnnotationConfigDispatcherServletInitializer {
    /**
     * 父容器的配置类
     */
    @Override
    protected Class<?>[] getRootConfigClasses() {
        return new Class[]{DaoConfiguration.class, ServiceConfiguration.class};
    }

    /**
     * 子容器的配置类(SpringMVC的配置类)
     */
    @Override
    protected Class<?>[] getServletConfigClasses() {
        return new Class[]{WebConfiguration.class};
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
        FilterRegistration.Dynamic encodingFilter =
                servletContext.addFilter("CharacterEncodingFilter", CharacterEncodingFilter.class);
        encodingFilter.setInitParameter("encoding", "UTF-8");
        encodingFilter.addMappingForUrlPatterns(null, false, "/*");
    }
}