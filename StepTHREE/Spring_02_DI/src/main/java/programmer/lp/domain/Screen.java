package programmer.lp.domain;

import java.util.List;

public class Screen {

    private String source;
    private Integer size;
    private List<String> info;

    public Screen() { }
    public Screen(List<String> info) {
        this.info = info;
    }
    public Screen(String source, Integer size) {
        this.source = source;
        this.size = size;
    }

    public String getSource() {
        return source;
    }

    public void setSource(String source) {
        this.source = source;
    }

    public Integer getSize() {
        return size;
    }

    public void setSize(Integer size) {
        this.size = size;
    }
}
