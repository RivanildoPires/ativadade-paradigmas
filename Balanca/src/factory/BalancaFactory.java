package factory;

import Exceptions.TipoBalancaException;
import enums.TipoBalanca;
import interfaces.IBalanca;
import models.Produto;
import services.FilizolaSmart;
import services.ToledoMGV6;
import services.UranoIntegra;

public class BalancaFactory {
    public static IBalanca<Produto> getBalanca(TipoBalanca tipo) throws TipoBalancaException {

        switch (tipo) {
            case FINIZOLA_SMART:
                return new FilizolaSmart();
            case TOLEDO_MGV6:
                return new ToledoMGV6();
            case URANO_INTEGRA:
                return new UranoIntegra();
            default:
                throw new TipoBalancaException();
        }
    }
}
