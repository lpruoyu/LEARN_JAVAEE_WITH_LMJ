package programmer.lp.jk.pojo.vo.req.save;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.validation.constraints.NotBlank;

@Data
public class ReqSaveDictType {
    @ApiModelProperty("主键：如果为空，新增记录；如果不为空，更新记录")
    private Integer id;
    @ApiModelProperty(value = "名称", required = true)
    @NotBlank(message = "名称不能为空")
    private String name;
    @ApiModelProperty(value = "值", required = true)
    @NotBlank(message = "值不能为空")
    private String value;
    @ApiModelProperty("简介")
    private String intro;
}

