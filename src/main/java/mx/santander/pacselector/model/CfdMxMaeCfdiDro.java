package mx.santander.pacselector.model;

import java.io.Serializable;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(name = "CFD_MX_MAE_CFDI_DRO")
public class CfdMxMaeCfdiDro  implements Serializable {


	private static final long serialVersionUID = 1L;

	@Id
	@Column(name = "ID_CFDI_PK")
	private String uuidInterno;
	
	@Column(name= "ID_ARCH_FACT_FK")
	private String idArchFact;
	
	@Column(name= "TXT_CFDI_VERSION")
	private String cfdiVersion;
	
	@Column(name= "TXT_CFDI_SERIE")
	private String cfdiSerie;
	
	@Column(name= "TXT_CFDI_FOLIO")
	private String cfdiFolio;
	
	@Column(name= "FCH_CFDI_EXPED")
	private String fchCfdiExped;
	
	@Column(name= "TXT_CAT_FORMA_PAGO_FK")
	private String catFormaPago;
	
	@Column(name= "TXT_CFDI_COND_PAGO")
	private String cfdiCondPago;
	
	@Column(name= "IMP_CFDI_SUB_TOT")
	private String impCfdisubTotal;
	
	@Column(name= "IMP_CFDI_DESCUENTO")
	private String impCfdiDescuento;
	
	@Column(name= "IMP_CFDI_T_CAMBIO")
	private String impCfdiTCambio;
	
	@Column(name= "IMP_CFDI_TOTAL")
	private String impCfdiTotal;
	
	@Column(name= "TXT_CAT_TIPO_COMP_FK")
	private String catTipoComp;
	
	@Column(name= "TXT_CAT_MTD_PAGO_FK")
	private String catMtdPago;
	
	@Column(name= "TXT_CFDI_COD_POST_FK")
	private String cfdiCodPost;
	
	@Column(name= "TXT_CFDI_CONFIRM")
	private String cfdiConfirm;
	
	@Column(name= "ID_FIL_FK")
	private String idFil;
	
	@Column(name= "TXT_CAT_REG_FIS_FK")
	private String catRegFis;
	
	@Column(name= "TXT_CFDI_RFC_REC")
	private String cfdiRfcRec;
	
	@Column(name= "TXT_CFDI_NOM_REC")
	private String cfdiNomRec;
	
	@Column(name= "TXT_CAT_PAIS_REC_FK")
	private String catPaisRec;
	
	@Column(name= "TXT_CALLE_REC")
	private String calleRec;
	
	@Column(name= "TXT_NUM_EXT_REC")
	private String numExtRec;
	
	@Column(name= "TXT_NUM_INT_REC")
	private String numIntRec;
	
	@Column(name= "TXT_COL_REC")
	private String colRec;
	
	@Column(name= "TXT_COD_POS_REC")
	private String codPosRec;
	
	@Column(name= "TXT_LOCAL_REC")
	private String localRec;
	
	@Column(name= "TXT_MUN_REC")
	private String numRec;
	
	@Column(name= "TXT_EDO_REC")
	private String edoRec;
	
	@Column(name= "TXT_PAIS_REC")
	private String paisRec;
	
	@Column(name= "TXT_CFDI_NUMREG_REC")
	private String cfdiNumregRec;
	
	@Column(name= "TXT_CAT_USO_CFDI_FK")
	private String catUsoCfdi;
	
	@Column(name= "TXT_CFDI_UUID_INT")
	private String cfdiUuidInt;
	
	@Column(name= "TXT_CFDI_UUID_SAT")
	private String cfdiUuidSat;
	
	@Column(name= "TXT_NUM_CTA_REC")
	private String numCtaRec;
	
	@Column(name= "TXT_REFER_REC")
	private String referRec;
	
	@Column(name= "TXT_COD_CLI")
	private String codCli;
	
	@Column(name= "TXT_CNTRA_TO_REC")
	private String cntraToRec;
	
	@Column(name= "TXT_PERIO_REC")
	private String perioRec;
	
	@Column(name= "TXT_CTR_CTO")
	private String ctrCto;
	
	@Column(name= "TXT_DESC_REC")
	private String descRec;
	
	@Column(name= "NUM_IVA_REC")
	private String numIvaRec;
	
	@Column(name= "TXT_MOTIV_DESCU")
	private String motivDescu;
	
	@Column(name= "TXT_ESTA_TUS")
	private String estatus;
	
	@Column(name= "FCH_TIMBR_ADO")
	private String fchTimbrAdo;
	
	@Column(name= "FCH_CANCE_LA")
	private String fchCancela;
	
	@Column(name= "TXT_PAC_NAME")
	private String pacName;
	
	@Column(name= "NUM_TOT_IMP_RET")
	private String numTotImpRet;
	
	@Column(name= "NUM_TOT_IMP_TRA")
	private String numTotImpTra;
	
	@Column(name= "TXT_CAT_MDA_FK")
	private String catMda;
	
	@Column(name= "ID_CAT_LUG_AR_EXP_EDI_CION_FK")
	private String idCatLugArExpEdcion;
	
	@Column(name= "ID_CAT_TIPO_RELA_FK")
	private String idCatTpoRela;
	
	@Column(name= "TXT_FAC_ATR_ADQ_RIE_NTE")
	private String factAtrAdoRieNte;
	
	@Column(name= "ID_RES_FISC_REC_FK")
	private String idResFiscRec;
	
	@Column(name= "ID_REG_FISC_REC_FK")
	private String idRegFiscRec;
	
	@Column(name= "TXT_CFDI_RFC_EMI")
	private String cfdiRfcEmi;
	
	@Column(name= "TXT_CFDI_NOM_EMI")
	private String cfdiNomEmi;
	
	@Column(name= "TXT_NUM_AUTORIZA")
	private String numAutoriza;
	
	@Column(name= "TXT_NUM_EMP")
	private String numEmp;
	
	@Column(name= "TXT_NUM_CTA")
	private String numCta;
	
	@Column(name= "FCH_RECE_PCI_ON")
	private String fchRecePciOn;
	
	@Column(name= "TXT_RFC_REM_PLAZ_ADO")
	private String rfcRemPlazAdo;
	
	@Column(name= "TXT_MVO_REM_PLA_ZO")
	private String mvoRemPlaZo;
	
	@Column(name= "TXT_REFER")
	private String refer;
	
	@Column(name= "NUM_NO_REG")
	private String numNoReg;
	
	@Column(name= "TXT_EXPO_RTA_CION")
	private String expoRtaCion;

}
