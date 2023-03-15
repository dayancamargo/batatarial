package com.tutorial.batata.model.batata;

import com.tutorial.batata.repository.AuditCommons;
import com.tutorial.batata.repository.JpaListener;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EntityListeners;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import org.hibernate.envers.AuditOverride;

import java.io.Serializable;

@Entity
@EntityListeners(JpaListener.class)
@Table
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@AuditOverride(forClass = AuditCommons.class)
public class Batata extends AuditCommons implements Serializable {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column
    private String name;

    @Column
    private String type;

    @Column(name = "father_id", nullable = false)
    private Integer fatherId;

    public Batata(BatataDto dto) {
        if(dto != null) {
            this.name = dto.name();
            this.type = dto.type();
            this.fatherId = dto.fatherId();
        }
    }

    public BatataDto toDto() {
        return new BatataDto(this.id,
                             this.name,
                             this.type,
                             this.fatherId,
                             this.getCreatedAt().toLocalDateTime(),
                             this.getUpdatedAt().toLocalDateTime());
    }

    @Override
    public String toString() {
       return ToStringBuilder.reflectionToString(this, ToStringStyle.JSON_STYLE);
    }
}
