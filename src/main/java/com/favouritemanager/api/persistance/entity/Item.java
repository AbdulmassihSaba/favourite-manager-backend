package com.favouritemanager.api.persistance.entity;

import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

@Entity
@Table(name = "item")
//@Table(@UniqueConstraint(columnNames = {"", ""}))
@Getter
@Setter
@ToString
@EqualsAndHashCode
@AllArgsConstructor
@NoArgsConstructor
public class Item {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", unique = true, nullable = false)
    private Long id;
    @ManyToOne(optional = false, fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    //@JoinColumn(name = "category_id")
    //@Fetch(FetchMode.JOIN)
    @JoinColumn(referencedColumnName = "id", nullable = false)
    private Category category;
    @Column
    private String link;
    @Column
    private String label;
    @Column(name = "updated_at")
    private String updatedAt;
}
