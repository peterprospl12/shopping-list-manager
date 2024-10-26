package org.example.shoppinglistmanager;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.core.util.DefaultIndenter;
import com.fasterxml.jackson.core.util.DefaultPrettyPrinter;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.io.*;
import java.util.*;

@SpringBootApplication
public class ShoppingListManagerApplication {
    public static void main(String[] args) {
        SpringApplication.run(ShoppingListManagerApplication.class, args);
    }

    @Bean
    public ObjectWriter objectWriter() {
        return new ObjectMapper()
                .enable(SerializationFeature.INDENT_OUTPUT)
                .setDefaultPropertyInclusion(JsonInclude.Include.NON_NULL)
                .registerModule(new JavaTimeModule())
                .writer(new DefaultPrettyPrinter()
                        .withArrayIndenter(DefaultIndenter.SYSTEM_LINEFEED_INSTANCE));
    }

}
