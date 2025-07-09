package mx.santander.pacselector.utils;


import lombok.NoArgsConstructor;
import mx.santander.pacselector.dto.request.RequestGrabaAuditoriaDTO;

@NoArgsConstructor
public final class UtilsBitacora {


    public static RequestGrabaAuditoriaDTO generaBeanBitacoro(int idOpe, String servicio, String valorNuevo) {
        RequestGrabaAuditoriaDTO audit = new RequestGrabaAuditoriaDTO();
        audit.setPstrCanalApp(ConstantesBita.APP_NAME);
        audit.setPstrCodOper(idOpe +"");
        audit.setPstrTabla(ConstantesBita.PAC);
        audit.setPstrDatoFijo("xml");
        audit.setPstrServicio(servicio);
        audit.setPstrTipoOper(idOpe + "");
        audit.setValorNvo(valorNuevo);
        audit.setDatoAfectado(valorNuevo);
        return audit;
    }

}
