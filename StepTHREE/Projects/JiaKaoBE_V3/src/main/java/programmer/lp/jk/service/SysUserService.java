package programmer.lp.jk.service;

import com.baomidou.mybatisplus.extension.service.IService;
import programmer.lp.jk.pojo.po.SysUser;
import programmer.lp.jk.pojo.vo.req.ReqLogin;
import programmer.lp.jk.pojo.vo.req.page.ReqPageSysUser;
import programmer.lp.jk.pojo.vo.req.save.ReqSaveSysUser;
import programmer.lp.jk.pojo.vo.resp.RespLogin;
import programmer.lp.jk.pojo.vo.resp.RespSysUser;
import programmer.lp.jk.pojo.vo.resp.json.JSONPageResult;

public interface SysUserService extends IService<SysUser> {
    JSONPageResult<RespSysUser> list(ReqPageSysUser reqPage);
    boolean saveOrUpdate(ReqSaveSysUser entity);
    RespLogin login(ReqLogin reqVo);
}

