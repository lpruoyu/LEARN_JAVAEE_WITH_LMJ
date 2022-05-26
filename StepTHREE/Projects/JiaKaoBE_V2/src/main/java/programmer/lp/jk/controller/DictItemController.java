package programmer.lp.jk.controller;

import com.baomidou.mybatisplus.extension.service.IService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import programmer.lp.jk.controller.base.BaseController;
import programmer.lp.jk.pojo.po.DictItem;
import programmer.lp.jk.pojo.query.DictItemQuery;
import programmer.lp.jk.pojo.result.R;
import programmer.lp.jk.pojo.result.SwaggerErrorR;
import programmer.lp.jk.pojo.result.SwaggerR;
import programmer.lp.jk.service.DictItemService;
import programmer.lp.jk.util.Rs;

@RestController
@RequestMapping("/dictItems")
@Api(tags = "数据字典条目", description = "增删改查")
public class DictItemController extends BaseController<DictItem> {
    @Autowired
    private DictItemService service;

    @GetMapping
    @ApiOperation("分页查询")
    @ApiResponses({
            @ApiResponse(code = 200, message = "请求成功，code为0", response = SwaggerR.class),
            @ApiResponse(code = 400, message = "出现错误，code非0", response = SwaggerErrorR.class)
    })
    public R list(DictItemQuery query) {
        service.list(query);
        return Rs.success(query).add(Rs.K_COUNT, query.getTotal());
    }

    @Override
    protected IService<DictItem> service() {
        return service;
    }
}

