package services.interfaces;

import models.Delivery;

public interface DeliveryService {
    void addDelivery(Delivery delivery);

    Delivery getDeliveryById(Long id);
}
