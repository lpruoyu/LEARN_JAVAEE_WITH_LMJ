package programmer.lp.jk.service;

import com.baomidou.mybatisplus.extension.service.IService;
import programmer.lp.jk.pojo.po.SysRoleResource;

public interface SysRoleResourceService extends IService<SysRoleResource> {
    boolean removeByRoleId(Short id);
}
