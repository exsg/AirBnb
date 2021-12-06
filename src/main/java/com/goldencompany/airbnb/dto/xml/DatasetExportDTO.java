package com.goldencompany.airbnb.dto.xml;

import java.util.List;
import javax.xml.bind.annotation.XmlRootElement;

        
@XmlRootElement
public class DatasetExportDTO {
    
    private List<ListingExportDTO> data;
             
    public DatasetExportDTO() {
    }

    public DatasetExportDTO(List data) {
        this.data = data;
    }

    public List<ListingExportDTO> getData() {
        return data;
    }

    public void setData(List<ListingExportDTO> data) {
        this.data = data;
    }
    
    
    
    

    
    
    
    
    
  
}
