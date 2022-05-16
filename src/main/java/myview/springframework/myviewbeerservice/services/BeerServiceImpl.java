package myview.springframework.myviewbeerservice.services;

import lombok.RequiredArgsConstructor;
import myview.springframework.myviewbeerservice.domain.Beer;
import myview.springframework.myviewbeerservice.repositories.BeerRepository;
import myview.springframework.myviewbeerservice.web.controller.NotFoundException;
import myview.springframework.myviewbeerservice.web.mappers.BeerMapper;
import myview.springframework.myviewbeerservice.web.model.BeerDto;
import org.springframework.stereotype.Service;

import java.util.UUID;

@RequiredArgsConstructor
@Service
public class BeerServiceImpl implements BeerService {
    private final BeerRepository beerRepository;
    private final BeerMapper beerMapper;
    @Override
    public BeerDto getById(UUID beerId) {
        //Replaced lambda with method reference
        //it will either return the beer by id or else throw NotFoundException
        return beerMapper.beerToBeerDto(beerRepository.findById(beerId).orElseThrow(NotFoundException::new));
       // return beerMapper.beerToBeerDto(beerRepository.findById(beerId).orElseThrow(()->new NotFoundException()));
    }

    @Override
    public BeerDto saveNewBeer(BeerDto beerDto) {
        //save takes Beer entity, hence beerMapper is used to convert beerDto to beer and
        //while returning, this needs to be converted back as beerDto
        return beerMapper.beerToBeerDto(beerRepository.save(beerMapper.beerDtoToBeer(beerDto)));
    }

    @Override
    public BeerDto updateBeer(UUID beerId, BeerDto beerDto) {
        Beer beer = beerRepository.findById(beerId).orElseThrow(NotFoundException::new);
        beer.setBeerName(beerDto.getBeerName());
        beer.setBeerStyle(beerDto.getBeerStyleEnum().name());
        beer.setPrice(beerDto.getPrice());
        beer.setUpc(beerDto.getUpc());
        return beerMapper.beerToBeerDto(beerRepository.save(beer));
    }
}
