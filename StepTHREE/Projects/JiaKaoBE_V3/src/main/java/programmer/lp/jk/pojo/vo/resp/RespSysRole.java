package programmer.lp.jk.pojo.vo.resp;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
@ApiModel("系统角色")
public class RespSysRole {
    @ApiModelProperty("id")
    private Short id;

    @ApiModelProperty("名称")
    private String name;
}