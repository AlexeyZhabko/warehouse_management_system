package by.zhabko.warehouse_management_system.entity;

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
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

@Getter
@Setter
@Entity
@Table(name = "DeliveryNotes", schema = "warehouse")
public class DeliveryNotesEntity {

  @Id
  @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "DeliveryNotes_id_gen")
  @SequenceGenerator(name = "DeliveryNotes_id_gen", sequenceName = "DeliveryNotes_id_seq", allocationSize = 1)
  @Column(name = "id", nullable = false)
  private Long id;

  @ManyToOne(fetch = FetchType.LAZY, optional = false)
  @OnDelete(action = OnDeleteAction.SET_NULL)
  @JoinColumn(name = "sellerId", nullable = false)
  private CountryEntity seller;

  @ManyToOne(fetch = FetchType.LAZY, optional = false)
  @OnDelete(action = OnDeleteAction.SET_NULL)
  @JoinColumn(name = "customerId", nullable = false)
  private CountryEntity customer;

  @Column(name = "totalPrice", nullable = false)
  private Long totalPrice;
}