package programmer.lp.jk.pojo.vo.req.page;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;

@EqualsAndHashCode(callSuper = true)
@Data
public class ReqPageExamPlace extends ReqKeywordPage {
    @ApiModelProperty("考场所属的省份id")
    private Integer provinceId;
    @ApiModelProperty("考场所属的城市id")
    private Integer cityId;
}

