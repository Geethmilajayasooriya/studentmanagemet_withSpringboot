/*package com.example.stumanagement.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Entity
@Table(name = "course")
public class courseentity {
    @Id
    private String courseid;
    private String name;
    private String credit;
    private String semester;
    private Boolean compulsory;
    private String department;
    private String status;
}
*/
package com.example.stumanagement.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.EqualsAndHashCode;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@Entity
@Table(name = "course")
public class courseentity {

    @Id
    @EqualsAndHashCode.Include  // ✅ Only this field used in equals/hashCode
    private String courseid;

    private String name;
    private String credit;
    private String semester;
    private Boolean compulsory;
    private String department;
    private String status;
}
