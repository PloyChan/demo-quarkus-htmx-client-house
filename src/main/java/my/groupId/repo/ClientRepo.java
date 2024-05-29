package my.groupId.repo;

import io.quarkus.hibernate.orm.panache.PanacheRepository;
import jakarta.enterprise.context.ApplicationScoped;
import my.groupId.model.Client;

@ApplicationScoped
public class ClientRepo implements PanacheRepository<Client> {


}
