package programmer.lp.jk.pojo.vo.resp.json;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;

@EqualsAndHashCode(callSuper = true)
@Data
@ApiModel("返回结果，带有数据")
public class JSONDataResult<T> extends JSONResult {
    @ApiModelProperty("返回的数据")
    private T data;

    public JSONDataResult() {
    }

    public JSONDataResult(T data) {
        this.data = data;
    }

    public JSONDataResult(String msg, T data) {
        super(msg);
        this.data = data;
    }
}
