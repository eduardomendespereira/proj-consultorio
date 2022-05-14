package br.com.uniamerica.api.repository;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import br.com.uniamerica.api.entity.Paciente;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

/**
 * @author Eduardo Mendes
 *
 * @since 1.0.0, 05/04/2022
 * @version 1.0.0
 */
@Repository
public interface PacienteRepository extends JpaRepository<Paciente, Long> {

    @Modifying
    @Query("UPDATE Paciente paciente " +
            "SET paciente.excluido = :now " +
            "WHERE paciente.id = :paciente")
    public void setUpdateExcluido(@Param("paciente") Long idPaciente, @Param("now") LocalDateTime now);
}
