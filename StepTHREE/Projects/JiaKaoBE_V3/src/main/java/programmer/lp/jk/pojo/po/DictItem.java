package programmer.lp.jk.pojo.po;

import lombok.Data;
import programmer.lp.jk.foreign.anno.ForeignField;

@Data
public class DictItem {
    //主键
    private Integer id;
    //名称
    private String name;
    //值
    private String value;
    //数据类型id
    @ForeignField(DictType.class)
    private Integer typeId;
    //排序序号：默认为0，值越大，越优先排列展示
    private Integer sn;
    //是否禁用：0，不禁用（启用）；1，禁用；默认为0
    private Short disabled;
}