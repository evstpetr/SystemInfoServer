package ru.pes.systeminfoserver.object;

import java.io.Serializable;
import java.util.ArrayList;


public class SoftInformation implements Serializable{
    
    private ArrayList<String> SOFT;
    private ArrayList<String> SOFT86;

    public SoftInformation(ArrayList<String> SOFT, ArrayList<String> SOFT86) {
        this.SOFT = SOFT;
        this.SOFT86 = SOFT86;
    }

    /**
     * @return the SOFT
     */
    public ArrayList<String> getSOFT() {
        return SOFT;
    }

    /**
     * @param SOFT the SOFT to set
     */
    public void setSOFT(ArrayList<String> SOFT) {
        this.SOFT = SOFT;
    }

    /**
     * @return the SOFT86
     */
    public ArrayList<String> getSOFT86() {
        return SOFT86;
    }

    /**
     * @param SOFT86 the SOFT86 to set
     */
    public void setSOFT86(ArrayList<String> SOFT86) {
        this.SOFT86 = SOFT86;
    }
    
    
}
