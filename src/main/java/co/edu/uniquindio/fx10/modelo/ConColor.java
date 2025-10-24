package co.edu.uniquindio.fx10.modelo;

import co.edu.uniquindio.fx10.modelo.IApartamento;

public class ConColor extends co.edu.uniquindio.fx10.modelo.ApartamentoDecorador {

    public ConColor(IApartamento apartamento) {
        super(apartamento);
    }

    public void ejecutarProceso (String  mensaje) {
        super.ejecutarProceso(mensaje);
        System.out.println("El proceso del apartamento con color se inicia  "+ mensaje);
    }
}
