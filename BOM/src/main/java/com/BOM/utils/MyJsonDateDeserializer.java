package com.BOM.utils;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;

import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

public class MyJsonDateDeserializer extends JsonDeserializer<Date> {
    @Override
    public Date deserialize(JsonParser jsonparser, DeserializationContext deserializationcontext)
            throws IOException, JsonProcessingException {
        Date dateResponse = null;
        try {

            String date = jsonparser.getText() + "";
            if (date.length() <= 10) {
                DateFormat df = new SimpleDateFormat("MM/dd/yyyy HH:mm:ss.SSS");
                String timeString = df.format(new Date()).substring(10); // 10 is the beginIndex of time here

                date = date + timeString;
            }

            try {
                if (date.contains("T")) {
                    dateResponse = VariableUtils.SIMPLE_DATE_FORMAT_OF_DATABASE_AWS.parse(date);
                } else if (date.length() == 19) {
                    dateResponse = VariableUtils.SIMPLE_DATE_FORMAT_OF_DATABASE2.parse(date);
                } else {
                    dateResponse = VariableUtils.SIMPLE_DATE_FORMAT_OF_DATABASE.parse(date);
                }
            } catch (Exception e) {
                System.err.println("second exception from MyJsonDateDeserializer " + e.getMessage());
            }

        } catch (Exception e) {
            System.err.println("first exception from MyJsonDateDeserializer " + e.getMessage());
        }

        return dateResponse;
    }
}
