package programmer.lp.jk.pojo.po;

import lombok.Data;
import programmer.lp.jk.common.foreign.anno.ForeignField;

@Data
public class SysResource {
    //主键
    private Short id;
    //名称
    private String name;
    //链接地址
    private String uri;
    //权限标识
    private String permission;
    //资源类型（0是目录，1是菜单，2是按钮）PS：按钮就是增删改查之类的能点击的
    private Short type;
    //图标
    private String icon;
    //序号
    private Short sn;
    //父资源id
    @ForeignField(SysResource.class)
    private Short parentId;
}

