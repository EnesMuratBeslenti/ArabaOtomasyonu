package javaapplication1;


import java.sql.*;
import java.util.ArrayList;

public class VeriTabaniIslemleri  {
    /**
     * Bu metot veri tabanıyla iletişim bağlantı kurmaya yarar.
     * @return
     */
    
    public Connection Baglan(){
        
        Connection baglantı=null;
        try{
            baglantı=DriverManager.getConnection("jdbc:sqlite:src\\VeriTabani\\OtoGaleriOtomasyonu.db");
            Class.forName("org.sqlite.JDBC");
            System.out.println("Bağlantı Başarılı");

        }catch (Exception e){
            System.out.println("Bağlantı Başarısız"+e.getMessage());
        }
        return baglantı;
    }

    /**
     * Bu metot Araba Tablosuna araba eklemeye yarar.
     * @param Marka
     * @param Seri
     * @param Model
     * @param Yıl
     * @param Yakıt
     * @param Vites
     * @param KM
     * @param Kasa
     * @param Motor_Gucu
     * @param Motor_Hacmi
     * @param Çekiş
     * @param Renk
     * @param Garanti
     * @param Plaka
     */
    public int VeriEklemeAraba( String Marka,String Seri,String Model,String Yıl,String Yakıt,String Vites,int KM,String Kasa,
                             String Motor_Gucu,String Motor_Hacmi,String Çekiş,String Renk,String Garanti,String Plaka){
        String sorgu ="Insert into Araba(Marka,Seri,Model,Yıl,Yakıt,Vites,KM,Kasa,Motor_Gucu,Motor_Hacmi,Çekiş,Renk,Garanti,Plaka)" +
                "Values(?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
        try(Connection baglantı=this.Baglan(); PreparedStatement islemler = baglantı.prepareStatement(sorgu)){
            islemler.setString(1,Marka);
            islemler.setString(2,Seri);
            islemler.setString(3,Model);
            islemler.setString(4,Yıl);
            islemler.setString(5,Yakıt);
            islemler.setString(6,Vites);
            islemler.setInt(7,KM);
            islemler.setString(8,Kasa);
            islemler.setString(9,Motor_Gucu);
            islemler.setString(10,Motor_Hacmi);
            islemler.setString(11,Çekiş);
            islemler.setString(12,Renk);
            islemler.setString(13,Garanti);
            islemler.setString(14,Plaka);
            islemler.executeUpdate();
            return 0;
        }catch (Exception e){
            System.out.println("İşlem Yapılamadı"+e.getMessage());
            return 1;
        }
    }

    /**
     * Bu Metot Araba tablosundan verilen id'ye göre arama yapar ve olan verileri <b>Arabalar tipinde</b> geri döndürür.
     * @param id
     * @return
     */

    public Arabalar VerileriGetirAraba(int id){
        String sorgu ="SELECT * from Araba where Id="+id;
        try(Connection baglantı=this.Baglan(); PreparedStatement islemler = baglantı.prepareStatement(sorgu); ResultSet GelenVeriler=islemler.executeQuery()){
            while (GelenVeriler.next()){
                Arabalar araba =new Arabalar();
                araba.setAraba_id(GelenVeriler.getString("id"));
                araba.setMarka(GelenVeriler.getString("Marka"));
                araba.setModel(GelenVeriler.getString("Model"));
                araba.setSeri(GelenVeriler.getString("Seri"));
                araba.setModel(GelenVeriler.getString("Model"));
                araba.setYıl(GelenVeriler.getString("Yıl"));
                araba.setYakıt(GelenVeriler.getString("Yakıt"));
                araba.setVites(GelenVeriler.getString("Vites"));
                araba.setKM(GelenVeriler.getInt("KM"));
                araba.setKasa(GelenVeriler.getString("Kasa"));
                araba.setMotor_Gucu(GelenVeriler.getString("Motor_Gucu"));
                araba.setMotor_Hacmi(GelenVeriler.getString("Motor_Hacmi"));
                araba.setÇekiş(GelenVeriler.getString("Çekiş"));
                araba.setRenk(GelenVeriler.getString("Renk"));
                araba.setGaranti(GelenVeriler.getString("Garanti"));
                araba.setPlaka(GelenVeriler.getString("Plaka"));
                araba.setDurum(GelenVeriler.getString("Durum"));
                return araba;
            }
        }
        catch (Exception e){
            System.out.println("İşlem Yapılamadı"+ e.getMessage());
        }
        return null;
    }


