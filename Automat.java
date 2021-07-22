package com.company;

public class Automat extends FSM{
    private Event event;

    public Automat(String text){
        super(text);
    }

    public State getState(){
        return state;
    }

    @Override
    public boolean scanner(){
       int count = 0;
       while (state != State.Success && state != State.Error){
           if(count<this.text.length()){
               event=recognizeEvent(text.charAt(count));
           } else {
               event = Event.EOS;
           }
           if(event!=null){
               handleEvent(event);
           } else {
               state = State.Error;
           }
           count++;
       }
       return state==State.Success;
    }

    @Override
   public Event recognizeEvent(char ch){
        Event temp;
        switch (ch){
            case 'a': case 'b':case 'c': case 'd':
                case 'e': case 'f':case 'g': case 'h':
            case 'i': case 'j':case 'k': case 'l':
            case 'm': case 'n':case 'o': case 'p': case 'q':
            case 'r': case 's':case 't': case 'u':
            case 'v': case 'w':case 'x': case 'y':case 'z':
                temp = Event.LowerLetter;
                break;
            case 'F': case 'G':case 'H': case 'I':
            case 'J': case 'K':
                temp=Event.UpperLetter;
                break;
            case '/':
                temp = Event.Slash;
                break;
            default:
                temp = Event.Any;
        }
        return temp;
    }

    public void handleEvent(Event event){
        switch (state){
            case Initial:
                switch (event){
                    case Slash:
                        state = State.Q1;
                        break;
                    case EOS:
                        state = State.Error;
                        break;
                    default:
                        state = State.Error;
                        break;
                }
                break;
            case Q1:
                switch (event){
                    case LowerLetter:
                        state = State.Q1;
                        break;
                    case UpperLetter:
                        state = State.Q2;
                        break;
                    case EOS:
                        state= State.Error;
                        break;
                    default:
                        state= State.Error;
                        break;
                }
                break;
            case Q2:
                switch (event){
                    case LowerLetter:
                        state = State.Q2;
                        break;
                    case UpperLetter:
                        state = State.Q3;
                        break;
                    case EOS:
                        state= State.Error;
                        break;
                    default:
                        state= State.Error;
                        break;
                }
                break;
            case Q3:
                switch (event){
                    case UpperLetter:
                        state = State.Q3;
                        break;
                    case EOS:
                        state= State.Q4;
                        break;
                    default:
                        state= State.Error;
                        break;
                }
                break;
            case Q4:
                switch (event){
                    case EOS:
                        state = State.Success;
                        break;
                    default:
                        state = State.Error;
                        break;
                }

        }
    }
}
