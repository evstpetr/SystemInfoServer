package ru.pes.systeminfoserver.utils;

import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import javax.json.JsonArray;
import javax.json.JsonObject;
import org.apache.log4j.Logger;
import ru.pes.systeminfoserver.db.DBConnector;
import ru.pes.systeminfoserver.object.SoftInformation;
import ru.pes.systeminfoserver.object.SystemInformation;

// Вспомогательный класс для работы с базой и форматом JSON
public class ServerUtil {

    private static final Logger logger = Logger.getLogger(ServerUtil.class);
    
    public static void saveSystemInformationIntoBase(JsonObject sysJSON, JsonObject softJSON) {

        try {
            SystemInformation si = getSystemInformationfromJSON(sysJSON);
            SoftInformation soft = getSoftInformationfromJSON(softJSON);
            DBConnector.InsertSystemInformation(si);
            DBConnector.InsertSoftInformation(soft, DBConnector.getPcId(si.getINVENTORY_NUMBER()));
        } catch (UnsupportedEncodingException ex) {
            logger.error("Encoding error ", ex);
        }

    }
    
    

    private static SystemInformation getSystemInformationfromJSON(JsonObject json) throws UnsupportedEncodingException {

        ArrayList<String> HDDS;
        HDDS = new ArrayList<>();
        JsonArray HDDS_JSON = json.getJsonArray("hdds");
        HDDS_JSON.stream().forEach((HDDS_JSON1) -> {
            HDDS.add(HDDS_JSON1.toString());
        });
        
        SystemInformation si = new SystemInformation(json.getString("inv_n"),
                json.getString("loc"),
                json.getString("dep"),
                json.getString("name"),
                json.getString("mb_vendor"),
                json.getString("mb_name"),
                json.getString("cpu_vendor"),
                json.getString("cpu_model"),
                json.getString("cores"),
                json.getString("frequency"),
                json.getString("ip"),
                json.getString("mac"),
                json.getString("os_name"),
                json.getString("arch"),
                json.getString("ram"),
                HDDS);
        return si;

    }
    
    private static SoftInformation getSoftInformationfromJSON(JsonObject json) {
        ArrayList<String> soft = new ArrayList<>();
        ArrayList<String> soft86 = new ArrayList<>();
        
        JsonArray SOFT_JSON = json.getJsonArray("soft");
        JsonArray SOFT86_JSON = json.getJsonArray("soft86");
        
        SOFT_JSON.stream().forEach((SOFT_JSON1) -> {
            soft.add(SOFT_JSON1.toString());
        });
        SOFT86_JSON.stream().forEach((SOFT86_JSON1) -> {
            soft86.add(SOFT86_JSON1.toString());
        });
        
        SoftInformation si = new SoftInformation(soft, soft86);
        return si;
        
    }

}
