package br.com.vinicius.viniflix.endpoint;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
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
    private SerieRepository serieRepository;

    @GetMapping
    public Page<SerieDto> listSeries(@RequestParam(required = false) String nameSerie,@PageableDefault(sort = "id", direction = Sort.Direction.ASC, size = 5, page = 0) Pageable pagination) {
        //Page<SerieDto> dto = list.map(SerieDto::new);
        //return dto;
        //return SerieDto.converter(list);
        if (nameSerie != null) {
            Page<Serie> list = serieRepository.findByName(nameSerie, pagination);
            return SerieDto.converter(list);
        } else {
            Page<Serie> list = serieRepository.findAll(pagination);
            return SerieDto.converter(list);
        }
    }

	@GetMapping("/{id}")
	public Optional<SerieDto> listSeries(@PathVariable Integer id){
	    Optional<Serie> serie = serieRepository.findById(id);
        Optional<SerieDto> serieDto = serie.map(e -> new SerieDto(e));

        return serieDto;
	}

    @PostMapping
    public ResponseEntity<Serie> newSerie (@RequestBody @Valid Serie serie){
        serieRepository.save(serie);
        return ResponseEntity.ok().build();
    }

    @PutMapping("/{id}")
    public ResponseEntity<Serie> updateSerie(@PathVariable Integer id, @RequestBody SerieDto serieDto){
        Optional<Serie> optional = serieRepository.findById(id);
        if (optional.isPresent()) {
            Serie newSerie = serieDto.update(id,serieRepository);
            serieRepository.save(newSerie);
            return ResponseEntity.ok().build();
        }
        return ResponseEntity.notFound().build();
    }


    @GetMapping("/all")
    public List<Serie> all(){
        return serieRepository.findAll();
    }


}

