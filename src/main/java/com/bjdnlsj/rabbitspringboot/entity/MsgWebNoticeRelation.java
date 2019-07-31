package com.bjdnlsj.rabbitspringboot.entity;


/**
 * @Author zhaoxiace
 * @Email zhaoxiace@ewsd.cn
 * @Date 2019-07-30 08:30:08
 */
public class MsgWebNoticeRelation  {
    private static final long serialVersionUID = 1L;

    // 是否删除
    private Integer isDel;
    // 发送状态：0-失败 1-成功
    private Integer sendStatus;
    // 接收人ID
    private String receiverId;
    // 接收人的名称
    private String receiverName;
    // 已读 or 未读
    private String receiverStatus;
    // 消息的唯一标识
    private String webNoticeUuid;
    // 接收人组织机构名称
    private String receiverOrgName;

    public String getReceiverName() {
        return receiverName;
    }

    public void setReceiverName(String receiverName) {
        this.receiverName = receiverName;
    }

    public String getReceiverOrgName() {
        return receiverOrgName;
    }

    public void setReceiverOrgName(String receiverOrgName) {
        this.receiverOrgName = receiverOrgName;
    }

    /**
     * 设置：是否删除
     */
    public void setIsDel(Integer isDel) {
        this.isDel = isDel;
    }

    /**
     * 获取：是否删除
     */
    public Integer getIsDel() {
        return isDel;
    }

    /**
     * 设置：发送状态：0-失败 1-成功
     */
    public void setSendStatus(Integer sendStatus) {
        this.sendStatus = sendStatus;
    }

    /**
     * 获取：发送状态：0-失败 1-成功
     */
    public Integer getSendStatus() {
        return sendStatus;
    }

    /**
     * 设置：接收人ID
     */
    public void setReceiverId(String receiverId) {
        this.receiverId = receiverId;
    }

    /**
     * 获取：接收人ID
     */
    public String getReceiverId() {
        return receiverId;
    }

    /**
     * 设置：已读 or 未读
     */
    public void setReceiverStatus(String receiverStatus) {
        this.receiverStatus = receiverStatus;
    }

    /**
     * 获取：已读 or 未读
     */
    public String getReceiverStatus() {
        return receiverStatus;
    }

    /**
     * 设置：消息的唯一标识
     */
    public void setWebNoticeUuid(String webNoticeUuid) {
        this.webNoticeUuid = webNoticeUuid;
    }

    /**
     * 获取：消息的唯一标识
     */
    public String getWebNoticeUuid() {
        return webNoticeUuid;
    }


}