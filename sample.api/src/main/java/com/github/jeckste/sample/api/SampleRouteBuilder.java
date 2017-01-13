/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.github.jeckste.sample.api;


import org.apache.camel.builder.RouteBuilder;
import org.apache.camel.cdi.ContextName;
import org.apache.camel.model.rest.RestBindingMode;



@ContextName("sample")
public class SampleRouteBuilder extends RouteBuilder {

    @Override
    public void configure() throws Exception {
    
        restConfiguration().component("servlet").bindingMode(RestBindingMode.json).skipBindingOnErrorCode(false);

        
        rest("/ping")
            .get()
            .outType(PingResponse.class)
            .route()
            .process(ex -> {
                PingResponse response = new PingResponse();
                response.setMessage("Hello world 3");
                response.setEnvironment(System.getenv("ENVIRONMENT"));
                ex.getOut().setBody(response);
            });
            
        
    }
}
