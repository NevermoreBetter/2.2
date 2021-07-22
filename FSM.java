package com.company;

public abstract class FSM {
    protected String text;
    protected State state;

    public FSM(String text){
        this.text=text;
        state = state.Initial;
    }

    public abstract boolean scanner();
    public abstract Event recognizeEvent(char ev);
    public abstract void handleEvent(Event ev);
}
