package protocol;

public class Protocol {


    private int priority;  //报文的优先级，3位

    private String reservedBits;     //保留位，默认为0，1位

    private String dataPage;    //数据页，默认为0，1位

    private String pduFormat;    //PDU格式以及参数组编号PGN，8位

    private String pduSpecialFormat;   //PDU特殊格式，pdu1格式中为目标地址，8位

    private String sourceAddress;    //源地址，8位

    private String dataArea;    //数据域存储参数组数据，0-8位，超出需分片


    public int getPriority() {
        return priority;
    }

    public void setPriority(int priority) {
        this.priority = priority;
    }

    public String getReservedBits() {
        return reservedBits;
    }

    public void setReservedBits(String reservedBits) {
        this.reservedBits = reservedBits;
    }

    public String getDataPage() {
        return dataPage;
    }

    public void setDataPage(String dataPage) {
        this.dataPage = dataPage;
    }

    public String getPduFormat() {
        return pduFormat;
    }

    public void setPduFormat(String pduFormat) {
        this.pduFormat = pduFormat;
    }

    public String getPduSpecialFormat() {
        return pduSpecialFormat;
    }

    public void setPduSpecialFormat(String pduSpecialFormat) {
        this.pduSpecialFormat = pduSpecialFormat;
    }

    public String getSourceAddress() {
        return sourceAddress;
    }

    public void setSourceAddress(String sourceAddress) {
        this.sourceAddress = sourceAddress;
    }

    public String getDataArea() {
        return dataArea;
    }

    public void setDataArea(String dataArea) {
        this.dataArea = dataArea;
    }




}
