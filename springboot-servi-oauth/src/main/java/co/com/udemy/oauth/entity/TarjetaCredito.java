package co.com.udemy.oauth.entity;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "TarjetasDeCredito")
public class TarjetaCredito {
	@Id
	private String NumeroDeTarjeta;
	private String FechaDeVencimiento;
	private String Cvv;

	public TarjetaCredito() {
	}

	public String getNumeroDeTarjeta() {
		return NumeroDeTarjeta;
	}

	public void setNumeroDeTarjeta(String numeroDeTarjeta) {
		NumeroDeTarjeta = numeroDeTarjeta;
	}

	public String getFechaDeVencimiento() {
		return FechaDeVencimiento;
	}

	public void setFechaDeVencimiento(String fechaDeVencimiento) {
		FechaDeVencimiento = fechaDeVencimiento;
	}

	public String getCvv() {
		return Cvv;
	}

	public void setCvv(String cvv) {
		Cvv = cvv;
	}
}
