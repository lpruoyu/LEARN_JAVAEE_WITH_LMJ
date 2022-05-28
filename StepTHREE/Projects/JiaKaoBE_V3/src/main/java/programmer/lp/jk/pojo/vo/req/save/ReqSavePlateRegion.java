package programmer.lp.jk.pojo.vo.req.save;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.NotBlank;

@Data
public class ReqSavePlateRegion {
    @ApiModelProperty("主键：如果为空，新增记录；如果不为空，更新记录")
    private Integer id;
    @ApiModelProperty(value = "名称", required = true)
    @NotBlank(message = "名称不能为空")
    private String name;
    @ApiModelProperty(value = "车牌：车牌的长度只能是1，比如陕、粤、A、C等", required = true)
    @NotBlank(message = "车牌不能为空")
    @Length(min = 1, max = 1, message = "车牌长度只能为1，比如陕、粤、A、C等")
    private String plate;
    @ApiModelProperty("父区域id：如果为空，代表省份id；如果不为空，代表城市id")
    private Integer parentId;
}

