package myview.springframework.myviewbeerservice.web.model;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.json.JsonTest;

import java.io.IOException;

import static org.junit.jupiter.api.Assertions.*;

@JsonTest
class BeerDtoTest extends BaseTest {
    //object mapper configured by spring boot
    @Autowired
    ObjectMapper objectMapper;
    //Serializing to json
    @Test
    void testSerializedDto() throws JsonProcessingException {
        BeerDto beerDto = getDto();
        String jsonString = objectMapper.writeValueAsString(beerDto);
        System.out.println(jsonString);
    }

    //DeSerializing from json
    @Test
    void testDeserialize() throws IOException {
        //String json = "{\"beerName\":\"BeerName\",\"beerStyle\":\"Ale\",\"upc\":123123123123,\"price\":\"12.99\",\"createdDate\":\"2019-06-03T21:01:53-0400\",\"lastUpdatedDate\":\"2019-06-03T21:01:53.628287-04:00\",\"localDate\":\"20220516\",\"beerId\":\"8ed4c7eb-ef3a-437e-823e-a26497ed7e71\"}\n";
        String json = "{\"beerName\":\"BeerName\",\"beerStyle\":\"Ale\",\"upc\":123123123123,\"price\":\"12.99\",\"createdDate\":\"2019-06-03T21:01:53-0400\",\"lastUpdatedDate\":\"2019-06-03T21:01:53.628287-04:00\",\"beerId\":\"8ed4c7eb-ef3a-437e-823e-a26497ed7e71\"}\n";
        BeerDto dto = objectMapper.readValue(json, BeerDto.class);

        System.out.println(dto);

    }
}