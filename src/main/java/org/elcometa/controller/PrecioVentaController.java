package org.elcometa.controller;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.enterprise.context.SessionScoped;
import javax.inject.Inject;
import javax.inject.Named;

import org.elcometa.business.PrecioVentaBusiness;
import org.elcometa.entities.PrecioVenta;
import org.primefaces.event.SelectEvent;

@Named
@SessionScoped
public class PrecioVentaController implements Serializable{
	
	private static final long serialVersionUID = 1L;

	@Inject
	private PrecioVentaBusiness precioVentaBusiness;
	
	private PrecioVenta precioVenta;
	private List<PrecioVenta> preciosVentas;
	private PrecioVenta precioVentaSeleccionado;
	private int claveFiltrar;
	
	@PostConstruct
	public void init()
	{
		precioVenta = new PrecioVenta();
		preciosVentas = new ArrayList<>();
		precioVentaSeleccionado = new PrecioVenta();
		
		mostrarPreciosVenta();
	}
	
	public void mostrarPreciosVenta()
	{
		try {
			preciosVentas = precioVentaBusiness.listarPrecioVenta();
		} catch (Exception e)
		{
		}
	}
	
	public void seleccionarPrecioVenta(SelectEvent e)
	{
		this.precioVentaSeleccionado = (PrecioVenta) e.getObject();
	}
	
	public String nuevoPrecioVenta()
	{
		this.limpiarFormulario();
		return "insert.xhtml";
	}
	
	public String editarPrecioVenta()
	{
		return "";
	}
	
	public void consultarPrecioVentaPorClave()
	{
		
	}
	
	public String guardarPrecioVenta()
	{
		return "";
	}
	
	public String regresarPrecioVenta()
	{
		return "";
	}
	
	public void limpiarFormulario()
	{
		this.precioVenta = new PrecioVenta();
	}
	
	public PrecioVentaBusiness getPrecioVentaBusiness() {
		return precioVentaBusiness;
	}

	public void setPrecioVentaBusiness(PrecioVentaBusiness precioVentaBusiness) {
		this.precioVentaBusiness = precioVentaBusiness;
	}

	public PrecioVenta getPrecioVenta() {
		return precioVenta;
	}

	public void setPrecioVenta(PrecioVenta precioVenta) {
		this.precioVenta = precioVenta;
	}

	public List<PrecioVenta> getPrecioVentas() {
		return precioVentas;
	}

	public void setPrecioVentas(List<PrecioVenta> precioVentas) {
		this.precioVentas = precioVentas;
	}

	public PrecioVenta getPrecioVentaSeleccionado() {
		return precioVentaSeleccionado;
	}

	public void setPrecioVentaSeleccionado(PrecioVenta precioVentaSeleccionado) {
		this.precioVentaSeleccionado = precioVentaSeleccionado;
	}

	public int getClaveFiltrar() {
		return claveFiltrar;
	}

	public void setClaveFiltrar(int claveFiltrar) {
		this.claveFiltrar = claveFiltrar;
	}
}
