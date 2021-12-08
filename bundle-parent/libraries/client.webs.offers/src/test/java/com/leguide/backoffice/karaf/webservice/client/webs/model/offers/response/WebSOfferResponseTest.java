package com.leguide.backoffice.karaf.webservice.client.webs.model.offers.response;

import com.leguide.backoffice.karaf.webservice.client.webs.connector.WebsResponseConverter;
import org.junit.Assert;
import org.junit.Test;

import java.io.File;
import java.net.URL;
import java.nio.charset.Charset;
import java.util.List;
import java.util.stream.Collectors;
import com.google.common.io.Files;

public class WebSOfferResponseTest {

    @Test
    public void ParseWebsJsonTest() throws Exception {
        ClassLoader classLoader = getClass().getClassLoader();
        URL resource = classLoader.getResource("webs.json");
        File mockFile = new File(resource.getPath());

        List<String> lines = Files.readLines(mockFile, Charset.defaultCharset());
        String content = lines.stream().collect(Collectors.joining("\n"));

        WebsResponseConverter converter = new WebsResponseConverter();
        converter.setResponse(content);

        Assert.assertNotNull(converter.convertJsonToWebSResponse());
    }
}
