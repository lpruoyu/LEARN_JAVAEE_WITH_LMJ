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
import programmer.lp.jk.common.util.JSONResults;
import programmer.lp.jk.pojo.po.DictType;
import programmer.lp.jk.pojo.vo.req.page.ReqPageDictType;
import programmer.lp.jk.pojo.vo.req.save.ReqSaveDictType;
import programmer.lp.jk.pojo.vo.resp.RespDictType;
import programmer.lp.jk.pojo.vo.resp.json.JSONDataResult;
import programmer.lp.jk.pojo.vo.resp.json.JSONPageResult;
import programmer.lp.jk.pojo.vo.resp.json.JSONResult;
import programmer.lp.jk.service.DictTypeService;

import javax.validation.Valid;
import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/dictTypes")
@Api(tags = "数据字典类型", description = "DictType")
public class DictTypeController extends BaseController<DictType, ReqSaveDictType> {
    @Autowired
    private DictTypeService service;

    @GetMapping("/list")
    @ApiOperation("查询所有记录")
    @RequiresPermissions(Constants.Permisson.DICT_TYPE_LIST)
    public JSONDataResult<List<RespDictType>> list() {
        final List<RespDictType> data = service.list()
                .stream().map(MapStruct.INSTANCE::po2vo)
                .collect(Collectors.toList());
        return JSONResults.ok(data);
    }

    @GetMapping
    @ApiOperation("分页查询")
    @RequiresPermissions(Constants.Permisson.DICT_TYPE_LIST)
    public JSONPageResult<RespDictType> list(@Valid ReqPageDictType reqPage) {
        return service.list(reqPage);
    }

    @Override
    @RequiresPermissions(value = {
            Constants.Permisson.DICT_TYPE_ADD,
            Constants.Permisson.DICT_TYPE_UPDATE
    }, logical = Logical.AND)
    public JSONResult save(ReqSaveDictType entity) {
        return super.save(entity);
    }

    @Override
    @RequiresPermissions(Constants.Permisson.DICT_TYPE_REMOVE)
    public JSONResult remove(String id) {
        return super.remove(id);
    }

    @Override
    protected IService<DictType> service() {
        return service;
    }

    @Override
    protected Function<ReqSaveDictType, DictType> function() {
        return MapStruct.INSTANCE::vo2po;
    }
}

