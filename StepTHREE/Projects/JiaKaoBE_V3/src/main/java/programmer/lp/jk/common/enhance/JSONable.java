package programmer.lp.jk.common.enhance;

import programmer.lp.jk.common.util.JSONs;

public interface JSONable {
    default String jsonString() throws Exception {
        return JSONs.getMAPPER().writeValueAsString(this);
    }
}
