package ru.pes.systeminfoserver.db;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import ru.pes.systeminfoserver.object.SoftInformation;
import ru.pes.systeminfoserver.object.SystemInformation;

// Класс для работы с БД, все тривиально
public class DBConnector {

    private static Connection con;
    private static PreparedStatement pstmt;
    private static final String WRITE_SI_SQL = "INSERT INTO pc (inv, location, department, pc_name, mb_vendor, "
            + "mb_name, cpu_vendor, cpu_model, cpu_cores, cpu_mhz, ip_addr,"
            + " mac_addr, os_name, os_arch, ram_total, hdd) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
    private static final String WRITE_SOFT_SQL = "INSERT INTO pc_soft (pc_id, soft) VALUES (?, ?)";

    public static void InsertSystemInformation(SystemInformation si) {

        try {
            con = getConnection();

            pstmt = con.prepareStatement(WRITE_SI_SQL);
            pstmt.setString(1, si.getINVENTORY_NUMBER());
            pstmt.setString(2, si.getLOCATION());
            pstmt.setString(3, si.getDEPARTMENT());
            pstmt.setString(4, si.getPC_NAME());
            pstmt.setString(5, si.getMB_VENDOR());
            pstmt.setString(6, si.getMB_NAME());
            pstmt.setString(7, si.getCPU_VENDOR());
            pstmt.setString(8, si.getCPU_MODEL());
            pstmt.setString(9, si.getCPU_CORES());
            pstmt.setString(10, si.getCPU_MHZ());
            pstmt.setString(11, si.getIP_ADDRESS());
            pstmt.setString(12, si.getMAC_ADDRESS());
            pstmt.setString(13, si.getOS_NAME());
            pstmt.setString(14, si.getOS_ARCH());
            pstmt.setString(15, si.getRAM());
            pstmt.setString(16, si.getHDDsAsString());
            pstmt.executeUpdate();

        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        } finally {
            if (con != null) {
                try {
                    con.close();
                } catch (SQLException se) {
                    System.out.println("Не удалось добавить в БД " + se.getMessage());
                }
            }
        }

    }
    
    public static void InsertSoftInformation(SoftInformation si, String pcID) {
        
        try {
            con = getConnection();
            pstmt = con.prepareStatement(WRITE_SOFT_SQL);
            
            ByteArrayOutputStream bout = new ByteArrayOutputStream();
            ObjectOutputStream oos = new ObjectOutputStream(bout);
            
            oos.writeObject(si);
            oos.close();
            byte[] bytes = bout.toByteArray();
            pstmt.setString(1, pcID);
            pstmt.setBlob(2, new ByteArrayInputStream(bytes));
            pstmt.executeUpdate();
            pstmt.close();

        } catch (SQLException | IOException ex) {
            System.out.println("!!! " + ex.getMessage());
        } finally {
            if (con != null) {
                try {
                    con.close();
                } catch (SQLException se) {
                    System.out.println("Не удалось добавить в БД " + se.getMessage());
                }
            }
        }
    }

    public static String getPcId(String inv_n){
        String res = "";
        try {
            con = getConnection();
            PreparedStatement ps = con.prepareStatement("SELECT id FROM pc where inv=?");
            ps.setString(1, inv_n);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                int id = rs.getInt("id");
                res = res + id;
            }
            rs.close();
            ps.close();
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        
        return res;
    }
    
    private static Connection getConnection() throws SQLException {
        String url = "jdbc:mysql://109.123.160.7:3306/sys_inf";
        String username = "root";
        String password = "azatIER75";
        Connection conn = DriverManager.getConnection(url, username, password);
        System.out.println("Соединение с базой установленно!");
        return conn;
        
    }

}
