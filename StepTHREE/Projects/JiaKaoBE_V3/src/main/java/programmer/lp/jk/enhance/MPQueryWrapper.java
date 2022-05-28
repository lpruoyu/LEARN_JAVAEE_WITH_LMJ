package programmer.lp.jk.enhance;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.toolkit.support.SFunction;

public class MPQueryWrapper<T> extends LambdaQueryWrapper<T> {
    @SafeVarargs
    public final MPQueryWrapper<T> like(Object val, SFunction<T, ?>... funcs) {
        if (val == null || funcs == null || funcs.length == 0) return this;
        final String str = val.toString();
        if (str.length() == 0) return this;

        return (MPQueryWrapper<T>) nested((wrapper) -> {
            for (SFunction<T, ?> func : funcs) {
                wrapper.like(func, str).or();
            }
        });
    }
}
