package com.spring.course.api.domain.service;

@Service
public class OrderServiceService {

    @Autowired
    private OrderServiceRepository repository;

    @Autowired
    private ClientRepository clientRepository;

    public OrderService create(OrderService orderService) {
        Client client = clientRepository.findById(orderService.getClient().getId())
                .orElseThrow(() -> new BusinessException("Cliente não encontrado"));
                
        orderService.setStatus(StatusOrderService.ABERTA)
        orderService.setDateOpen(LocalDateTime.now());

        return repository.save(orderService);
    }
}