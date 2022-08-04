package programmer.lp.jk.pojo.vo.resp;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.math.BigDecimal;
import java.util.Date;

@Data
@ApiModel("科二科三课程")
public class RespExamPlaceCourse {
    @ApiModelProperty("主键：如果为空，新增记录；如果不为空，更新记录")
    private Integer id;
    @ApiModelProperty("创建时间，系统自动生成")
    private Date createTime;
    @ApiModelProperty("名称")
    private String name;
    @ApiModelProperty("价格")
    private BigDecimal price;
    @ApiModelProperty("所属考场id")
    private Integer placeId;
    @ApiModelProperty("课程类型：0是课程合集，2是科目2，3是科目3")
    private Short type;
    @ApiModelProperty("简介")
    private String intro;
    @ApiModelProperty("视频")
    private String video;
    @ApiModelProperty("封面")
    private String cover;
    @ApiModelProperty("城市id")
    private String cityId;
    @ApiModelProperty("省份id")
    private String provinceId;
}

