package com.spring.course.api.controller;

import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/ordens-servico")
public class OrderServiceController {
    
    @Autowired
    private ModelMapper modelMapper;

    @Autowired
    private OrderServiceRepository serviceRepository;

    @Autowired
    private OrderServiceService orderService;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public OrderServiceModel create(@Valid @RequestBody OrderService order) {
        return toModel(orderService.create(order));
    }

    @GetMapping
    public List<OrderService> list() {
        return toCollectionModel(serviceRepository.findAll());
    }

    @GetMapping("/{orderServiceId}")
    public ResponseEntity<OrderServiceModel> search(@PathVariable Long orderServiceId) {
        Optional<OrderService> order = serviceRepository.findById(orderServiceId);

        if(order.isPresent()) {
            OrderServiceModel model = toModel(order.get());
            return ResponseEntity.ok(model);
        }

        return ResponseEntity.notFound().build();
    }

    private OrderServiceModel toModel(OrderService orderService) {
        return modelMapper.map(orderService, OrderServiceModel.class);
    }

    private List<OrderServiceModel> toCollectionModel(List<OrderService> orderServices) {
        return orderServices.stream()
                .map(orderService -> toModel(orderService))
                .collect(Collectors.toList());
    }
}