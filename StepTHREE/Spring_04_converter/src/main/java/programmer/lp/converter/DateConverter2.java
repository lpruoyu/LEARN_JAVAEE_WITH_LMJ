package programmer.lp.converter;

import org.springframework.core.convert.converter.Converter;

import java.text.SimpleDateFormat;
import java.util.Date;

public class DateConverter2 implements Converter<String, Date> {
    private String format;
    public void setFormat(String format) {
        this.format = format;
    }
    @Override
    public Date convert(String dateStr) {
        try {
            return new SimpleDateFormat(format).parse(dateStr);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
}
