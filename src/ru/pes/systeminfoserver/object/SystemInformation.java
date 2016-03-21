package ru.pes.systeminfoserver.object;

import java.util.ArrayList;


public class SystemInformation {
    
    private String INVENTORY_NUMBER;
    private String LOCATION;
    private String DEPARTMENT;
    private String PC_NAME;
    private String MB_VENDOR;
    private String MB_NAME;
    private String CPU_VENDOR;
    private String CPU_MODEL;
    private String CPU_CORES;
    private String CPU_MHZ;
    private String IP_ADDRESS;
    private String MAC_ADDRESS;
    private String OS_NAME;
    private String OS_ARCH;
    private String RAM;
    private ArrayList<String> HDDs;

    public SystemInformation(String INVENTORY_NUMBER, String LOCATION, String DEPARTMENT, String PC_NAME, String MB_VENDOR, String MB_NAME, String CPU_VENDOR, String CPU_MODEL, String CPU_CORES, String CPU_MHZ, String IP_ADDRESS, String MAC_ADDRESS, String OS_NAME, String OS_ARCH, String RAM, ArrayList<String> HDDs) {
        this.INVENTORY_NUMBER = INVENTORY_NUMBER;
        this.LOCATION = LOCATION;
        this.DEPARTMENT = DEPARTMENT;
        this.PC_NAME = PC_NAME;
        this.MB_VENDOR = MB_VENDOR;
        this.MB_NAME = MB_NAME;
        this.CPU_VENDOR = CPU_VENDOR;
        this.CPU_MODEL = CPU_MODEL;
        this.CPU_CORES = CPU_CORES;
        this.CPU_MHZ = CPU_MHZ;
        this.IP_ADDRESS = IP_ADDRESS;
        this.MAC_ADDRESS = MAC_ADDRESS;
        this.OS_NAME = OS_NAME;
        this.OS_ARCH = OS_ARCH;
        this.RAM = RAM;
        this.HDDs = HDDs;
    }
    
    /**
     * @return the LOCATION
     */
    public String getLOCATION() {
        return LOCATION;
    }

    /**
     * @param LOCATION the LOCATION to set
     */
    public void setLOCATION(String LOCATION) {
        this.LOCATION = LOCATION;
    }

    /**
     * @return the DEPARTMENT
     */
    public String getDEPARTMENT() {
        return DEPARTMENT;
    }

    /**
     * @param DEPARTMENT the DEPARTMENT to set
     */
    public void setDEPARTMENT(String DEPARTMENT) {
        this.DEPARTMENT = DEPARTMENT;
    }

    /**
     * @return the PC_NAME
     */
    public String getPC_NAME() {
        return PC_NAME;
    }

    /**
     * @param PC_NAME the PC_NAME to set
     */
    public void setPC_NAME(String PC_NAME) {
        this.PC_NAME = PC_NAME;
    }

    /**
     * @return the MB_VENDOR
     */
    public String getMB_VENDOR() {
        return MB_VENDOR;
    }

    /**
     * @param MB_VENDOR the MB_VENDOR to set
     */
    public void setMB_VENDOR(String MB_VENDOR) {
        this.MB_VENDOR = MB_VENDOR;
    }

    /**
     * @return the MB_NAME
     */
    public String getMB_NAME() {
        return MB_NAME;
    }

    /**
     * @param MB_NAME the MB_NAME to set
     */
    public void setMB_NAME(String MB_NAME) {
        this.MB_NAME = MB_NAME;
    }

    /**
     * @return the CPU_VENDOR
     */
    public String getCPU_VENDOR() {
        return CPU_VENDOR;
    }

    /**
     * @param CPU_VENDOR the CPU_VENDOR to set
     */
    public void setCPU_VENDOR(String CPU_VENDOR) {
        this.CPU_VENDOR = CPU_VENDOR;
    }

    /**
     * @return the CPU_MODEL
     */
    public String getCPU_MODEL() {
        return CPU_MODEL;
    }

    /**
     * @param CPU_MODEL the CPU_MODEL to set
     */
    public void setCPU_MODEL(String CPU_MODEL) {
        this.CPU_MODEL = CPU_MODEL;
    }

