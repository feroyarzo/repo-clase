public class Empleado {
	
    private String nombre;
    private double salarioMensual;

    public Empleado(String nombre, double salarioMensual) {
        this.nombre = nombre;
        this.salarioMensual = salarioMensual;
    }       

    public double calcularSalarioAnual() {
        return this.salarioMensual * 12;
    }

    public double aplicarBono(double porcentaje) {
        if (porcentaje < 0) {
            throw new IllegalArgumentException("El porcentaje de bono no puede ser negativo");
        }
        return this.calcularSalarioAnual() * (1 + porcentaje / 100);
    }

    // Getters y setters
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public double getSalarioMensual() {
        return salarioMensual;
    }

    public void setSalarioMensual(double salarioMensual) {
        this.salarioMensual = salarioMensual;
    }
}
