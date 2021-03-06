package myview.springframework.myviewbeerservice.web.model;

import java.math.BigDecimal;
import java.time.OffsetDateTime;
import java.util.UUID;

public class BaseTest {
    BeerDto getDto(){
        return BeerDto.builder()
                .beerName("BeerName")
                .beerStyleEnum(BeerStyleEnum.ALE)
                .id(UUID.randomUUID())
                .createdDate(OffsetDateTime.now())
                .lastModifiedDate(OffsetDateTime.now())
                .price(new BigDecimal("12.99"))
                .upc("123123123123")
                //.localDate(LocalDate.now())
                .build();
    }
}
