package co.edu.uniquindio.fx10.modelo;

import co.edu.uniquindio.fx10.modelo.SistemaElectrico;
import co.edu.uniquindio.fx10.modelo.SistemaGas;

public class ApartaEstudio {

    private SistemaGas sistemaGas;
    private SistemaElectrico sistemaElectrico;

    public ApartaEstudio(){
        this.sistemaGas = new SistemaGas();
        this.sistemaElectrico = new SistemaElectrico();
    }

    public SistemaGas getSistemaGas() {
        return sistemaGas;
    }

    public void setSistemaGas(SistemaGas sistemaGas) {
        this.sistemaGas = sistemaGas;
    }

    public SistemaElectrico getSistemaElectrico() {
        return sistemaElectrico;
    }

    public void setSistemaElectrico(SistemaElectrico sistemaElectrico) {
        this.sistemaElectrico = sistemaElectrico;
    }

    public void iniciarProcesoPropiedad() {
        System.out.println("Iniciando proceso de encendido...");
        if (sistemaGas.verificarCombustible()) {
            sistemaElectrico.encenderSistema();
            sistemaGas.verificarCombustible();
            System.out.println("El sistema funciona correctamente.");
        } else {
            System.out.println("No hay combustible. No se puede encender.");
        }
    }
}
