package edu.eci.cvds.servlet.backingBean;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
//import javax.enterprise.context.SessionScoped;
import javax.faces.bean.ApplicationScoped;
import javax.faces.bean.ManagedBean;


@ManagedBean(name = "calculadoraBean")
@ApplicationScoped
//@SessionScoped
public class CalculadoraBean {
	private double promedio;
	private double desviacionEstandar;
	private double varianza;
	private double moda;
	private int cantidadNumeros;
	//Lista de números 
	private String numeros;
	private ArrayList<Double> listaNumeros ;	
	
	public CalculadoraBean() {		
	}
	
	
	public double getPromedio() {		
		return promedio;
	}
	
	public double getDesviacionEstandar() {		
		return desviacionEstandar;
	}
	
	public double getModa() {		
		return moda;
	}
	
	public double getVarianza() {		
		return varianza;
	}
	
	
	/**
	 * Permite calcular el promedio de un listado de numeros ingresados.
	 * @return promedio - valor del promedio de los numeros.
	 */
	public double calculateMean(String numeros) {
		promedio = 0;
		setListaNumeros(numeros);
		convertirLista(numeros);
		for (double d: listaNumeros) promedio = promedio + d/cantidadNumeros;
		return promedio;
	}
	
	/**
	 * Permite calcular la desviacion estandar de un listado de numeros ingresados.
	 * @return desviacionEstandar - valor de la desviacion de los numeros.
	 */
	public double calculateStandardDeviation(String numeros) {
		desviacionEstandar = 0;
		double promedioDS = calculateMean(numeros);
		setListaNumeros(numeros);
		convertirLista(numeros);
		for (double d: listaNumeros) desviacionEstandar += Math.pow((d-promedioDS), 2);
		desviacionEstandar =Math.sqrt(desviacionEstandar/cantidadNumeros);
		return desviacionEstandar;
	}
	
	/**
	 * Permite calcular la varianza de un listado de numeros ingresados.
	 * @return varianza - valor de la desviacion de los numeros.
	 */
	public double calculateVariance(String numeros) {
		varianza = 0;	
		setListaNumeros(numeros);
		convertirLista(numeros);
		double promedioV = calculateMean(numeros);
		for (double d: listaNumeros) varianza += Math.pow((d-promedioV),2)/cantidadNumeros;
		
		
		return varianza;
	}
	
	/**
	 * Permite calcular la moda de un listado de numeros ingresados.
	 * @return moda - valor de la moda de los numeros.
	 */
	public double calculateMode(String numeros){
		moda = 0;
		setListaNumeros(numeros);
		convertirLista(numeros);
		HashMap<Double, Integer> mapa = new HashMap<>();
		for(Double d: listaNumeros) {
			if (mapa.containsKey(d)) {
			    mapa.put(d, mapa.get(d) + 1);
			  } else {
			    mapa.put(d, 1);
			  }
		}
		int mayor=0;
		for (Map.Entry<Double, Integer> entry : mapa.entrySet()) {
		    if (entry.getValue() > mayor) {
		    	mayor = entry.getValue();
		    	moda = entry.getKey();
		    }
		}
		
		return moda;
	}
	
	/**
	 * Permite reiniciar la aplicación.
	 */
	public void restart() {
		promedio = 0;
		desviacionEstandar = 0;
		varianza = 0;
		moda  = 0;
		listaNumeros = new ArrayList<Double>();
		numeros = "0";
	}
	
	/**
	 * Retorna la lista de numeros ingresada por el usuario.
	 * @return listaNumeros;
	 */
	public ArrayList<Double> getListaNumeros() {
		return listaNumeros;
	}
	
	/**
	 * Actualiza la lista de números ingresada por el usuario.
	 * @param listaNumeros - nueva lista de números.
	 */
	public void setListaNumeros(String listaEntrante) {
		this.numeros = listaEntrante;
		
	}

	public String getNumeros() {
		return numeros;
	}
	
	public void setNumeros(String numeros) {
		this.numeros = numeros;
	}
	
	public void convertirLista(String listaEntrante) {
		this.listaNumeros = new ArrayList<Double>();
		for (String s : listaEntrante.split(",")) {
			this.listaNumeros.add(Double.parseDouble(s));
		}
		cantidadNumeros = this.listaNumeros.size();
	}
}
