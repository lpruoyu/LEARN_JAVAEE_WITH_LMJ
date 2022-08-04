package programmer.lp.jk.pojo.po;

import lombok.Data;
import programmer.lp.jk.common.foreign.anno.ForeignField;

@Data
public class SysRoleResource {
    //角色id
    @ForeignField(SysRole.class)
    private Short roleId;
    //资源id
    @ForeignField(SysResource.class)
    private Short resourceId;
}