package com.axamit.spring.service;

import com.axamit.spring.model.SortedStrings;

import java.util.List;

/**
 * Created by Pavel on 30.10.2016.
 */
public interface StringsSorter {

    List<SortedStrings> sortStrings(List<String> source);

}
