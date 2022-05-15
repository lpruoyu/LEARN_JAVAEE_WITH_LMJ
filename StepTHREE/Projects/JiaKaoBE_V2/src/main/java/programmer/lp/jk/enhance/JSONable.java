package programmer.lp.jk.enhance;

import com.fasterxml.jackson.databind.ObjectMapper;

public interface JSONable {
    ObjectMapper MAPPER = new ObjectMapper();

    default String json() throws Exception {
        return MAPPER.writeValueAsString(this);
    }
}
