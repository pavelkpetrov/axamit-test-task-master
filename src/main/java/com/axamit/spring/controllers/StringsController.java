package com.axamit.spring.controllers;

import com.axamit.spring.assembler.StringsAssembler;
import com.axamit.spring.dto.ErrorResponse;
import com.axamit.spring.dto.StringsDto;
import com.axamit.spring.dto.StringsResponseDto;
import com.axamit.spring.exceptions.StringsException;
import com.axamit.spring.model.SortedStrings;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


import com.axamit.spring.service.StringsService;

import javax.validation.Valid;
import java.util.List;

@Controller
@RequestMapping("/strings")
public class StringsController {

    private static final Logger logger = LoggerFactory.getLogger(StringsController.class);

    @Autowired
    @Qualifier("stringsService")
	private StringsService stringsService;
    @Autowired
	private StringsAssembler stringsAssembler;

    @RequestMapping(value = "/sort",
            method = RequestMethod.POST,
            headers = {"Content-type=application/json"})
    @ResponseBody
    public List<StringsResponseDto> sort(@Valid @RequestBody StringsDto strings, BindingResult bindingResult)
            throws StringsException {
        logger.debug("Accept strings:" + strings);

        if (bindingResult.hasErrors()) {
            logger.error("Validation fail");
            throw new StringsException("Validation error", StringsException.CODE_INVALID_STRINGS);
        }

        List<SortedStrings> processedStrings = stringsService.processStrings(strings);
        return stringsAssembler.assemble(processedStrings);
    }

    @ExceptionHandler({StringsException.class})
    @ResponseBody
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    public ErrorResponse databaseError(StringsException error) {
        return new ErrorResponse(error.getMessage(), error.getCode());
    }

}
