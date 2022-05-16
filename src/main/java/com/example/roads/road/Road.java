package com.example.roads.road;

import javax.persistence.*;

@Entity

@Table(
        name ="roads"
)
public class RoadApi extends BaseEntity{
    @Id
    @GeneratedValue(
            strategy = GenerationType.IDENTITY
    )
    private int id;
    private String name;
    private String description;
    private int status;

    @OneToMany(
            mapppedBy ="Road",
            cascade={CascadeType.ALL}
    )

