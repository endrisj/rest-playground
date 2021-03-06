package com.example.playground;

import java.util.ArrayList;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class CrawlingSource {

    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private long id;
    
    @Column(unique = true)
    private String url;
    
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "crawlingSource", fetch = FetchType.LAZY, orphanRemoval = true)
    private List<FamousPerson> famousPeople = new ArrayList<>();
    
    private String repositoryKey;
    private boolean isScanned = false;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getRepositoryKey() {
        return repositoryKey;
    }

    public void setRepositoryKey(String repositoryKey) {
        this.repositoryKey = repositoryKey;
    }

    public List<FamousPerson> getFamousPeople() {
        return famousPeople;
    }
    
    public void addFamousPerson(FamousPerson famousPerson) {
        famousPerson.setCrawlingSource(this);
        famousPeople.add(famousPerson);
    }

    public boolean getIsScanned() {
        return isScanned;
    }

    public void setIsScanned(boolean isScanned) {
        this.isScanned = isScanned;
    }
}
