package programmer.lp.jk.pojo.po;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class DictItem {
    //主键
    private Integer id;
    //名称
    private String name;
    //值
    private String value;
    //类型id
    private Integer typeId;
    //排序序号：默认为0，值越大，越优先排列展示
    private Integer sn;
    //是否启用：0，禁用；1，启用；默认为1
    private Short enabled;
}

