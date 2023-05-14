package com.pdf.demo;

import com.pdf.DTO.DataDto;
import org.thymeleaf.TemplateEngine;
import org.thymeleaf.context.Context;
import org.thymeleaf.templateresolver.ClassLoaderTemplateResolver;

import java.io.StringWriter;
import java.util.List;

public class HTMLGenerator {
    public static String generateHTMLTable(List<DataDto> dataList) {
        Context context = new Context();
        context.setVariable("dataList", dataList);

        ClassLoaderTemplateResolver resolver = new ClassLoaderTemplateResolver();
        resolver.setTemplateMode("HTML");

        TemplateEngine engine = new TemplateEngine();
        engine.setTemplateResolver(resolver);

        StringWriter writer = new StringWriter();
        engine.process("bom.html", context, writer);

        return writer.toString();
    }
}
