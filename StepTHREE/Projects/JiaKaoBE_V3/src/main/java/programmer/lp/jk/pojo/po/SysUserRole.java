package programmer.lp.jk.pojo.po;

import lombok.Data;
import programmer.lp.jk.common.foreign.anno.ForeignField;

@Data
public class SysUserRole {
    //角色id
    @ForeignField(SysRole.class)
    private Short roleId;
    //用户id
    @ForeignField(SysUser.class)
    private Integer userId;
}