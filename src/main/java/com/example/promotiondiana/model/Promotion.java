package com.example.promotiondiana.model;

import javax.persistence.Entity;

@Entity
public class Promotion extends ModelBase {


    private String description =  "<name> Hoy es su cumpleaños y usted es importante para nosotros, queremos celebralo ofreciendo un <discount> % de descuento y delivery gratuito. Valido por 24 hrs";



    public String getDescription() {
        return description;
    }

    public void setDescription(String name, String discount) {
        this.description = description;
        description.replace("<name>",name);
        description.replace("<discount>",discount);
    }
}
