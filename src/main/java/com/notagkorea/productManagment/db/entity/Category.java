package com.notagkorea.productManagment.db.entity;

import com.notagkorea.productManagment.db.type.Division;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.hibernate.envers.AuditOverride;
import javax.persistence.*;

@Entity
@Getter
@NoArgsConstructor
@Builder
@AuditOverride(forClass = BaseEntity.class)
public class Category extends BaseEntity{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "category_id")
    private Long categoryId;

    private String categoryCode;

    private String categoryName;

    @Enumerated(EnumType.STRING)
    private Division division;

    public Category(Long categoryId, String categoryCode, String categoryName, Division division) {
        this.categoryId = categoryId;
        this.categoryCode = categoryCode;
        this.categoryName = categoryName;
        this.division = division;
    }
}
