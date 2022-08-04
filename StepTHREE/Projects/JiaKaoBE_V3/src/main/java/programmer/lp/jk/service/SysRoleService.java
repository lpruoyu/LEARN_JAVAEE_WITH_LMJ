package programmer.lp.jk.service;

import com.baomidou.mybatisplus.extension.service.IService;
import programmer.lp.jk.pojo.po.SysRole;
import programmer.lp.jk.pojo.vo.req.page.ReqPageSysRole;
import programmer.lp.jk.pojo.vo.req.save.ReqSaveSysRole;
import programmer.lp.jk.pojo.vo.resp.RespSysRole;
import programmer.lp.jk.pojo.vo.resp.json.JSONPageResult;

import java.util.List;

public interface SysRoleService extends IService<SysRole> {
    JSONPageResult<RespSysRole> list(ReqPageSysRole reqPage);
    List<Short> listIds(Integer userId);
    boolean saveOrUpdate(ReqSaveSysRole entity);
    List<SysRole> listByUserId(Integer id);
}

