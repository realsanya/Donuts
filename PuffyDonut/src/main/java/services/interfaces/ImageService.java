package services.interfaces;

import models.Image;

import java.util.List;

public interface ImageService {

    List<Image> getAll();

    Image getById(Integer id);

    void addImage(Image image);

    Image getByPath(String path);

    Integer update(Image image);

}
