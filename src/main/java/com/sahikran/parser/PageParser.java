package com.sahikran.parser;

import com.sahikran.exception.PageParserException;
import com.sahikran.model.Result;
import com.sahikran.parser.PageParserFactoryImpl.ParserType;

public interface PageParser {
    ParserType getType();
    Result parse() throws PageParserException;
}
