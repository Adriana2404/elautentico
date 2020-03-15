package com.ecodeup.beans;

import java.io.Serializable;
import java.util.LinkedHashMap;
import java.util.Locale;
import java.util.Map;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import javax.faces.event.ValueChangeEvent;
 
@ManagedBean(name="language")
@SessionScoped
public class IdiomaBean implements Serializable{
	
	private static final long serialVersionUID = 1L;
	
	private Locale locale;
	
	private String localeCode;
	private static Map<String,Object> countries;
	
	static{
		countries = new LinkedHashMap<String,Object>();
		countries.put("Spanish", new Locale("es", "ES"));
		countries.put("English", Locale.ENGLISH); //label, value
	}

	public Map<String, Object> getCountriesInMap() {
		return countries;
	}
	
	public Locale getLocale() {
		return locale;
	}

	public void setLocale(Locale locale) {
		this.locale = locale;
	}

	public String getLocaleCode() {
		return localeCode;
	}


	public void setLocaleCode(String localeCode) {
		this.localeCode = localeCode;
	}
	
	 public void changeLanguage(String language){
		 FacesContext.getCurrentInstance().getViewRoot().setLocale(new Locale(language));
 		locale = FacesContext.getCurrentInstance()
			.getViewRoot().getLocale();
	 }

}