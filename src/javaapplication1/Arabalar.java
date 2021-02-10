package javaapplication1;

import javax.xml.transform.Result;
import java.sql.ResultSet;

public class Arabalar extends VeriTabaniIslemleri {
    public String araba_id,  Marka, Seri,Model,Yıl, Yakıt, Vites, Kasa;
    public String Motor_Gucu;
    public String Motor_Hacmi;
    public String Çekiş;
    public String Renk;
    public String Garanti;
    public String Plaka;

    public String getDurum() {
        return Durum;
    }

    public void setDurum(String durum) {
        Durum = durum;
    }

    public String Durum;
    int KM;

    public int getKM() {
        return KM;
    }

    public void setKM(int KM) {
        this.KM = KM;
    }

    public String getAraba_id() {
        return araba_id;
    }

    public void setAraba_id(String araba_id) {
        this.araba_id = araba_id;
    }

    public String getMarka() {
        return Marka;
    }

    public void setMarka(String marka) {
        Marka = marka;
    }

    public String getSeri() {
        return Seri;
    }

    public void setSeri(String seri) {
        Seri = seri;
    }

    public String getModel() {
        return Model;
    }

    public void setModel(String model) {
        Model = model;
    }

    public String getYıl() {
        return Yıl;
    }

    public void setYıl(String yıl) {
        Yıl = yıl;
    }

    public String getYakıt() {
        return Yakıt;
    }

    public void setYakıt(String yakıt) {
        Yakıt = yakıt;
    }

    public String getVites() {
        return Vites;
    }

    public void setVites(String vites) {
        Vites = vites;
    }

    public String getKasa() {
        return Kasa;
    }

    public void setKasa(String kasa) {
        Kasa = kasa;
    }

    public String getMotor_Gucu() {
        return Motor_Gucu;
    }

    public void setMotor_Gucu(String motor_Gucu) {
        Motor_Gucu = motor_Gucu;
    }

    public String getMotor_Hacmi() {
        return Motor_Hacmi;
    }

    public void setMotor_Hacmi(String motor_Hacmi) {
        Motor_Hacmi = motor_Hacmi;
    }

    public String getÇekiş() {
        return Çekiş;
    }

    public void setÇekiş(String çekiş) {
        Çekiş = çekiş;
    }

    public String getRenk() {
        return Renk;
    }

    public void setRenk(String renk) {
        Renk = renk;
    }

    public String getGaranti() {
        return Garanti;
    }

    public void setGaranti(String garanti) {
        Garanti = garanti;
    }

    public String getPlaka() {
        return Plaka;
    }

    public void setPlaka(String plaka) {
        Plaka = plaka;
    }
}
