package com.spring.course.api.domain.model;

@Entity
public class Comment {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    private OrderService orderService;

    private String description;

    private OffsetDateTime dateSend;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public OrderService getOrderService() {
        return orderService;
    }

    public void setOrderService(OrderService orderService) {
        this.orderService = orderService;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public OffsetDateTime getDateSend() {
        return dateSend;
    }

    public void setDateSend(OffsetDateTime dateSend) {
        this.dateSend = dateSend;
    }
}