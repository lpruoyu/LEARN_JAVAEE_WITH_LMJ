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
import programmer.lp.jk.common.enhance.CodeMsg;
import programmer.lp.jk.common.mapstruct.MapStruct;
import programmer.lp.jk.common.util.Constants;
import programmer.lp.jk.common.util.JSONResults;
import programmer.lp.jk.common.util.Streams;
import programmer.lp.jk.pojo.po.SysRole;
import programmer.lp.jk.pojo.vo.req.page.ReqPageSysRole;
import programmer.lp.jk.pojo.vo.req.save.ReqSaveSysRole;
import programmer.lp.jk.pojo.vo.resp.RespSysRole;
import programmer.lp.jk.pojo.vo.resp.json.JSONDataResult;
import programmer.lp.jk.pojo.vo.resp.json.JSONPageResult;
import programmer.lp.jk.pojo.vo.resp.json.JSONResult;
import programmer.lp.jk.service.SysRoleService;

import javax.validation.Valid;
import java.util.List;
import java.util.function.Function;

@RestController
@RequestMapping("/sysRoles")
@Api(tags = "系统角色", description = "SysRole")
public class SysRoleController extends BaseController<SysRole, ReqSaveSysRole> {
    @Autowired
    private SysRoleService service;

    @GetMapping("/ids")
    @ApiOperation("根据用户id获取角色id")
    @RequiresPermissions(Constants.Permisson.SYS_ROLE_LIST)
    public JSONDataResult<List<Short>> ids(Integer userId) {
        return JSONResults.ok(service.listIds(userId));
    }

    @GetMapping("/list")
    @ApiOperation("查询所有记录")
    @RequiresPermissions(Constants.Permisson.SYS_ROLE_LIST)
    public JSONDataResult<List<RespSysRole>> list() {
//        final List<RespSysRole> data = service.list()
//                .stream().map(MapStruct.INSTANCE::po2vo)
//                .collect(Collectors.toList());
        return JSONResults.ok(Streams.map(service.list(), MapStruct.INSTANCE::po2vo));
    }

    @GetMapping
    @ApiOperation("分页查询")
    @RequiresPermissions(Constants.Permisson.SYS_ROLE_LIST)
    public JSONPageResult<RespSysRole> list(@Valid ReqPageSysRole reqPage) {
        return service.list(reqPage);
    }

    @Override
    @RequiresPermissions(value = {
            Constants.Permisson.SYS_ROLE_ADD,
            Constants.Permisson.SYS_ROLE_UPDATE
    }, logical = Logical.AND)
    public JSONResult save(ReqSaveSysRole entity) {
        if (service.saveOrUpdate(entity)) {
            return JSONResults.ok(CodeMsg.SAVE_OK);
        }
        return JSONResults.exception(CodeMsg.SAVE_ERROR);
    }

    @Override
    @RequiresPermissions(Constants.Permisson.SYS_ROLE_REMOVE)
    public JSONResult remove(String id) {
        return super.remove(id);
    }

    @Override
    protected IService<SysRole> service() {
        return service;
    }

    @Override
    protected Function<ReqSaveSysRole, SysRole> function() {
        return MapStruct.INSTANCE::vo2po;
    }
}

