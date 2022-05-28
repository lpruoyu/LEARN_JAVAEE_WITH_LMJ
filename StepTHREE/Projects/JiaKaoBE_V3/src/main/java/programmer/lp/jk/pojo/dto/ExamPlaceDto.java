package programmer.lp.jk.pojo.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
@ApiModel("考场")
public class ExamPlaceDto {
    @ApiModelProperty("考场的主键")
    private Integer id;
    @ApiModelProperty("考场名称")
    private String name;
}
