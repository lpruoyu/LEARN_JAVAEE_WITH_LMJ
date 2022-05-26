package programmer.lp.jk.pojo.po;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import programmer.lp.jk.foreign.anno.ForeignField;
import programmer.lp.jk.validator.BoolNumber;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Data
@NoArgsConstructor
@AllArgsConstructor
//@ForeignTable("dict_item")
@ApiModel("数据字典条目")
public class DictItem {
    //主键
    private Integer id;
    //名称
    @NotBlank(message = "名称不能为空")
    @ApiModelProperty(name = "姓名", required = true)
    private String name;
    //值
    @NotBlank(message = "值不能为空")
    @ApiModelProperty(name = "值", required = true)
    private String value;
    //类型id
//    @ForeignField(column = "type_id", mainTable = DictType.class, mainField = "id")
    @ForeignField(DictType.class)
    @NotNull
    @ApiModelProperty(name = "所属类型ID", required = true)
    private Integer typeId;
    //排序序号：默认为0，值越大，越优先排列展示
    @Min(value = 0, message = "sn不能为负数")
    private Integer sn;
    //是否禁用：0，不禁用（启用）；1，禁用；默认为0
//    @Range(min = 0, max = 1, message = "disabled只能是0或1")
    @BoolNumber(message = "disabled只能是0或1")
    private Short disabled;
}

