package com.spring.course.api.domain.service;

@Service
public class OrderServiceService {

    @Autowired
    private OrderServiceRepository repository;

    public OrderService create(OrderService orderService) {
        orderService.setStatus(StatusOrderService.ABERTA)
        orderService.setDateOpen(LocalDateTime.now());

        return repository.save(orderService);
    }
}