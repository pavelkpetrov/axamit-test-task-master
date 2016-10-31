package com.axamit.spring.service;

import com.axamit.spring.model.SortedStrings;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Created by Pavel on 30.10.2016.
 */
@Service("simpleSorter")
public class StringsSorterImpl implements StringsSorter{
    public final static String WORD_DELIMETER = " ";

    private static int getLongestWordLength(String s){
        if (StringUtils.isEmpty(s)) {
            return 0;
        }
        return  Arrays.stream(s.split(WORD_DELIMETER)).
                sorted((w1, w2) -> Integer.valueOf(w2.length()).compareTo(w1.length())).findFirst().get().length();
    }

    @Override
    public List<SortedStrings> sortStrings(List<String> source) {
        Comparator<SortedStrings> comparator = Comparator.comparing(SortedStrings::getLongestWord);
        return source.stream().map(s -> new SortedStrings(s, StringsSorterImpl.getLongestWordLength(s))).
                sorted(comparator.reversed()).collect(Collectors.toList());
    }
}
