package programmer.lp.jk.pojo.po;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Province {
    //主键
    private Short id;
    //中国省份名称
    private String name;
    //车牌（省份别名）
    private String plate;
}

