package com.axamit.spring.dto;

import org.apache.commons.lang3.builder.ReflectionToStringBuilder;

import java.io.Serializable;

/**
 * Created by Pavel on 30.10.2016.
 */
public class StringsResponseDto implements Serializable {
    private String string;
    private int longestWord;

    public String getString() {
        return string;
    }

    public void setString(String string) {
        this.string = string;
    }

    public int getLongestWord() {
        return longestWord;
    }

    public void setLongestWord(int longestWord) {
        this.longestWord = longestWord;
    }

    @Override
    public String toString(){
        return ReflectionToStringBuilder.toString(this);
    }

}
