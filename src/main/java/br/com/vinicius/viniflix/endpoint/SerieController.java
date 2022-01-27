package br.com.vinicius.viniflix.endpoint;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.web.bind.annotation.*;

import br.com.vinicius.viniflix.dto.SerieDto;
import br.com.vinicius.viniflix.model.Serie;
import br.com.vinicius.viniflix.repository.SerieRepository;

import java.util.Optional;

@RestController
@RequestMapping("/series")
public class SerieController {

    @Autowired
    private SerieRepository serieRepository;

    @GetMapping
    public Page<SerieDto> listSeries(@RequestParam(required = false) String nameSerie,@PageableDefault(sort = "name", direction = Sort.Direction.ASC, size = 5, page = 0) Pageable pagination) {
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
	public Optional<SerieDto> serieId(@PathVariable Integer id){
	    Optional<Serie> serie = serieRepository.findById(id);
        Optional<SerieDto> serieDto = serie.map(e -> new SerieDto(e));
        return serieDto;
	}


}

