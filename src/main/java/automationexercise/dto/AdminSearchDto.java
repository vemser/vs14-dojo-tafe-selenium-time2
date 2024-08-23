package automationexercise.dto;


import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class AdminSearchDto {

    private String username;
    private String userRole;
    private String employeeName;
    private String status;

}
