package com.axamit.spring.assembler;

import com.axamit.spring.dto.StringsResponseDto;
import com.axamit.spring.model.SortedStrings;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Created by Pavel on 30.10.2016.
 */
@Component
public class StringsAssembler implements Assembler<SortedStrings, StringsResponseDto> {

    @Override
    public StringsResponseDto assemble(SortedStrings source) {
        StringsResponseDto dto = new StringsResponseDto();
        dto.setString(source.getString());
        dto.setLongestWord(source.getLongestWord());
        return dto;
    }

    @Override
    public List<StringsResponseDto> assemble(List<SortedStrings> source){
        if (source == null) {
            return new ArrayList<>();
        }
        return source.stream().map(this::assemble).collect(Collectors.toList());
    }

}
