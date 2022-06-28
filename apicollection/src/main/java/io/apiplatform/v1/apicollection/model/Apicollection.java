package io.apiplatform.v1.apicollection.model;


import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;


@Document(collection = "apicollection")
public class Apicollection {

    @Id
    private String id;
    private String name;
    private String description;
    private String partner;
    private String account;
    private Object authModel;
    private Object apiExecutors;
    private Timestamp createdAt;
    private Timestamp lastUpdatedAt;
    private Integer executorsOrder;
    private String collectionScope;
    private Object headers;
    private Object queryParams;
    private Object pathParams;
    private String createdBy;
    private String updatedBy;
    private String displayname;
    private String category;
    private String version;
    
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
    public String getPartner() {
        return partner;
    }

    public void setPartner(String partner) {
        this.partner = partner;
    }
    public String getAccount() {
        return account;
    }

    public void setAccount(String account) {
        this.account = account;
    }
    public Object getAuthModel() {
        return authModel;
    }

    public void setAuthModel(Object authModel) {
        this.authModel = authModel;
    }
    public Object getApiExecutors() {
        return apiExecutors;
    }

    public void setApiExecutors(Object apiExecutors) {
        this.apiExecutors = apiExecutors;
    }
    public Timestamp getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Timestamp createdAt) {
        this.createdAt = createdAt;
    }
    public Timestamp getLastUpdatedAt() {
        return lastUpdatedAt;
    }

    public void setLastUpdatedAt(Timestamp lastUpdatedAt) {
        this.lastUpdatedAt = lastUpdatedAt;
    }
    public Integer getExecutorsOrder() {
        return executorsOrder;
    }

    public void setExecutorsOrder(Integer executorsOrder) {
        this.executorsOrder = executorsOrder;
    }
    public String getCollectionScope() {
        return collectionScope;
    }

    public void setCollectionScope(String collectionScope) {
        this.collectionScope = collectionScope;
    }
    public Object getHeaders() {
        return headers;
    }

    public void setHeaders(Object headers) {
        this.headers = headers;
    }
    public Object getQueryParams() {
        return queryParams;
    }

    public void setQueryParams(Object queryParams) {
        this.queryParams = queryParams;
    }
    public Object getPathParams() {
        return pathParams;
    }

    public void setPathParams(Object pathParams) {
        this.pathParams = pathParams;
    }
    public String getCreatedBy() {
        return createdBy;
    }

    public void setCreatedBy(String createdBy) {
        this.createdBy = createdBy;
    }
    public String getUpdatedBy() {
        return updatedBy;
    }

    public void setUpdatedBy(String updatedBy) {
        this.updatedBy = updatedBy;
    }
    public String getDisplayname() {
        return displayname;
    }

    public void setDisplayname(String displayname) {
        this.displayname = displayname;
    }
    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }
    public String getVersion() {
        return version;
    }

    public void setVersion(String version) {
        this.version = version;
    }
    
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }
    
}
