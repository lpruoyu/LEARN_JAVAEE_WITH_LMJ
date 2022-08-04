package programmer.lp.jk.common.enhance;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.toolkit.support.SFunction;

public class MPLambdaQueryWrapper<T> extends LambdaQueryWrapper<T> {
    @SafeVarargs
    public final MPLambdaQueryWrapper<T> like(Object val, SFunction<T, ?>... funcs) {
        if (val == null || funcs == null || funcs.length == 0) return this;
        final String str = val.toString();
        if (str.length() == 0) return this;

        return (MPLambdaQueryWrapper<T>) nested(
                (wrapper) -> {
                    for (SFunction<T, ?> func : funcs) {
                        wrapper.like(func, str).or();
                    }
                }
        );
    }
}
