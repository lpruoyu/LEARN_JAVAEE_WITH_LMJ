package programmer.lp.jk.controller;

import com.baomidou.mybatisplus.extension.service.IService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import programmer.lp.jk.controller.base.BaseController;
import programmer.lp.jk.mapstruct.MapStruct;
import programmer.lp.jk.pojo.po.DictItem;
import programmer.lp.jk.pojo.vo.req.page.ReqPageDictItem;
import programmer.lp.jk.pojo.vo.req.save.ReqSaveDictItem;
import programmer.lp.jk.pojo.vo.resp.RespDictItem;
import programmer.lp.jk.pojo.vo.resp.json.JSONPageResult;
import programmer.lp.jk.service.DictItemService;

import java.util.function.Function;

@RestController
@RequestMapping("/dictItems")
@Api(tags = "数据字典条目", description = "DictItem")
public class DictItemController extends BaseController<DictItem, ReqSaveDictItem> {
    @Autowired
    private DictItemService service;

    @GetMapping
    @ApiOperation("分页查询")
    public JSONPageResult<RespDictItem> list(ReqPageDictItem reqPageDictItem) {
        return service.list(reqPageDictItem);
    }

    @Override
    protected IService<DictItem> service() {
        return service;
    }

    @Override
    protected Function<ReqSaveDictItem, DictItem> function() {
        return MapStruct.INSTANCE::vo2po;
    }
}
