package com.example.demo;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.oxm.jaxb.Jaxb2Marshaller;

@Configuration
public class CalciConfig
{
    @Bean
    public Jaxb2Marshaller marshaller()
    {
        Jaxb2Marshaller marshaller = new Jaxb2Marshaller();
        marshaller.setContextPath("pojoClasses");
        return marshaller;
    }

    @Bean
    public CalciClient calciClient(Jaxb2Marshaller marshaller)
    {
        CalciClient client = new CalciClient();
        client.setDefaultUri("http://www.dneonline.com/calculator.asmx");
        client.setMarshaller(marshaller);
        client.setUnmarshaller(marshaller);
        return client;
    }


}
