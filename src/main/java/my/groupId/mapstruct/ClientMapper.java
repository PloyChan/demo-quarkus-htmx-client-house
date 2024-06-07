package my.groupId.mapstruct;

import my.groupId.dto.ClientDto;
import my.groupId.model.Client;
import org.mapstruct.*;

@Mapper(unmappedTargetPolicy = ReportingPolicy.ERROR, componentModel = MappingConstants.ComponentModel.CDI)
public interface ClientMapper {
    Client toEntity(ClientDto clientDto);
}
