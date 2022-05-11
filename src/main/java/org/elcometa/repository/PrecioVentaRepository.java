package org.elcometa.repository;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.inject.Named;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import org.elcometa.entities.PrecioVenta;

@Named
public class PrecioVentaRepository implements Serializable{
	
	private static final long serialVersionUID = 1L;
	
	@PersistenceContext(unitName = "demoWeb")
	private EntityManager em;
	
	public Long insert(PrecioVenta precioVenta) throws Exception 
	{
		em.persist(precioVenta);
		return precioVenta.getId();
	}
	
	public Long update(PrecioVenta precioVenta) throws Exception 
	{
		em.merge(precioVenta);
		return precioVenta.getId();
	}
	
	public List<PrecioVenta> findAll() throws Exception 
	{
		List<PrecioVenta> precioVentas = new ArrayList<>();
		TypedQuery<PrecioVenta> query = em.createQuery("From PrecioVenta pv", PrecioVenta.class);
		precioVentas = query.getResultList();
		return precioVentas;
	}
	
	public List<PrecioVenta> findByClave(int clave) throws Exception {
		List<PrecioVenta> precioVentas = new ArrayList<>();
		TypedQuery<PrecioVenta> query = em.createQuery("From PrecioVenta pv Where pv.clave=?1", PrecioVenta.class);
		query.setParameter(1, clave);
		precioVentas = query.getResultList();
		return precioVentas;
	}
}
