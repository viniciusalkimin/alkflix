package br.com.vinicius.viniflix.service;

import br.com.vinicius.viniflix.dto.SerieDto;
import br.com.vinicius.viniflix.model.Serie;
import br.com.vinicius.viniflix.repository.SerieRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class SerieService {
    @Autowired
    private SerieRepository repository;

    public Page<SerieDto> listSeries(String nameSerie, Pageable pagination) {

        if (nameSerie != null) {
            Page<Serie> list = repository.findByName(nameSerie, pagination);
            return SerieDto.converter(list);
        } else {
            Page<Serie> list = repository.findAll(pagination);
            return SerieDto.converter(list);
        }
    }

    public Optional<SerieDto> serieById(Integer id) {
        Optional<Serie> serie = repository.findById(id);
        Optional<SerieDto> serieDto = serie.map(e -> new SerieDto(e));
        return serieDto;
    }

    public ResponseEntity<SerieDto> saveSerie(Serie serie) {
        repository.save(serie);
        return ResponseEntity.ok().build();
    }

    public ResponseEntity<SerieDto> updateSerie(Integer id, SerieDto serieDto){
        Optional<Serie> optional = repository.findById(id);
        if (optional.isPresent()) {
            Serie newSerie = serieDto.update(id, repository);
            repository.save(newSerie);
            return ResponseEntity.ok().build();
        }
        return ResponseEntity.notFound().build();
    }

    public ResponseEntity<SerieDto> deleteOne(Integer id) {
        if(repository.findById(id).isPresent()) {
            repository.deleteById(id);
            return ResponseEntity.ok().build();
        }else
          return ResponseEntity.notFound().build();
    }

    public List<Serie> all() {
        return repository.findAll();
    }
}
