package programmer.lp.jk.pojo.po;

import lombok.Data;
import programmer.lp.jk.foreign.anno.ForeignField;

@Data
public class ExamPlace {
    //主键
    private Integer id;
    //名称
    private String name;
    //考场是哪个省份的
    @ForeignField(PlateRegion.class)
    private Integer provinceId;
    //考场是哪个城市的
    @ForeignField(PlateRegion.class)
    private Integer cityId;
    //考场的具体地址
    private String address;
    //纬度
    private Double latitude;
    //经度
    private Double longitude;
}

