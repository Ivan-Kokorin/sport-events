package com.data.parser.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Getter;
import lombok.Setter;
import org.springframework.lang.Nullable;


@Getter
@Setter
@JsonIgnoreProperties(ignoreUnknown = true)
public class Sport {
    private int id;
    @Nullable
    private int parentId;
    private String name;

    @Override
    public String toString() {
        return "Sport{" +
                "id=" + id +
                ", parentId=" + parentId +
                ", name='" + name + '\'' +
                '}' + "\n";
    }
}