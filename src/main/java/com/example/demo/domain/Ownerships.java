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
    private Products product;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id", nullable = false)
    private Users user;

    @Column(nullable = false)
    private LocalDateTime acquiredAt;

    private LocalDateTime releasedAt;

    // 서비스 계층에서 사용할 메서드들
    public static Ownerships create(Products product, Users user) {
        Ownerships ownership = new Ownerships();
        ownership.product = product;
        ownership.user = user;
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