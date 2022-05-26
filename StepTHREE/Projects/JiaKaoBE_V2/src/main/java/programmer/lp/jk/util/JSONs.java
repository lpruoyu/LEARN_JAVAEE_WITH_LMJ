package programmer.lp.jk.util;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.databind.ObjectMapper;

public final class JSONs {
    private JSONs() {
    }

    private static final ObjectMapper MAPPER = new ObjectMapper();

    static {
        MAPPER.setDefaultPropertyInclusion(JsonInclude.Include.NON_NULL);
    }
    public static ObjectMapper getMAPPER() {
        return MAPPER;
    }
}
