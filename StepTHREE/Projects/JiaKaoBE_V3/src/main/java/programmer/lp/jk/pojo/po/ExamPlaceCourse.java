package programmer.lp.jk.pojo.po;

import lombok.Data;
import programmer.lp.jk.common.foreign.anno.ForeignField;

import java.math.BigDecimal;
import java.util.Date;

@Data
public class ExamPlaceCourse { // 课程—科2科3
    // 主键
    private Integer id;
    // 创建时间，系统自动生成
    private Date createTime;
    // 名称
    private String name;
    // 价格
    private BigDecimal price;
    // 课程类型：0是课程合集，2是科目2，3是科目3
    private Short type;
    // 简介
    private String intro;
    // 视频
    private String video;
    // 封面
    private String cover;
    // 考场
    @ForeignField(ExamPlace.class)
    private Integer placeId;
}