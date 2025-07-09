package mx.santander.pacselector.dto;

public interface CifrasControlResumenDTO {
    Integer getTotal();       // maps to NUM_ARCH_FACT_PROC
    Integer getCorrectos();   // maps to NUM_ARCH_FACT_COR
    Integer getIncidentes();  // maps to NUM_ARCH_FACT_INC
}
