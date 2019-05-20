package entity;

import javax.persistence.*;
import java.util.UUID;

@Entity
@Table(name = "valid_client")
public class ValidClient {
    @Id
    @Column(name = "uuid", length = 16)
    private UUID uuid;

    @Column(name = "name")
    private String name;

    @OneToOne(fetch = FetchType.LAZY)
    @MapsId
    @JoinColumn(name = "uuid")
    //private Client client;
    // TODO
    //  Наладить передачу объекта

    public UUID getUuid() {
        return uuid;
    }

    public void setUuid(UUID uuid) {
        this.uuid = uuid;
    }
}
