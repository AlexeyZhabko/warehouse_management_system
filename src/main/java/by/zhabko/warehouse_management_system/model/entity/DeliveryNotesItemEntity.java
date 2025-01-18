package by.zhabko.warehouse_management_system.model.entity;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "delivery_notes_items", schema = "warehouse")
public class DeliveryNotesItemEntity {

  @Id
  @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "delivery_notes_items_id_gen")
  @SequenceGenerator(name = "delivery_notes_items_id_gen", sequenceName = "warehouse.delivery_notes_items_id_seq", allocationSize = 1)
  @Column(name = "id", nullable = false)
  private Long id;

  @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
  @JoinColumn(name = "delivery_note_id", nullable = false)
  private DeliveryNotesEntity deliveryNote;

  @Column(name = "name", nullable = false, length = 200)
  private String name;

  @Column(name = "price", nullable = false)
  private Long price;

}