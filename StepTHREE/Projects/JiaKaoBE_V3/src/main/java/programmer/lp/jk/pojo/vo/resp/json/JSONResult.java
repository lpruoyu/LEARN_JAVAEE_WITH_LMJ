package programmer.lp.jk.pojo.vo.resp.json;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import programmer.lp.jk.common.enhance.CodeMsg;

@Data
@ApiModel("返回结果")
public class JSONResult {
    @ApiModelProperty("前端框架Layui要求返回的code：规定0代表成功，其他代表失败")
    private Integer code;
    @ApiModelProperty("返回的信息")
    private String msg;

    public JSONResult() {
        this(CodeMsg.OPERATE_OK);
    }

    public JSONResult(Integer code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    public JSONResult(String msg) {
        this();
        this.msg = msg;
    }

    public JSONResult(Integer code) {
        this.code = code;
    }

    public JSONResult(CodeMsg codeMsg) {
        this(codeMsg.getCode(), codeMsg.getMsg());
    }
}
