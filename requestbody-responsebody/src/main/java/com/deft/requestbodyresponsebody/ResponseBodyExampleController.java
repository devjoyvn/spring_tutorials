package com.deft.requestbodyresponsebody;

import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/login-response")
public class ResponseBodyExampleController {

    @ResponseBody
    @PostMapping
    public ResponseTransfer postResponseController(
            @RequestBody LoginForm loginForm) {
        return new ResponseTransfer("Thanks For Posting!!!");
    }

    @PostMapping(value = "/content", produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public ResponseTransfer postResponseJsonContent(
            @RequestBody LoginForm loginForm) {
        return new ResponseTransfer("JSON Content!");
    }

    @PostMapping(value = "/content", produces = MediaType.APPLICATION_XML_VALUE)
    @ResponseBody
    public ResponseTransfer postResponseXmlContent(
            @RequestBody LoginForm loginForm) {
        return new ResponseTransfer("XML Content!");
    }


}
