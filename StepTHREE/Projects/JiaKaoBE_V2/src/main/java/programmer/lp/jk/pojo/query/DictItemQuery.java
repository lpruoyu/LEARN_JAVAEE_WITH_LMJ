package programmer.lp.jk.pojo.query;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;

@EqualsAndHashCode(callSuper = true)
@Data
@ApiModel
public class DictItemQuery extends KeywordQuery {
    @ApiModelProperty("类型ID")
    private Integer typeId;
}
