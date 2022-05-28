package programmer.lp.jk.pojo.vo.resp.json;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.util.List;

@EqualsAndHashCode(callSuper = true)
@Data
@ApiModel("分页查询结果")
public class JSONPageResult<T> extends JSONDataResult<List<T>> {
    @ApiModelProperty("记录总数")
    private long count;
    @ApiModelProperty("总页数")
    private long pages;
}
