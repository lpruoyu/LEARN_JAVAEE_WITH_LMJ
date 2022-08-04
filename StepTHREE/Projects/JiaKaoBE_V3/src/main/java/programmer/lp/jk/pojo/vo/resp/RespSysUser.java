package programmer.lp.jk.pojo.vo.resp;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
@ApiModel("系统用户")
public class RespSysUser {
    @ApiModelProperty("id")
    private Integer id;

    @ApiModelProperty("昵称")
    private String nickname;

    @ApiModelProperty("用户名")
    private String username;

    @ApiModelProperty("账号的状态【0是正常，1是锁定】")
    private Short status;

    @ApiModelProperty("最后一次登录的时间")
    // 前后端分离一般返回UNIX时间戳
    // UNIX时间戳：从 1970-1-1 0:0:0 开始到现在走过的毫秒数
    private Long loginTime;
}