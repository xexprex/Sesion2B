package Sesion2B;

public class Empleado {
	public enum TipoEmpleado{Vendedor,Encargado};
	float salarioBase=0;
	float primas=0;
	float extras=0;
	
	public float caculoNominaBruta(TipoEmpleado tipo, float ventaMes, float HorasExtras) {
		
		if(tipo==TipoEmpleado.Encargado) {
			salarioBase=2500;
		}else if(tipo==TipoEmpleado.Vendedor) {
			salarioBase=2000;
		}
		
		if(ventaMes>=1500) {
			primas=200;
		}else if(ventaMes>=1000) {
			primas=100;
		}
		
		extras=HorasExtras *30;
		
		return salarioBase + primas + extras;
		
	}
	
	public float calculoNominaNeta(float nominaBruta) {
		
		float retencion=0;
		

		if(nominaBruta>=2100 && nominaBruta<=2500) {
			retencion=(float) 0.15;
		}else if(nominaBruta>=2500) {
			retencion=(float)0.18;
		}
		return nominaBruta*(1-retencion);
	}
	
	
	
	
}
