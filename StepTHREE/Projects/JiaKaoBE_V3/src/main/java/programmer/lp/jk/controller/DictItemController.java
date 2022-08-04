package programmer.lp.jk.controller;

import com.baomidou.mybatisplus.extension.service.IService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.apache.shiro.authz.annotation.Logical;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import programmer.lp.jk.common.mapstruct.MapStruct;
import programmer.lp.jk.common.util.Constants;
import programmer.lp.jk.pojo.po.DictItem;
import programmer.lp.jk.pojo.vo.req.page.ReqPageDictItem;
import programmer.lp.jk.pojo.vo.req.save.ReqSaveDictItem;
import programmer.lp.jk.pojo.vo.resp.RespDictItem;
import programmer.lp.jk.pojo.vo.resp.json.JSONPageResult;
import programmer.lp.jk.pojo.vo.resp.json.JSONResult;
import programmer.lp.jk.service.DictItemService;

import javax.validation.Valid;
import java.util.function.Function;

@RestController
@RequestMapping("/dictItems")
@Api(tags = "数据字典条目", description = "DictItem")
public class DictItemController extends BaseController<DictItem, ReqSaveDictItem> {
    @Autowired
    private DictItemService service;

    @GetMapping
    @ApiOperation("分页查询")
    @RequiresPermissions(Constants.Permisson.DICT_ITEM_LIST)
    public JSONPageResult<RespDictItem> list(@Valid ReqPageDictItem reqPageDictItem) {
        return service.list(reqPageDictItem);
    }

    @Override
    @RequiresPermissions(value = {
            Constants.Permisson.DICT_ITEM_ADD,
            Constants.Permisson.DICT_ITEM_UPDATE
    }, logical = Logical.AND)
    public JSONResult save(ReqSaveDictItem entity) {
        return super.save(entity);
    }

    @Override
    @RequiresPermissions(Constants.Permisson.DICT_ITEM_REMOVE)
    public JSONResult remove(String id) {
        return super.remove(id);
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
