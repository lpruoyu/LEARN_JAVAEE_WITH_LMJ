package programmer.lp.converter;

import org.springframework.core.convert.converter.Converter;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Set;

public class DateConverter implements Converter<String, Date> {
    private Set<String> formats;
    public void setFormats(Set<String> formats) {
        this.formats = formats;
    }
    @Override
    public Date convert(String dateStr) {
        if (null == formats || formats.isEmpty()) return null;
        for (String format : formats) {
            try {
                return new SimpleDateFormat(format).parse(dateStr);
            } catch (Exception e) {
                System.out.println("不支持：<" + format + ">格式！");
            }
        }
        return null;
    }
}