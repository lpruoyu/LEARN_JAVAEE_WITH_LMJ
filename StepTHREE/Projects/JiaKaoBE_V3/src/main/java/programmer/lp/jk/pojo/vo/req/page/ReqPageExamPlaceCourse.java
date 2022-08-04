package programmer.lp.jk.pojo.vo.req.page;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;
import programmer.lp.jk.common.validator.CourseType;

@EqualsAndHashCode(callSuper = true)
@Data
public class ReqPageExamPlaceCourse extends ReqPageKeyword {
    @ApiModelProperty("省份id")
    private Integer provinceId;
    @ApiModelProperty("城市id")
    private Integer cityId;
    @ApiModelProperty("所属考场id")
    private Integer placeId;
    @ApiModelProperty(value = "课程类型：0是课程合集，2是科目2，3是科目3")
    @CourseType(message = "课程类型只能为0或2或3")
    private Short type;
}

