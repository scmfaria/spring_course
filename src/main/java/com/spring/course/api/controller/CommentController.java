package com.spring.course.api.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/order-service/{orderServiceId}/comentario")
public class CommentController {

    @Autowired 
    private OrderServiceService orderServiceService;

    @Autowired
    private OrderServiceRepository serviceRepository;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Comment add(@PathVariable Long orderServiceId, 
                @Valid @RequestBody Comment commentPost) {
        return orderServiceService.addComment(orderServiceId, commentPost);
    }

    @GetMapping
    public List<Comment> list(@PathVariable Long orderServiceId) {
        OrderService orderService = serviceRepository.findById(orderServiceId)
                .orElseThrow(() -> new NotFoundException("Ordem de serviço não encontrada"));

        return orderService.getComments();
    }


}