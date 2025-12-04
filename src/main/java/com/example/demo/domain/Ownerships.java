package com.example.demo.domain;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Entity
@Getter
@Setter
public class Ownerships {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "product_id", nullable = false)
    private Products products;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id", nullable = false)
    private Users users;

    @Column(nullable = false)
    private LocalDateTime acquiredAt;

    private LocalDateTime releasedAt;

    // 서비스 계층에서 사용할 메서드들
    public static Ownerships acquire(Products product, Users user) {
        Ownerships ownership = new Ownerships();
        ownership.products = product;
        ownership.users = user;
        ownership.acquiredAt = LocalDateTime.now();
        return ownership;
    }

    public void release() {
        this.releasedAt = LocalDateTime.now();
    }

    public boolean isActive() {
        return this.releasedAt == null;
    }
}