package com.itgrids.voterdata;

/**
 * Created with IntelliJ IDEA.
 * User: ralapaty
 * Date: 02/11/2012
 * Time: 20:21
 * To change this template use File | Settings | File Templates.
 */
public class VoterInfo {
    private String voterId;
    private String voterName;
    private String guardianName;
    private String guardianRelation;
    private String houseNumber;
    private String sex;
    private String age;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        VoterInfo voterInfo = (VoterInfo) o;

        if (age != null ? !age.equals(voterInfo.age) : voterInfo.age != null) return false;
        if (guardianName != null ? !guardianName.equals(voterInfo.guardianName) : voterInfo.guardianName != null)
            return false;
        if (guardianRelation != null ? !guardianRelation.equals(voterInfo.guardianRelation) : voterInfo.guardianRelation != null)
            return false;
        if (houseNumber != null ? !houseNumber.equals(voterInfo.houseNumber) : voterInfo.houseNumber != null)
            return false;
        if (sex != null ? !sex.equals(voterInfo.sex) : voterInfo.sex != null) return false;
        if (voterId != null ? !voterId.equals(voterInfo.voterId) : voterInfo.voterId != null) return false;
        if (voterName != null ? !voterName.equals(voterInfo.voterName) : voterInfo.voterName != null) return false;

        return true;
    }

    @Override
    public String toString() {
        return "VoterInfo{" +
                "voterId='" + voterId + '\'' +
                ", voterName='" + voterName + '\'' +
                ", guardianName='" + guardianName + '\'' +
                ", guardianRelation='" + guardianRelation + '\'' +
                ", houseNumber='" + houseNumber + '\'' +
                ", sex='" + sex + '\'' +
                ", age='" + age + '\'' +
                '}';
    }

    @Override
    public int hashCode() {
        int result = voterId != null ? voterId.hashCode() : 0;
        result = 31 * result + (voterName != null ? voterName.hashCode() : 0);
        result = 31 * result + (guardianName != null ? guardianName.hashCode() : 0);
        result = 31 * result + (guardianRelation != null ? guardianRelation.hashCode() : 0);
        result = 31 * result + (houseNumber != null ? houseNumber.hashCode() : 0);
        result = 31 * result + (sex != null ? sex.hashCode() : 0);
        result = 31 * result + (age != null ? age.hashCode() : 0);
        return result;
    }

    public String getVoterId() {

        return voterId;
    }

    public void setVoterId(String voterId) {
        this.voterId = voterId;
    }

    public String getVoterName() {
        return voterName;
    }

    public void setVoterName(String voterName) {
        this.voterName = voterName;
    }

    public String getGuardianName() {
        return guardianName;
    }

    public void setGuardianName(String guardianName) {
        this.guardianName = guardianName;
    }

    public String getGuardianRelation() {
        return guardianRelation;
    }

    public void setGuardianRelation(String guardianRelation) {
        this.guardianRelation = guardianRelation;
    }

    public String getHouseNumber() {
        return houseNumber;
    }

    public void setHouseNumber(String houseNumber) {
        this.houseNumber = houseNumber;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }
}
