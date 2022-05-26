package programmer.lp.jk.enhance;

import programmer.lp.jk.util.JSONs;

public interface JSONable {
    default String jsonString() throws Exception {
        return JSONs.getMAPPER().writeValueAsString(this);
    }
}
