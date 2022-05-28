package programmer.lp.jk.controller.base;

import com.baomidou.mybatisplus.extension.service.IService;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import programmer.lp.jk.pojo.vo.resp.json.JSONResult;
import programmer.lp.jk.util.CodeMsg;
import programmer.lp.jk.util.JSONResults;

import javax.validation.Valid;
import javax.validation.constraints.NotBlank;
import java.util.Arrays;
import java.util.function.Function;

@Validated
public abstract class BaseController<T, ReqSave> {
    protected abstract IService<T> service();
    protected abstract Function<ReqSave, T> function();

    @PostMapping("/remove")
    @ApiOperation("根据id删除一条或多条记录，多个id使用逗号隔开")
    public JSONResult remove(@RequestParam @ApiParam(required = true) @NotBlank(message = "id不能为空") String id) {
        final String[] ids = id.split(",");
        if (!service().removeByIds(Arrays.asList(ids))) {
            JSONResults.exception(CodeMsg.REMOVE_ERROR);
        }
        return JSONResults.success(CodeMsg.REMOVE_OK);
    }

    @PostMapping("/save")
    @ApiOperation("添加或更新记录：id为空，插入记录；id不为空，更新纪录")
    public JSONResult save(@Valid ReqSave entity) {
        if (!service().saveOrUpdate(function().apply(entity))) {
            JSONResults.exception(CodeMsg.SAVE_ERROR);
        }
        return JSONResults.success(CodeMsg.SAVE_OK);
    }
}
