package com.hospitalapp.commons.Exception;

public class EntryNotFoundException extends Exception{

    public EntryNotFoundException(){}

    public EntryNotFoundException(Throwable e){
        super(e);
    }

    public EntryNotFoundException(String msg){
        super(msg);
    }

    public EntryNotFoundException(String msg, Throwable e){
        super(msg, e);
    }
}
