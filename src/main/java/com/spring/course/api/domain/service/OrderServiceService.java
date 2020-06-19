package com.spring.course.api.domain.service;

@Service
public class OrderServiceService {

    @Autowired
    private OrderServiceRepository repository;

    @Autowired
    private ClientRepository clientRepository;

    @Autowired
    private CommentRepository commentRepository;

    public OrderService create(OrderService orderService) {
        Client client = clientRepository.findById(orderService.getClient().getId())
                .orElseThrow(() -> new BusinessException("Cliente não encontrado"));
                
        orderService.setStatus(StatusOrderService.ABERTA)
        orderService.setDateOpen(LocalDateTime.now());

        return repository.save(orderService);
    }

    public Comment addComment(Long orderServiceId, String description) {
        OrderService orderService = repository.findById(orderServiceId)
                .orElseThrow(() -> new NotFoundException("Ordem de serviço não encontrada"));

        Comment comment = new Comment();
        comment.setDescription(description);
        comment.setDateSend(OffsetDateTime.now());
        comment.setOrderService(orderService);

        return commentRepository.save(comment);
    }

    public void finishOrder(Long orderServiceId) {
        OrderService orderService = repository.findById(orderServiceId)
                .orElseThrow(() -> new NotFoundException("Ordem de serviço não encontrada"));

        if(!StatusOrderService.ABERTA.equals(orderService.getStatus())) {
            throw new BusinessException("Ordem de serviço não pode ser finalizada");
        }

        orderService.setStatus(StatusOrderService.FINALIZADA);
        orderService.setDateFinish(OffsetDateTime.now());

        repository.save(orderService);
    }
}