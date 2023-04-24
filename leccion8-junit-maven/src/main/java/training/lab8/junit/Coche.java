package training.lab8.junit;

public class Coche {
	String modelo;
	public float precioBase;
	public static float impuesto;
	
	public Coche(String modelo, float precioBase) {
		super();
		this.modelo = modelo;
		this.precioBase = precioBase;
	}
	
	public float precioFinal(float descuento) throws Exception{
		
		float precioConDescuento = this.precioBase;
		
		if (descuento < 0 || descuento > 100) {
			throw new RuntimeException("Descuento erroneo");
		}
		
		if (precioBase >= 5000) {
			precioConDescuento = this.precioBase - (this.precioBase * descuento/100f);
		}
		
		return precioConDescuento + precioConDescuento * this.impuesto/100f;
		
	}
}