    /**
     * @return the CPU_CORES
     */
    public String getCPU_CORES() {
        return CPU_CORES;
    }

    /**
     * @param CPU_CORES the CPU_CORES to set
     */
    public void setCPU_CORES(String CPU_CORES) {
        this.CPU_CORES = CPU_CORES;
    }

    /**
     * @return the CPU_MHZ
     */
    public String getCPU_MHZ() {
        return CPU_MHZ;
    }

    /**
     * @param CPU_MHZ the CPU_MHZ to set
     */
    public void setCPU_MHZ(String CPU_MHZ) {
        this.CPU_MHZ = CPU_MHZ;
    }

    /**
     * @return the IP_ADDRESS
     */
    public String getIP_ADDRESS() {
        return IP_ADDRESS;
    }

    /**
     * @param IP_ADDRESS the IP_ADDRESS to set
     */
    public void setIP_ADDRESS(String IP_ADDRESS) {
        this.IP_ADDRESS = IP_ADDRESS;
    }

    /**
     * @return the MAC_ADDRESS
     */
    public String getMAC_ADDRESS() {
        return MAC_ADDRESS;
    }

    /**
     * @param MAC_ADDRESS the MAC_ADDRESS to set
     */
    public void setMAC_ADDRESS(String MAC_ADDRESS) {
        this.MAC_ADDRESS = MAC_ADDRESS;
    }

    /**
     * @return the OS_NAME
     */
    public String getOS_NAME() {
        return OS_NAME;
    }

    /**
     * @param OS_NAME the OS_NAME to set
     */
    public void setOS_NAME(String OS_NAME) {
        this.OS_NAME = OS_NAME;
    }

    /**
     * @return the OS_ARCH
     */
    public String getOS_ARCH() {
        return OS_ARCH;
    }

    /**
     * @param OS_ARCH the OS_ARCH to set
     */
    public void setOS_ARCH(String OS_ARCH) {
        this.OS_ARCH = OS_ARCH;
    }

    /**
     * @return the RAM
     */
    public String getRAM() {
        return RAM;
    }

    /**
     * @param RAM the RAM to set
     */
    public void setRAM(String RAM) {
        this.RAM = RAM;
    }

    /**
     * @return the HDDs
     */
    public ArrayList<String> getHDDs() {
        return HDDs;
    }

    /**
     * @param HDDs the HDDs to set
     */
    public void setHDDs(ArrayList<String> HDDs) {
        this.HDDs = HDDs;
    }

    public String getHDDsAsString() {
        StringBuilder sb = new StringBuilder("");
        
        HDDs.stream().forEach((HDD) -> {
            sb.append(HDD);
        });
        
        return sb.toString();
    }
    
    /**
     * @return the INVENTORY_NUMBER
     */
    public String getINVENTORY_NUMBER() {
        return INVENTORY_NUMBER;
    }

    /**
     * @param INVENTORY_NUMBER the INVENTORY_NUMBER to set
     */
    public void setINVENTORY_NUMBER(String INVENTORY_NUMBER) {
        this.INVENTORY_NUMBER = INVENTORY_NUMBER;
    }
    
    public void setSystemInformation(SystemInformation si) {
        this.INVENTORY_NUMBER = si.getINVENTORY_NUMBER();
        this.LOCATION = si.getLOCATION();
        this.DEPARTMENT = si.getDEPARTMENT();
        this.PC_NAME = si.getPC_NAME();
        this.MB_VENDOR = si.getMB_VENDOR();
        this.MB_NAME = si.getMB_NAME();
        this.CPU_VENDOR = si.getCPU_VENDOR();
        this.CPU_MODEL = si.getCPU_MODEL();
        this.CPU_CORES = si.getCPU_CORES();
        this.CPU_MHZ = si.getCPU_MHZ();
        this.IP_ADDRESS = si.getIP_ADDRESS();
        this.MAC_ADDRESS = si.getMAC_ADDRESS();
        this.OS_NAME = si.getOS_NAME();
        this.OS_ARCH = si.getOS_ARCH();
        this.RAM = si.getRAM();
        this.HDDs = si.getHDDs();
    }
    
}
