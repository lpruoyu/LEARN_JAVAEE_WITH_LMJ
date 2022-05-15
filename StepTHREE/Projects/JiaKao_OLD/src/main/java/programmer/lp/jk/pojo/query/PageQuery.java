package programmer.lp.jk.pojo.query;

import lombok.Data;

import java.util.List;

@Data
public class PageQuery<T> {
    private static final int MIN_SIZE = 1;
    private static final int DEFAULT_SIZE = 10;
    private long size;
    private long no;
    private List<T> data;

    public long getSize() {
        return size < MIN_SIZE ? DEFAULT_SIZE : size;
    }

    public long getNo() {
        return no < MIN_SIZE ? MIN_SIZE : no;
    }
}
