package co.edu.uniquindio.fx10.modelo;

public  class Propiedad {

    private String ciudad;
    private int nHabitaciones;
    private int nPisos;
    private double precio;
    private String direccion;

    public Propiedad(String ciudad, int nHabitaciones, int nPisos, double precio, String direccion) {
        this.ciudad = ciudad;
        this.nHabitaciones = nHabitaciones;
        this.nPisos = nPisos;
        this.precio = precio;
        this.direccion = direccion;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getCiudad() {
        return ciudad;
    }

    public void setCiudad(String ciudad) {
        this.ciudad = ciudad;
    }

    public int getNHabitaciones() {
        return nHabitaciones;
    }

    public void setNHabitaciones(int nHabitaciones) {
        this.nHabitaciones = nHabitaciones;
    }

    public int getNPisos() {
        return nPisos;
    }

    public void setNPisos(int nPisos) {
        this.nPisos = nPisos;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    @Override
    public String toString() {
        return "Propiedad{" +
                "ciudad='" + ciudad + '\'' +
                ", nHabitaciones=" + nHabitaciones +
                ", nPisos=" + nPisos +
                ", precio=" + precio +
                '}';
    }


}