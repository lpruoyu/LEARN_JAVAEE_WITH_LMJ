package programmer.lp.jk.pojo.po;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import programmer.lp.jk.foreign.anno.ForeignField;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class PlateRegion {
    //主键
    private Integer id;
    //区域名称
    private String name;
    //车牌
    private String plate;
    //如果是市区的话，代表所属省份id
    @ForeignField(PlateRegion.class)
    private Integer parentId;
    //区域对应的拼音
    private String pinyin;
}

