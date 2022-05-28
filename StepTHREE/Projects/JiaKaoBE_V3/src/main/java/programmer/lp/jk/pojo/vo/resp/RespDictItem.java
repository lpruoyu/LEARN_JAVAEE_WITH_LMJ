package programmer.lp.jk.pojo.vo.resp;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
@ApiModel("数据字典条目")
public class RespDictItem {
    @ApiModelProperty("主键：如果为空，新增记录；如果不为空，更新记录")
    private Integer id;
    @ApiModelProperty("名称")
    private String name;
    @ApiModelProperty("值")
    private String value;
    @ApiModelProperty("所属数据类型id")
    private Integer typeId;
    @ApiModelProperty("排序序号：值越大，越优先排列展示。默认为0")
    private Integer sn;
    @ApiModelProperty("是否禁用：0，不禁用（启用）；1，禁用。默认为0")
    private Short disabled;
}

