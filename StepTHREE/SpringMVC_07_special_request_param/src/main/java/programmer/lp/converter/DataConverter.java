package programmer.lp.converter;

import org.springframework.core.convert.converter.Converter;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Set;

public class DataConverter implements Converter<String, Date> {
    private Set<String> patterns;

    public void setPatterns(Set<String> patterns) {
        this.patterns = patterns;
    }

    @Override
    public Date convert(String source) {
        if (null == patterns || patterns.size() == 0) return null;
        for (String pattern : patterns) {
            try {
                return new SimpleDateFormat(pattern).parse(source);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return null;
    }
}
