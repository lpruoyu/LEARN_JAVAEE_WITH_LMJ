package programmer.lp.jk.pojo.vo.resp;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
@ApiModel("考场")
public class RespExamPlace {
    @ApiModelProperty("主键：如果为空，新增记录；如果不为空，更新记录")
    private Integer id;
    @ApiModelProperty("名称")
    private String name;
    @ApiModelProperty("考场是哪个省份的")
    private Integer provinceId;
    @ApiModelProperty("考场是哪个城市的")
    private Integer cityId;
    @ApiModelProperty("考场的地址")
    private String address;
    @ApiModelProperty("纬度")
    private Double latitude;
    @ApiModelProperty("经度")
    private Double longitude;
}

