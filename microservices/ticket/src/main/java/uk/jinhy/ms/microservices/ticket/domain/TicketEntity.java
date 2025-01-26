package uk.jinhy.ms.microservices.ticket.domain;

import jakarta.persistence.*;
import lombok.*;

import org.hibernate.annotations.UuidGenerator;
import uk.jinhy.ms.util.persistence.BaseEntity;

@Entity
@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class TicketEntity extends BaseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(unique = true, nullable = false)
    private String uuid;

    @Column(unique = true, nullable = false)
    private String name;

    private void setUuid(String uuid) {
        this.uuid = uuid;
    }

    @PrePersist
    protected void onCreate() {
        setUuid(java.util.UUID.randomUUID().toString());
    }
}
