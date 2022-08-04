package programmer.lp.jk.pojo.vo.req.page;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;

@EqualsAndHashCode(callSuper = true)
@Data
public class ReqPageKeyword extends ReqPage {
    @ApiModelProperty("搜索关键词")
    private String keyword;
}
