package programmer.lp.jk.pojo.vo.req.page;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;

@EqualsAndHashCode(callSuper = true)
@Data
public class ReqPageCity extends ReqKeywordPage {
    @ApiModelProperty("省份id")
    private Integer parentId;
}