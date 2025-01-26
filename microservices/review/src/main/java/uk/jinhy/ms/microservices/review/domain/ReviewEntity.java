package uk.jinhy.ms.microservices.review.domain;

import jakarta.persistence.*;
import lombok.*;

import org.hibernate.annotations.UuidGenerator;
import uk.jinhy.ms.util.persistence.BaseEntity;

@Entity
@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class ReviewEntity extends BaseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(unique = true, nullable = false)
    private String uuid;

    @Column(nullable = false)
    private String content;

    @Column(nullable = false)
    private int ticketId;

    @Column(nullable = false)
    private int userId;

    private void setUuid(String uuid) {
        this.uuid = uuid;
    }

    @PrePersist
    protected void onCreate() {
        setUuid(java.util.UUID.randomUUID().toString());
    }
}
