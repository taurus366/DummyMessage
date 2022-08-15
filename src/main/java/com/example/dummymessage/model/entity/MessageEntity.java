package com.example.dummymessage.model.entity;

import com.example.dummymessage.model.enums.MessageType;
import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.*;
import java.time.Instant;

@Entity
@Table(name = "messages")
public class MessageEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;

    @Enumerated(EnumType.STRING)
    @Column
    private MessageType type;

    @Column
    private String payload;

    @CreationTimestamp
    @Column
    private Instant created_at;

    public MessageType getType() {
        return type;
    }

    public MessageEntity setType(MessageType type) {
        this.type = type;
        return this;
    }

    public String getPayload() {
        return payload;
    }

    public MessageEntity setPayload(String payload) {
        this.payload = payload;
        return this;
    }

    public Instant getCreated_at() {
        return created_at;
    }

//    public MessageEntity setCreated_at(Instant created_at) {
//        this.created_at = created_at;
//        return this;
//    }

    public Long getId() {
        return id;
    }

//    public void setId(Long id) {
//        this.id = id;
//    }
}
