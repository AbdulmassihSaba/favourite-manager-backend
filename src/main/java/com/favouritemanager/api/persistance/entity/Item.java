package com.favouritemanager.api.persistance.entity;

import jakarta.persistence.*;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Entity
@Table(name = "item")
@Getter
@Setter
@ToString
@EqualsAndHashCode
public class Item {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", unique = true, nullable = false)
    private Long id;
    @ManyToOne(optional = false, fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    //@JoinColumn(name = "category_id")
    @JoinColumn(referencedColumnName = "id", nullable = false)
    private Category category;
    @Column
    private String link;
    @Column
    private String label;
    @Column(name = "updated_at")
    private String updatedAt;
}
