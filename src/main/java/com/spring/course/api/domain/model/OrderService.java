package com.spring.course.api.domain.model;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Entity
public class OrderService {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull
    @ManyToOne
    private Client client;

    @NotBlank
    private String description;

    @NotNull
    private BigDecimal price;

    @Enumerated(EnumType.STRING)
    @JsonProperty(access = Access.READ_ONLY)
    private StatusOrderService status;

    @JsonProperty(access = Access.READ_ONLY)
    private LocalDateTime dateOpen;

    @JsonProperty(access = Access.READ_ONLY)
    private LocalDateTime dateFinish;

    @OneToMany(mappedBy = "orderService")
    private List<Comment> comments = new ArrayList<>();

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public StatusOrderService getStatus() {
        return status;
    }

    public void setStatus(StatusOrderService status) {
        this.status = status;
    }

    public LocalDateTime getDateOpen() {
        return dateOpen;
    }

    public void setDateOpen(LocalDateTime dateOpen) {
        this.dateOpen = dateOpen;
    }
    
    public LocalDateTime getDateFinish() {
        return dateFinish;
    }

    public void setDateFinish(LocalDateTime dateFinish) {
        this.dateFinish = dateFinish;
    }

    public void setComments(List<Comment> comments) {
        this.comments = comments;
    }

    public List<Comment> getComments() {
        return comments;
    }
}