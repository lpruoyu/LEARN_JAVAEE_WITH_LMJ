package programmer.lp.jk.pojo.vo.req.save;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Data
public class ReqSaveExamPlace {
    @ApiModelProperty("主键：如果为空，新增记录；如果不为空，更新记录")
    private Integer id;
    @ApiModelProperty(value = "名称", required = true)
    @NotBlank(message = "名称不能为空")
    private String name;
    @ApiModelProperty(value = "考场是哪个省份的", required = true)
    @NotNull(message = "省份id不能为空")
    private Integer provinceId;
    @ApiModelProperty(value = "考场是哪个城市的", required = true)
    @NotNull(message = "城市id不能为空")
    private Integer cityId;
    @ApiModelProperty("考场的地址")
    private String address;
    @ApiModelProperty("纬度")
    private Double latitude;
    @ApiModelProperty("经度")
    private Double longitude;
}

