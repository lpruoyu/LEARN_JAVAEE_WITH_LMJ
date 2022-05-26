package programmer.lp.jk.pojo.po;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotBlank;

@Data
@NoArgsConstructor
@AllArgsConstructor
//@ForeignTable("dict_type")
public class DictType {
    //主键
//    @ForeignField(column = "id", cascade = ForeignCascade.DEFAULT)
//    @ForeignField(cascade = ForeignCascade.DELETE) // 有点危险
    private Integer id;
    //名称
    @NotBlank(message = "名称不能为空")
    private String name;
    //值
    @NotBlank(message = "值不能为空")
    private String value;
    //简介
    private String intro;
}