    /**
     * Bu metot değer almaz,Arabalar tablosunda bulunan tüm verileri <b>ArrayList < Arabalar > tipinde</b> getirmeye yarar.
     * @return
     */
    public ArrayList<Arabalar> VerileriGetirAraba(){
        String sorgu ="SELECT * from Araba";
        try(Connection baglantı=this.Baglan(); PreparedStatement islemler = baglantı.prepareStatement(sorgu); ResultSet GelenVeriler=islemler.executeQuery()){
            ArrayList<Arabalar>ArabalarListesi=new ArrayList<Arabalar>();
            while (GelenVeriler.next()){
                Arabalar araba =new Arabalar();
                araba.setAraba_id(GelenVeriler.getString("id"));
                araba.setMarka(GelenVeriler.getString("Marka"));
                araba.setModel(GelenVeriler.getString("Model"));
                araba.setSeri(GelenVeriler.getString("Seri"));
                araba.setModel(GelenVeriler.getString("Model"));
                araba.setYıl(GelenVeriler.getString("Yıl"));
                araba.setYakıt(GelenVeriler.getString("Yakıt"));
                araba.setVites(GelenVeriler.getString("Vites"));
                araba.setKM(GelenVeriler.getInt("KM"));
                araba.setKasa(GelenVeriler.getString("Kasa"));
                araba.setMotor_Gucu(GelenVeriler.getString("Motor_Gucu"));
                araba.setMotor_Hacmi(GelenVeriler.getString("Motor_Hacmi"));
                araba.setÇekiş(GelenVeriler.getString("Çekiş"));
                araba.setRenk(GelenVeriler.getString("Renk"));
                araba.setGaranti(GelenVeriler.getString("Garanti"));
                araba.setPlaka(GelenVeriler.getString("Plaka"));
                araba.setDurum(GelenVeriler.getString("Durum"));
                ArabalarListesi.add(araba);
            }
            return ArabalarListesi;
        }
        catch (Exception e){
            System.out.println("İşlem Yapılamadı"+ e.getMessage());
        }
        return null;
    }
    public ArrayList<Arabalar> VerileriGetirAraba(String sorgu){
        try(Connection baglantı=this.Baglan(); PreparedStatement islemler = baglantı.prepareStatement(sorgu); ResultSet GelenVeriler=islemler.executeQuery()){
            ArrayList<Arabalar>ArabalarListesi=new ArrayList<Arabalar>();
            while (GelenVeriler.next()){
                Arabalar araba =new Arabalar();
                araba.setAraba_id(GelenVeriler.getString("id"));
                araba.setMarka(GelenVeriler.getString("Marka"));
                araba.setModel(GelenVeriler.getString("Model"));
                araba.setSeri(GelenVeriler.getString("Seri"));
                araba.setModel(GelenVeriler.getString("Model"));
                araba.setYıl(GelenVeriler.getString("Yıl"));
                araba.setYakıt(GelenVeriler.getString("Yakıt"));
                araba.setVites(GelenVeriler.getString("Vites"));
                araba.setKM(GelenVeriler.getInt("KM"));
                araba.setKasa(GelenVeriler.getString("Kasa"));
                araba.setMotor_Gucu(GelenVeriler.getString("Motor_Gucu"));
                araba.setMotor_Hacmi(GelenVeriler.getString("Motor_Hacmi"));
                araba.setÇekiş(GelenVeriler.getString("Çekiş"));
                araba.setRenk(GelenVeriler.getString("Renk"));
                araba.setGaranti(GelenVeriler.getString("Garanti"));
                araba.setPlaka(GelenVeriler.getString("Plaka"));
                araba.setDurum(GelenVeriler.getString("Durum"));
                ArabalarListesi.add(araba);
            }
            return ArabalarListesi;
        }
        catch (Exception e){
            System.out.println("İşlem Yapılamadı"+ e.getMessage());
        }
        return null;
    }

