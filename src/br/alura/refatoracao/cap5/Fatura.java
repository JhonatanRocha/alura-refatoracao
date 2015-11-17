package br.alura.refatoracao.cap5;

public class Fatura {

	private double valorMensal;
	private String cliente;

	public Fatura() {}

	public Fatura(double valorMensal, String cliente) {
		this.valorMensal = valorMensal;
		this.cliente = cliente;
	}
	public double getValorMensal() {
		return valorMensal;
	}
	public void setValorMensal(double valorMensal) {
		this.valorMensal = valorMensal;
	}
	public String getCliente() {
		return cliente;
	}
	public void setCliente(String cliente) {
		this.cliente = cliente;
	}
	
	public double converteValor(double taxa){
		return valorMensal * taxa;
	}
	
	public double emDolar(){
		return converteValor(2.7);
	}
	
	public double emReal(){
		return converteValor(1.0);
	}
}
