package com.axamit.spring.test.junit;

import com.axamit.spring.dto.StringsDto;
import com.axamit.spring.model.SortedStrings;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import com.axamit.spring.service.StringsSorter;

import java.io.IOException;
import java.util.List;

import static org.junit.Assert.*;

/**
 * Created by Pavel on 30.10.2016.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:appServlet/servlet-context.xml")
public class SorterTest {

    @Autowired
    @Qualifier("simpleSorter")
    private StringsSorter stringsSorter;

    private StringsDto stringsDto;

    @Before
    public void init() throws IOException {
        ObjectMapper mapper = new ObjectMapper();
        StringsDto obj = mapper.readValue(this.getClass().getResourceAsStream("SorterTest.json"), StringsDto.class);
        stringsDto = obj;
    }

    @Test
    public void test_sorter_return_expected() {
        List<SortedStrings> result = stringsSorter.sortStrings(stringsDto.getStrings());
        assertTrue(result != null);
        assertTrue(!result.isEmpty());
        SortedStrings sortedStrings0 = result.iterator().next();
        String testStr = sortedStrings0.getString();
        int length = sortedStrings0.getLongestWord();
        assertTrue("Aliens are watching up in the sky".equals(testStr));
        assertTrue(8 == length);
    }

}
