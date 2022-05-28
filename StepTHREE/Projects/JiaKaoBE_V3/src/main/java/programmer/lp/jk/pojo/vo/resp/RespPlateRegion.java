package programmer.lp.jk.pojo.vo.resp;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
@ApiModel("区域信息：省份、城市")
public class RespPlateRegion {
    @ApiModelProperty("主键：如果为空，新增记录；如果不为空，更新记录")
    private Integer id;
    @ApiModelProperty("名称")
    private String name;
    @ApiModelProperty("车牌")
    private String plate;
    @ApiModelProperty("父区域id：如果为空，代表省份id；如果不为空，代表城市id")
    private Integer parentId;
}

