package programmer.lp.jk.common.enhance;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;

public class MPQueryWrapper<T> extends QueryWrapper<T> {
    @SafeVarargs
    public final MPQueryWrapper<T> like(Object val, String... columns) {
        if (val == null || columns == null || columns.length == 0) return this;
        final String str = val.toString();
        if (str.length() == 0) return this;

        return (MPQueryWrapper<T>) nested((wrapper) -> {
            for (String column : columns) {
                wrapper.like(column, str).or();
            }
        });
    }
}
