package andrei.springboot.fotbal_proiect.service.utils;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;
import java.io.InputStream;


public final class JsonReader {

    private static final ObjectMapper objectMapper = new ObjectMapper();

    public static <T> T read(String filePath, Class<T> valueType) {
        var inputStream = JsonReader.class.getClassLoader().getResourceAsStream(filePath);
        if (inputStream == null) {
            throw new RuntimeException("Resource not found: " + filePath);
        }
        try {
            return objectMapper.readValue(inputStream, valueType);
        } catch (IOException e) {
            throw new RuntimeException("Error on reading file %s | %s".formatted(filePath, e.getMessage()), e);
        }
    }

    public static <T> T read(String filePath, TypeReference<T> valueTypeRef) {
        var inputStream = JsonReader.class.getClassLoader().getResourceAsStream(filePath);
        if (inputStream == null) {
            throw new RuntimeException("Resource not found: " + filePath);
        }
        try {
            return objectMapper.readValue(inputStream, valueTypeRef);
        } catch (IOException e) {
            throw new RuntimeException("Error reading from resource " + filePath + " | " + e.getMessage(), e);
        }
    }
}
