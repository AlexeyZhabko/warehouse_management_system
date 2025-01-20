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
import jakarta.persistence.OneToMany;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;
import java.util.List;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

@Getter
@Setter
@Entity
@Table(name = "delivery_notes", schema = "warehouse")
public class DeliveryNotesEntity {

  @Id
  @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "deliveryNotes_id_gen")
  @SequenceGenerator(name = "deliveryNotes_id_gen", sequenceName = "warehouse.deliveryNotes_id_seq", allocationSize = 1)
  @Column(name = "id", nullable = false)
  private Long id;

  @ManyToOne(fetch = FetchType.LAZY, optional = false, cascade = CascadeType.ALL)
  @OnDelete(action = OnDeleteAction.SET_NULL)
  @JoinColumn(name = "sellerId", nullable = false)
  private CompanyEntity seller;

  @ManyToOne(fetch = FetchType.LAZY, optional = false, cascade = CascadeType.ALL)
  @OnDelete(action = OnDeleteAction.SET_NULL)
  @JoinColumn(name = "customerId", nullable = false)
  private CompanyEntity customer;

  @Column(name = "totalPrice", nullable = false)
  private Long totalPrice;

  @OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL, mappedBy = "deliveryNote")
  @OnDelete(action = OnDeleteAction.CASCADE)
  private List<DeliveryNotesItemEntity> items;
}