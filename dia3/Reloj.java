package com.roshka.bootcamp;

public class Reloj {
    private int hora, minuto, segundo;

    public Reloj() {
        this.hora = 12;
        this.minuto = 0;
        this.segundo = 0;
    }

    public Reloj(int hora, int minuto, int segundo) {
        this.hora = hora;
        this.minuto = minuto;
        this.segundo = segundo;
    }

    public Reloj(int segundos){
        this(segundos/3600, segundos%3600/60, segundos%3600%60);
    }

    public void setReloj(int segundo){
        this.segundo += segundo;
        this.minuto += minuto;
        this.minuto +=(int)(this.segundo/60);
        this.segundo = this.segundo % 60;
        this.hora += hora;
        this.hora += this.minuto/60;
        this.minuto = this.minuto % 60;
        this.hora = this.hora % 24;    }

    //getters
    public int getHora() {
        return hora;
    }

    public int getMinuto() {
        return minuto;
    }

    public int getSegundo() {
        return segundo;
    }

    //setters

    public void setHora(int hora) {
        this.hora = hora;
    }

    public void setMinuto(int minuto) {
        this.minuto = minuto;
    }

    public void setSegundo(int segundo) {
        this.segundo = segundo;
    }

    public void tick(){
        if (this.segundo == 59){
            this.segundo = 0;
        } else {
            this.segundo++;
        }
    }

    public void addReloj(Reloj reloj){
        this.segundo += reloj.getSegundo();
        this.minuto += reloj.getMinuto();
        this.minuto +=(int)(this.segundo/60);
        this.segundo = this.segundo % 60;
        this.hora += reloj.getHora();
        this.hora +=(int)(this.minuto/60);
        this.minuto = this.minuto % 60;
        this.hora = this.hora % 24;
    }

    @Override
    public String toString() {
        String horas = "[";
        String hh = "";
        String mm = "" + ":";
        String ss = "" + "]";
        if (hora < 10) {
            hh = "0" + hora + ":";
        }else {
            hh = hora +  ":";
        }
        if (minuto < 10) {
            mm = "0" + minuto + ":";
        }else {
            mm = minuto + ":";
        }
        if (segundo < 10) {
            ss = "0" + segundo +")";
        }else {
            ss = segundo +")";
        }
        horas += (hh+mm+ss);
        return horas;
    }

    public void tickDecrement(){
        this.segundo--;
    }

    public Reloj restaReloj(Reloj reloj){
        if(this.segundo < reloj.getSegundo()){
            --this.minuto;
            this.segundo += 60;
        }

        if(this.minuto < reloj.getMinuto()){
            --this.hora;
            this.minuto += 60;
        }

        this.segundo -= reloj.getSegundo();
        this.minuto -= reloj.getMinuto();
        this.hora -= reloj.getHora();

        return new Reloj(hora,minuto, segundo);
    }
}
