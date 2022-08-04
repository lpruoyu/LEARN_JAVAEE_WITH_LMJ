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
import programmer.lp.jk.pojo.po.SysResource;
import programmer.lp.jk.pojo.vo.req.page.ReqPageSysResource;
import programmer.lp.jk.pojo.vo.req.save.ReqSaveSysResource;
import programmer.lp.jk.pojo.vo.resp.RespSysResource;
import programmer.lp.jk.pojo.vo.resp.RespSysResourceTree;
import programmer.lp.jk.pojo.vo.resp.json.JSONDataResult;
import programmer.lp.jk.pojo.vo.resp.json.JSONPageResult;
import programmer.lp.jk.pojo.vo.resp.json.JSONResult;
import programmer.lp.jk.service.SysResourceService;

import javax.validation.Valid;
import java.util.List;
import java.util.function.Function;

@RestController
@RequestMapping("/sysResources")
@Api(tags = "系统资源/权限", description = "SysResource")
public class SysResourceController extends BaseController<SysResource, ReqSaveSysResource> {
    @Autowired
    private SysResourceService service;

    @GetMapping
    @ApiOperation("分页查询")
    @RequiresPermissions(Constants.Permisson.SYS_RESOURCE_LIST)
    public JSONPageResult<RespSysResource> list(@Valid ReqPageSysResource reqVo) {
        return service.list(reqVo);
    }

    @GetMapping("/list")
    @ApiOperation("查询出所有的资源信息")
    @RequiresPermissions(Constants.Permisson.SYS_RESOURCE_LIST)
    public JSONDataResult<List<RespSysResource>> listAll() {
        return JSONResults.ok(service.listAll());
    }

    @GetMapping("/listParents")
    @ApiOperation("查询所有的父资源（目录、菜单）")
    @RequiresPermissions(Constants.Permisson.SYS_RESOURCE_LIST)
    public JSONDataResult<List<RespSysResource>> listParents() {
        return JSONResults.ok(service.listParents());
    }

    @GetMapping("/listTree")
    @ApiOperation("查询所有（树状结构结构展示）")
    @RequiresPermissions(Constants.Permisson.SYS_RESOURCE_LIST)
    public JSONDataResult<List<RespSysResourceTree>> listTree() {
        return JSONResults.ok(service.listTree());
    }

    @GetMapping("/ids")
    @ApiOperation("根据角色id获取资源id")
    @RequiresPermissions(Constants.Permisson.SYS_RESOURCE_LIST)
    public JSONDataResult<List<Short>> ids(Integer roleId) {
        return JSONResults.ok(service.listIds(roleId));
    }

    @Override
    @RequiresPermissions(value = {
            Constants.Permisson.SYS_RESOURCE_ADD,
            Constants.Permisson.SYS_RESOURCE_UPDATE
    }, logical = Logical.AND)
    public JSONResult save(ReqSaveSysResource entity) {
        return super.save(entity);
    }

    @Override
    @RequiresPermissions(Constants.Permisson.SYS_RESOURCE_REMOVE)
    public JSONResult remove(String id) {
        return super.remove(id);
    }

    @Override
    protected IService<SysResource> service() {
        return service;
    }

    @Override
    protected Function<ReqSaveSysResource, SysResource> function() {
        return MapStruct.INSTANCE::vo2po;
    }
}

