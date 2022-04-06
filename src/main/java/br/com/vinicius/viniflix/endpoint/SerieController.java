package br.com.vinicius.viniflix.endpoint;

import br.com.vinicius.viniflix.dto.SerieDto;
import br.com.vinicius.viniflix.model.Serie;
import br.com.vinicius.viniflix.service.SerieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/series")
public class SerieController {

    @Autowired
    private SerieService serieService;

    @GetMapping
    public ResponseEntity<Page<Serie>> listSeries(@RequestParam(required = false) String nameSerie,
                                                  @PageableDefault(sort = "id", direction = Sort.Direction.ASC, size = 5, page = 0) Pageable pagination) {
        return ResponseEntity.status(HttpStatus.OK).body(serieService.listSeries(nameSerie, pagination));
    }

    @GetMapping("/{id}")
    public ResponseEntity<Object> getOneSerie(@PathVariable Integer id) {
        Optional<Serie> serie = serieService.serieById(id);
        if (!serie.isPresent()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Serie Not Found!");
        }
        return ResponseEntity.status(HttpStatus.OK).body(serie);
    }

    @PostMapping
    public ResponseEntity<Serie> newSerie(@RequestBody SerieDto serieDto) {
        return ResponseEntity.status(HttpStatus.OK).body(serieService.saveSerie(serieDto));
    }

    @PutMapping
    public ResponseEntity<Serie> updateSerie(@RequestBody Serie serie) {
        return ResponseEntity.status(HttpStatus.OK).body(serieService.updateSerie(serie));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Object> deleteById(@PathVariable Integer id) {
        Serie serie = serieService.serieById(id).get();
        if ( serie == null) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Serie Not Found!");
        }
        serieService.deleteOne(serie);
        return ResponseEntity.status(HttpStatus.OK).body("Serie deleted!");
    }

    @GetMapping("/all")
    public List<Serie> all() {
        return serieService.all();
    }
}

