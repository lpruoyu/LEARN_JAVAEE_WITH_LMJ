package programmer.lp.jk.pojo.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.util.List;

@Data
@ApiModel("城市")
public class CityDto {
    @ApiModelProperty("城市的主键")
    private Integer id;
    @ApiModelProperty("城市名称")
    private String name;
    @ApiModelProperty("该城市对应的车牌")
    private String plate;
    @ApiModelProperty("该城市下的考场")
    private List<ExamPlaceDto> children;
}
