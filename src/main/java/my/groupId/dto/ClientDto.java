package my.groupId.dto;

import jakarta.validation.constraints.Digits;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import my.groupId.model.Client;
import org.jboss.resteasy.reactive.RestForm;

import java.io.Serializable;

/**
 * DTO for {@link Client}
 */
public class ClientDto implements Serializable {
    private Long id;

    @RestForm
    @NotBlank(message = "firstname is required")
    @Size(max = 2, message = "ห้ามเกิน 2")
//    @Digits(integer = 2, fraction = 0 )
    private String firstName;

    @RestForm
    private String lastName;

    @RestForm
    private String tel;

    @RestForm
    private String email;
    @RestForm
    private String lineId;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getTel() {
        return tel;
    }

    public void setTel(String tel) {
        this.tel = tel;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getLineId() {
        return lineId;
    }

    public void setLineId(String lineId) {
        this.lineId = lineId;
    }
}
