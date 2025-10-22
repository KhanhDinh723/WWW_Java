package edu.iuh.fit.se.nhathuoc.utils;

import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import lombok.Getter;

/**
 * Author: Khánh Đinh
 * Date:   9/30/2025
 * Time:   5:21 PM
 */
public class JPAUtil {
    @Getter
    private static EntityManagerFactory emf;
    public static void init(){
        if(emf == null){
            emf= Persistence.createEntityManagerFactory("default");

        }
    }
    public static void destroy(){
        if(emf.isOpen()){
            emf.close();

        }
    }

}
