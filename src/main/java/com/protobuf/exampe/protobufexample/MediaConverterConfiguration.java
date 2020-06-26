package com.protobuf.exampe.protobufexample;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.http.MediaType;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.http.converter.protobuf.ProtobufHttpMessageConverter;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import java.util.ArrayList;
import java.util.List;

//@Configuration
public class MediaConverterConfiguration {
    @Bean
    //@Primary
    public ProtobufHttpMessageConverter jacksonConverter() {
        ProtobufHttpMessageConverter protobufHttpMessageConverter =
                new ProtobufHttpMessageConverter();
        MappingJackson2HttpMessageConverter mc =
                new MappingJackson2HttpMessageConverter();
        List<MediaType> supportedMediaTypes =
                new ArrayList(protobufHttpMessageConverter.getSupportedMediaTypes());
        supportedMediaTypes
               .add(MediaType.valueOf(MediaType.APPLICATION_JSON_VALUE));
       // supportedMediaTypes.add(MediaType.valueOf("application/protobuf"));
       supportedMediaTypes.add( MediaType.valueOf("application/x-protobuf"));
       protobufHttpMessageConverter.setSupportedMediaTypes(supportedMediaTypes);
        //mc.setObjectMapper(halObjectMapper);
        return protobufHttpMessageConverter;
    }

    //@Override
    public void configureMessageConverters(List<HttpMessageConverter<?>> converters) {
        converters.add(jacksonConverter());
    }
}
