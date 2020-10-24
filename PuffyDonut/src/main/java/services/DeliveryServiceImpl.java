package services;

import models.Delivery;
import repositories.interfaces.DeliveryRepository;
import services.interfaces.DeliveryService;

public class DeliveryServiceImpl implements DeliveryService {
    private DeliveryRepository deliveryRepository;

    public DeliveryServiceImpl(DeliveryRepository deliveryRepository) {
        this.deliveryRepository = deliveryRepository;
    }

    @Override
    public void addDelivery(Delivery delivery) {
        deliveryRepository.save(delivery);
    }

    @Override
    public Delivery getDeliveryById(Long id) {
        return deliveryRepository.findById(id);
    }
}
