package programmer.lp.jk.pojo.query;

import lombok.Data;
import lombok.EqualsAndHashCode;
import programmer.lp.jk.pojo.po.DictItem;

@EqualsAndHashCode(callSuper = true)
@Data
public class DictItemQuery extends KeywordQuery<DictItem> {
    private long total;
    private long pages;
}
