package programmer.lp.jk.pojo.query;

import lombok.Data;
import lombok.EqualsAndHashCode;

@EqualsAndHashCode(callSuper = true)
@Data
public class KeywordQuery<T> extends PageQuery<T> {
    private String keyword;
}
