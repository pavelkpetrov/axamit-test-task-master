package com.axamit.spring.dto;

import org.apache.commons.lang3.builder.ReflectionToStringBuilder;

import java.io.Serializable;
import java.util.List;
import javax.validation.constraints.NotNull;

/**
 * @author Pavel Petrov
 *         created on 30.10.2016
 */
public class StringsDto implements Serializable {

    @NotNull
    private List<String> strings;

    public List<String> getStrings() {
        return strings;
    }

    public void setStrings(List<String> strings) {
        this.strings = strings;
    }

    @Override
    public String toString(){
        return ReflectionToStringBuilder.toString(this);
    }
}
