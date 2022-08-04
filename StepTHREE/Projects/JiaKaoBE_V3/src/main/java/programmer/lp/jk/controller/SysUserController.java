package programmer.lp.jk.controller;

import com.baomidou.mybatisplus.extension.service.IService;
import com.wf.captcha.utils.CaptchaUtil;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.apache.shiro.authz.annotation.Logical;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import programmer.lp.jk.common.cache.Caches;
import programmer.lp.jk.common.enhance.CodeMsg;
import programmer.lp.jk.common.mapstruct.MapStruct;
import programmer.lp.jk.common.shiro.TokenFilter;
import programmer.lp.jk.common.util.Constants;
import programmer.lp.jk.common.util.JSONResults;
import programmer.lp.jk.pojo.po.SysUser;
import programmer.lp.jk.pojo.vo.req.ReqLogin;
import programmer.lp.jk.pojo.vo.req.page.ReqPageSysUser;
import programmer.lp.jk.pojo.vo.req.save.ReqSaveSysUser;
import programmer.lp.jk.pojo.vo.resp.RespLogin;
import programmer.lp.jk.pojo.vo.resp.RespSysUser;
import programmer.lp.jk.pojo.vo.resp.json.JSONDataResult;
import programmer.lp.jk.pojo.vo.resp.json.JSONPageResult;
import programmer.lp.jk.pojo.vo.resp.json.JSONResult;
import programmer.lp.jk.service.SysUserService;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;
import java.util.function.Function;

@RestController
@RequestMapping("/sysUsers")
@Api(tags = "系统用户", description = "SysUser")
public class SysUserController extends BaseController<SysUser, ReqSaveSysUser> {
    @Autowired
    private SysUserService service;

    @GetMapping
    @ApiOperation("分页查询")
    @RequiresPermissions(Constants.Permisson.SYS_USER_LIST)
    public JSONPageResult<RespSysUser> list(@Valid ReqPageSysUser reqPage) {
        return service.list(reqPage);
    }

    @GetMapping("/captcha")
    @ApiOperation("生成验证码")
    public void captcha(HttpServletRequest request,
                        HttpServletResponse response) throws Exception {
        CaptchaUtil.out(request, response);
    }

    @PostMapping("/logout")
    @ApiOperation("退出登录")
    public JSONResult logout(@RequestHeader(TokenFilter.HEADER_TOKEN) String token) {
        Caches.removeToken(token);
//        Caches.remove(id);
        return JSONResults.ok(CodeMsg.LOGOUT_OK);
    }

    @PostMapping("/login")
    @ApiOperation("登录")
    public JSONDataResult<RespLogin> login(ReqLogin reqVo, HttpServletRequest request) {
        if (CaptchaUtil.ver(reqVo.getCaptcha(), request)) {
            return JSONResults.ok(service.login(reqVo));
        }
        return JSONResults.exception(CodeMsg.WRONG_CAPTCHA);
    }

    @Override
    @RequiresPermissions(value = {
            Constants.Permisson.SYS_USER_ADD,
            Constants.Permisson.SYS_USER_UPDATE
    }, logical = Logical.AND)
    public JSONResult save(ReqSaveSysUser entity) {
        if (service.saveOrUpdate(entity)) {
            return JSONResults.ok(CodeMsg.SAVE_OK);
        }
        return JSONResults.exception(CodeMsg.SAVE_ERROR);
    }

    @Override
    @RequiresPermissions(Constants.Permisson.SYS_USER_REMOVE)
    public JSONResult remove(String id) {
        return super.remove(id);
    }

    @Override
    protected IService<SysUser> service() {
        return service;
    }

    @Override
    protected Function<ReqSaveSysUser, SysUser> function() {
        return MapStruct.INSTANCE::vo2po;
    }
}
