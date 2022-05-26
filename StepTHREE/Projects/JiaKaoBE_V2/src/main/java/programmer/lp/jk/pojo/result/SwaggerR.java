package programmer.lp.jk.pojo.result;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
@ApiModel
public class SwaggerR {
    private String msg;
    @ApiModelProperty("code为0代表成功")
    private Integer code;
    private Object data;
}
