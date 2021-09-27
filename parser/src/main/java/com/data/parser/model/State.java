package com.data.parser.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Getter;
import lombok.Setter;
import org.springframework.lang.Nullable;


@Getter
@Setter
@JsonIgnoreProperties(ignoreUnknown = true)
public class State {
    @Nullable
    private boolean inHotList;
    @Nullable
    private boolean willBeLive;

    @Override
    public String toString() {
        return "State{" +
                "inHotList=" + inHotList +
                ", willBeLive=" + willBeLive +
                '}';
    }
}
