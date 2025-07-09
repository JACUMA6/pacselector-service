package mx.santander.pacselector.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;


@Getter
@Setter
@Entity
@Table(name = "CFD_MX_AUX_ARCH_FACT_DRO")
public class cfdMxAuxArchFactDro {
	
	@Id
	@Column(name = "ID_ARCH_FACT_PK")
	private Long idArchFact;
	
	@Column(name = "TXT_NAME_ARCH_FACT")
	private String nameArchFact;
	
	@Column(name = "FCH_CREA_ARCH_FACT")
	private String fchCreaArchFact;
	
	@Column(name = "NUM_ARCH_FACT_PROC")
	private int numArchFactProc;
	
	@Column(name = "NUM_ARCH_FACT_COR")
	private int numArchFactCor;
	
	@Column(name = "NUM_ARCH_FACT_INC")
	private int numArchFactInc;
	
	@Column(name = "ID_USER_FK")
	private int idUser;
	
	@Column(name = "FLG_ARCH_PROC")
	private char flgArchProc;
	
	@Column(name = "FCH_MOD_ARCH_FACT")
	private String fchModArchFact;
	
	@Column(name = "TXT_TIPO_FORM_ARCH")
	private String tipoFormArch;

}
