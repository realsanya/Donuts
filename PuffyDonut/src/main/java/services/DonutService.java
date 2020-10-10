package services;

import models.Donut;

import java.util.List;

public interface DonutService {
    List<Donut> getAllDonuts();

    List<Donut> getAllDonutsByTag(String tag);

    List<Donut> getAllDonutsByWeight(Integer weight);
}