    /**
     * Bu metot Musteriler tablosunda verilen id'ye göre arama yapar ve gelen sonucu <b>Müsteriler tipinde</b> geri döndürür.
     * @param id
     * @return
     */
    public Musteriler VerileriGetirMusteri(int id){
        String sorgu ="SELECT * from Müsteriler where Id="+id;
        try(Connection baglantı=this.Baglan(); PreparedStatement islemler = baglantı.prepareStatement(sorgu); ResultSet GelenVeriler=islemler.executeQuery()){
            while (GelenVeriler.next()){
                Musteriler musteri = new Musteriler();
                musteri.setId(GelenVeriler.getString("id"));
                musteri.setMusteri_ad(GelenVeriler.getString("müsteri_ad"));
                musteri.setMusteri_soyad(GelenVeriler.getString("müsteri_soyad"));
                musteri.setMuster_telNo(GelenVeriler.getString("müsteri_telNo"));
                return musteri;
            }
        }
        catch (Exception e){
            System.out.println("İşlem Yapılamadı"+ e.getMessage());
        }
        return null;
    }

    /**
     * Bu metot Müsteriler Tablosundaki tüm verileri <b>ArrayList< Müsteriler ></b> tipinde geri getirir.
     * @return
     */
    public ArrayList<Musteriler> VerileriGetirMusteri(){
        String sorgu ="SELECT * from Müsteriler ";
        try(Connection baglantı=this.Baglan(); PreparedStatement islemler = baglantı.prepareStatement(sorgu); ResultSet GelenVeriler=islemler.executeQuery()){
            ArrayList<Musteriler>MusterilerListesi=new ArrayList<Musteriler>();
            while (GelenVeriler.next()){
                Musteriler musteri = new Musteriler();
                musteri.setId(GelenVeriler.getString("id"));
                musteri.setMusteri_ad(GelenVeriler.getString("müsteri_ad"));
                musteri.setMusteri_soyad(GelenVeriler.getString("müsteri_soyad"));
                musteri.setMuster_telNo(GelenVeriler.getString("müsteri_telNo"));
                MusterilerListesi.add(musteri);
            }
            return MusterilerListesi;
        }
        catch (Exception e){
            System.out.println("İşlem Yapılamadı"+ e.getMessage());
        }
        return null;
    }


    public int VeriEkleMusteri(String ad,String soyad,String TelNo){
        String sorgu="insert into Müsteriler(müsteri_ad,müsteri_soyad,müsteri_telNo)VALUES (?,?,?)";
        try(Connection baglantı=this.Baglan(); PreparedStatement islemler = baglantı.prepareStatement(sorgu)){
                islemler.setString(1,ad);
                islemler.setString(2,soyad);
                islemler.setString(3,TelNo);
                islemler.executeUpdate();
                return 0;
        }
        catch (Exception e){
            System.out.println("İşlem Yapılamadı"+e.getMessage());
            return 1;
        }

    }

    /**
     * Bu metot Hesap_tipi tablosuna Veri eklemeye yarar.
     * @param id
     * @param personel_tip
     * @param admin_id
     * @param admin_tip
     */
     public int VeriEkleHesapTipi(String id, String personel_tip, String admin_id, String admin_tip,String personel_isim,String personel_sifre){
        String sorgu ="insert into Hesap_tipi (id,personel_tip,admin_id,admin_tip,personel_isim,personel_sifre) values (?,?,?,?,?,?);";
         try(Connection baglantı=this.Baglan(); PreparedStatement islemler = baglantı.prepareStatement(sorgu)){
              islemler.setString(1,id);
              islemler.setString(2,personel_tip);
              islemler.setString(3,admin_id);
              islemler.setString(4,admin_tip);
              islemler.setString(5, personel_isim);
              islemler.setString(6,personel_sifre);
              islemler.executeUpdate();
              return 0;
         }catch (Exception e){
             System.out.println("İşlem Yapılamadı"+e.getMessage());
             return 1;
         }
     }

