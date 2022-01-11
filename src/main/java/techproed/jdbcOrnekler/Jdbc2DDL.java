package techproed.jdbcOrnekler;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class Jdbc2DDL {

	public static void main(String[] args) throws ClassNotFoundException, SQLException {

		// 1-) İlgili driver i yüklemeliyiz.
		Class.forName("com.mysql.cj.jdbc.Driver");

		// 2-) Bağlantı oluşturmalıyız.
		Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/sys?serverTimezone=UTC", "root",
				"1234567");

		// 3-) SQL komutları için bir Statement nesnesi oluştur.
		Statement st = (Statement) con.createStatement();

		/*
		 * A) CREATE TABLE, DROP TABLE, ALTER TABLE gibi DDL ifadeleri icin sonuc kümesi
		 * (ResultSet) dondurmeyen metotlar kullanilmalidir. Bunun icin JDBC'de 2
		 * alternatif bulunmaktadir. 1) execute() metodu 2) excuteUpdate() metodu.
		 * 
		 * B) - execute() metodu hertur SQL ifadesiyle kullanibilen genel bir komuttur.
		 * - execute(), Boolean bir deger dondurur. DDL islemlerinde false dondururken,
		 * DML islemlerinde true deger dondurur. - Ozellikle, hangi tip SQL ifadesinin
		 * kullanilmasinin gerektiginin belli olmadigi durumlarda tercih edilmektedir.
		 * 
		 * C) - executeUpdate() metodu ise INSERT, Update gibi DML islemlerinde yaygin
		 * kullanilir. - bu islemlerde islemden etkilenen satir sayisini dondurur. -
		 * Ayrıca, DDL islemlerinde de kullanilabilir ve bu islemlerde 0 dondurur.
		 */

		/*
		 * =======================================================================
		 * ORNEK1:isciler adinda bir tablo olusturunuz id int, birim VARCHAR(10), maas
		 * int //
		 * ========================================================================
		 */
		String sorgu = "CREATE TABLE isciler" + " (id int primary key," + " birim VARCHAR(10)," + " maas int)";

		// 1.yöntem

//	    boolean s1=st.execute(sorgu);
		//
//	    System.out.println("isciler tablosu oluşturuldu" +s1);

		// 2.yöntem

		/*st.execute(sorgu);
		System.out.println("isciler tablosu oluşturuldu "+st.execute(sorgu));
		
		*/
		/*======================================================================
		  ORNEK2:isciler tablosunu siliniz 		
//		========================================================================*/
		st.execute("drop table isciler");
		
		System.out.println("İsciler tablosu silindi.");
	    
	    
	    

	}

}
