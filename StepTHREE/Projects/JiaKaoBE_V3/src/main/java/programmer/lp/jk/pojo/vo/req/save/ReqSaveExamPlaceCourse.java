package programmer.lp.jk.pojo.vo.req.save;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import org.springframework.web.multipart.MultipartFile;
import programmer.lp.jk.common.validator.CourseType;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.math.BigDecimal;

@Data
public class ReqSaveExamPlaceCourse {
    @ApiModelProperty("主键：如果为空，新增记录；如果不为空，更新记录")
    private Integer id;
    @ApiModelProperty(value = "名称", required = true)
    @NotBlank(message = "名称不能为空")
    private String name;
    @ApiModelProperty(value = "价格", required = true)
    @NotNull(message = "价格不能为空")
    @Min(value = 0, message = "价格不能是负数")
    private BigDecimal price;
    @ApiModelProperty(value = "所属考场id", required = true)
    @NotNull(message = "考场id不能为空")
    private Integer placeId;
    @ApiModelProperty(value = "课程类型：0是课程合集，2是科目2，3是科目3", required = true)
    @CourseType(message = "课程类型只能为0或2或3")
    private Short type;
    @ApiModelProperty("简介")
    private String intro;
    @ApiModelProperty("视频")
    private String video;

    @ApiModelProperty("新上传的封面数据")
    private MultipartFile coverFile;
    @ApiModelProperty("旧封面的路径")
    private String cover;
}

