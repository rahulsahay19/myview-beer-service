package myview.springframework.myviewbeerservice.web.controller;


import lombok.RequiredArgsConstructor;
import myview.springframework.myviewbeerservice.domain.Beer;
import myview.springframework.myviewbeerservice.services.BeerService;
import myview.springframework.myviewbeerservice.web.model.BeerDto;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RequiredArgsConstructor
@RequestMapping("/api/v1/beer")
@RestController
public class BeerController {
    private final BeerService beerService;

    @GetMapping("/{beerId}")
    public ResponseEntity<BeerDto> getBeerById(@PathVariable("beerId") UUID beerId){

        return new ResponseEntity<>(beerService.getById(beerId), HttpStatus.OK);
        //return new ResponseEntity<>(BeerDto.builder().build(), HttpStatus.OK);
      //  return new ResponseEntity<>(BeerDto.builder();
/*                .id(UUID.randomUUID())
                .beerName("Galaxy Cat")
                .build(), HttpStatus.OK);*/
    }

    @PostMapping
    public ResponseEntity<BeerDto> saveNewBeer(@RequestBody BeerDto beerDto){
        return new ResponseEntity<>(beerService.saveNewBeer(beerDto), HttpStatus.CREATED);
        //return new ResponseEntity<>(HttpStatus.CREATED);
       /* return new ResponseEntity<>(BeerDto.builder()
                .id(UUID.randomUUID())
                .build(), HttpStatus.CREATED);*/
    }

    @PutMapping("/{beerId}")
    public ResponseEntity<BeerDto> updateBeerById(@PathVariable("beerId") UUID beerId,@RequestBody BeerDto beerDto){
        return new ResponseEntity<>(beerService.updateBeer(beerId, beerDto), HttpStatus.NO_CONTENT);
        //return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
