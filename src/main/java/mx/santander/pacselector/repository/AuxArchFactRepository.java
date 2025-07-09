package mx.santander.pacselector.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import mx.santander.pacselector.model.cfdMxAuxArchFactDro;

@Repository
public interface AuxArchFactRepository extends JpaRepository<cfdMxAuxArchFactDro, Long>{
	
	@Modifying
	@Transactional
	@Query(value = """
	    UPDATE CFD_MX_AUX_ARCH_FACT_DRO
	    SET NUM_ARCH_FACT_COR = (
	        SELECT COUNT(1)
	        FROM CFD_MX_MAE_CFDI_DRO
	        WHERE ID_ARCH_FACT_FK = :idFile AND TXT_ESTA_TUS = 'T'
	    ),
	    FCH_MOD_ARCH_FACT = SYSDATE
	    WHERE ID_ARCH_FACT_PK = :idFile
	    """, nativeQuery = true)
	int actualizarCifrasCorrectas(@Param("idFile") Long idFile);
	
	@Modifying
	@Transactional
	@Query(value = """
	    UPDATE CFD_MX_AUX_ARCH_FACT_DRO
	    SET NUM_ARCH_FACT_INC = (
	        SELECT (
	            SELECT COUNT(1)
	            FROM CFD_MX_MAE_CFDI_DRO
	            WHERE ID_ARCH_FACT_FK = :idFile AND TXT_ESTA_TUS = 'E'
	        ) + (
	            SELECT COUNT(1)
	            FROM CFD_MX_LOG_LAYT
	            WHERE ID_REG_LAYT_FK IN (
	                SELECT ID_REG_LAYT_PK
	                FROM CFD_MX_REG_LAYT
	                WHERE ID_ARCH_FACT_FK = :idFile
	            )
	        )
	        FROM DUAL
	    )
	    WHERE ID_ARCH_FACT_PK = :idFile
	    """, nativeQuery = true)
	int actualizarCifrasIncidencias(@Param("idFile") Long idFile);

}
