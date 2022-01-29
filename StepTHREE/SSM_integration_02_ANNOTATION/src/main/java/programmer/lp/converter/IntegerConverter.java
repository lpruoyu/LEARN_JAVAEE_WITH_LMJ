package programmer.lp.converter;

import org.springframework.core.convert.converter.Converter;

public class IntegerConverter implements Converter<String, Integer> {
    @Override
    public Integer convert(String source) {
        return Integer.parseInt(source) + 10;
    }
}
