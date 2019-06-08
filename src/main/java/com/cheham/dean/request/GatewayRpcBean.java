package com.cheham.dean.request;

import java.io.Serializable;
import java.sql.Timestamp;

public class GatewayRpcBean implements Serializable {

    private static final long serialVersionUID = 7503710091945320739L;

    private String id; //网关ID

    private String proxy_net_address; //长连接服务器的net地址(ip:port)

    private String security_key; //网关加密（rsa）的公钥

    private String serial; //网关序列号

    private String mac; //网关mac地址

    private String sys_ver; //网关的软件系统版本号

    private String protocol_ver; //网关网络协议版本号

    private String zigbee_ver; //网关zigbee模块的版本号

    private Byte https_supported; //网关是否支持https协议

    private String product_id; //产品id

    private Timestamp upgrade_date; //网关升级时间

    private Timestamp online_status_date; //网关登录时间

    private Timestamp create_date;

    private Timestamp modify_date;

    private String mq_tag; //给第三方的标识，备注信息

    private String method; //RPC调用的方法

    @Override
    public String toString() {
        return "GatewayRpcBean{" +
                "id='" + id + '\'' +
                ", proxy_net_address='" + proxy_net_address + '\'' +
                ", security_key='" + security_key + '\'' +
                ", serial='" + serial + '\'' +
                ", mac='" + mac + '\'' +
                ", sys_ver='" + sys_ver + '\'' +
                ", protocol_ver='" + protocol_ver + '\'' +
                ", zigbee_ver='" + zigbee_ver + '\'' +
                ", https_supported=" + https_supported +
                ", product_id='" + product_id + '\'' +
                ", upgrade_date=" + upgrade_date +
                ", online_status_date=" + online_status_date +
                ", create_date=" + create_date +
                ", modify_date=" + modify_date +
                ", mq_tag='" + mq_tag + '\'' +
                '}';
    }

    public String getMethod() {
        return method;
    }

    public void setMethod(String method) {
        this.method = method;
    }

    public void setId(String id) {
        this.id = id;
    }

    public void setProxy_net_address(String proxy_net_address) {
        this.proxy_net_address = proxy_net_address;
    }

    public void setSecurity_key(String security_key) {
        this.security_key = security_key;
    }

    public void setSerial(String serial) {
        this.serial = serial;
    }

    public void setMac(String mac) {
        this.mac = mac;
    }

    public void setSys_ver(String sys_ver) {
        this.sys_ver = sys_ver;
    }

    public void setProtocol_ver(String protocol_ver) {
        this.protocol_ver = protocol_ver;
    }

    public void setZigbee_ver(String zigbee_ver) {
        this.zigbee_ver = zigbee_ver;
    }

    public void setHttps_supported(Byte https_supported) {
        this.https_supported = https_supported;
    }

    public void setProduct_id(String product_id) {
        this.product_id = product_id;
    }

    public void setUpgrade_date(Timestamp upgrade_date) {
        this.upgrade_date = upgrade_date;
    }

    public void setOnline_status_date(Timestamp online_status_date) {
        this.online_status_date = online_status_date;
    }

    public void setCreate_date(Timestamp create_date) {
        this.create_date = create_date;
    }

    public void setModify_date(Timestamp modify_date) {
        this.modify_date = modify_date;
    }

    public void setMq_tag(String mq_tag) {
        this.mq_tag = mq_tag;
    }

    public String getId() {
        return id;
    }

    public String getProxy_net_address() {
        return proxy_net_address;
    }

    public String getSecurity_key() {
        return security_key;
    }

    public String getSerial() {
        return serial;
    }

    public String getMac() {
        return mac;
    }

    public String getSys_ver() {
        return sys_ver;
    }

    public String getProtocol_ver() {
        return protocol_ver;
    }

    public String getZigbee_ver() {
        return zigbee_ver;
    }

    public Byte getHttps_supported() {
        return https_supported;
    }

    public String getProduct_id() {
        return product_id;
    }

    public Timestamp getUpgrade_date() {
        return upgrade_date;
    }

    public Timestamp getOnline_status_date() {
        return online_status_date;
    }

    public Timestamp getCreate_date() {
        return create_date;
    }

    public Timestamp getModify_date() {
        return modify_date;
    }

    public String getMq_tag() {
        return mq_tag;
    }
}
