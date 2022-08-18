package br.com.vinicius.viniflix.service;

import br.com.vinicius.viniflix.dto.SerieDto;
import br.com.vinicius.viniflix.model.Serie;
import br.com.vinicius.viniflix.repository.SerieRepository;
import lombok.AllArgsConstructor;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class SerieService {

    private SerieRepository repository;

    public Page<Serie> listSeries(String nameSerie, Pageable pagination) {

        if (nameSerie != null) {
            return repository.findByName(nameSerie, pagination);
        }
        return repository.findAll(pagination);
    }

    public Optional<Serie> serieById(Integer id) {
        return repository.findById(id);
    }

    public Serie saveSerie(SerieDto serieDto) {
        var serie = new Serie();
        BeanUtils.copyProperties(serieDto, serie);
        return repository.save(serie);
    }

    public Serie updateSerie(SerieDto serieDto) {
        var serie = new Serie();
        BeanUtils.copyProperties(serieDto, serie);
        return repository.save(serie);
    }

    public void deleteOne(Serie serie) {
        repository.delete(serie);
    }

    public List<Serie> all() {
        return repository.findAll();
    }
}
