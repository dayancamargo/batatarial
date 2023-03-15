package com.tutorial.batata.model.batata;

import com.tutorial.batata.repository.AuditCommons;
import com.tutorial.batata.repository.JpaListener;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.apache.commons.lang3.ObjectUtils;
import org.hibernate.envers.AuditOverride;
import org.springframework.util.CollectionUtils;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

@Entity
@EntityListeners(JpaListener.class)
@Table
@Getter @Setter
@NoArgsConstructor @AllArgsConstructor
@AuditOverride(forClass = AuditCommons.class)
public class FatherBatata extends AuditCommons implements Serializable {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column
    private String name;

    @Column
    private String type;

    @OneToMany(fetch = FetchType.LAZY)
    @JoinColumn(name = "father_id")
    private List<Batata> batatas;

    public FatherBatata(FatherBatataCreateDto dto) {
        if(dto != null) {
            this.id = dto.id();
            this.name = dto.name();
            this.type = dto.type();
        }
    }

    public FatherBatataDto toDto(){

        return new FatherBatataDto(this.id,
                                   this.name,
                                   this.type,
                                   this.getCreatedAt().toLocalDateTime(),
                                   this.getUpdatedAt().toLocalDateTime(),
                                   ObjectUtils.defaultIfNull(batatas, new ArrayList<Batata>()).stream().map(Batata::toDto).toList());
    }
}
