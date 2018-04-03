package com.cake.server.interceptor;

import com.cake.server.constants.App;
import com.fasterxml.jackson.core.JsonEncoding;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonProcessingException;
import org.apache.commons.lang3.StringUtils;
import org.springframework.http.HttpOutputMessage;
import org.springframework.http.converter.HttpMessageNotWritableException;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;
import java.io.IOException;

/**
 * Class description goes here
 * Created by ylq on 15/4/1 下午4:05.
 */
public class JsonpHttpMessageConverter extends MappingJackson2HttpMessageConverter {
    @Override
    protected void writeInternal(Object object, HttpOutputMessage outputMessage) throws IOException, HttpMessageNotWritableException {
        JsonEncoding encoding = getJsonEncoding(outputMessage.getHeaders().getContentType());
        JsonGenerator jsonGenerator = this.getObjectMapper().getFactory().createJsonGenerator(outputMessage.getBody(), encoding);
        String callBackName = App.JSONP_CALLBACK;
        try {
            //ConfigContainer.JSONP_CALLBACK 为回调名称，如"callback"
            HttpServletRequest request = ((ServletRequestAttributes) RequestContextHolder
                    .getRequestAttributes()).getRequest();
            String tem = request.getParameter("callback");
            if (StringUtils.isNotBlank(tem)) {
                callBackName = tem;
            }
            jsonGenerator.writeRaw(callBackName);
            jsonGenerator.writeRaw('(');
            this.getObjectMapper().writeValue(jsonGenerator, object);
            jsonGenerator.writeRaw(");");
            jsonGenerator.flush();
        } catch (JsonProcessingException ex) {
            throw new HttpMessageNotWritableException("Could not write JSON: " + ex.getMessage(), ex);
        }
    }
}