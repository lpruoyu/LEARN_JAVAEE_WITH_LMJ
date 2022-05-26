package programmer.lp.jk.pojo.result;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
@ApiModel
public class SwaggerErrorR {
    private String msg;
    @ApiModelProperty("code非0表示出现错误")
    private Integer code;
}
