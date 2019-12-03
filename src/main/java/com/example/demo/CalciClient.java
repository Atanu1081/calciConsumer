package com.example.demo;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.ws.client.core.support.WebServiceGatewaySupport;
import org.springframework.ws.soap.client.core.SoapActionCallback;
import pojoClasses.*;

public class CalciClient extends WebServiceGatewaySupport
{
    private static final Logger logger = LoggerFactory.getLogger(CalciClient.class);

    public AddResponse getAddResponse (int a, int b)
    {
        Add request = new Add();
        request.setIntA(a);
        request.setIntB(b);

        logger.info("Adding " + a + " and " + b);

        AddResponse response = (AddResponse) getWebServiceTemplate()
                .marshalSendAndReceive("http://www.dneonline.com/calculator.asmx", request,
                        new SoapActionCallback(
                                "http://tempuri.org/Add"));

        return response;

    }

    public DivideResponse getDivideResult (int a, int b)
    {
        Divide request = new Divide();
        request.setIntA(a);
        request.setIntB(b);

        logger.info("Dividing "+a+" by "+b);

        DivideResponse response = (DivideResponse) getWebServiceTemplate().marshalSendAndReceive("http://www.dneonline.com/calculator.asmx",request,
                new SoapActionCallback("http://tempuri.org/Divide"));
        return response;
    }

    public MultiplyResponse getMulResult (int a, int b)
    {
        Multiply request = new Multiply();
        request.setIntA(a);
        request.setIntB(b);

        logger.info("Multiplying "+a+" and "+b);

        MultiplyResponse response = (MultiplyResponse) getWebServiceTemplate().marshalSendAndReceive("http://www.dneonline.com/calculator.asmx",request,
                new SoapActionCallback("http://tempuri.org/Multiply"));
        return response;
    }

    public SubtractResponse getSubResult (int a, int b)
    {
        Subtract request = new Subtract();
        request.setIntA(a);
        request.setIntB(b);

        logger.info("Subtracting "+b+" from "+a);

        SubtractResponse response = (SubtractResponse) getWebServiceTemplate().marshalSendAndReceive("http://www.dneonline.com/calculator.asmx",request,
                new SoapActionCallback("http://tempuri.org/Subtract"));
        return response;
    }
}
