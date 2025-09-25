package com.wellsfargo.counselor.entity;

import javax.persistence.*;
import java.time.Instant;

@Entity
@Table(name = "audit_log")
public class AuditLog {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "audit_id")
    private Long id;

    @Column(name = "entity_name")
    private String entityName;

    @Column(name = "entity_id")
    private Long entityId;

    @Column
    private String action; // "CREATE","UPDATE","DELETE"

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "changed_by_advisor_id")
    private Advisor changedBy;

    @Column
    private Instant timestamp;

    @Column(columnDefinition = "TEXT")
    private String details;

    public AuditLog() { }

    public AuditLog(Long id, String entityName, Long entityId, String action,
                    Advisor changedBy, Instant timestamp, String details) {
        this.id = id;
        this.entityName = entityName;
        this.entityId = entityId;
        this.action = action;
        this.changedBy = changedBy;
        this.timestamp = timestamp;
        this.details = details;
    }

    public Long getId() { return id; }
    public String getEntityName() { return entityName; }
    public void setEntityName(String entityName) { this.entityName = entityName; }
    public Long getEntityId() { return entityId; }
    public void setEntityId(Long entityId) { this.entityId = entityId; }
    public String getAction() { return action; }
    public void setAction(String action) { this.action = action; }
    public Advisor getChangedBy() { return changedBy; }
    public void setChangedBy(Advisor changedBy) { this.changedBy = changedBy; }
    public Instant getTimestamp() { return timestamp; }
    public void setTimestamp(Instant timestamp) { this.timestamp = timestamp; }
    public String getDetails() { return details; }
    public void setDetails(String details) { this.details = details; }
}
