package mx.santander.pacselector.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import mx.santander.pacselector.model.CfdMxLogPac;


@Repository
public interface LogPacRepository extends JpaRepository<CfdMxLogPac, Long>{
	
	@Modifying
    @Transactional
    @Query(
        value = "INSERT INTO CFD_MX_LOG_PAC (ID_LOG_PAC_PK, ID_ARCH_FACT_FK, ID_CFDI_FK, TXT_MSG_RESP, TXT_JSON_FACT) " +
                "VALUES (CFD_MX_LOG_PAC_SEQ.NEXTVAL, :idFile, :idCfdi, :txtMsgResp, :txtJsonFact)",
        nativeQuery = true
    )
    void insertLogPac(@Param("idFile") Long idFile,
                      @Param("idCfdi") Long idCfdi,
                      @Param("txtMsgResp") String txtMsgResp,
                      @Param("txtJsonFact") String txtJsonFact);
}
