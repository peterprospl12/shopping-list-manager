package shopping.list.manager.productservice.listeners.impl;

import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.stereotype.Service;
import shopping.list.manager.enums.UserEvents;
import shopping.list.manager.events.UserEvent;
import shopping.list.manager.productservice.listeners.api.UserEventListener;
import shopping.list.manager.productservice.product.service.api.ProductService;

@Service
public class UserEventListenerDefault implements UserEventListener {

    private final ProductService productService;
    private final RabbitTemplate rabbitTemplate;

    public UserEventListenerDefault(ProductService productService, RabbitTemplate rabbitTemplate) {
        this.productService = productService;
        this.rabbitTemplate = rabbitTemplate;
    }

    @RabbitListener(queues = "${user.deleted.queue}")
    public void handleUserDeletedEvent(UserEvent event) {
        if(UserEvents.USER_DELETED.equals(event.getEventType())) {
            productService.deleteProductsForUser(event.getUserId());
        }
    }
}
