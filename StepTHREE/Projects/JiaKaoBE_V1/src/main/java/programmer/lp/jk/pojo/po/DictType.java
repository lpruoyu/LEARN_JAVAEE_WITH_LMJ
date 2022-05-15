package programmer.lp.jk.pojo.po;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class DictType {
    //主键
    private Integer id;
    //名称
    private String name;
    //值
    private String value;
    //简介
    private String intro;
}

