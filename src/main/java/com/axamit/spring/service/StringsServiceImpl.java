package com.axamit.spring.service;

import com.axamit.spring.dto.StringsDto;
import com.axamit.spring.exceptions.StringsException;
import com.axamit.spring.model.SortedStrings;

import java.util.List;

public class StringsServiceImpl implements StringsService {

    private StringsSorter stringsSorter;

    public List<SortedStrings> processStrings(StringsDto strings) throws StringsException {
        return stringsSorter.sortStrings(strings.getStrings());
    }

    public StringsSorter getStringsSorter() {
        return stringsSorter;
    }

    public void setStringsSorter(StringsSorter stringsSorter) {
        this.stringsSorter = stringsSorter;
    }
}
