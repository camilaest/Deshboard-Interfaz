package co.edu.uniquindio.fx10.modelo;

import co.edu.uniquindio.fx10.modelo.IApartamento;

public class ConSeguro extends co.edu.uniquindio.fx10.modelo.ApartamentoDecorador {


    public ConSeguro(IApartamento apartamento) {
        super(apartamento);
    }

    public void ejecutarProceso (String  mensaje) {
        super.ejecutarProceso(mensaje);
        System.out.println("El proceso del apartamento con seguro se inicia  "+ mensaje);
    }
}
