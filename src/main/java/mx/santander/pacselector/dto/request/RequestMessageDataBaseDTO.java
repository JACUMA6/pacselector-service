package mx.santander.pacselector.dto.request;

import java.io.Serializable;

public class RequestMessageDataBaseDTO implements Serializable {

    private static final long serialVersionUID = 1L;

    private String idPeticion;
    private String addParamToSql;
    private String codeError;
    private String messageError;
    private int recordsAffected;

    private String codeOperation;
    private int typeOperation;
    private String queriesEnum;

    public RequestMessageDataBaseDTO() {
    }

    public RequestMessageDataBaseDTO(String idPeticion, String addParamToSql, String codeError, String messageError, int recordsAffected,
                                     String codeOperation, int typeOperation, String queriesEnum) {
        this.idPeticion = idPeticion;
        this.addParamToSql = addParamToSql;
        this.codeError = codeError;
        this.messageError = messageError;
        this.recordsAffected = recordsAffected;
        this.codeOperation = codeOperation;
        this.typeOperation = typeOperation;
        this.queriesEnum = queriesEnum;
    }

    public String getIdPeticion() {
        return idPeticion;
    }

    public void setIdPeticion(String idPeticion) {
        this.idPeticion = idPeticion;
    }
    
	public String getAddParamToSql() {
		return addParamToSql;
	}

	public void setAddParamToSql(String addParamToSql) {
		this.addParamToSql = addParamToSql;
	}
	
	public String getCodeError() {
		return codeError;
	}

	public void setCodeError(String codeError) {
		this.codeError = codeError;
	}

	public String getMessageError() {
		return messageError;
	}

	public void setMessageError(String messageError) {
		this.messageError = messageError;
	}

	public int getRecordsAffected() {
		return recordsAffected;
	}

	public void setRecordsAffected(int recordsAffected) {
		this.recordsAffected = recordsAffected;
	}

	public String getCodeOperation() {
        return codeOperation;
    }

    public void setCodeOperation(String codeOperation) {
        this.codeOperation = codeOperation;
    }

    public int getTypeOperation() {
        return typeOperation;
    }

    public void setTypeOperation(int typeOperation) {
        this.typeOperation = typeOperation;
    }
    
    public String getQueriesEnum() {
		return queriesEnum;
	}

	public void setQueriesEnum(String queriesEnum) {
		this.queriesEnum = queriesEnum;
	}

	@Override
    public String toString() {
        return "RequestMessageDataBaseDTO{" +
                "idPeticion='" + idPeticion + '\'' +
                ", addParamToSql='" + addParamToSql + '\'' +
                ", codeError='" + codeError + '\'' +
                ", messageError='" + messageError + '\'' +
                ", recordsAffected='" + recordsAffected + '\'' +
                ", codeOperation='" + codeOperation + '\'' +
                ", typeOperation='" + typeOperation + '\'' +
                '}';
    }
}