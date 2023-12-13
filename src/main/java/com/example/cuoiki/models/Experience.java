package com.example.cuoiki.models;

import com.example.cuoiki.Roles;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Date;

@Entity
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Experience {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "experience_id")
    private long id;
    private Date fromDate;
    private Date toDate;
    private String companyName;
    private String workDescription;
    @Enumerated(EnumType.ORDINAL)
    private Roles role;
    @ManyToOne
    @JoinColumn(name = "candidate_id")
    private Candidate candidate;
    @Override
    public String toString() {
        return "Experience{" +
                "id=" + id +
                ", fromDate=" + fromDate +
                ", toDate=" + toDate +
                ", companyName='" + companyName + '\'' +
                ", workDescription='" + workDescription + '\'' +
                ", role=" + role +
                // ", candidate=" + candidate +  // Loại bỏ dòng này
                '}';
    }

}
