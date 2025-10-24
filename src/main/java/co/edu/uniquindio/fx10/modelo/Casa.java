package co.edu.uniquindio.fx10.modelo;

import co.edu.uniquindio.fx10.modelo.Propiedad;

public class Casa extends Propiedad {

    public Casa (Builder builder){
        super(builder.ciudad, builder.nHabitaciones, builder.nPisos, builder.precio, builder.direccion);

    }


    public static class Builder {
        private String ciudad;
        private int nHabitaciones;
        private int nPisos;
        private double precio;
        private String direccion;


        public Casa build() {
            return new Casa(this);
        }

        public Builder ciudad(String ciudad) {
            this.ciudad = ciudad;
            return this;
        }

        public Builder direccion (String direccion){
            this.direccion = direccion;
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

        @Override
        public String toString() {
            return super.toString() + "Builder{" +
                    "ciudad='" + ciudad + '\'' +
                    ", nHabitaciones=" + nHabitaciones +
                    ", nPisos=" + nPisos +
                    ", precio=" + precio +
                    ", dirección: " + direccion + "\n";
        } 
    }
}
