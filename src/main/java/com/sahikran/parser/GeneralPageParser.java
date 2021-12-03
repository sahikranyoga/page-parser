package com.sahikran.parser;

import com.sahikran.exception.PageParserException;
import com.sahikran.model.Result;
import com.sahikran.parser.PageParserFactoryImpl.ParserType;

public final class GeneralPageParser implements PageParser {

    @Override
    public Result parse() throws PageParserException {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public ParserType getType() {
        return ParserType.GENERAL;
    }
    
}