    /**
     * Bu metot Verilen id'ye göre veri tabanında arama yapar ve gelen değeri <b>Hesap_tipi</b> şeklinde geri döndürür.
     * @param id
     * @return
     */
     public HesapTipi VeriGetirHesapTipi(int id){
         String sorgu ="SELECT * from Hesap_tipi where id="+id;
         try(Connection baglantı=this.Baglan(); PreparedStatement islemler = baglantı.prepareStatement(sorgu); ResultSet GelenVeriler=islemler.executeQuery()){
             while (GelenVeriler.next()){
                 HesapTipi hesaplar=new HesapTipi();
                 hesaplar.setId(GelenVeriler.getString("id"));
                 hesaplar.setPersonel_tip(GelenVeriler.getString("personel_tip"));
                 hesaplar.setAdmin_id(GelenVeriler.getString("admin_id"));
                 hesaplar.setAdmin_tip(GelenVeriler.getString("admin_tip"));
                 hesaplar.setPersonel_isim(GelenVeriler.getString("personel_isim"));
                 hesaplar.setPersonel_sifre(GelenVeriler.getString("personel_sifre"));
                 return hesaplar;
             }
         }
         catch (Exception e){
             System.out.println("İşlem Yapılamadı"+ e.getMessage());
         }
         return null;
     }
    public int giris(String isim,String sifre){
        String sorgu ="SELECT * from Hesap_tipi where personel_isim='"+isim+"' and personel_sifre='"+sifre+"'";
        System.out.print(sorgu);
        try(Connection baglantı=this.Baglan(); PreparedStatement islemler = baglantı.prepareStatement(sorgu); ResultSet GelenVeriler=islemler.executeQuery()){
            System.out.print(GelenVeriler.getString("personel_isim"));
            System.out.print(GelenVeriler.getRow());
            if (GelenVeriler.getRow()>=0){
                if(GelenVeriler.getString("admin_tip").equals("1"))
                   return 1;
                else
                    return 0;
            }
            else {
                return 2;
            }
        }
        catch (Exception e){
            System.out.println("İşlem Yapılamadı"+ e.getMessage()); return 2;
        }

    }

    /**
     * Bu metot değer almaz ve Hesap_tipi tablosunda bulunan tüm verileri <b>ArrayList< Hesap_tipi > şeklinde</b> geri döndürür.
     * @return
     */
    public ArrayList<HesapTipi> VeriGetirHesapTipi(){
        String sorgu ="SELECT * from Hesap_tipi ";
        try(Connection baglantı=this.Baglan(); PreparedStatement islemler = baglantı.prepareStatement(sorgu); ResultSet GelenVeriler=islemler.executeQuery()){
           ArrayList<HesapTipi>HesaplarListesi=new ArrayList<HesapTipi>();
            while (GelenVeriler.next()){
                HesapTipi hesaplar=new HesapTipi();
                hesaplar.setId(GelenVeriler.getString("id"));
                hesaplar.setPersonel_tip(GelenVeriler.getString("personel_tip"));
                hesaplar.setAdmin_id(GelenVeriler.getString("admin_id"));
                hesaplar.setAdmin_tip(GelenVeriler.getString("admin_tip"));
                hesaplar.setPersonel_isim(GelenVeriler.getString("personel_isim"));
                hesaplar.setPersonel_sifre(GelenVeriler.getString("personel_sifre"));
                HesaplarListesi.add(hesaplar);
            }
            return HesaplarListesi;
        }
        catch (Exception e){
            System.out.println("İşlem Yapılamadı"+ e.getMessage());
        }
        return null;
    }

    /**
     * Bu metot verilen <b>Tablo ismi,güncellenicek sütunun ismi,satır id'si ve yeni değer</b> parametrelerini alarak çalışır.
     * @param TabloIsmı
     * @param GuncellenicekSütunIsmi
     * @param Id
     * @param YeniDeger
     */
    public void Guncelle(String TabloIsmı,String GuncellenicekSütunIsmi,int Id,String YeniDeger){
        String sorgu ="update "+TabloIsmı+" set "+GuncellenicekSütunIsmi+"=? where id="+Id;
        try(Connection baglantı=this.Baglan(); PreparedStatement islemler = baglantı.prepareStatement(sorgu)){
                  islemler.setString(1,YeniDeger);
                  islemler.executeUpdate();
                  System.out.println("Güncelleme işlemi başarılı");
        }
        catch (Exception e){
            System.out.println("İşlem Yapılamadı"+e.getMessage());
        }
    }

    /**
     * Bu metot verilen <b>tablo ismine ve satır id'sine</b> göre silme işlemi yapar
     * @param TabloIsmı
     * @param Id
     */
    public void Sil(String TabloIsmı,int Id){
        String sorgu ="DELETE FROM "+TabloIsmı+" Where id=?";
        try(Connection baglantı=this.Baglan(); PreparedStatement islemler = baglantı.prepareStatement(sorgu)){
            islemler.setInt(1,Id);
            islemler.executeUpdate();
            System.out.println("Silme işlemi başarılı");
        }
        catch (Exception e){
            System.out.println("İşlem Yapılamadı"+e.getMessage());
        }
    }

}
