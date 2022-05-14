package myview.springframework.myviewbeerservice.web.mappers;

import myview.springframework.myviewbeerservice.domain.Beer;
import myview.springframework.myviewbeerservice.web.model.BeerDto;
import org.mapstruct.Mapper;

@Mapper(uses=DateMapper.class)
public interface BeerMapper {
    BeerDto beerToBeerDto(Beer beer);
    Beer beerDtoToBeer(BeerDto beerDto);
}
