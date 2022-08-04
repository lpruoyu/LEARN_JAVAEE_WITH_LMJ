package programmer.lp.jk.pojo.po;

import lombok.Data;
import programmer.lp.jk.common.foreign.anno.ForeignField;

@Data
public class PlateRegion {
    //主键
    private Integer id;
    //区域名称
    private String name;
    //车牌
    private String plate;
    //父区域id；如果是省份的话，为0；如果是城市的话，代表所属省份id
    @ForeignField(PlateRegion.class)
    private Integer parentId;
    //区域对应的拼音
    private String pinyin;
}
