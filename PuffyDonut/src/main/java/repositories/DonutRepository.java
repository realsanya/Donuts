package repositories;

import models.Donut;

import java.util.List;

public interface DonutRepository extends OrmRepository<Donut> {
    List<Donut> findAllByTag(String tag);
    List<Donut> findAllByWeight(int weight);
}
