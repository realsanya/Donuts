package services;

import models.Image;
import repositories.ImageRepositoryJdbc;
import repositories.interfaces.ImageRepository;
import services.interfaces.ImageService;

import java.util.List;

public class ImageServiceImpl implements ImageService {

    ImageRepository imageRepository;

    public ImageServiceImpl(ImageRepository imageRepository) {
        this.imageRepository = imageRepository;
    }

    @Override
    public List<Image> getAll() {
        return imageRepository.findAll();
    }

    @Override
    public Image getById(Integer id) {
        return imageRepository.findById(id);
    }

    @Override
    public void addImage(Image image) {
        imageRepository.save(image);
    }

    @Override
    public Image getByPath(String path) {
        return imageRepository.findByPath(path);
    }

    @Override
    public Integer update(Image image) {
        return imageRepository.update(image);
    }
}
