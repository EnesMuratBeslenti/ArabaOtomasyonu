package javaapplication1;
/*CREATE TABLE "Müsteriler" (
	"id"	nvarchar(11),
	"müsteri_ad"	TEXT,
	"müsteri_soyad"	TEXT,
	"müsteri_telNo"	nvarchar(255),
	PRIMARY KEY("id")
)*/
public class Musteriler extends VeriTabaniIslemleri {
    public String id;
    public String musteri_ad;
    public String musteri_soyad;
    public String muster_telNo;

    public String getAraba_id() {
        return araba_id;
    }

    public void setAraba_id(String araba_id) {
        this.araba_id = araba_id;
    }

    public String araba_id;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getMusteri_ad() {
        return musteri_ad;
    }

    public void setMusteri_ad(String musteri_ad) {
        this.musteri_ad = musteri_ad;
    }

    public String getMusteri_soyad() {
        return musteri_soyad;
    }

    public void setMusteri_soyad(String musteri_soyad) {
        this.musteri_soyad = musteri_soyad;
    }

    public String getMuster_telNo() {
        return muster_telNo;
    }

    public void setMuster_telNo(String muster_telNo) {
        this.muster_telNo = muster_telNo;
    }
}
