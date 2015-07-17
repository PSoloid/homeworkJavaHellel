package com.Hellel.PSoloid.SingleTone;

/**
 * Created by ITHILLEL7 on 17.07.2015.
 */
public class WebService {
    private static WebService service = new WebService();
    private WebService(){


    }

    public static WebService getInstance(){

        return service;
    }

    public void print(){
        System.out.println("Service");
    }
}
