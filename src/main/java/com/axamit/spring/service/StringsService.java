package com.axamit.spring.service;


import com.axamit.spring.dto.StringsDto;
import com.axamit.spring.exceptions.StringsException;
import com.axamit.spring.model.SortedStrings;

import java.util.List;

public interface StringsService {

    List<SortedStrings> processStrings(StringsDto strings) throws StringsException;

}
