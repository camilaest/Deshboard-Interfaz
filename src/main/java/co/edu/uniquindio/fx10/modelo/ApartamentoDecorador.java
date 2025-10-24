package co.edu.uniquindio.fx10.modelo;

import co.edu.uniquindio.fx10.modelo.IApartamento;

public class ApartamentoDecorador implements IApartamento {


    public IApartamento apartamento;

    public ApartamentoDecorador(IApartamento apartamento) {
        this.apartamento = apartamento;
    }

    @Override
    public void ejecutarProceso(String mensaje) {
        apartamento.ejecutarProceso(mensaje);
    }
}
