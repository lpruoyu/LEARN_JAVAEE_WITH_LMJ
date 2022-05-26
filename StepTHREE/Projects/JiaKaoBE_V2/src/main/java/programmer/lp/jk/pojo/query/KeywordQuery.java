package programmer.lp.jk.pojo.query;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;

@EqualsAndHashCode(callSuper = true)
@Data
public class KeywordQuery extends PageQuery {
    @ApiModelProperty("关键字")
    private String keyword;
}
