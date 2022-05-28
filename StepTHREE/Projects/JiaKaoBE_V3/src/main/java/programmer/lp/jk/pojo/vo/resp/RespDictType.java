package programmer.lp.jk.pojo.vo.resp;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
@ApiModel("数据字典类型")
public class RespDictType {
    @ApiModelProperty("主键：如果为空，新增记录；如果不为空，更新记录")
    private Integer id;
    @ApiModelProperty("名称")
    private String name;
    @ApiModelProperty("值")
    private String value;
    @ApiModelProperty("简介")
    private String intro;
}

