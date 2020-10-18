package services;

import models.Donut;

import java.util.List;
import java.util.Optional;

public interface DonutService {
    List<Donut> getAllDonuts();

    Optional<Donut> getDonutById(Long id);

    List<Donut> getAllDonutsByTag(String tag);

    List<Donut> getAllDonutsByWeight(Integer weight);
}
