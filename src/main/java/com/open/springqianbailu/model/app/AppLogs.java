package com.open.springqianbailu.model.app;

import java.util.Date;

public class AppLogs {
    private Integer id;

    private String className;

    private String classSimpleName;

    private Date createdAtTimemillis;

    private Integer dbVersion;

    private String groupDescription;

    private String groupHash;

    private Integer heapAnalysisId;

    private Integer isLibraryLeak;

    private Integer retainedHeapByteSize;

    private Integer state;

    private String version;

    private String os;

    private String platform;

    private String screen;

    private String channel;

    private String net;

    private String nation;

    private String appId;

    private String deviceId;

    private String model;

    private String advertisingId;

    private String locationLongitude;

    private String locationLatitude;

    private String leakTrace;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getClassname() {
        return className;
    }

    public void setClassname(String className) {
        this.className = className == null ? null : className.trim();
    }

    public String getclassSimpleName() {
        return classSimpleName;
    }

    public void setClasssimplename(String classSimpleName) {
        this.classSimpleName = classSimpleName == null ? null : classSimpleName.trim();
    }

    public Date getCreatedAtTimemillis() {
        return createdAtTimemillis;
    }

    public void setCreatedattimemillis(Date createdAtTimemillis) {
        this.createdAtTimemillis = createdAtTimemillis;
    }

    public Integer getDbVersion() {
        return dbVersion;
    }

    public void setDbVersion(Integer dbversion) {
        this.dbVersion = dbversion;
    }

    public String getGroupDescription() {
        return groupDescription;
    }

    public void setGroupDescription(String groupdescription) {
        this.groupDescription = groupdescription == null ? null : groupdescription.trim();
    }

    public String getGroupHash() {
        return groupHash;
    }

    public void setGroupHash(String grouphash) {
        this.groupHash = grouphash == null ? null : grouphash.trim();
    }

    public Integer getHeapAnalysisId() {
        return heapAnalysisId;
    }

    public void setHeapAnalysisId(Integer heapanalysisid) {
        this.heapAnalysisId = heapanalysisid;
    }

    public Integer getIsLibraryLeak() {
        return isLibraryLeak;
    }

    public void setIsLibraryLeak(Integer islibraryleak) {
        this.isLibraryLeak = islibraryleak;
    }

    public Integer getRetainedHeapByteZize() {
        return retainedHeapByteSize;
    }

    public void setRetainedHeapByteZize(Integer retainedheapbytesize) {
        this.retainedHeapByteSize = retainedheapbytesize;
    }

    public Integer getState() {
        return state;
    }

    public void setState(Integer state) {
        this.state = state;
    }

    public String getVersion() {
        return version;
    }

    public void setVersion(String version) {
        this.version = version == null ? null : version.trim();
    }

    public String getOs() {
        return os;
    }

    public void setOs(String os) {
        this.os = os == null ? null : os.trim();
    }

    public String getPlatform() {
        return platform;
    }

    public void setPlatform(String platform) {
        this.platform = platform == null ? null : platform.trim();
    }

    public String getScreen() {
        return screen;
    }

    public void setScreen(String screen) {
        this.screen = screen == null ? null : screen.trim();
    }

    public String getChannel() {
        return channel;
    }

    public void setChannel(String channel) {
        this.channel = channel == null ? null : channel.trim();
    }

    public String getNet() {
        return net;
    }

    public void setNet(String net) {
        this.net = net == null ? null : net.trim();
    }

    public String getNation() {
        return nation;
    }

    public void setNation(String nation) {
        this.nation = nation == null ? null : nation.trim();
    }

    public String getAppId() {
        return appId;
    }

    public void setAppId(String appid) {
        this.appId = appid == null ? null : appid.trim();
    }

    public String getDeviceId() {
        return deviceId;
    }

    public void setDeviceId(String deviceid) {
        this.deviceId = deviceid == null ? null : deviceid.trim();
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model == null ? null : model.trim();
    }

    public String getAdvertisingId() {
        return advertisingId;
    }

    public void setAdvertisingId(String advertisingId) {
        this.advertisingId = advertisingId == null ? null : advertisingId.trim();
    }

    public String getLocationLongitude() {
        return locationLongitude;
    }

    public void setLocationLongitude(String locationlongitude) {
        this.locationLongitude = locationlongitude == null ? null : locationlongitude.trim();
    }

    public String getLocationLatitude() {
        return locationLatitude;
    }

    public void setLocationLatitude(String locationlatitude) {
        this.locationLatitude = locationlatitude == null ? null : locationlatitude.trim();
    }

    public String getLeakTrace() {
        return leakTrace;
    }

    public void setLeakTrace(String leaktrace) {
        this.leakTrace = leaktrace == null ? null : leaktrace.trim();
    }
}