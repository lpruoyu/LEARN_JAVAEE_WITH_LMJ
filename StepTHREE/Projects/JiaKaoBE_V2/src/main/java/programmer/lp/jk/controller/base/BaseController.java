package programmer.lp.jk.controller.base;

import com.baomidou.mybatisplus.extension.service.IService;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import programmer.lp.jk.pojo.result.CodeMsg;
import programmer.lp.jk.pojo.result.R;
import programmer.lp.jk.util.Rs;

import javax.validation.Valid;
import javax.validation.constraints.NotBlank;
import java.util.Arrays;

@Validated
public abstract class BaseController<T> {
    protected abstract IService<T> service();

    @GetMapping("/list")
    public R list() {
        return Rs.success(service().list());
    }

    @PostMapping("/remove")
    @ApiOperation("根据id删除记录，多个id使用逗号隔开")
    public R remove(@NotBlank(message = "id不能为空")
                    @ApiParam(name = "id", required = true)
                    @RequestParam
                    String id) {
        final String[] ids = id.split(",");
        if (!service().removeByIds(Arrays.asList(ids))) {
            Rs.exception(CodeMsg.REMOVE_ERROR);
        }
        return Rs.success(CodeMsg.REMOVE_OK);
    }

    @PostMapping("/save")
    @ApiOperation("新增或者更新记录，id为空新增；id不为空保存")
    public R save(@Valid T entity) {
        if (!service().saveOrUpdate(entity)) {
            Rs.exception(CodeMsg.SAVE_ERROR);
        }
        return Rs.success(CodeMsg.SAVE_OK);
    }
}
