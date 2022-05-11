package org.elcometa.business;

import java.io.Serializable;
import java.util.List;

import javax.inject.Inject;
import javax.inject.Named;
import javax.transaction.Transactional;

import org.elcometa.entities.PrecioVenta;
import org.elcometa.repository.PrecioVentaRepository;

@Named
public class PrecioVentaBusiness implements Serializable{
	

	private static final long serialVersionUID = 1L;
	
	@Inject
	private PrecioVentaRepository precioVentaRepository;
	
	@Transactional
	public Long registrarPrecioVenta (PrecioVenta precioVenta) throws Exception 
	{
		precioVenta.setPrecio(obtenerPrecioVenta(precioVenta));
		return precioVentaRepository.insert(precioVenta);
	}
	
	public List<PrecioVenta> listarPrecioVenta() throws Exception 
	{
		return precioVentaRepository.findAll();
	}
	
	public List<PrecioVenta> obtenerPrecioVentasPorClave(int clave) throws Exception 
	{
		return precioVentaRepository.findByClave(clave);
	}
	
	private double obtenerPrecioVenta (PrecioVenta precioVenta)  
	{
		double montoPrecioVenta, costoManoObra, costoGastoFabricacion, costoProduccion;
		
		if(precioVenta.getClave()==3 || precioVenta.getClave()==4)
			costoManoObra = 0.75*precioVenta.getCostoMateriaPrima();
		else if (precioVenta.getClave()==1 || precioVenta.getClave()==5)
			costoManoObra = 0.80*precioVenta.getCostoMateriaPrima();
		else
			costoManoObra = 0.85*precioVenta.getCostoMateriaPrima();
		
		if(precioVenta.getClave()==2 || precioVenta.getClave()==5)
			costoGastoFabricacion = 0.30*precioVenta.getCostoMateriaPrima();
		else if (precioVenta.getClave()==3 || precioVenta.getClave()==6)
			costoGastoFabricacion = 0.35*precioVenta.getCostoMateriaPrima();
		else
			costoGastoFabricacion = 0.28*precioVenta.getCostoMateriaPrima();
		
		costoProduccion = precioVenta.getCostoMateriaPrima()+ costoManoObra + costoGastoFabricacion;
		montoPrecioVenta = costoProduccion + (0.45*costoProduccion);
		
		return montoPrecioVenta;
	}
}
