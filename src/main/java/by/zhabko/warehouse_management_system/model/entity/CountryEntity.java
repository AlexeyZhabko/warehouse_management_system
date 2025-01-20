package by.zhabko.warehouse_management_system.model.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@Entity
@NoArgsConstructor
@Table(name = "countries", schema = "warehouse")
public class CountryEntity {

  @Id
  @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "countries_id_gen")
  @SequenceGenerator(name = "countries_id_gen", sequenceName = "warehouse.countries_id_seq", allocationSize = 1)
  @Column(name = "id", nullable = false)
  private Long id;

  @Column(name = "name", nullable = false, length = 200)
  private String name;

  public CountryEntity(String name) {
    this.name = name;
  }
}