package mx.santander.pacselector.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import mx.santander.pacselector.model.CfdMxMaeCfdiDro;

@Repository
public interface CfdMxMaeCfdiDroRepository extends JpaRepository<CfdMxMaeCfdiDro, String> {

	Optional<CfdMxMaeCfdiDro> findByUuidInterno(String uuidInterno);

	@Modifying
	@Query("UPDATE CfdMxMaeCfdiDro c SET c.pacName = :pacName WHERE c.cfdiUuidInt = :cfdiUuidInt")
	int updateCfdi(@Param("pacName") String pacName, @Param("cfdiUuidInt") String cfdiUuidInt);

	@Query(value = "SELECT " + "NVL(TXT_COD_CLI, ' ') AS codCli, " + "NVL(TXT_CNTRA_TO_REC, ' ') AS cntraToRec, "
			+ "NVL(TXT_PERIO_REC, ' ') AS perioRec " + "FROM CFD_MX_MAE_CFDI_DRO "
			+ "WHERE TXT_CFDI_UUID_INT = :cfdiUuidInt", nativeQuery = true)
	Optional<CfdMxMaeCfdiDro> findContratoByUuid(@Param("cfdiUuidInt") String cfdiUuidInt);

}
