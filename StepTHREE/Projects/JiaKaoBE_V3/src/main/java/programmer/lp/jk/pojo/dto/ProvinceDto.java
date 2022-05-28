package programmer.lp.jk.pojo.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.util.List;

@Data
@ApiModel("省份")
public class ProvinceDto {
    @ApiModelProperty("省份的主键")
    private Integer id;
    @ApiModelProperty("省份名称")
    private String name;
    @ApiModelProperty("省份对应的车牌")
    private String plate;
    @ApiModelProperty("该省份下的城市")
    private List<CityDto> children;
}
