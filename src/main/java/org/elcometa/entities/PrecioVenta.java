package org.elcometa.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="precio_venta")
public class PrecioVenta {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@Column(name="clave", nullable = false)
	private int clave;
	@Column(name="costo_materia_prima", nullable = false)
	private double costoMateriaPrima;
	@Column(name="precio", nullable = false)
	private double precio;
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public int getClave() {
		return clave;
	}
	public void setClave(int clave) {
		this.clave = clave;
	}
	public double getCostoMateriaPrima() {
		return costoMateriaPrima;
	}
	public void setCostoMateriaPrima(double costoMateriaPrima) {
		this.costoMateriaPrima = costoMateriaPrima;
	}
	public double getPrecio() {
		return precio;
	}
	public void setPrecio(double precio) {
		this.precio = precio;
	}
	

}
