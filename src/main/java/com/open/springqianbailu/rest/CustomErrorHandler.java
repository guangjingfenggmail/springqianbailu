package com.open.springqianbailu.rest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.client.ClientHttpResponse;
import org.springframework.web.client.DefaultResponseErrorHandler;

import java.io.IOException;

public class CustomErrorHandler extends DefaultResponseErrorHandler {

    public  String TAG = getClass().getSimpleName();
        public Logger logger = LoggerFactory.getLogger(getClass().getSimpleName());

    @Override
    public void handleError(ClientHttpResponse response) throws IOException {
        logger.error(response.toString());
    }
}