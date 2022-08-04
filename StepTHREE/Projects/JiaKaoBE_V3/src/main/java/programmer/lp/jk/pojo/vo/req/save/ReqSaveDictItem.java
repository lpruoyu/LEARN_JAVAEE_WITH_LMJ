package programmer.lp.jk.pojo.vo.req.save;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import programmer.lp.jk.common.validator.BoolNumber;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Data
public class ReqSaveDictItem {
    @ApiModelProperty("主键：如果为空，新增记录；如果不为空，更新记录")
    private Integer id;
    @ApiModelProperty(value = "名称", required = true)
    @NotBlank(message = "名称不能为空")
    private String name;
    @ApiModelProperty(value = "值", required = true)
    @NotBlank(message = "值不能为空")
    private String value;
    @ApiModelProperty(value = "所属数据类型id", required = true)
    @NotNull(message = "类型id不能为空")
    private Integer typeId;
    @ApiModelProperty("排序序号：不能是负数；值越大，越优先排列展示；默认为0")
    @Min(value = 0, message = "序号不能是负数")
    private Integer sn;
    @ApiModelProperty("是否禁用：0，不禁用（启用）；1，禁用。默认为0")
    @BoolNumber(message = "只能是0或1：0启用，1禁用")
    private Short disabled;
}

