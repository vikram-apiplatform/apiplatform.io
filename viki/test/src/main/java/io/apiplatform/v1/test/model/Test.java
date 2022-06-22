package io.apiplatform.v1.test.io.apiplatform.v1.test.model;


import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;


@Document(collection = "user")
public class Test {

    @Id
    private String id;
    private Double EId;
    private String EName;
    private Boolean Email;
    private String DOJ;
    private Date Time;
    
    public Double getEId() {
        return EId;
    }

    public void setEId(Double EId) {
        this.EId = EId;
    }
    public String getEName() {
        return EName;
    }

    public void setEName(String EName) {
        this.EName = EName;
    }
    public Boolean getEmail() {
        return Email;
    }

    public void setEmail(Boolean Email) {
        this.Email = Email;
    }
    public String getDOJ() {
        return DOJ;
    }

    public void setDOJ(String DOJ) {
        this.DOJ = DOJ;
    }
    public Date getTime() {
        return Time;
    }

    public void setTime(Date Time) {
        this.Time = Time;
    }
    
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }
    
}
