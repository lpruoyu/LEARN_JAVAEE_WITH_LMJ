package programmer.lp.jk.pojo.dto;

import lombok.Data;
import programmer.lp.jk.pojo.po.SysResource;
import programmer.lp.jk.pojo.po.SysRole;
import programmer.lp.jk.pojo.po.SysUser;

import java.util.List;

@Data
public class SysUserDto {
    private SysUser user;
    private List<SysRole> roles;
    private List<SysResource> resources;
}
