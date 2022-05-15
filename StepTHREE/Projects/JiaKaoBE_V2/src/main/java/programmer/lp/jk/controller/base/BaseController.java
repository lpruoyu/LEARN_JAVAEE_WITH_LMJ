package programmer.lp.jk.controller.base;

import com.baomidou.mybatisplus.extension.service.IService;
import org.springframework.web.bind.annotation.PostMapping;
import programmer.lp.jk.exception.CommonException;
import programmer.lp.jk.pojo.result.CodeMsg;
import programmer.lp.jk.pojo.result.R;
import programmer.lp.jk.util.Rs;

import java.util.Arrays;

public abstract class BaseController<T> {
    protected abstract IService<T> service();

    @PostMapping("/remove")
    public R remove(String id) {
        final String[] ids = id.split(",");
        if (!service().removeByIds(Arrays.asList(ids))) {
            throw new CommonException(CodeMsg.REMOVE_ERROR);
        }
        return Rs.success(CodeMsg.REMOVE_OK.getMsg());
    }

    @PostMapping("/save")
    public R save(T entity) {
        if (!service().saveOrUpdate(entity)) {
            throw new CommonException(CodeMsg.SAVE_ERROR);
        }
        return Rs.success(CodeMsg.SAVE_OK.getMsg());
    }
}
