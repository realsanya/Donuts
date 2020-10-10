package services;

import models.Donut;
import repositories.DonutRepository;

import java.util.List;

public class DonutServiceImpl implements DonutService {

    private DonutRepository donutRepository;

    public DonutServiceImpl(DonutRepository donutRepository) {
        this.donutRepository = donutRepository;
    }

    @Override
    public List<Donut> getAllDonuts() {
        return donutRepository.findAll();
    }

    @Override
    public List<Donut> getAllDonutsByTag(String tag) {
        return donutRepository.findAllByTag(tag);
    }

    @Override
    public List<Donut> getAllDonutsByWeight(Integer weight) {
        return donutRepository.findAllByWeight(weight);
    }
}
