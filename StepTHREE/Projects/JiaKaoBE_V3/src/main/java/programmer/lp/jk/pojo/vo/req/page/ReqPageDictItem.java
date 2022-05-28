package programmer.lp.jk.pojo.vo.req.page;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;

@EqualsAndHashCode(callSuper = true)
@Data
public class ReqPageDictItem extends ReqKeywordPage{
    @ApiModelProperty("数据字典类型ID")
    private Integer typeId;
}
