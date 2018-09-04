package br.com.rafaelvalentim.agro.Model;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Boletim {

    private Long id;
    private Date data;


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Date getData() {
        return data;
    }

    public void setData(Date data) {
        this.data = data;
    }

    public String toString(){
        Date date = this.data;

        DateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
        String dataBoletim = formatter.format(date);

        return this.getId() + "- " + dataBoletim;
    }

}
