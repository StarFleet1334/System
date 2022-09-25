package com.solvd.app.service.myBatisImp;

import com.solvd.app.tables.*;

import java.sql.SQLException;
import java.util.Date;
import java.util.List;

public class Main {
    public static void main(String[] args) throws SQLException {

       TechnologiesServiceImp serviceImp = new TechnologiesServiceImp();

       Technologies x = serviceImp.get(6);
           System.out.println("Technologies : ");
           System.out.println(x.getId() + " " + x.getName() + " " + x.getPc() + " " + x.getLeptop());
           System.out.println("Specs : ");
           System.out.println(x.getSpecs().getId() + " " + x.getSpecs().getOperating_system() + " " + x.getSpecs().getModel() + " " + x.getSpecs().getMemory() + " " + x.getSpecs().getSystem_manufacturer());


    }
}