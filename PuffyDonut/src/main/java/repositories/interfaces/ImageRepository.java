package repositories.interfaces;

import models.Image;
import models.User;

public interface ImageRepository extends OrmRepository<Image> {
    Image findByPath(String path);

    Integer update(Image image);
}
