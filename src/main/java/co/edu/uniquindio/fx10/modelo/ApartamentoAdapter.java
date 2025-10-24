package co.edu.uniquindio.fx10.modelo;

public class ApartamentoAdapter implements IApartamento{


    public ApartamentoAntiguoIncompatible apartamentoIncompatible;

    public ApartamentoAdapter(ApartamentoAntiguoIncompatible apartamentoIncompatible) {
        this.apartamentoIncompatible = apartamentoIncompatible;
    }


    @Override
    public void ejecutarProceso(String mensaje) {
        apartamentoIncompatible.start();
    }
}
