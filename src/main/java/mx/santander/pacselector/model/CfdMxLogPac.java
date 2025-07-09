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
@Table(name = "CFD_MX_LOG_PAC")
public class CfdMxLogPac implements Serializable{
	
	private static final long serialVersionUID = 5756581537721698580L;

	@Id
	@Column(name = "ID_LOG_PAC_PK")
	private Long idLogPacPk;
	
	@Column(name = "ID_ARCH_FACT_FK")
	private Long idFile;
	
	@Column(name = "ID_CFDI_FK")
	private int idCfdi;
	
	@Column(name = "TXT_MSG_RESP")
	private String txtMsgResp;
	
	@Column(name = "TXT_JSON_FACT")
	private String txtJsonFact;

	public CfdMxLogPac(int idCfdi, String txtMsgResp, String txtJsonFact) {
		this.idCfdi = idCfdi;
		this.txtMsgResp = txtMsgResp;
		this.txtJsonFact = txtJsonFact;
	}
}
