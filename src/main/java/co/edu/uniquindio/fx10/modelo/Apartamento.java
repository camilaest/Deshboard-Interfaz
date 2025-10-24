
package co.edu.uniquindio.fx10.modelo;
import co.edu.uniquindio.fx10.modelo.IApartamento;
import co.edu.uniquindio.fx10.modelo.Propiedad;

public class Apartamento extends Propiedad implements IApartamento {

    private boolean piscina;

    public Apartamento (Builder builder){
        super(builder.ciudad, builder.nHabitaciones, builder.nPisos, builder.precio, builder.direccion);
        this.piscina = piscina;
    }

    public boolean getiscina() {
        return piscina;
    }

    public void setPiscina(boolean piscina) {
        this.piscina = piscina;
    }


    public static class Builder {
        private String ciudad;
        private int nHabitaciones;
        private int nPisos;
        private double precio;
        private  boolean piscina;
        private String direccion;

        public Apartamento build(){
            return new Apartamento(this);
        }

        public Builder ciudad(String ciudad) {
            this.ciudad = ciudad;
            return this;
        }

        public Builder nHabitaciones(int nHabitaciones) {
            this.nHabitaciones = nHabitaciones;
            return this;
        }

        public Builder nPisos(int nPisos) {
            this.nPisos = nPisos;
            return this;
        }

        public Builder precio(double precio) {
            this.precio = precio;
            return this;
        }

        public Builder direccion(String direccion){
            this.direccion = direccion;
            return this;
        }

        public  Builder piscina(boolean piscina) {
            this.piscina = piscina;
            return this;
        }

        @Override
        public String toString() {
            return super.toString()+ "Builder{" +
                    "ciudad='" + ciudad + '\'' +
                    ", nHabitaciones=" + nHabitaciones +
                    ", nPisos=" + nPisos +
                    ", precio=" + precio +
                    ", piscina=" + piscina +
                    ", Direccion" + direccion + "\n";
        }

    }

    @Override
    public String toString() {
        return super.toString()+ "Builder{" +
                ", piscina=" + piscina +
                '}';
    }

    @Override
    public void ejecutarProceso(String mensaje) {
        System.out.println("Apartamento inicia proceso");
    }
}
