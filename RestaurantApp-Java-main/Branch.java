public class Branch {
    private String branchCode;
    private String cityName;
    private String address;
    private String pincode;

    public Branch(String branchCode, String cityName, String address, String pincode) {
        this.branchCode = branchCode;
        this.cityName = cityName;
        this.address = address;
        this.pincode = pincode;
    }

    public String getBranchCode() {
        return branchCode;
    }

    public String getCityName() {
        return cityName;
    }

    public String getAddress() {
        return address;
    }

    public String getPincode() {
        return pincode;
    }
}
