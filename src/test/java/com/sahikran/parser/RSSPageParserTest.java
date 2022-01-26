package com.sahikran.parser;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.io.InputStream;
import java.net.http.HttpResponse;
import java.time.Duration;
import java.util.concurrent.ExecutionException;

import com.sahikran.exception.PageParserException;
import com.sahikran.httputil.HttpsRestHandler;
import com.sahikran.httputil.RestHandler;
import com.sahikran.model.Result;
import com.sahikran.parser.PageParserFactoryImpl.ParserType;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
public class RSSPageParserTest {
    
    @Mock
    private RestHandler restHandler;

    @Mock
    private PageParser pageParser;

    private final String pageUrl = "https://www.ijoy.org.in/rss.asp?issn=0973-6131;year=2021;volume=14;issue=2;month=May-August";

    private final String searchString = "yoga";

    @BeforeEach
    public void init(){
        restHandler = new HttpsRestHandler();
        PageParserFactory pageParserFactory = new PageParserFactoryImpl(searchString, Duration.ofSeconds(60));
        pageParser = pageParserFactory.get(pageUrl, ParserType.RSS);
    }

    @Test
    public void whenRssParseCalled_returnAValidResult(){
        
        HttpResponse<InputStream> response = null;
        try {
            response =  restHandler.getHttpClient(true, Duration.ofSeconds(60))
                .thenComposeAsync(restHandler.invokeARestCall(pageUrl)).get();
            assertNotNull(response);
        } catch (InterruptedException | ExecutionException e) {
            e.printStackTrace();
        }

        try {
            Result result = pageParser.parse();
            assertNotNull(result);
            assertTrue(result.getFeedItems().size() == 13);
        } catch (PageParserException e) {
            e.printStackTrace();
        }
    }
}
