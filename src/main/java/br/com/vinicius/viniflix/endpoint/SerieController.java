package br.com.vinicius.viniflix.endpoint;

import br.com.vinicius.viniflix.Service.SerieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import br.com.vinicius.viniflix.dto.SerieDto;
import br.com.vinicius.viniflix.model.Serie;
import br.com.vinicius.viniflix.repository.SerieRepository;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/series")
public class SerieController {

    @Autowired
    private SerieService serieService;

    @GetMapping
    public Page<SerieDto> listSeries(@RequestParam(required = false) String nameSerie, @PageableDefault(sort = "id", direction = Sort.Direction.ASC, size = 5, page = 0) Pageable pagination) {
        return serieService.listSeries(nameSerie, pagination);
    }

    @GetMapping("/{id}")
    public Optional<SerieDto> listSeries(@PathVariable Integer id) {
        return serieService.serieById(id);
    }

    @PostMapping
    public ResponseEntity<SerieDto> newSerie(@RequestBody @Valid Serie serie) {
        return serieService.saveSerie(serie);
    }

    @PutMapping("/{id}")
    public ResponseEntity<SerieDto> updateSerie(@PathVariable Integer id, @RequestBody SerieDto serieDto) {
        return serieService.updateSerie(id, serieDto);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<SerieDto> deleteById(@PathVariable Integer id){
        return serieService.deleteOne(id);
    }

    @GetMapping("/all")
    public List<Serie> all() {
        return serieService.all();
    }
}

