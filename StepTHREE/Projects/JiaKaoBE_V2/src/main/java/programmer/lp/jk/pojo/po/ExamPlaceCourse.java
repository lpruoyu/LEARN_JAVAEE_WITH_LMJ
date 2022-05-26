package programmer.lp.jk.pojo.po;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import programmer.lp.jk.foreign.anno.ForeignField;

import java.math.BigDecimal;
import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ExamPlaceCourse { // 科2科3
    //主键
    private Integer id;
    
    private Date createTime;
    //名称
    private String name;
    //价格
    private BigDecimal price;
    //课程类型：0是课程合集，2是科目2，3是科目3
    private Short type;
    
    private String intro;
    //视频
    private String video;
    //封面
    private String cover;
    //考场
    @ForeignField(mainTable = ExamPlace.class)
    private Integer placeId;
}

