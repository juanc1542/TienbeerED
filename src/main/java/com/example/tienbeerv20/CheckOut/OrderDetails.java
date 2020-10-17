package com.example.tienbeerv20.CheckOut;

public class OrderDetails {
    private long id;
    private long orderId;
    private String shippingAddress;
    private String shippingType;
    private String shippingCost;
    private String billingAddres;
    private String createdDate;

    public OrderDetails(long id, long orderId, String shipAddress, String shipType, String shipCost, String billAddres, String creaDate){
        this.setBillingAddres(billAddres);
        this.setId(id);
        this.setOrderId(orderId);
        this.setShippingAddress(shipAddress);
        this.setShippingCost(shipCost);
        this.setShippingType(shipType);
        this.setCreatedDate(creaDate);
    }


    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public long getOrderId() {
        return orderId;
    }

    public void setOrderId(long orderId) {
        this.orderId = orderId;
    }

    public String getShippingAddress() {
        return shippingAddress;
    }

    public void setShippingAddress(String shippingAddress) {
        this.shippingAddress = shippingAddress;
    }

    public String getShippingType() {
        return shippingType;
    }

    public void setShippingType(String shippingType) {
        this.shippingType = shippingType;
    }

    public String getShippingCost() {
        return shippingCost;
    }

    public void setShippingCost(String shippingCost) {
        this.shippingCost = shippingCost;
    }

    public String getBillingAddres() {
        return billingAddres;
    }

    public void setBillingAddres(String billingAddres) {
        this.billingAddres = billingAddres;
    }

    public String getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(String createdDate) {
        this.createdDate = createdDate;
    }



//--------------------------------------------------------------------------------------------------
    public void cancelOrder(){


    }

//--------------------------------------------------------------------------------------------------
    public void trackOrder(){


    }
}

//--------------------------------------------------------------------------------------------------

