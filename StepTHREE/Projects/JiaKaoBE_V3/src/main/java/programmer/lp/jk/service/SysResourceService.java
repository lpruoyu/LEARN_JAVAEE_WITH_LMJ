package programmer.lp.jk.service;

import com.baomidou.mybatisplus.extension.service.IService;
import programmer.lp.jk.pojo.po.SysResource;
import programmer.lp.jk.pojo.vo.req.page.ReqPageSysResource;
import programmer.lp.jk.pojo.vo.resp.RespSysResource;
import programmer.lp.jk.pojo.vo.resp.RespSysResourceTree;
import programmer.lp.jk.pojo.vo.resp.json.JSONPageResult;

import java.util.List;

public interface SysResourceService extends IService<SysResource> {
    JSONPageResult<RespSysResource> list(ReqPageSysResource reqVo);
    List<RespSysResource> listAll();
    List<RespSysResource> listParents();
    List<RespSysResourceTree> listTree();
    List<Short> listIds(Integer roleId);
    List<SysResource> listByRoleIds(List<Short> roleIds);
}

